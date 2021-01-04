package com.baidu.b.a;
/* loaded from: classes15.dex */
class k {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f1571a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1572b;
    private final byte[] c;
    private final int d;
    private int e;
    private int f;

    /* JADX INFO: Access modifiers changed from: protected */
    public k() {
        this(0);
    }

    protected k(int i) {
        this.f1571a = new byte[1];
        this.f1572b = new int[4];
        this.c = new byte[16];
        this.d = i;
        b();
    }

    private static int a(byte[] bArr, int i) {
        return (int) (j(bArr, i, 4) & 4294967295L);
    }

    private void b() {
        this.f1572b[0] = (this.d - 1640531535) - 2048144777;
        this.f1572b[1] = this.d - 2048144777;
        this.f1572b[2] = this.d;
        this.f1572b[3] = this.d - (-1640531535);
    }

    private void f(byte[] bArr, int i) {
        int i2 = this.f1572b[0];
        int i3 = this.f1572b[1];
        int i4 = this.f1572b[2];
        int i5 = this.f1572b[3];
        this.f1572b[0] = Integer.rotateLeft(i2 + (a(bArr, i) * (-2048144777)), 13) * (-1640531535);
        this.f1572b[1] = Integer.rotateLeft(i3 + (a(bArr, i + 4) * (-2048144777)), 13) * (-1640531535);
        this.f1572b[2] = Integer.rotateLeft(i4 + (a(bArr, i + 8) * (-2048144777)), 13) * (-1640531535);
        this.f1572b[3] = Integer.rotateLeft(i5 + (a(bArr, i + 12) * (-2048144777)), 13) * (-1640531535);
        this.f = 0;
    }

    private static long j(byte[] bArr, int i, int i2) {
        if (i2 > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (bArr[i + i3] & 255) << (i3 * 8);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a() {
        int rotateLeft = this.e + (this.e > 16 ? Integer.rotateLeft(this.f1572b[0], 1) + Integer.rotateLeft(this.f1572b[1], 7) + Integer.rotateLeft(this.f1572b[2], 12) + Integer.rotateLeft(this.f1572b[3], 18) : this.f1572b[2] + 374761393);
        int i = this.f - 4;
        int i2 = 0;
        while (i2 <= i) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.c, i2) * (-1028477379)), 17) * 668265263;
            i2 += 4;
        }
        int i3 = rotateLeft;
        while (i2 < this.f) {
            i3 = (-1640531535) * Integer.rotateLeft(((this.c[i2] & 255) * 374761393) + i3, 11);
            i2++;
        }
        int i4 = ((i3 >>> 15) ^ i3) * (-2048144777);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477379);
        return (i5 ^ (i5 >>> 16)) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.e += i2;
        int i3 = i + i2;
        if (this.f + i2 < 16) {
            System.arraycopy(bArr, i, this.c, this.f, i2);
            this.f += i2;
            return;
        }
        if (this.f > 0) {
            int i4 = 16 - this.f;
            System.arraycopy(bArr, i, this.c, this.f, i4);
            f(this.c, 0);
            i += i4;
        }
        int i5 = i3 - 16;
        while (i <= i5) {
            f(bArr, i);
            i += 16;
        }
        if (i < i3) {
            this.f = i3 - i;
            System.arraycopy(bArr, i, this.c, 0, this.f);
        }
    }
}
