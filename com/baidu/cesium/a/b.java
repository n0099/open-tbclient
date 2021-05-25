package com.baidu.cesium.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b implements Serializable, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public static final int f4537b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4538c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4539d = 63;

    /* renamed from: e  reason: collision with root package name */
    public static final long f4540e = -1;
    public static final long j = 7997698588986878753L;

    /* renamed from: g  reason: collision with root package name */
    public long[] f4542g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f4543h;

    /* renamed from: i  reason: collision with root package name */
    public transient boolean f4544i;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f4536a = !b.class.desiredAssertionStatus();

    /* renamed from: f  reason: collision with root package name */
    public static final ObjectStreamField[] f4541f = {new ObjectStreamField("bits", long[].class)};

    public b() {
        this.f4543h = 0;
        this.f4544i = false;
        j(64);
        this.f4544i = false;
    }

    public b(int i2) {
        this.f4543h = 0;
        this.f4544i = false;
        if (i2 >= 0) {
            j(i2);
            this.f4544i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public b(long[] jArr) {
        this.f4543h = 0;
        this.f4544i = false;
        this.f4542g = jArr;
        this.f4543h = jArr.length;
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
        int i2 = 0;
        while (order.remaining() >= 8) {
            jArr[i2] = order.getLong();
            i2++;
        }
        int remaining2 = order.remaining();
        for (int i3 = 0; i3 < remaining2; i3++) {
            jArr[i2] = jArr[i2] | ((order.get() & 255) << (i3 * 8));
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
        long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
        this.f4542g = jArr;
        this.f4543h = jArr.length;
        i();
        long[] jArr2 = this.f4542g;
        boolean z = true;
        this.f4544i = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.f4544i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.f4542g);
        objectOutputStream.writeFields();
    }

    public static void e(int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i3);
        } else if (i2 <= i3) {
        } else {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + " > toIndex: " + i3);
        }
    }

    private void h() {
        int i2;
        int i3;
        if (!f4536a && (i3 = this.f4543h) != 0 && this.f4542g[i3 - 1] == 0) {
            throw new AssertionError();
        }
        if (!f4536a && ((i2 = this.f4543h) < 0 || i2 > this.f4542g.length)) {
            throw new AssertionError();
        }
        if (f4536a) {
            return;
        }
        int i4 = this.f4543h;
        long[] jArr = this.f4542g;
        if (i4 != jArr.length && jArr[i4] != 0) {
            throw new AssertionError();
        }
    }

    public static int i(int i2) {
        return i2 >> 6;
    }

    private void i() {
        int i2 = this.f4543h - 1;
        while (i2 >= 0 && this.f4542g[i2] == 0) {
            i2--;
        }
        this.f4543h = i2 + 1;
    }

    private void j() {
        int i2 = this.f4543h;
        long[] jArr = this.f4542g;
        if (i2 != jArr.length) {
            this.f4542g = Arrays.copyOf(jArr, i2);
            h();
        }
    }

    private void j(int i2) {
        this.f4542g = new long[i(i2 - 1) + 1];
    }

    private void k(int i2) {
        long[] jArr = this.f4542g;
        if (jArr.length < i2) {
            this.f4542g = Arrays.copyOf(this.f4542g, Math.max(jArr.length * 2, i2));
            this.f4544i = false;
        }
    }

    private void l(int i2) {
        int i3 = i2 + 1;
        if (this.f4543h < i3) {
            k(i3);
            this.f4543h = i3;
        }
    }

    public void a(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int i3 = i(i2);
        l(i3);
        long[] jArr = this.f4542g;
        jArr[i3] = jArr[i3] ^ (1 << i2);
        i();
        h();
    }

    public void a(int i2, int i3) {
        e(i2, i3);
        if (i2 == i3) {
            return;
        }
        int i4 = i(i2);
        int i5 = i(i3 - 1);
        l(i5);
        long j2 = (-1) << i2;
        long j3 = (-1) >>> (-i3);
        if (i4 == i5) {
            long[] jArr = this.f4542g;
            jArr[i4] = (j3 & j2) ^ jArr[i4];
        } else {
            long[] jArr2 = this.f4542g;
            jArr2[i4] = jArr2[i4] ^ j2;
            while (true) {
                i4++;
                if (i4 >= i5) {
                    break;
                }
                long[] jArr3 = this.f4542g;
                jArr3[i4] = ~jArr3[i4];
            }
            long[] jArr4 = this.f4542g;
            jArr4[i5] = j3 ^ jArr4[i5];
        }
        i();
        h();
    }

    public void a(int i2, int i3, boolean z) {
        if (z) {
            b(i2, i3);
        } else {
            c(i2, i3);
        }
    }

    public void a(int i2, boolean z) {
        if (z) {
            b(i2);
        } else {
            c(i2);
        }
    }

    public boolean a(b bVar) {
        for (int min = Math.min(this.f4543h, bVar.f4543h) - 1; min >= 0; min--) {
            if ((this.f4542g[min] & bVar.f4542g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i2 = this.f4543h;
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = i2 - 1;
        int i4 = i3 * 8;
        for (long j2 = this.f4542g[i3]; j2 != 0; j2 >>>= 8) {
            i4++;
        }
        byte[] bArr = new byte[i4];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i5 = 0; i5 < i3; i5++) {
            order.putLong(this.f4542g[i5]);
        }
        for (long j3 = this.f4542g[i3]; j3 != 0; j3 >>>= 8) {
            order.put((byte) (255 & j3));
        }
        return bArr;
    }

    public void b(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int i3 = i(i2);
        l(i3);
        long[] jArr = this.f4542g;
        jArr[i3] = jArr[i3] | (1 << i2);
        h();
    }

    public void b(int i2, int i3) {
        e(i2, i3);
        if (i2 == i3) {
            return;
        }
        int i4 = i(i2);
        int i5 = i(i3 - 1);
        l(i5);
        long j2 = (-1) << i2;
        long j3 = (-1) >>> (-i3);
        if (i4 == i5) {
            long[] jArr = this.f4542g;
            jArr[i4] = (j3 & j2) | jArr[i4];
        } else {
            long[] jArr2 = this.f4542g;
            jArr2[i4] = j2 | jArr2[i4];
            while (true) {
                i4++;
                if (i4 >= i5) {
                    break;
                }
                this.f4542g[i4] = -1;
            }
            long[] jArr3 = this.f4542g;
            jArr3[i5] = j3 | jArr3[i5];
        }
        h();
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        while (true) {
            int i2 = this.f4543h;
            if (i2 <= bVar.f4543h) {
                break;
            }
            long[] jArr = this.f4542g;
            int i3 = i2 - 1;
            this.f4543h = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f4543h; i4++) {
            long[] jArr2 = this.f4542g;
            jArr2[i4] = jArr2[i4] & bVar.f4542g[i4];
        }
        i();
        h();
    }

    public long[] b() {
        return Arrays.copyOf(this.f4542g, this.f4543h);
    }

    public void c() {
        while (true) {
            int i2 = this.f4543h;
            if (i2 <= 0) {
                return;
            }
            long[] jArr = this.f4542g;
            int i3 = i2 - 1;
            this.f4543h = i3;
            jArr[i3] = 0;
        }
    }

    public void c(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int i3 = i(i2);
        if (i3 >= this.f4543h) {
            return;
        }
        long[] jArr = this.f4542g;
        jArr[i3] = jArr[i3] & (~(1 << i2));
        i();
        h();
    }

    public void c(int i2, int i3) {
        int i4;
        e(i2, i3);
        if (i2 != i3 && (i4 = i(i2)) < this.f4543h) {
            int i5 = i(i3 - 1);
            if (i5 >= this.f4543h) {
                i3 = d();
                i5 = this.f4543h - 1;
            }
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f4542g;
                jArr[i4] = (~(j3 & j2)) & jArr[i4];
            } else {
                long[] jArr2 = this.f4542g;
                jArr2[i4] = (~j2) & jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f4542g[i4] = 0;
                }
                long[] jArr3 = this.f4542g;
                jArr3[i5] = (~j3) & jArr3[i5];
            }
            i();
            h();
        }
    }

    public void c(b bVar) {
        if (this == bVar) {
            return;
        }
        int min = Math.min(this.f4543h, bVar.f4543h);
        int i2 = this.f4543h;
        int i3 = bVar.f4543h;
        if (i2 < i3) {
            k(i3);
            this.f4543h = bVar.f4543h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f4542g;
            jArr[i4] = jArr[i4] | bVar.f4542g[i4];
        }
        if (min < bVar.f4543h) {
            System.arraycopy(bVar.f4542g, min, this.f4542g, min, this.f4543h - min);
        }
        h();
    }

    public Object clone() {
        if (!this.f4544i) {
            j();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f4542g = (long[]) this.f4542g.clone();
            bVar.h();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d() {
        int i2 = this.f4543h;
        if (i2 == 0) {
            return 0;
        }
        return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f4542g[i2 - 1]));
    }

    public b d(int i2, int i3) {
        int i4;
        long j2;
        e(i2, i3);
        h();
        int d2 = d();
        int i5 = 0;
        if (d2 <= i2 || i2 == i3) {
            return new b(0);
        }
        if (i3 > d2) {
            i3 = d2;
        }
        int i6 = i3 - i2;
        b bVar = new b(i6);
        int i7 = i(i6 - 1) + 1;
        int i8 = i(i2);
        int i9 = i2 & 63;
        boolean z = i9 == 0;
        while (true) {
            i4 = i7 - 1;
            if (i5 >= i4) {
                break;
            }
            long[] jArr = bVar.f4542g;
            long[] jArr2 = this.f4542g;
            jArr[i5] = z ? jArr2[i8] : (jArr2[i8] >>> i2) | (jArr2[i8 + 1] << (-i2));
            i5++;
            i8++;
        }
        long j3 = (-1) >>> (-i3);
        long[] jArr3 = bVar.f4542g;
        if (((i3 - 1) & 63) < i9) {
            long[] jArr4 = this.f4542g;
            j2 = ((jArr4[i8 + 1] & j3) << (-i2)) | (jArr4[i8] >>> i2);
        } else {
            j2 = (this.f4542g[i8] & j3) >>> i2;
        }
        jArr3[i4] = j2;
        bVar.f4543h = i7;
        bVar.i();
        bVar.h();
        return bVar;
    }

    public void d(b bVar) {
        int min = Math.min(this.f4543h, bVar.f4543h);
        int i2 = this.f4543h;
        int i3 = bVar.f4543h;
        if (i2 < i3) {
            k(i3);
            this.f4543h = bVar.f4543h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f4542g;
            jArr[i4] = jArr[i4] ^ bVar.f4542g[i4];
        }
        int i5 = bVar.f4543h;
        if (min < i5) {
            System.arraycopy(bVar.f4542g, min, this.f4542g, min, i5 - min);
        }
        i();
        h();
    }

    public boolean d(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            return i3 < this.f4543h && (this.f4542g[i3] & (1 << i2)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public int e(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f4543h) {
            return -1;
        }
        long j2 = this.f4542g[i3] & ((-1) << i2);
        while (j2 == 0) {
            i3++;
            if (i3 == this.f4543h) {
                return -1;
            }
            j2 = this.f4542g[i3];
        }
        return (i3 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public void e(b bVar) {
        for (int min = Math.min(this.f4543h, bVar.f4543h) - 1; min >= 0; min--) {
            long[] jArr = this.f4542g;
            jArr[min] = jArr[min] & (~bVar.f4542g[min]);
        }
        i();
        h();
    }

    public boolean e() {
        return this.f4543h == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            h();
            bVar.h();
            if (this.f4543h != bVar.f4543h) {
                return false;
            }
            for (int i2 = 0; i2 < this.f4543h; i2++) {
                if (this.f4542g[i2] != bVar.f4542g[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4543h; i3++) {
            i2 += Long.bitCount(this.f4542g[i3]);
        }
        return i2;
    }

    public int f(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f4543h) {
            return i2;
        }
        long j2 = (~this.f4542g[i3]) & ((-1) << i2);
        while (j2 == 0) {
            i3++;
            int i4 = this.f4543h;
            if (i3 == i4) {
                return i4 * 64;
            }
            j2 = ~this.f4542g[i3];
        }
        return (i3 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public int g() {
        return this.f4542g.length * 64;
    }

    public int g(int i2) {
        if (i2 < 0) {
            if (i2 == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f4543h) {
            return d() - 1;
        }
        long j2 = this.f4542g[i3] & ((-1) >>> (-(i2 + 1)));
        while (j2 == 0) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return -1;
            }
            j2 = this.f4542g[i4];
            i3 = i4;
        }
        return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
    }

    public int h(int i2) {
        if (i2 < 0) {
            if (i2 == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f4543h) {
            return i2;
        }
        long j2 = (~this.f4542g[i3]) & ((-1) >>> (-(i2 + 1)));
        while (j2 == 0) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return -1;
            }
            j2 = ~this.f4542g[i4];
            i3 = i4;
        }
        return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
    }

    public int hashCode() {
        int i2 = this.f4543h;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f4542g[i2] * (i2 + 1);
        }
    }

    public String toString() {
        h();
        int i2 = this.f4543h;
        StringBuilder sb = new StringBuilder(((i2 > 128 ? f() : i2 * 64) * 6) + 2);
        sb.append('{');
        int e2 = e(0);
        if (e2 != -1) {
            sb.append(e2);
            while (true) {
                e2 = e(e2 + 1);
                if (e2 < 0) {
                    break;
                }
                int f2 = f(e2);
                do {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(e2);
                    e2++;
                } while (e2 < f2);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
