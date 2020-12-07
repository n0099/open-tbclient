package com.baidu.helios.channels.csc;
/* loaded from: classes11.dex */
public class a {
    private static final byte[][] awA = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};

    /* renamed from: com.baidu.helios.channels.csc.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0148a {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f1804a;
        private int b;

        public C0148a(byte[] bArr, int i) {
            this.f1804a = bArr;
            this.b = i;
        }

        public byte[] a() {
            return this.f1804a;
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
        byte b;
        int i2;
        int i3 = i % 3;
        if (i3 == 1) {
            i2 = i + 2;
            b = 2;
        } else if (i3 == 2) {
            i2 = i + 1;
            b = 1;
        } else {
            b = 0;
            i2 = i;
        }
        int i4 = (i2 / 3) * 2;
        if (b > 0) {
            i4++;
        }
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (byte b2 : bArr) {
            for (int i7 = 7; i7 >= 0; i7--) {
                bArr2[i6] = (byte) ((bArr2[i6] << 1) | ((b2 >> i7) & 1));
                if (i5 % 3 == 2) {
                    bArr2[i6 + 1] = awA[bArr2[i6]][1];
                    bArr2[i6] = awA[bArr2[i6]][0];
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
        if (b > 0) {
            bArr2[i6] = (byte) (bArr2[i6] << b);
            bArr2[i6 + 1] = awA[bArr2[i6]][1];
            bArr2[i6] = awA[bArr2[i6]][0];
            bArr2[i6 + 2] = b;
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    public static C0148a x(byte[] bArr) {
        int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
        int i = length / 8;
        if (length % 8 > 0) {
            i++;
        }
        byte[] bArr2 = new byte[i];
        byte b = 8;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length - 1; i3 += 2) {
            byte b2 = (byte) (((bArr[i3] * 3) + bArr[i3 + 1]) & 255);
            byte b3 = 2;
            while (b3 >= 0) {
                if (b <= 0) {
                    i2++;
                    b = 8;
                }
                if (i2 >= i) {
                    break;
                }
                bArr2[i2] = (byte) ((bArr2[i2] << 1) | ((b2 >> b3) & 1));
                b3--;
                b--;
            }
        }
        if (b > 0 && i2 < i) {
            bArr2[i2] = (byte) (bArr2[i2] << b);
        }
        return new C0148a(bArr2, length);
    }
}
