package com.baidu.kirin.d;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] b = new int[256];

    static {
        Arrays.fill(b, -1);
        int length = a.length;
        for (int i = 0; i < length; i++) {
            b[a[i]] = i;
        }
        b[61] = 0;
    }

    public static final String a(String str) {
        try {
            return new String(a(str.getBytes("UTF-8"), false));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Base64 encoding error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static final char[] a(byte[] bArr, boolean z) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i = (length / 3) * 3;
        int i2 = (((length - 1) / 3) + 1) << 2;
        int i3 = i2 + (z ? ((i2 - 1) / 76) << 1 : 0);
        char[] cArr = new char[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i) {
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr[i7] & 255) << 8) | ((bArr[i6] & 255) << 16);
            i6 = i8 + 1;
            int i10 = i9 | (bArr[i8] & 255);
            int i11 = i5 + 1;
            cArr[i5] = a[(i10 >>> 18) & 63];
            int i12 = i11 + 1;
            cArr[i11] = a[(i10 >>> 12) & 63];
            int i13 = i12 + 1;
            cArr[i12] = a[(i10 >>> 6) & 63];
            i5 = i13 + 1;
            cArr[i13] = a[i10 & 63];
            if (z && (i4 = i4 + 1) == 19 && i5 < i3 - 2) {
                int i14 = i5 + 1;
                cArr[i5] = '\r';
                cArr[i14] = '\n';
                i5 = i14 + 1;
                i4 = 0;
            }
        }
        int i15 = length - i;
        if (i15 > 0) {
            int i16 = (i15 == 2 ? (bArr[length - 1] & 255) << 2 : 0) | ((bArr[i] & 255) << 10);
            cArr[i3 - 4] = a[i16 >> 12];
            cArr[i3 - 3] = a[(i16 >>> 6) & 63];
            cArr[i3 - 2] = i15 == 2 ? a[i16 & 63] : '=';
            cArr[i3 - 1] = '=';
        }
        return cArr;
    }
}
