package com.baidu.mapapi;
/* loaded from: classes.dex */
public class c {
    private static char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] b = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            b[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            b[i4] = (byte) ((i4 + 52) - 48);
        }
        b[43] = 62;
        b[47] = 63;
    }

    public static char[] a(char[] cArr) {
        boolean z;
        boolean z2;
        char[] cArr2 = new char[((cArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < cArr.length) {
            int i3 = (cArr[i2] & 255) << 8;
            if (i2 + 1 < cArr.length) {
                i3 |= cArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < cArr.length) {
                i4 |= cArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            cArr2[i + 3] = a[z2 ? i4 & 63 : 64];
            int i5 = i4 >> 6;
            cArr2[i + 2] = a[z ? i5 & 63 : 64];
            int i6 = i5 >> 6;
            cArr2[i + 1] = a[i6 & 63];
            cArr2[i + 0] = a[(i6 >> 6) & 63];
            i2 += 3;
            i += 4;
        }
        return cArr2;
    }

    public static char[] b(char[] cArr) {
        int i = 0;
        int length = ((cArr.length + 3) / 4) * 3;
        if (cArr.length > 0 && cArr[cArr.length - 1] == '=') {
            length--;
        }
        if (cArr.length > 1 && cArr[cArr.length - 2] == '=') {
            length--;
        }
        char[] cArr2 = new char[length];
        int i2 = 0;
        int i3 = 0;
        for (char c : cArr) {
            byte b2 = b[c & 255];
            if (b2 >= 0) {
                int i4 = i2 << 6;
                int i5 = i3 + 6;
                int i6 = i4 | b2;
                if (i5 >= 8) {
                    int i7 = i5 - 8;
                    cArr2[i] = (char) ((i6 >> i7) & 255);
                    i++;
                    i2 = i6;
                    i3 = i7;
                } else {
                    i3 = i5;
                    i2 = i6;
                }
            }
        }
        if (i != cArr2.length) {
            throw new Error("miscalculated data length!");
        }
        return cArr2;
    }
}
