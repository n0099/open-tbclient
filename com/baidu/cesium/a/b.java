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
    public static final int f4542b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4543c = 64;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4544d = 63;

    /* renamed from: e  reason: collision with root package name */
    public static final long f4545e = -1;
    public static final long j = 7997698588986878753L;

    /* renamed from: g  reason: collision with root package name */
    public long[] f4547g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f4548h;
    public transient boolean i;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f4541a = !b.class.desiredAssertionStatus();

    /* renamed from: f  reason: collision with root package name */
    public static final ObjectStreamField[] f4546f = {new ObjectStreamField("bits", long[].class)};

    public b() {
        this.f4548h = 0;
        this.i = false;
        j(64);
        this.i = false;
    }

    public b(int i) {
        this.f4548h = 0;
        this.i = false;
        if (i >= 0) {
            j(i);
            this.i = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i);
    }

    public b(long[] jArr) {
        this.f4548h = 0;
        this.i = false;
        this.f4547g = jArr;
        this.f4548h = jArr.length;
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
        long[] jArr = (long[]) objectInputStream.readFields().get("bits", (Object) null);
        this.f4547g = jArr;
        this.f4548h = jArr.length;
        i();
        long[] jArr2 = this.f4547g;
        boolean z = true;
        this.i = (jArr2.length <= 0 || jArr2[jArr2.length - 1] != 0) ? false : false;
        h();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        h();
        if (!this.i) {
            j();
        }
        objectOutputStream.putFields().put("bits", this.f4547g);
        objectOutputStream.writeFields();
    }

    public static void e(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i2);
        } else if (i <= i2) {
        } else {
            throw new IndexOutOfBoundsException("fromIndex: " + i + " > toIndex: " + i2);
        }
    }

    private void h() {
        int i;
        int i2;
        if (!f4541a && (i2 = this.f4548h) != 0 && this.f4547g[i2 - 1] == 0) {
            throw new AssertionError();
        }
        if (!f4541a && ((i = this.f4548h) < 0 || i > this.f4547g.length)) {
            throw new AssertionError();
        }
        if (f4541a) {
            return;
        }
        int i3 = this.f4548h;
        long[] jArr = this.f4547g;
        if (i3 != jArr.length && jArr[i3] != 0) {
            throw new AssertionError();
        }
    }

    public static int i(int i) {
        return i >> 6;
    }

    private void i() {
        int i = this.f4548h - 1;
        while (i >= 0 && this.f4547g[i] == 0) {
            i--;
        }
        this.f4548h = i + 1;
    }

    private void j() {
        int i = this.f4548h;
        long[] jArr = this.f4547g;
        if (i != jArr.length) {
            this.f4547g = Arrays.copyOf(jArr, i);
            h();
        }
    }

    private void j(int i) {
        this.f4547g = new long[i(i - 1) + 1];
    }

    private void k(int i) {
        long[] jArr = this.f4547g;
        if (jArr.length < i) {
            this.f4547g = Arrays.copyOf(this.f4547g, Math.max(jArr.length * 2, i));
            this.i = false;
        }
    }

    private void l(int i) {
        int i2 = i + 1;
        if (this.f4548h < i2) {
            k(i2);
            this.f4548h = i2;
        }
    }

    public void a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int i2 = i(i);
        l(i2);
        long[] jArr = this.f4547g;
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
            long[] jArr = this.f4547g;
            jArr[i3] = (j3 & j2) ^ jArr[i3];
        } else {
            long[] jArr2 = this.f4547g;
            jArr2[i3] = jArr2[i3] ^ j2;
            while (true) {
                i3++;
                if (i3 >= i4) {
                    break;
                }
                long[] jArr3 = this.f4547g;
                jArr3[i3] = ~jArr3[i3];
            }
            long[] jArr4 = this.f4547g;
            jArr4[i4] = j3 ^ jArr4[i4];
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
        for (int min = Math.min(this.f4548h, bVar.f4548h) - 1; min >= 0; min--) {
            if ((this.f4547g[min] & bVar.f4547g[min]) != 0) {
                return true;
            }
        }
        return false;
    }

    public byte[] a() {
        int i = this.f4548h;
        if (i == 0) {
            return new byte[0];
        }
        int i2 = i - 1;
        int i3 = i2 * 8;
        for (long j2 = this.f4547g[i2]; j2 != 0; j2 >>>= 8) {
            i3++;
        }
        byte[] bArr = new byte[i3];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i4 = 0; i4 < i2; i4++) {
            order.putLong(this.f4547g[i4]);
        }
        for (long j3 = this.f4547g[i2]; j3 != 0; j3 >>>= 8) {
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
        long[] jArr = this.f4547g;
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
            long[] jArr = this.f4547g;
            jArr[i3] = (j3 & j2) | jArr[i3];
        } else {
            long[] jArr2 = this.f4547g;
            jArr2[i3] = j2 | jArr2[i3];
            while (true) {
                i3++;
                if (i3 >= i4) {
                    break;
                }
                this.f4547g[i3] = -1;
            }
            long[] jArr3 = this.f4547g;
            jArr3[i4] = j3 | jArr3[i4];
        }
        h();
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        while (true) {
            int i = this.f4548h;
            if (i <= bVar.f4548h) {
                break;
            }
            long[] jArr = this.f4547g;
            int i2 = i - 1;
            this.f4548h = i2;
            jArr[i2] = 0;
        }
        for (int i3 = 0; i3 < this.f4548h; i3++) {
            long[] jArr2 = this.f4547g;
            jArr2[i3] = jArr2[i3] & bVar.f4547g[i3];
        }
        i();
        h();
    }

    public long[] b() {
        return Arrays.copyOf(this.f4547g, this.f4548h);
    }

    public void c() {
        while (true) {
            int i = this.f4548h;
            if (i <= 0) {
                return;
            }
            long[] jArr = this.f4547g;
            int i2 = i - 1;
            this.f4548h = i2;
            jArr[i2] = 0;
        }
    }

    public void c(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int i2 = i(i);
        if (i2 >= this.f4548h) {
            return;
        }
        long[] jArr = this.f4547g;
        jArr[i2] = jArr[i2] & (~(1 << i));
        i();
        h();
    }

    public void c(int i, int i2) {
        int i3;
        e(i, i2);
        if (i != i2 && (i3 = i(i)) < this.f4548h) {
            int i4 = i(i2 - 1);
            if (i4 >= this.f4548h) {
                i2 = d();
                i4 = this.f4548h - 1;
            }
            long j2 = (-1) << i;
            long j3 = (-1) >>> (-i2);
            if (i3 == i4) {
                long[] jArr = this.f4547g;
                jArr[i3] = (~(j3 & j2)) & jArr[i3];
            } else {
                long[] jArr2 = this.f4547g;
                jArr2[i3] = (~j2) & jArr2[i3];
                while (true) {
                    i3++;
                    if (i3 >= i4) {
                        break;
                    }
                    this.f4547g[i3] = 0;
                }
                long[] jArr3 = this.f4547g;
                jArr3[i4] = (~j3) & jArr3[i4];
            }
            i();
            h();
        }
    }

    public void c(b bVar) {
        if (this == bVar) {
            return;
        }
        int min = Math.min(this.f4548h, bVar.f4548h);
        int i = this.f4548h;
        int i2 = bVar.f4548h;
        if (i < i2) {
            k(i2);
            this.f4548h = bVar.f4548h;
        }
        for (int i3 = 0; i3 < min; i3++) {
            long[] jArr = this.f4547g;
            jArr[i3] = jArr[i3] | bVar.f4547g[i3];
        }
        if (min < bVar.f4548h) {
            System.arraycopy(bVar.f4547g, min, this.f4547g, min, this.f4548h - min);
        }
        h();
    }

    public Object clone() {
        if (!this.i) {
            j();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f4547g = (long[]) this.f4547g.clone();
            bVar.h();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d() {
        int i = this.f4548h;
        if (i == 0) {
            return 0;
        }
        return ((i - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f4547g[i - 1]));
    }

    public b d(int i, int i2) {
        int i3;
        long j2;
        e(i, i2);
        h();
        int d2 = d();
        int i4 = 0;
        if (d2 <= i || i == i2) {
            return new b(0);
        }
        if (i2 > d2) {
            i2 = d2;
        }
        int i5 = i2 - i;
        b bVar = new b(i5);
        int i6 = i(i5 - 1) + 1;
        int i7 = i(i);
        int i8 = i & 63;
        boolean z = i8 == 0;
        while (true) {
            i3 = i6 - 1;
            if (i4 >= i3) {
                break;
            }
            long[] jArr = bVar.f4547g;
            long[] jArr2 = this.f4547g;
            jArr[i4] = z ? jArr2[i7] : (jArr2[i7] >>> i) | (jArr2[i7 + 1] << (-i));
            i4++;
            i7++;
        }
        long j3 = (-1) >>> (-i2);
        long[] jArr3 = bVar.f4547g;
        if (((i2 - 1) & 63) < i8) {
            long[] jArr4 = this.f4547g;
            j2 = ((jArr4[i7 + 1] & j3) << (-i)) | (jArr4[i7] >>> i);
        } else {
            j2 = (this.f4547g[i7] & j3) >>> i;
        }
        jArr3[i3] = j2;
        bVar.f4548h = i6;
        bVar.i();
        bVar.h();
        return bVar;
    }

    public void d(b bVar) {
        int min = Math.min(this.f4548h, bVar.f4548h);
        int i = this.f4548h;
        int i2 = bVar.f4548h;
        if (i < i2) {
            k(i2);
            this.f4548h = bVar.f4548h;
        }
        for (int i3 = 0; i3 < min; i3++) {
            long[] jArr = this.f4547g;
            jArr[i3] = jArr[i3] ^ bVar.f4547g[i3];
        }
        int i4 = bVar.f4548h;
        if (min < i4) {
            System.arraycopy(bVar.f4547g, min, this.f4547g, min, i4 - min);
        }
        i();
        h();
    }

    public boolean d(int i) {
        if (i >= 0) {
            h();
            int i2 = i(i);
            return i2 < this.f4548h && (this.f4547g[i2] & (1 << i)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
    }

    public int e(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 >= this.f4548h) {
            return -1;
        }
        long j2 = this.f4547g[i2] & ((-1) << i);
        while (j2 == 0) {
            i2++;
            if (i2 == this.f4548h) {
                return -1;
            }
            j2 = this.f4547g[i2];
        }
        return (i2 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public void e(b bVar) {
        for (int min = Math.min(this.f4548h, bVar.f4548h) - 1; min >= 0; min--) {
            long[] jArr = this.f4547g;
            jArr[min] = jArr[min] & (~bVar.f4547g[min]);
        }
        i();
        h();
    }

    public boolean e() {
        return this.f4548h == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            h();
            bVar.h();
            if (this.f4548h != bVar.f4548h) {
                return false;
            }
            for (int i = 0; i < this.f4548h; i++) {
                if (this.f4547g[i] != bVar.f4547g[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4548h; i2++) {
            i += Long.bitCount(this.f4547g[i2]);
        }
        return i;
    }

    public int f(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        h();
        int i2 = i(i);
        if (i2 >= this.f4548h) {
            return i;
        }
        long j2 = (~this.f4547g[i2]) & ((-1) << i);
        while (j2 == 0) {
            i2++;
            int i3 = this.f4548h;
            if (i2 == i3) {
                return i3 * 64;
            }
            j2 = ~this.f4547g[i2];
        }
        return (i2 * 64) + Long.numberOfTrailingZeros(j2);
    }

    public int g() {
        return this.f4547g.length * 64;
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
        if (i2 >= this.f4548h) {
            return d() - 1;
        }
        long j2 = this.f4547g[i2] & ((-1) >>> (-(i + 1)));
        while (j2 == 0) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                return -1;
            }
            j2 = this.f4547g[i3];
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
        if (i2 >= this.f4548h) {
            return i;
        }
        long j2 = (~this.f4547g[i2]) & ((-1) >>> (-(i + 1)));
        while (j2 == 0) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                return -1;
            }
            j2 = ~this.f4547g[i3];
            i2 = i3;
        }
        return (((i2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(j2);
    }

    public int hashCode() {
        int i = this.f4548h;
        long j2 = 1234;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j2 >> 32) ^ j2);
            }
            j2 ^= this.f4547g[i] * (i + 1);
        }
    }

    public String toString() {
        h();
        int i = this.f4548h;
        StringBuilder sb = new StringBuilder(((i > 128 ? f() : i * 64) * 6) + 2);
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
