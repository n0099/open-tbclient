package cn.jiguang.d.c;
/* loaded from: classes3.dex */
public final class e {
    private byte[] a;
    private int b;
    private int c;

    public e() {
        this(32);
    }

    private e(int i) {
        this.a = new byte[32];
        this.b = 0;
        this.c = -1;
    }

    private static void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + " out of range for " + i + " bit value");
        }
    }

    private void d(int i) {
        if (this.a.length - this.b >= i) {
            return;
        }
        int length = this.a.length * 2;
        if (length < this.b + i) {
            length = this.b + i;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.a, 0, bArr, 0, this.b);
        this.a = bArr;
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i) {
        if (i > this.b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.b = i;
    }

    public final void a(int i, int i2) {
        a(i, 16);
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.a[i2] = (byte) ((i >>> 8) & 255);
        this.a[i2 + 1] = (byte) (i & 255);
    }

    public final void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((j >>> 24) & 255);
        byte[] bArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr2[i2] = (byte) ((j >>> 16) & 255);
        byte[] bArr3 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        bArr3[i3] = (byte) ((j >>> 8) & 255);
        byte[] bArr4 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        bArr4[i4] = (byte) (j & 255);
    }

    public final void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public final void a(byte[] bArr, int i, int i2) {
        d(i2);
        System.arraycopy(bArr, i, this.a, this.b, i2);
        this.b += i2;
    }

    public final void b(int i) {
        a(0L, 8);
        d(1);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = 0;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.b];
        System.arraycopy(this.a, 0, bArr, 0, this.b);
        return bArr;
    }

    public final void c(int i) {
        a(i, 16);
        d(2);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        bArr2[i3] = (byte) (i & 255);
    }
}
