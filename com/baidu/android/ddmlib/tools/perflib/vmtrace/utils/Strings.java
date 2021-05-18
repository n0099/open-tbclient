package com.baidu.android.ddmlib.tools.perflib.vmtrace.utils;
/* loaded from: classes.dex */
public class Strings {
    public static String repeat(String str, int i2) {
        if (i2 <= 1) {
            return i2 == 0 ? "" : str;
        }
        int length = str.length();
        long j = length * i2;
        int i3 = (int) j;
        if (i3 == j) {
            char[] cArr = new char[i3];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i4 = i3 - length;
                if (length < i4) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i4);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
        }
    }
}
