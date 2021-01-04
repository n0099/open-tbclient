package com.baidu.helios.channels.csc;
/* loaded from: classes15.dex */
public class a {
    private static final byte[][] awV = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    /* renamed from: com.baidu.helios.channels.csc.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0140a {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f2479a;

        /* renamed from: b  reason: collision with root package name */
        private int f2480b;

        public C0140a(byte[] bArr, int i) {
            this.f2479a = bArr;
            this.f2480b = i;
        }

        public byte[] a() {
            return this.f2479a;
        }
    }

    public static int a(int i) {
        char c = 2;
        int i2 = i % 3;
        if (i2 == 1) {
            i += 2;
        } else if (i2 == 2) {
            i++;
            c = 1;
        } else {
            c = 0;
        }
        int i3 = (i / 3) * 2;
        return c > 0 ? i3 + 1 : i3;
    }

    public static byte[] a(byte[] bArr, int i) {
        byte b2;
        int i2;
        int i3 = i % 3;
        if (i3 == 1) {
            i2 = i + 2;
            b2 = 2;
        } else if (i3 == 2) {
            i2 = i + 1;
            b2 = 1;
        } else {
            b2 = 0;
            i2 = i;
        }
        int i4 = (i2 / 3) * 2;
        if (b2 > 0) {
            i4++;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (byte b3 : bArr) {
            for (int i7 = 7; i7 >= 0; i7--) {
                bArr2[i6] = (byte) ((bArr2[i6] << 1) | ((b3 >> i7) & 1));
                if (i5 % 3 == 2) {
                    bArr2[i6 + 1] = awV[bArr2[i6]][1];
                    bArr2[i6] = awV[bArr2[i6]][0];
                    i6 += 2;
                }
                i5++;
                if (i5 == i) {
                    break;
                }
            }
            if (i5 == i) {
                break;
            }
        }
        if (b2 > 0) {
            bArr2[i6] = (byte) (bArr2[i6] << b2);
            bArr2[i6 + 1] = awV[bArr2[i6]][1];
            bArr2[i6] = awV[bArr2[i6]][0];
            bArr2[i6 + 2] = b2;
        }
        return bArr2;
    }

    public static C0140a u(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i = length / 8;
        if (length % 8 > 0) {
            i++;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 8;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length - 1; i4 += 2) {
            byte b2 = (byte) (((bArr[i4] * 3) + bArr[i4 + 1]) & 255);
            for (int i5 = 2; i5 >= 0; i5--) {
                if (i2 <= 0) {
                    i3++;
                    i2 = 8;
                }
                if (i3 >= i) {
                    break;
                }
                bArr2[i3] = (byte) ((bArr2[i3] << 1) | ((b2 >> i5) & 1));
                i2--;
            }
        }
        if (i2 > 0 && i3 < i) {
            bArr2[i3] = (byte) (bArr2[i3] << i2);
        }
        return new C0140a(bArr2, length);
    }
}
