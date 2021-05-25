package com.baidu.ad.magic.flute.a.a;

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
public class c implements Serializable, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public static final int f2110b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2111c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2112d = 63;

    /* renamed from: e  reason: collision with root package name */
    public static final long f2113e = -1;
    public static final long j = 7997698588986878753L;

    /* renamed from: g  reason: collision with root package name */
    public long[] f2115g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f2116h;

    /* renamed from: i  reason: collision with root package name */
    public transient boolean f2117i;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f2109a = !c.class.desiredAssertionStatus();

    /* renamed from: f  reason: collision with root package name */
    public static final ObjectStreamField[] f2114f = {new ObjectStreamField("bits", long[].class)};

    public c() {
        this.f2116h = 0;
        this.f2117i = false;
        j(64);
        this.f2117i = false;
    }

    public c(int i2) {
        this.f2116h = 0;
        this.f2117i = false;
        if (i2 >= 0) {
            j(i2);
            this.f2117i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public c(long[] jArr) {
        this.f2116h = 0;
        this.f2117i = false;
        this.f2115g = jArr;
        this.f2116h = jArr.length;
        h();
    }

    public static c a(ByteBuffer byteBuffer) {
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
        return new c(jArr);
    }

    public static c a(LongBuffer longBuffer) {
        LongBuffer slice = longBuffer.slice();
        int remaining = slice.remaining();
        while (remaining > 0 && slice.get(remaining - 1) == 0) {
            remaining--;
        }
        long[] jArr = new long[remaining];
        slice.get(jArr);
        return new c(jArr);
    }

    public static c a(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }

    public static c a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new c(Arrays.copyOf(jArr, length));
    }

    private void a(ObjectInputStream objectInputStream) {
        long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
        this.f2115g = jArr;
        this.f2116h = jArr.length;
        i();
        long[] jArr2 = this.f2115g;
        boolean z = true;
        this.f2117i = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.f2117i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.f2115g);
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
        if (!f2109a && (i3 = this.f2116h) != 0 && this.f2115g[i3 - 1] == 0) {
            throw new AssertionError();
        }
        if (!f2109a && ((i2 = this.f2116h) < 0 || i2 > this.f2115g.length)) {
            throw new AssertionError();
        }
        if (f2109a) {
            return;
        }
        int i4 = this.f2116h;
        long[] jArr = this.f2115g;
        if (i4 != jArr.length && jArr[i4] != 0) {
            throw new AssertionError();
        }
    }

    public static int i(int i2) {
        return i2 >> 6;
    }

    private void i() {
        int i2 = this.f2116h - 1;
        while (i2 >= 0 && this.f2115g[i2] == 0) {
            i2--;
        }
        this.f2116h = i2 + 1;
    }

    private void j() {
        int i2 = this.f2116h;
        long[] jArr = this.f2115g;
        if (i2 != jArr.length) {
            this.f2115g = Arrays.copyOf(jArr, i2);
            h();
        }
    }

    private void j(int i2) {
        this.f2115g = new long[i(i2 - 1) + 1];
    }

    private void k(int i2) {
        long[] jArr = this.f2115g;
        if (jArr.length < i2) {
            this.f2115g = Arrays.copyOf(this.f2115g, Math.max(jArr.length * 2, i2));
            this.f2117i = false;
        }
    }

    private void l(int i2) {
        int i3 = i2 + 1;
        if (this.f2116h < i3) {
            k(i3);
            this.f2116h = i3;
        }
    }

    public void a(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int i3 = i(i2);
        l(i3);
        long[] jArr = this.f2115g;
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
            long[] jArr = this.f2115g;
            jArr[i4] = (j3 & j2) ^ jArr[i4];
        } else {
            long[] jArr2 = this.f2115g;
            jArr2[i4] = jArr2[i4] ^ j2;
            while (true) {
                i4++;
                if (i4 >= i5) {
                    break;
                }
                long[] jArr3 = this.f2115g;
                jArr3[i4] = ~jArr3[i4];
            }
            long[] jArr4 = this.f2115g;
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

    public boolean a(c cVar) {
        for (int min = Math.min(this.f2116h, cVar.f2116h) - 1; min >= 0; min--) {
            if ((this.f2115g[min] & cVar.f2115g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i2 = this.f2116h;
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = i2 - 1;
        int i4 = i3 * 8;
        for (long j2 = this.f2115g[i3]; j2 != 0; j2 >>>= 8) {
            i4++;
        }
        byte[] bArr = new byte[i4];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i5 = 0; i5 < i3; i5++) {
            order.putLong(this.f2115g[i5]);
        }
        for (long j3 = this.f2115g[i3]; j3 != 0; j3 >>>= 8) {
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
        long[] jArr = this.f2115g;
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
            long[] jArr = this.f2115g;
            jArr[i4] = (j3 & j2) | jArr[i4];
        } else {
            long[] jArr2 = this.f2115g;
            jArr2[i4] = j2 | jArr2[i4];
            while (true) {
                i4++;
                if (i4 >= i5) {
                    break;
                }
                this.f2115g[i4] = -1;
            }
            long[] jArr3 = this.f2115g;
            jArr3[i5] = j3 | jArr3[i5];
        }
        h();
    }

    public void b(c cVar) {
        if (this == cVar) {
            return;
        }
        while (true) {
            int i2 = this.f2116h;
            if (i2 <= cVar.f2116h) {
                break;
            }
            long[] jArr = this.f2115g;
            int i3 = i2 - 1;
            this.f2116h = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f2116h; i4++) {
            long[] jArr2 = this.f2115g;
            jArr2[i4] = jArr2[i4] & cVar.f2115g[i4];
        }
        i();
        h();
    }

    public long[] b() {
        return Arrays.copyOf(this.f2115g, this.f2116h);
    }

    public void c() {
        while (true) {
            int i2 = this.f2116h;
            if (i2 <= 0) {
                return;
            }
            long[] jArr = this.f2115g;
            int i3 = i2 - 1;
            this.f2116h = i3;
            jArr[i3] = 0;
        }
    }

    public void c(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int i3 = i(i2);
        if (i3 >= this.f2116h) {
            return;
        }
        long[] jArr = this.f2115g;
        jArr[i3] = jArr[i3] & (~(1 << i2));
        i();
        h();
    }

    public void c(int i2, int i3) {
        int i4;
        e(i2, i3);
        if (i2 != i3 && (i4 = i(i2)) < this.f2116h) {
            int i5 = i(i3 - 1);
            if (i5 >= this.f2116h) {
                i3 = d();
                i5 = this.f2116h - 1;
            }
            long j2 = (-1) << i2;
            long j3 = (-1) >>> (-i3);
            if (i4 == i5) {
                long[] jArr = this.f2115g;
                jArr[i4] = (~(j3 & j2)) & jArr[i4];
            } else {
                long[] jArr2 = this.f2115g;
                jArr2[i4] = (~j2) & jArr2[i4];
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f2115g[i4] = 0;
                }
                long[] jArr3 = this.f2115g;
                jArr3[i5] = (~j3) & jArr3[i5];
            }
            i();
            h();
        }
    }

    public void c(c cVar) {
        if (this == cVar) {
            return;
        }
        int min = Math.min(this.f2116h, cVar.f2116h);
        int i2 = this.f2116h;
        int i3 = cVar.f2116h;
        if (i2 < i3) {
            k(i3);
            this.f2116h = cVar.f2116h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f2115g;
            jArr[i4] = jArr[i4] | cVar.f2115g[i4];
        }
        if (min < cVar.f2116h) {
            System.arraycopy(cVar.f2115g, min, this.f2115g, min, this.f2116h - min);
        }
        h();
    }

    public Object clone() {
        if (!this.f2117i) {
            j();
        }
        try {
            c cVar = (c) super.clone();
            cVar.f2115g = (long[]) this.f2115g.clone();
            cVar.h();
            return cVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d() {
        int i2 = this.f2116h;
        if (i2 == 0) {
            return 0;
        }
        return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f2115g[i2 - 1]));
    }

    public c d(int i2, int i3) {
        int i4;
        long j2;
        e(i2, i3);
        h();
        int d2 = d();
        int i5 = 0;
        if (d2 <= i2 || i2 == i3) {
            return new c(0);
        }
        if (i3 > d2) {
            i3 = d2;
        }
        int i6 = i3 - i2;
        c cVar = new c(i6);
        int i7 = i(i6 - 1) + 1;
        int i8 = i(i2);
        int i9 = i2 & 63;
        boolean z = i9 == 0;
        while (true) {
            i4 = i7 - 1;
            if (i5 >= i4) {
                break;
            }
            long[] jArr = cVar.f2115g;
            long[] jArr2 = this.f2115g;
            jArr[i5] = z ? jArr2[i8] : (jArr2[i8] >>> i2) | (jArr2[i8 + 1] << (-i2));
            i5++;
            i8++;
        }
        long j3 = (-1) >>> (-i3);
        long[] jArr3 = cVar.f2115g;
        if (((i3 - 1) & 63) < i9) {
            long[] jArr4 = this.f2115g;
            j2 = ((jArr4[i8 + 1] & j3) << (-i2)) | (jArr4[i8] >>> i2);
        } else {
            j2 = (this.f2115g[i8] & j3) >>> i2;
        }
        jArr3[i4] = j2;
        cVar.f2116h = i7;
        cVar.i();
        cVar.h();
        return cVar;
    }

    public void d(c cVar) {
        int min = Math.min(this.f2116h, cVar.f2116h);
        int i2 = this.f2116h;
        int i3 = cVar.f2116h;
        if (i2 < i3) {
            k(i3);
            this.f2116h = cVar.f2116h;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f2115g;
            jArr[i4] = jArr[i4] ^ cVar.f2115g[i4];
        }
        int i5 = cVar.f2116h;
        if (min < i5) {
            System.arraycopy(cVar.f2115g, min, this.f2115g, min, i5 - min);
        }
        i();
        h();
    }

    public boolean d(int i2) {
        if (i2 >= 0) {
            h();
            int i3 = i(i2);
            return i3 < this.f2116h && (this.f2115g[i3] & (1 << i2)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public int e(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f2116h) {
            return -1;
        }
        long j2 = this.f2115g[i3] & ((-1) << i2);
        while (j2 == 0) {
            i3++;
            if (i3 == this.f2116h) {
                return -1;
            }
            j2 = this.f2115g[i3];
        }
        return (i3 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public void e(c cVar) {
        for (int min = Math.min(this.f2116h, cVar.f2116h) - 1; min >= 0; min--) {
            long[] jArr = this.f2115g;
            jArr[min] = jArr[min] & (~cVar.f2115g[min]);
        }
        i();
        h();
    }

    public boolean e() {
        return this.f2116h == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            h();
            cVar.h();
            if (this.f2116h != cVar.f2116h) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2116h; i2++) {
                if (this.f2115g[i2] != cVar.f2115g[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2116h; i3++) {
            i2 += Long.bitCount(this.f2115g[i3]);
        }
        return i2;
    }

    public int f(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        h();
        int i3 = i(i2);
        if (i3 >= this.f2116h) {
            return i2;
        }
        long j2 = (~this.f2115g[i3]) & ((-1) << i2);
        while (j2 == 0) {
            i3++;
            int i4 = this.f2116h;
            if (i3 == i4) {
                return i4 * 64;
            }
            j2 = ~this.f2115g[i3];
        }
        return (i3 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public int g() {
        return this.f2115g.length * 64;
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
        if (i3 >= this.f2116h) {
            return d() - 1;
        }
        long j2 = this.f2115g[i3] & ((-1) >>> (-(i2 + 1)));
        while (j2 == 0) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return -1;
            }
            j2 = this.f2115g[i4];
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
        if (i3 >= this.f2116h) {
            return i2;
        }
        long j2 = (~this.f2115g[i3]) & ((-1) >>> (-(i2 + 1)));
        while (j2 == 0) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return -1;
            }
            j2 = ~this.f2115g[i4];
            i3 = i4;
        }
        return (((i3 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
    }

    public int hashCode() {
        int i2 = this.f2116h;
        long j2 = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f2115g[i2] * (i2 + 1);
        }
    }

    public String toString() {
        h();
        int i2 = this.f2116h;
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
