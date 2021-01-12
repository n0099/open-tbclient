package com.baidu.cesium.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class b implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1614a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1615b = 6;
    private static final int c = 64;
    private static final int d = 63;
    private static final long e = -1;
    private static final ObjectStreamField[] f;
    private static final long j = 7997698588986878753L;
    private long[] g;
    private transient int h;
    private transient boolean i;

    static {
        f1614a = !b.class.desiredAssertionStatus();
        f = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public b() {
        this.h = 0;
        this.i = false;
        j(64);
        this.i = false;
    }

    public b(int i) {
        this.h = 0;
        this.i = false;
        if (i < 0) {
            throw new NegativeArraySizeException("nbits < 0: " + i);
        }
        j(i);
        this.i = true;
    }

    private b(long[] jArr) {
        this.h = 0;
        this.i = false;
        this.g = jArr;
        this.h = jArr.length;
        h();
    }

    public static b a(ByteBuffer byteBuffer) {
        ByteBuffer order = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        int remaining = order.remaining();
        while (remaining > 0 && order.get(remaining - 1) == 0) {
            remaining--;
        }
        long[] jArr = new long[(remaining + 7) / 8];
        order.limit(remaining);
        int i = 0;
        while (order.remaining() >= 8) {
            jArr[i] = order.getLong();
            i++;
        }
        int remaining2 = order.remaining();
        for (int i2 = 0; i2 < remaining2; i2++) {
            jArr[i] = jArr[i] | ((order.get() & 255) << (i2 * 8));
        }
        return new b(jArr);
    }

    public static b a(LongBuffer longBuffer) {
        LongBuffer slice = longBuffer.slice();
        int remaining = slice.remaining();
        while (remaining > 0 && slice.get(remaining - 1) == 0) {
            remaining--;
        }
        long[] jArr = new long[remaining];
        slice.get(jArr);
        return new b(jArr);
    }

    public static b a(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }

    public static b a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new b(Arrays.copyOf(jArr, length));
    }

    private void a(ObjectInputStream objectInputStream) {
        this.g = (long[]) objectInputStream.readFields().get("bits", (Object) null);
        this.h = this.g.length;
        i();
        this.i = this.g.length > 0 && this.g[this.g.length + (-1)] == 0;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.g);
        objectOutputStream.writeFields();
    }

    private static void e(int i, int i2) {
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

    private void h() {
        if (!f1614a && this.h != 0 && this.g[this.h - 1] == 0) {
            throw new AssertionError();
        }
        if (!f1614a && (this.h < 0 || this.h > this.g.length)) {
            throw new AssertionError();
        }
        if (!f1614a && this.h != this.g.length && this.g[this.h] != 0) {
            throw new AssertionError();
        }
    }

    private static int i(int i) {
        return i >> 6;
    }

    private void i() {
        int i = this.h - 1;
        while (i >= 0 && this.g[i] == 0) {
            i--;
        }
        this.h = i + 1;
    }

    private void j() {
        if (this.h != this.g.length) {
            this.g = Arrays.copyOf(this.g, this.h);
            h();
        }
    }

    private void j(int i) {
        this.g = new long[i(i - 1) + 1];
    }

    private void k(int i) {
        if (this.g.length < i) {
            this.g = Arrays.copyOf(this.g, Math.max(this.g.length * 2, i));
            this.i = false;
        }
    }

    private void l(int i) {
        int i2 = i + 1;
        if (this.h < i2) {
            k(i2);
            this.h = i2;
        }
    }

    public void a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int i2 = i(i);
        l(i2);
        long[] jArr = this.g;
        jArr[i2] = jArr[i2] ^ (1 << i);
        i();
        h();
    }

    public void a(int i, int i2) {
        e(i, i2);
        if (i == i2) {
            return;
        }
        int i3 = i(i);
        int i4 = i(i2 - 1);
        l(i4);
        long j2 = (-1) << i;
        long j3 = (-1) >>> (-i2);
        if (i3 == i4) {
            long[] jArr = this.g;
            jArr[i3] = (j2 & j3) ^ jArr[i3];
        } else {
            long[] jArr2 = this.g;
            jArr2[i3] = j2 ^ jArr2[i3];
            for (int i5 = i3 + 1; i5 < i4; i5++) {
                long[] jArr3 = this.g;
                jArr3[i5] = jArr3[i5] ^ (-1);
            }
            long[] jArr4 = this.g;
            jArr4[i4] = jArr4[i4] ^ j3;
        }
        i();
        h();
    }

    public void a(int i, int i2, boolean z) {
        if (z) {
            b(i, i2);
        } else {
            c(i, i2);
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            b(i);
        } else {
            c(i);
        }
    }

    public boolean a(b bVar) {
        for (int min = Math.min(this.h, bVar.h) - 1; min >= 0; min--) {
            if ((this.g[min] & bVar.g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i = this.h;
        if (i == 0) {
            return new byte[0];
        }
        int i2 = (i - 1) * 8;
        for (long j2 = this.g[i - 1]; j2 != 0; j2 >>>= 8) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i3 = 0; i3 < i - 1; i3++) {
            order.putLong(this.g[i3]);
        }
        for (long j3 = this.g[i - 1]; j3 != 0; j3 >>>= 8) {
            order.put((byte) (255 & j3));
        }
        return bArr;
    }

    public void b(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int i2 = i(i);
        l(i2);
        long[] jArr = this.g;
        jArr[i2] = jArr[i2] | (1 << i);
        h();
    }

    public void b(int i, int i2) {
        e(i, i2);
        if (i == i2) {
            return;
        }
        int i3 = i(i);
        int i4 = i(i2 - 1);
        l(i4);
        long j2 = (-1) << i;
        long j3 = (-1) >>> (-i2);
        if (i3 == i4) {
            long[] jArr = this.g;
            jArr[i3] = (j2 & j3) | jArr[i3];
        } else {
            long[] jArr2 = this.g;
            jArr2[i3] = j2 | jArr2[i3];
            for (int i5 = i3 + 1; i5 < i4; i5++) {
                this.g[i5] = -1;
            }
            long[] jArr3 = this.g;
            jArr3[i4] = jArr3[i4] | j3;
        }
        h();
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        while (this.h > bVar.h) {
            long[] jArr = this.g;
            int i = this.h - 1;
            this.h = i;
            jArr[i] = 0;
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            long[] jArr2 = this.g;
            jArr2[i2] = jArr2[i2] & bVar.g[i2];
        }
        i();
        h();
    }

    public long[] b() {
        return Arrays.copyOf(this.g, this.h);
    }

    public void c() {
        while (this.h > 0) {
            long[] jArr = this.g;
            int i = this.h - 1;
            this.h = i;
            jArr[i] = 0;
        }
    }

    public void c(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int i2 = i(i);
        if (i2 >= this.h) {
            return;
        }
        long[] jArr = this.g;
        jArr[i2] = jArr[i2] & ((1 << i) ^ (-1));
        i();
        h();
    }

    public void c(int i, int i2) {
        int i3;
        int i4;
        e(i, i2);
        if (i != i2 && (i3 = i(i)) < this.h) {
            int i5 = i(i2 - 1);
            if (i5 >= this.h) {
                i2 = d();
                i4 = this.h - 1;
            } else {
                i4 = i5;
            }
            long j2 = (-1) << i;
            long j3 = (-1) >>> (-i2);
            if (i3 == i4) {
                long[] jArr = this.g;
                jArr[i3] = ((j2 & j3) ^ (-1)) & jArr[i3];
            } else {
                long[] jArr2 = this.g;
                jArr2[i3] = (j2 ^ (-1)) & jArr2[i3];
                for (int i6 = i3 + 1; i6 < i4; i6++) {
                    this.g[i6] = 0;
                }
                long[] jArr3 = this.g;
                jArr3[i4] = jArr3[i4] & (j3 ^ (-1));
            }
            i();
            h();
        }
    }

    public void c(b bVar) {
        if (this == bVar) {
            return;
        }
        int min = Math.min(this.h, bVar.h);
        if (this.h < bVar.h) {
            k(bVar.h);
            this.h = bVar.h;
        }
        for (int i = 0; i < min; i++) {
            long[] jArr = this.g;
            jArr[i] = jArr[i] | bVar.g[i];
        }
        if (min < bVar.h) {
            System.arraycopy(bVar.g, min, this.g, min, this.h - min);
        }
        h();
    }

    public Object clone() {
        if (!this.i) {
            j();
        }
        try {
            b bVar = (b) super.clone();
            bVar.g = (long[]) this.g.clone();
            bVar.h();
            return bVar;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    public int d() {
        if (this.h == 0) {
            return 0;
        }
        return ((this.h - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.g[this.h - 1]));
    }

    public b d(int i, int i2) {
        int i3;
        int i4 = 0;
        e(i, i2);
        h();
        int d2 = d();
        if (d2 <= i || i == i2) {
            return new b(0);
        }
        if (i2 > d2) {
            i2 = d2;
        }
        b bVar = new b(i2 - i);
        int i5 = i((i2 - i) - 1) + 1;
        int i6 = i(i);
        boolean z = (i & 63) == 0;
        while (true) {
            i3 = i6;
            if (i4 >= i5 - 1) {
                break;
            }
            bVar.g[i4] = z ? this.g[i3] : (this.g[i3] >>> i) | (this.g[i3 + 1] << (-i));
            i4++;
            i6 = i3 + 1;
        }
        long j2 = (-1) >>> (-i2);
        bVar.g[i5 - 1] = ((i2 + (-1)) & 63) < (i & 63) ? ((j2 & this.g[i3 + 1]) << (-i)) | (this.g[i3] >>> i) : (j2 & this.g[i3]) >>> i;
        bVar.h = i5;
        bVar.i();
        bVar.h();
        return bVar;
    }

    public void d(b bVar) {
        int min = Math.min(this.h, bVar.h);
        if (this.h < bVar.h) {
            k(bVar.h);
            this.h = bVar.h;
        }
        for (int i = 0; i < min; i++) {
            long[] jArr = this.g;
            jArr[i] = jArr[i] ^ bVar.g[i];
        }
        if (min < bVar.h) {
            System.arraycopy(bVar.g, min, this.g, min, bVar.h - min);
        }
        i();
        h();
    }

    public boolean d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        h();
        int i2 = i(i);
        return i2 < this.h && (this.g[i2] & (1 << i)) != 0;
    }

    public int e(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 >= this.h) {
            return -1;
        }
        long j2 = this.g[i2] & ((-1) << i);
        while (j2 == 0) {
            i2++;
            if (i2 == this.h) {
                return -1;
            }
            j2 = this.g[i2];
        }
        return (i2 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public void e(b bVar) {
        for (int min = Math.min(this.h, bVar.h) - 1; min >= 0; min--) {
            long[] jArr = this.g;
            jArr[min] = jArr[min] & (bVar.g[min] ^ (-1));
        }
        i();
        h();
    }

    public boolean e() {
        return this.h == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            h();
            bVar.h();
            if (this.h == bVar.h) {
                for (int i = 0; i < this.h; i++) {
                    if (this.g[i] != bVar.g[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int f() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.h) {
                return i3;
            }
            i = Long.bitCount(this.g[i2]) + i3;
            i2++;
        }
    }

    public int f(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 >= this.h) {
            return i;
        }
        long j2 = (this.g[i2] ^ (-1)) & ((-1) << i);
        while (j2 == 0) {
            i2++;
            if (i2 == this.h) {
                return this.h * 64;
            }
            j2 = this.g[i2] ^ (-1);
        }
        return (i2 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public int g() {
        return this.g.length * 64;
    }

    public int g(int i) {
        if (i < 0) {
            if (i == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 >= this.h) {
            return d() - 1;
        }
        long j2 = this.g[i2] & ((-1) >>> (-(i + 1)));
        while (j2 == 0) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                return -1;
            }
            j2 = this.g[i3];
            i2 = i3;
        }
        return (((i2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
    }

    public int h(int i) {
        if (i < 0) {
            if (i == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 < this.h) {
            long j2 = (this.g[i2] ^ (-1)) & ((-1) >>> (-(i + 1)));
            while (j2 == 0) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    return -1;
                }
                j2 = this.g[i3] ^ (-1);
                i2 = i3;
            }
            return (((i2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
        }
        return i;
    }

    public int hashCode() {
        long j2 = 1234;
        int i = this.h;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.g[i] * (i + 1);
        }
    }

    public String toString() {
        h();
        StringBuilder sb = new StringBuilder(((this.h > 128 ? f() : this.h * 64) * 6) + 2);
        sb.append('{');
        int e2 = e(0);
        if (e2 != -1) {
            sb.append(e2);
            int e3 = e(e2 + 1);
            while (e3 >= 0) {
                int f2 = f(e3);
                do {
                    sb.append(", ").append(e3);
                    e3++;
                } while (e3 < f2);
                e3 = e(e3 + 1);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
