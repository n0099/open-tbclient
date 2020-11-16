package com.baidu.b.a;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class b implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1244a;
    private static final ObjectStreamField[] b;
    private long[] c;
    private transient int d;
    private transient boolean e;

    static {
        f1244a = !b.class.desiredAssertionStatus();
        b = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public b() {
        this.d = 0;
        this.e = false;
        g(64);
        this.e = false;
    }

    public b(int i) {
        this.d = 0;
        this.e = false;
        if (i < 0) {
            throw new NegativeArraySizeException("nbits < 0: " + i);
        }
        g(i);
        this.e = true;
    }

    private b(long[] jArr) {
        this.d = 0;
        this.e = false;
        this.c = jArr;
        this.d = jArr.length;
        d();
    }

    public static b a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new b(Arrays.copyOf(jArr, length));
    }

    private void d() {
        if (!f1244a && this.d != 0 && this.c[this.d - 1] == 0) {
            throw new AssertionError();
        }
        if (!f1244a && (this.d < 0 || this.d > this.c.length)) {
            throw new AssertionError();
        }
        if (!f1244a && this.d != this.c.length && this.c[this.d] != 0) {
            throw new AssertionError();
        }
    }

    private static void d(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i2);
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + " > toIndex: " + i2);
        }
    }

    private void e() {
        int i = this.d - 1;
        while (i >= 0 && this.c[i] == 0) {
            i--;
        }
        this.d = i + 1;
    }

    private static int f(int i) {
        return i >> 6;
    }

    private void f() {
        if (this.d != this.c.length) {
            this.c = Arrays.copyOf(this.c, this.d);
            d();
        }
    }

    private void g(int i) {
        this.c = new long[f(i - 1) + 1];
    }

    private void h(int i) {
        if (this.c.length < i) {
            this.c = Arrays.copyOf(this.c, Math.max(this.c.length * 2, i));
            this.e = false;
        }
    }

    private void i(int i) {
        int i2 = i + 1;
        if (this.d < i2) {
            h(i2);
            this.d = i2;
        }
    }

    public void a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int f = f(i);
        i(f);
        long[] jArr = this.c;
        jArr[f] = jArr[f] | (1 << i);
        d();
    }

    public void a(int i, int i2) {
        d(i, i2);
        if (i == i2) {
            return;
        }
        int f = f(i);
        int f2 = f(i2 - 1);
        i(f2);
        long j = (-1) << i;
        long j2 = (-1) >>> (-i2);
        if (f == f2) {
            long[] jArr = this.c;
            jArr[f] = (j & j2) | jArr[f];
        } else {
            long[] jArr2 = this.c;
            jArr2[f] = j | jArr2[f];
            for (int i3 = f + 1; i3 < f2; i3++) {
                this.c[i3] = -1;
            }
            long[] jArr3 = this.c;
            jArr3[f2] = jArr3[f2] | j2;
        }
        d();
    }

    public void a(int i, int i2, boolean z) {
        if (z) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            a(i);
        } else {
            b(i);
        }
    }

    public void a(b bVar) {
        if (this == bVar) {
            return;
        }
        while (this.d > bVar.d) {
            long[] jArr = this.c;
            int i = this.d - 1;
            this.d = i;
            jArr[i] = 0;
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            long[] jArr2 = this.c;
            jArr2[i2] = jArr2[i2] & bVar.c[i2];
        }
        e();
        d();
    }

    public byte[] a() {
        int i = this.d;
        if (i == 0) {
            return new byte[0];
        }
        int i2 = (i - 1) * 8;
        for (long j = this.c[i - 1]; j != 0; j >>>= 8) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i3 = 0; i3 < i - 1; i3++) {
            order.putLong(this.c[i3]);
        }
        for (long j2 = this.c[i - 1]; j2 != 0; j2 >>>= 8) {
            order.put((byte) (255 & j2));
        }
        return bArr;
    }

    public int b() {
        if (this.d == 0) {
            return 0;
        }
        return ((this.d - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.c[this.d - 1]));
    }

    public void b(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int f = f(i);
        if (f >= this.d) {
            return;
        }
        long[] jArr = this.c;
        jArr[f] = jArr[f] & ((1 << i) ^ (-1));
        e();
        d();
    }

    public void b(int i, int i2) {
        int f;
        int i3;
        d(i, i2);
        if (i != i2 && (f = f(i)) < this.d) {
            int f2 = f(i2 - 1);
            if (f2 >= this.d) {
                i2 = b();
                i3 = this.d - 1;
            } else {
                i3 = f2;
            }
            long j = (-1) << i;
            long j2 = (-1) >>> (-i2);
            if (f == i3) {
                long[] jArr = this.c;
                jArr[f] = ((j & j2) ^ (-1)) & jArr[f];
            } else {
                long[] jArr2 = this.c;
                jArr2[f] = (j ^ (-1)) & jArr2[f];
                for (int i4 = f + 1; i4 < i3; i4++) {
                    this.c[i4] = 0;
                }
                long[] jArr3 = this.c;
                jArr3[i3] = jArr3[i3] & (j2 ^ (-1));
            }
            e();
            d();
        }
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        int min = Math.min(this.d, bVar.d);
        if (this.d < bVar.d) {
            h(bVar.d);
            this.d = bVar.d;
        }
        for (int i = 0; i < min; i++) {
            long[] jArr = this.c;
            jArr[i] = jArr[i] | bVar.c[i];
        }
        if (min < bVar.d) {
            System.arraycopy(bVar.c, min, this.c, min, this.d - min);
        }
        d();
    }

    public int c() {
        int i = 0;
        for (int i2 = 0; i2 < this.d; i2++) {
            i += Long.bitCount(this.c[i2]);
        }
        return i;
    }

    public b c(int i, int i2) {
        int i3;
        int i4 = 0;
        d(i, i2);
        d();
        int b2 = b();
        if (b2 <= i || i == i2) {
            return new b(0);
        }
        if (i2 > b2) {
            i2 = b2;
        }
        b bVar = new b(i2 - i);
        int f = f((i2 - i) - 1) + 1;
        int f2 = f(i);
        boolean z = (i & 63) == 0;
        while (true) {
            i3 = f2;
            if (i4 >= f - 1) {
                break;
            }
            bVar.c[i4] = z ? this.c[i3] : (this.c[i3] >>> i) | (this.c[i3 + 1] << (-i));
            i4++;
            f2 = i3 + 1;
        }
        long j = (-1) >>> (-i2);
        bVar.c[f - 1] = ((i2 + (-1)) & 63) < (i & 63) ? ((j & this.c[i3 + 1]) << (-i)) | (this.c[i3] >>> i) : (j & this.c[i3]) >>> i;
        bVar.d = f;
        bVar.e();
        bVar.d();
        return bVar;
    }

    public void c(b bVar) {
        int min = Math.min(this.d, bVar.d);
        if (this.d < bVar.d) {
            h(bVar.d);
            this.d = bVar.d;
        }
        for (int i = 0; i < min; i++) {
            long[] jArr = this.c;
            jArr[i] = jArr[i] ^ bVar.c[i];
        }
        if (min < bVar.d) {
            System.arraycopy(bVar.c, min, this.c, min, bVar.d - min);
        }
        e();
        d();
    }

    public boolean c(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        d();
        int f = f(i);
        return f < this.d && (this.c[f] & (1 << i)) != 0;
    }

    public Object clone() {
        if (!this.e) {
            f();
        }
        try {
            b bVar = (b) super.clone();
            bVar.c = (long[]) this.c.clone();
            bVar.d();
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public int d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int f = f(i);
        if (f >= this.d) {
            return -1;
        }
        long j = this.c[f] & ((-1) << i);
        while (j == 0) {
            f++;
            if (f == this.d) {
                return -1;
            }
            j = this.c[f];
        }
        return (f * 64) + Long.numberOfTrailingZeros(j);
    }

    public void d(b bVar) {
        for (int min = Math.min(this.d, bVar.d) - 1; min >= 0; min--) {
            long[] jArr = this.c;
            jArr[min] = jArr[min] & (bVar.c[min] ^ (-1));
        }
        e();
        d();
    }

    public int e(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int f = f(i);
        if (f >= this.d) {
            return i;
        }
        long j = (this.c[f] ^ (-1)) & ((-1) << i);
        while (j == 0) {
            f++;
            if (f == this.d) {
                return this.d * 64;
            }
            j = this.c[f] ^ (-1);
        }
        return (f * 64) + Long.numberOfTrailingZeros(j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            d();
            bVar.d();
            if (this.d == bVar.d) {
                for (int i = 0; i < this.d; i++) {
                    if (this.c[i] != bVar.c[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = 1234;
        int i = this.d;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j >> 32) ^ j);
            }
            j ^= this.c[i] * (i + 1);
        }
    }

    public String toString() {
        d();
        StringBuilder sb = new StringBuilder(((this.d > 128 ? c() : this.d * 64) * 6) + 2);
        sb.append('{');
        int d = d(0);
        if (d != -1) {
            sb.append(d);
            int d2 = d(d + 1);
            while (d2 >= 0) {
                int e = e(d2);
                do {
                    sb.append(", ").append(d2);
                    d2++;
                } while (d2 < e);
                d2 = d(d2 + 1);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
