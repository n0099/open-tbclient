package com.alibaba.fastjson.util;

import java.util.Arrays;
/* loaded from: classes10.dex */
public class Base64 {
    public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int[] IA = new int[256];

    static {
        Arrays.fill(IA, -1);
        int length = CA.length;
        for (int i = 0; i < length; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        int i6 = i;
        while (i6 < i5 && IA[cArr[i6]] < 0) {
            i6++;
        }
        int i7 = i5;
        while (i7 > 0 && IA[cArr[i7]] < 0) {
            i7--;
        }
        if (cArr[i7] == '=') {
            i3 = cArr[i7 + (-1)] == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i8 = (i7 - i6) + 1;
        int i9 = i2 > 76 ? (cArr[76] == '\r' ? i8 / 78 : 0) << 1 : 0;
        int i10 = (((i8 - i9) * 6) >> 3) - i3;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = i6 + 1;
            int i15 = i14 + 1;
            int i16 = (IA[cArr[i6]] << 18) | (IA[cArr[i14]] << 12);
            int i17 = i15 + 1;
            int i18 = (IA[cArr[i15]] << 6) | i16;
            i6 = i17 + 1;
            int i19 = i18 | IA[cArr[i17]];
            int i20 = i13 + 1;
            bArr[i13] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i13 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i9 > 0 && (i12 = i12 + 1) == 19) {
                i6 += 2;
                i12 = 0;
            }
        }
        if (i13 < i10) {
            int i22 = 0;
            for (int i23 = i6; i23 <= i7 - i3; i23++) {
                i4++;
                i22 = (IA[cArr[i23]] << (18 - (i4 * 6))) | i22;
            }
            int i24 = 16;
            for (int i25 = i13; i25 < i10; i25++) {
                bArr[i25] = (byte) (i22 >> i24);
                i24 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        int i6 = i;
        while (i6 < i5 && IA[str.charAt(i6)] < 0) {
            i6++;
        }
        int i7 = i5;
        while (i7 > 0 && IA[str.charAt(i7)] < 0) {
            i7--;
        }
        if (str.charAt(i7) == '=') {
            i3 = str.charAt(i7 + (-1)) == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i8 = (i7 - i6) + 1;
        int i9 = i2 > 76 ? (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1 : 0;
        int i10 = (((i8 - i9) * 6) >> 3) - i3;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = i6 + 1;
            int i15 = i14 + 1;
            int i16 = (IA[str.charAt(i6)] << 18) | (IA[str.charAt(i14)] << 12);
            int i17 = i15 + 1;
            int i18 = (IA[str.charAt(i15)] << 6) | i16;
            i6 = i17 + 1;
            int i19 = i18 | IA[str.charAt(i17)];
            int i20 = i13 + 1;
            bArr[i13] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i13 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i9 > 0 && (i12 = i12 + 1) == 19) {
                i6 += 2;
                i12 = 0;
            }
        }
        if (i13 < i10) {
            int i22 = 0;
            for (int i23 = i6; i23 <= i7 - i3; i23++) {
                i4++;
                i22 = (IA[str.charAt(i23)] << (18 - (i4 * 6))) | i22;
            }
            int i24 = 16;
            for (int i25 = i13; i25 < i10; i25++) {
                bArr[i25] = (byte) (i22 >> i24);
                i24 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i;
        int i2 = 0;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < i3 && IA[str.charAt(i4) & 255] < 0) {
            i4++;
        }
        int i5 = i3;
        while (i5 > 0 && IA[str.charAt(i5) & 255] < 0) {
            i5--;
        }
        if (str.charAt(i5) == '=') {
            i = str.charAt(i5 + (-1)) == '=' ? 2 : 1;
        } else {
            i = 0;
        }
        int i6 = (i5 - i4) + 1;
        int i7 = length > 76 ? (str.charAt(76) == '\r' ? i6 / 78 : 0) << 1 : 0;
        int i8 = (((i6 - i7) * 6) >> 3) - i;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9) {
            int i12 = i4 + 1;
            int i13 = i12 + 1;
            int i14 = (IA[str.charAt(i4)] << 18) | (IA[str.charAt(i12)] << 12);
            int i15 = i13 + 1;
            int i16 = (IA[str.charAt(i13)] << 6) | i14;
            i4 = i15 + 1;
            int i17 = i16 | IA[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i11 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i7 > 0 && (i10 = i10 + 1) == 19) {
                i4 += 2;
                i10 = 0;
            }
        }
        if (i11 < i8) {
            int i20 = 0;
            for (int i21 = i4; i21 <= i5 - i; i21++) {
                i2++;
                i20 = (IA[str.charAt(i21)] << (18 - (i2 * 6))) | i20;
            }
            int i22 = 16;
            for (int i23 = i11; i23 < i8; i23++) {
                bArr[i23] = (byte) (i20 >> i22);
                i22 -= 8;
            }
        }
        return bArr;
    }
}
