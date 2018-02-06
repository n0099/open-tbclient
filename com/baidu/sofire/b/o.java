package com.baidu.sofire.b;
/* loaded from: classes.dex */
public final class o {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr3[i] = (byte) i;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i2 = (i2 + (bArr2[i3] & 255) + (bArr3[i4] & 255)) & 255;
                byte b = bArr3[i4];
                bArr3[i4] = bArr3[i2];
                bArr3[i2] = b;
                i3 = (i3 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i6 = (i6 + 1) & 255;
            i5 = (i5 + (bArr3[i6] & 255)) & 255;
            byte b2 = bArr3[i6];
            bArr3[i6] = bArr3[i5];
            bArr3[i5] = b2;
            bArr4[i7] = (byte) (bArr3[((bArr3[i6] & 255) + (bArr3[i5] & 255)) & 255] ^ bArr[i7]);
            bArr4[i7] = (byte) (bArr4[i7] ^ 42);
        }
        return bArr4;
    }
}
