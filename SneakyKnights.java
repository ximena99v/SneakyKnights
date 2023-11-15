// Ximena Ramirez
// COP 3503 Spring 2023
// NID: xi982885

import java.io.*;
import java.util.*;
import java.awt.*;

public class SneakyKnights
{
	// Given an ArrayList of coordinate strings that are the locations of knights on the board
	// return true if none of the knights can attack one another, 
	// otherwise, return false
	public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
	{
		HashSet<Point> knights = new HashSet<>(); // this hashSet stores our knights' positions

		Point current; // current coordinate we're checking
		Point potientialAttack; // potiential attack point 


		int i = 0; //STRING ELEMENT IN THE ARRAYLIST

		while(i < coordinateStrings.size())
		{
			int row = 0;
			int col = 0;
			int curr = 0; // current charater in the string
			int digit = 0; 
			StringBuilder builder = new StringBuilder(coordinateStrings.get(i).length());

			// Reads through column string
			while ((Character.isLetter(coordinateStrings.get(i).charAt(curr)) == true))
			{
				builder.append(coordinateStrings.get(i).charAt(curr));
				curr++;
			}

			// Convert column's string to integer
			col = convertColStringToInt(builder.toString(), builder.length());
			
			// Reads through the rest of the string as rows
			while ((curr < coordinateStrings.get(i).length()) && 
				(Character.isDigit(coordinateStrings.get(i).charAt(curr))))
			{
				row *= 10;
				digit = ((int)coordinateStrings.get(i).charAt(curr) - '0');
				row += digit;
				curr++;
			}
			i++;

			current  = new Point(col, row);

			// Check if there's a knight already at this column and row
			// if there isn't, add our current coordinate.
			// Otherwise, return false for knight not safe. 
			if(!knights.contains(current))
				knights.add(current);
			else
				return false;

			// Check if there's a potential attack 2 columns to the right 1 row up
			potientialAttack = new Point(col + 2, row + 1);
			if(knights.contains(potientialAttack))
				return false;

			// Check if there's a potential attack 2 columns to the right 1 row down
			potientialAttack = new Point(col + 2, row - 1);
			if(knights.contains(potientialAttack))
				return false;
			
			// Check if there's a potential attack 2 columns to the left 1 row up
			potientialAttack = new Point(col - 2, row + 1);
			if(knights.contains(potientialAttack))
				return false;
			
			// Check if there's a potential attack 2 columns to the left 1 row down
			potientialAttack = new Point(col - 2, row - 1);
			if(knights.contains(potientialAttack))
				return false;

			// Check if there's a potential attack 1 column to the right 2 rows UP
			potientialAttack = new Point(col + 1, row + 2);
			if(knights.contains(potientialAttack))
				return false;

			// Check if there's a potential attack 1 column to the right 2 rows down
			potientialAttack = new Point(col + 1, row - 2);
			if(knights.contains(potientialAttack))
				return false;

			// Check if there's a potential attack 1 column to the left 2 rows up
			potientialAttack = new Point(col - 1, row + 2);
			if(knights.contains(potientialAttack))
				return false;

			// Check if there's a potential attack 1 column to the left 2 rows down
			potientialAttack = new Point(col - 1, row - 2);
			if(knights.contains(potientialAttack))
				return false;
		}

		return true; // No knights can attack one another 
	}

	// This method converts a column string of letters to integers 
	public static int convertColStringToInt(String coordinateStrings, int length)
	{ 
		int col = 0;
		int result = 0;

		for (int i = 0; i < length; i++)
		{
			result *= 26;
			col = ((int)coordinateStrings.charAt(i) - 'a' + 1);
			result += col;
		}

		return result;
	}

	// Returns a double indicating how difficult I found this assignment on a scale of 1.0 through 5.0
	public static double difficultyRating()
	{
		return 1.0;
	}

	// Return an estimate (greater than zero) of the number of hours you spent on this assignment.
	public static double hoursSpent ()
	{
		return 4.0;
	}


}