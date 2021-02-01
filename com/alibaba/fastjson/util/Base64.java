package com.alibaba.fastjson.util;

import java.util.Arrays;
/* loaded from: classes4.dex */
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
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        int i5 = i;
        while (i5 < i4 && IA[cArr[i5]] < 0) {
            i5++;
        }
        int i6 = i4;
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        if (cArr[i6] == '=') {
            i3 = cArr[i6 + (-1)] == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i5) + 1;
        int i8 = i2 > 76 ? (cArr[76] == '\r' ? i7 / 78 : 0) << 1 : 0;
        int i9 = (((i7 - i8) * 6) >> 3) - i3;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i5 + 1;
            int i14 = i13 + 1;
            int i15 = (IA[cArr[i5]] << 18) | (IA[cArr[i13]] << 12);
            int i16 = i14 + 1;
            int i17 = (IA[cArr[i14]] << 6) | i15;
            int i18 = i16 + 1;
            int i19 = i17 | IA[cArr[i16]];
            int i20 = i12 + 1;
            bArr[i12] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i12 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i8 > 0 && (i11 = i11 + 1) == 19) {
                i18 += 2;
                i11 = 0;
            }
            i5 = i18;
        }
        if (i12 < i9) {
            int i22 = 0;
            int i23 = 0;
            while (i5 <= i6 - i3) {
                int i24 = i23 | (IA[cArr[i5]] << (18 - (i22 * 6)));
                i22++;
                i23 = i24;
                i5++;
            }
            int i25 = 16;
            for (int i26 = i12; i26 < i9; i26++) {
                bArr[i26] = (byte) (i23 >> i25);
                i25 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        int i5 = i;
        while (i5 < i4 && IA[str.charAt(i5)] < 0) {
            i5++;
        }
        int i6 = i4;
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
            i6--;
        }
        if (str.charAt(i6) == '=') {
            i3 = str.charAt(i6 + (-1)) == '=' ? 2 : 1;
        } else {
            i3 = 0;
        }
        int i7 = (i6 - i5) + 1;
        int i8 = i2 > 76 ? (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1 : 0;
        int i9 = (((i7 - i8) * 6) >> 3) - i3;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i5 + 1;
            int i14 = i13 + 1;
            int i15 = (IA[str.charAt(i5)] << 18) | (IA[str.charAt(i13)] << 12);
            int i16 = i14 + 1;
            int i17 = (IA[str.charAt(i14)] << 6) | i15;
            int i18 = i16 + 1;
            int i19 = i17 | IA[str.charAt(i16)];
            int i20 = i12 + 1;
            bArr[i12] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            i12 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i8 > 0 && (i11 = i11 + 1) == 19) {
                i18 += 2;
                i11 = 0;
            }
            i5 = i18;
        }
        if (i12 < i9) {
            int i22 = 0;
            int i23 = 0;
            while (i5 <= i6 - i3) {
                int i24 = i23 | (IA[str.charAt(i5)] << (18 - (i22 * 6)));
                i22++;
                i23 = i24;
                i5++;
            }
            int i25 = 16;
            for (int i26 = i12; i26 < i9; i26++) {
                bArr[i26] = (byte) (i23 >> i25);
                i25 -= 8;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && IA[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        int i4 = i2;
        while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        if (str.charAt(i4) == '=') {
            i = str.charAt(i4 + (-1)) == '=' ? 2 : 1;
        } else {
            i = 0;
        }
        int i5 = (i4 - i3) + 1;
        int i6 = length > 76 ? (str.charAt(76) == '\r' ? i5 / 78 : 0) << 1 : 0;
        int i7 = (((i5 - i6) * 6) >> 3) - i;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i10 < i8) {
            int i11 = i3 + 1;
            int i12 = i11 + 1;
            int i13 = (IA[str.charAt(i3)] << 18) | (IA[str.charAt(i11)] << 12);
            int i14 = i12 + 1;
            int i15 = (IA[str.charAt(i12)] << 6) | i13;
            int i16 = i14 + 1;
            int i17 = i15 | IA[str.charAt(i14)];
            int i18 = i10 + 1;
            bArr[i10] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            i10 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i6 > 0 && (i9 = i9 + 1) == 19) {
                i16 += 2;
                i9 = 0;
            }
            i3 = i16;
        }
        if (i10 < i7) {
            int i20 = 0;
            int i21 = 0;
            while (i3 <= i4 - i) {
                int i22 = i21 | (IA[str.charAt(i3)] << (18 - (i20 * 6)));
                i20++;
                i21 = i22;
                i3++;
            }
            int i23 = 16;
            for (int i24 = i10; i24 < i7; i24++) {
                bArr[i24] = (byte) (i21 >> i23);
                i23 -= 8;
            }
        }
        return bArr;
    }
}
