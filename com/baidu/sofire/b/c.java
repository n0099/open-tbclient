package com.baidu.sofire.b;
/* loaded from: classes.dex */
public final class c {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = (length / 4) * 3;
        if (i6 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i6];
        int i7 = length;
        int i8 = 0;
        while (true) {
            byte b = bArr[i7 - 1];
            if (b != 10 && b != 13 && b != 32 && b != 9) {
                if (b != 61) {
                    break;
                }
                i8++;
            }
            i7--;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i7) {
            byte b2 = bArr[i9];
            if (b2 == 10 || b2 == 13 || b2 == 32 || b2 == 9) {
                i = i10;
                i2 = i12;
                i3 = i11;
            } else {
                if (b2 >= 65 && b2 <= 90) {
                    i4 = b2 - 65;
                } else if (b2 >= 97 && b2 <= 122) {
                    i4 = b2 - 71;
                } else if (b2 >= 48 && b2 <= 57) {
                    i4 = b2 + 4;
                } else if (b2 == 43) {
                    i4 = 62;
                } else if (b2 == 47) {
                    i4 = 63;
                } else {
                    return null;
                }
                int i13 = (i10 << 6) | ((byte) i4);
                if (i11 % 4 == 3) {
                    int i14 = i12 + 1;
                    bArr2[i12] = (byte) ((16711680 & i13) >> 16);
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) ((65280 & i13) >> 8);
                    i5 = i15 + 1;
                    bArr2[i15] = (byte) (i13 & 255);
                } else {
                    i5 = i12;
                }
                i3 = i11 + 1;
                i2 = i5;
                i = i13;
            }
            i9++;
            i11 = i3;
            i12 = i2;
            i10 = i;
        }
        if (i8 > 0) {
            int i16 = i10 << (i8 * 6);
            int i17 = i12 + 1;
            bArr2[i12] = (byte) ((16711680 & i16) >> 16);
            if (i8 == 1) {
                i12 = i17 + 1;
                bArr2[i17] = (byte) ((65280 & i16) >> 8);
            } else {
                i12 = i17;
            }
        }
        byte[] bArr3 = new byte[i12];
        System.arraycopy(bArr2, 0, bArr3, 0, i12);
        return bArr3;
    }
}
