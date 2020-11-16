package com.baidu.helios.common.cc;
/* loaded from: classes10.dex */
class h {
    private final byte[] h;
    private final int[] i;
    private final byte[] j;
    private final int k;
    private int l;
    private int m;

    /* JADX INFO: Access modifiers changed from: protected */
    public h() {
        this(0);
    }

    protected h(int i) {
        this.h = new byte[1];
        this.i = new int[4];
        this.j = new byte[16];
        this.k = i;
        c();
    }

    private static int a(byte[] bArr, int i) {
        return (int) (j(bArr, i, 4) & 4294967295L);
    }

    private void c() {
        this.i[0] = (this.k - 1640531535) - 2048144777;
        this.i[1] = this.k - 2048144777;
        this.i[2] = this.k;
        this.i[3] = this.k - (-1640531535);
    }

    private void g(byte[] bArr, int i) {
        int i2 = this.i[0];
        int i3 = this.i[1];
        int i4 = this.i[2];
        int i5 = this.i[3];
        this.i[0] = Integer.rotateLeft(i2 + (a(bArr, i) * (-2048144777)), 13) * (-1640531535);
        this.i[1] = Integer.rotateLeft(i3 + (a(bArr, i + 4) * (-2048144777)), 13) * (-1640531535);
        this.i[2] = Integer.rotateLeft(i4 + (a(bArr, i + 8) * (-2048144777)), 13) * (-1640531535);
        this.i[3] = Integer.rotateLeft(i5 + (a(bArr, i + 12) * (-2048144777)), 13) * (-1640531535);
        this.m = 0;
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
    public void a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.l += i2;
        int i3 = i + i2;
        if (this.m + i2 < 16) {
            System.arraycopy(bArr, i, this.j, this.m, i2);
            this.m += i2;
            return;
        }
        if (this.m > 0) {
            int i4 = 16 - this.m;
            System.arraycopy(bArr, i, this.j, this.m, i4);
            g(this.j, 0);
            i += i4;
        }
        int i5 = i3 - 16;
        while (i <= i5) {
            g(bArr, i);
            i += 16;
        }
        if (i < i3) {
            this.m = i3 - i;
            System.arraycopy(bArr, i, this.j, 0, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b() {
        int rotateLeft = (this.l > 16 ? Integer.rotateLeft(this.i[0], 1) + Integer.rotateLeft(this.i[1], 7) + Integer.rotateLeft(this.i[2], 12) + Integer.rotateLeft(this.i[3], 18) : this.i[2] + 374761393) + this.l;
        int i = this.m - 4;
        int i2 = rotateLeft;
        int i3 = 0;
        while (i3 <= i) {
            i2 = Integer.rotateLeft(i2 + (a(this.j, i3) * (-1028477379)), 17) * 668265263;
            i3 += 4;
        }
        int i4 = i2;
        while (i3 < this.m) {
            i4 = Integer.rotateLeft(((this.j[i3] & 255) * 374761393) + i4, 11) * (-1640531535);
            i3++;
        }
        int i5 = ((i4 >>> 15) ^ i4) * (-2048144777);
        int i6 = (i5 ^ (i5 >>> 13)) * (-1028477379);
        return (i6 ^ (i6 >>> 16)) & 4294967295L;
    }
}
