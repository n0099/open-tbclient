package com.alibaba.fastjson.util;

import java.util.Arrays;
/* loaded from: classes.dex */
public class Base64 {
    public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int[] IA;

    static {
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = CA.length;
        for (int i2 = 0; i2 < length; i2++) {
            IA[CA[i2]] = i2;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i6 = (i2 + i3) - 1;
        while (i2 < i6 && IA[cArr[i2]] < 0) {
            i2++;
        }
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        int i7 = cArr[i6] == '=' ? cArr[i6 + (-1)] == '=' ? 2 : 1 : 0;
        int i8 = (i6 - i2) + 1;
        if (i3 > 76) {
            i4 = (cArr[76] == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr = IA;
            int i13 = i2 + 1;
            int i14 = i13 + 1;
            int i15 = (iArr[cArr[i2]] << 18) | (iArr[cArr[i13]] << 12);
            int i16 = i14 + 1;
            int i17 = i15 | (iArr[cArr[i14]] << 6);
            int i18 = i16 + 1;
            int i19 = i17 | iArr[cArr[i16]];
            int i20 = i11 + 1;
            bArr[i11] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            int i22 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                i2 = i18;
            } else {
                i2 = i18 + 2;
                i12 = 0;
            }
            i11 = i22;
        }
        if (i11 < i9) {
            int i23 = 0;
            while (i2 <= i6 - i7) {
                i5 |= IA[cArr[i2]] << (18 - (i23 * 6));
                i23++;
                i2++;
            }
            int i24 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i5 >> i24);
                i24 -= 8;
                i11++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i6 = (i2 + i3) - 1;
        while (i2 < i6 && IA[str.charAt(i2)] < 0) {
            i2++;
        }
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
            i6--;
        }
        int i7 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
        int i8 = (i6 - i2) + 1;
        if (i3 > 76) {
            i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i2 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = (IA[str.charAt(i2)] << 18) | (IA[str.charAt(i13)] << 12) | (IA[str.charAt(i14)] << 6) | IA[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                i2 = i16;
            } else {
                i2 = i16 + 2;
                i12 = 0;
            }
            i11 = i20;
        }
        if (i11 < i9) {
            int i21 = 0;
            while (i2 <= i6 - i7) {
                i5 |= IA[str.charAt(i2)] << (18 - (i21 * 6));
                i21++;
                i2++;
            }
            int i22 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i5 >> i22);
                i22 -= 8;
                i11++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i4 = length - 1;
        int i5 = 0;
        while (i5 < i4 && IA[str.charAt(i5) & 255] < 0) {
            i5++;
        }
        while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        int i6 = str.charAt(i4) == '=' ? str.charAt(i4 + (-1)) == '=' ? 2 : 1 : 0;
        int i7 = (i4 - i5) + 1;
        if (length > 76) {
            i2 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i8 = (((i7 - i2) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i5 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = (IA[str.charAt(i5)] << 18) | (IA[str.charAt(i12)] << 12) | (IA[str.charAt(i13)] << 6) | IA[str.charAt(i14)];
            int i17 = i10 + 1;
            bArr[i10] = (byte) (i16 >> 16);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (i16 >> 8);
            int i19 = i18 + 1;
            bArr[i18] = (byte) i16;
            if (i2 <= 0 || (i11 = i11 + 1) != 19) {
                i5 = i15;
            } else {
                i5 = i15 + 2;
                i11 = 0;
            }
            i10 = i19;
        }
        if (i10 < i8) {
            int i20 = 0;
            while (i5 <= i4 - i6) {
                i3 |= IA[str.charAt(i5)] << (18 - (i20 * 6));
                i20++;
                i5++;
            }
            int i21 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i3 >> i21);
                i21 -= 8;
                i10++;
            }
        }
        return bArr;
    }
}
