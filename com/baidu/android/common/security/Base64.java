package com.baidu.android.common.security;

import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4 = (i / 4) * 3;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i - 1];
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i) {
            byte b3 = bArr[i6];
            if (b3 == 10 || b3 == 13 || b3 == 32) {
                i2 = i9;
            } else if (b3 == 9) {
                i2 = i9;
            } else {
                if (b3 >= 65 && b3 <= 90) {
                    i3 = b3 - 65;
                } else if (b3 >= 97 && b3 <= 122) {
                    i3 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i3 = b3 + 4;
                } else if (b3 == 43) {
                    i3 = 62;
                } else if (b3 == 47) {
                    i3 = 63;
                } else {
                    return null;
                }
                i7 = (i7 << 6) | ((byte) i3);
                if (i8 % 4 == 3) {
                    int i10 = i9 + 1;
                    bArr2[i9] = (byte) ((16711680 & i7) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & i7) >> 8);
                    i2 = i11 + 1;
                    bArr2[i11] = (byte) (i7 & 255);
                } else {
                    i2 = i9;
                }
                i8++;
            }
            i6++;
            i9 = i2;
        }
        if (i5 > 0) {
            int i12 = i7 << (i5 * 6);
            int i13 = i9 + 1;
            bArr2[i9] = (byte) ((16711680 & i12) >> 16);
            if (i5 == 1) {
                i9 = i13 + 1;
                bArr2[i13] = (byte) ((65280 & i12) >> 8);
            } else {
                i9 = i13;
            }
        }
        byte[] bArr3 = new byte[i9];
        System.arraycopy(bArr2, 0, bArr3, 0, i9);
        return bArr3;
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int i;
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[length + (length / 76) + 3];
        int length2 = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4 += 3) {
            int i5 = i3 + 1;
            bArr2[i3] = MAP[(bArr[i4] & 255) >> 2];
            int i6 = i5 + 1;
            bArr2[i5] = MAP[((bArr[i4] & 3) << 4) | ((bArr[i4 + 1] & 255) >> 4)];
            int i7 = i6 + 1;
            bArr2[i6] = MAP[((bArr[i4 + 1] & 15) << 2) | ((bArr[i4 + 2] & 255) >> 6)];
            int i8 = i7 + 1;
            bArr2[i7] = MAP[bArr[i4 + 2] & 63];
            if ((i8 - i2) % 76 != 0 || i8 == 0) {
                i3 = i8;
            } else {
                i3 = i8 + 1;
                bArr2[i8] = 10;
                i2++;
            }
        }
        switch (bArr.length % 3) {
            case 1:
                int i9 = i3 + 1;
                bArr2[i3] = MAP[(bArr[length2] & 255) >> 2];
                int i10 = i9 + 1;
                bArr2[i9] = MAP[(bArr[length2] & 3) << 4];
                int i11 = i10 + 1;
                bArr2[i10] = 61;
                i = i11 + 1;
                bArr2[i11] = 61;
                break;
            case 2:
                int i12 = i3 + 1;
                bArr2[i3] = MAP[(bArr[length2] & 255) >> 2];
                int i13 = i12 + 1;
                bArr2[i12] = MAP[((bArr[length2] & 3) << 4) | ((bArr[length2 + 1] & 255) >> 4)];
                int i14 = i13 + 1;
                bArr2[i13] = MAP[(bArr[length2 + 1] & 15) << 2];
                i = i14 + 1;
                bArr2[i14] = 61;
                break;
            default:
                i = i3;
                break;
        }
        return new String(bArr2, 0, i, str);
    }
}
