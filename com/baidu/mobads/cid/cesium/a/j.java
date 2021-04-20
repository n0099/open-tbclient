package com.baidu.mobads.cid.cesium.a;

import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8048a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f8049b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f8050c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8051d;

    /* renamed from: e  reason: collision with root package name */
    public int f8052e;

    /* renamed from: f  reason: collision with root package name */
    public int f8053f;

    public j() {
        this(0);
    }

    public j(int i) {
        this.f8048a = new byte[1];
        this.f8049b = new int[4];
        this.f8050c = new byte[16];
        this.f8051d = i;
        b();
    }

    public static int a(byte[] bArr, int i) {
        return (int) (b(bArr, i, 4) & 4294967295L);
    }

    public static long b(byte[] bArr, int i, int i2) {
        if (i2 <= 8) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j |= (bArr[i + i3] & 255) << (i3 * 8);
            }
            return j;
        }
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    private void b() {
        int[] iArr = this.f8049b;
        int i = this.f8051d;
        iArr[0] = i + XXHash32.PRIME1 + XXHash32.PRIME2;
        iArr[1] = XXHash32.PRIME2 + i;
        iArr[2] = i;
        iArr[3] = i - XXHash32.PRIME1;
    }

    private void b(byte[] bArr, int i) {
        int[] iArr = this.f8049b;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int rotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
        int[] iArr2 = this.f8049b;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f8053f = 0;
    }

    public long a() {
        int i = 0;
        int rotateLeft = (this.f8052e > 16 ? Integer.rotateLeft(this.f8049b[0], 1) + Integer.rotateLeft(this.f8049b[1], 7) + Integer.rotateLeft(this.f8049b[2], 12) + Integer.rotateLeft(this.f8049b[3], 18) : this.f8049b[2] + XXHash32.PRIME5) + this.f8052e;
        int i2 = this.f8053f - 4;
        while (i <= i2) {
            rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f8050c, i) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
            i += 4;
        }
        while (i < this.f8053f) {
            rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f8050c[i] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
            i++;
        }
        int i3 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
        int i4 = (i3 ^ (i3 >>> 13)) * XXHash32.PRIME3;
        return (i4 ^ (i4 >>> 16)) & 4294967295L;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f8052e += i2;
        int i3 = i + i2;
        int i4 = this.f8053f;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.f8050c, i4, i2);
            this.f8053f += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.f8050c, i4, i5);
            b(this.f8050c, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            b(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.f8053f = i7;
            System.arraycopy(bArr, i, this.f8050c, 0, i7);
        }
    }
}
