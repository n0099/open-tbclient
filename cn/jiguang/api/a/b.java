package cn.jiguang.api.a;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class b {
    private static final BigInteger kt = BigInteger.ONE.shiftLeft(64);
    private byte[] a;
    private int b;
    private int c;

    public b() {
        this(32);
    }

    public b(int i) {
        this.a = new byte[i];
        this.b = 0;
        this.c = -1;
    }

    private void a(int i) {
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

    public void b(long j, int i) {
        if (i > this.b - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        int i2 = i + 1;
        this.a[i] = (byte) ((j >>> 24) & 255);
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((j >>> 16) & 255);
        this.a[i3] = (byte) ((j >>> 8) & 255);
        this.a[i3 + 1] = (byte) (j & 255);
    }

    public void c(long j, int i) {
        int i2 = i + 1;
        this.a[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        this.a[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        this.a[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        this.a[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        this.a[i6] = (byte) ((j >>> 16) & 255);
        this.a[i7] = (byte) ((j >>> 8) & 255);
        this.a[i7 + 1] = (byte) (j & 255);
    }

    public int current() {
        return this.b;
    }

    public void f(byte[] bArr) {
        l(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void g(long j) {
        a(4);
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

    public void h(long j) {
        a(8);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        byte[] bArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr2[i2] = (byte) ((j >>> 48) & 255);
        byte[] bArr3 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        bArr3[i3] = (byte) ((j >>> 40) & 255);
        byte[] bArr4 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        bArr4[i4] = (byte) ((j >>> 32) & 255);
        byte[] bArr5 = this.a;
        int i5 = this.b;
        this.b = i5 + 1;
        bArr5[i5] = (byte) ((j >>> 24) & 255);
        byte[] bArr6 = this.a;
        int i6 = this.b;
        this.b = i6 + 1;
        bArr6[i6] = (byte) ((j >>> 16) & 255);
        byte[] bArr7 = this.a;
        int i7 = this.b;
        this.b = i7 + 1;
        bArr7[i7] = (byte) ((j >>> 8) & 255);
        byte[] bArr8 = this.a;
        int i8 = this.b;
        this.b = i8 + 1;
        bArr8[i8] = (byte) (j & 255);
    }

    public void k(int i) {
        a(1);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void k(int i, int i2) {
        if (i2 > this.b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.a[i2] = (byte) (i & 255);
    }

    public void l(int i) {
        a(2);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        bArr2[i3] = (byte) (i & 255);
    }

    public void l(int i, int i2) {
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.a[i2] = (byte) ((i >>> 8) & 255);
        this.a[i2 + 1] = (byte) (i & 255);
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.b];
        System.arraycopy(this.a, 0, bArr, 0, this.b);
        return bArr;
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        a(i2);
        System.arraycopy(bArr, i, this.a, this.b, i2);
        this.b += i2;
    }
}
