package com.baidu.mobads.cid.cesium.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class b implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f8031a = !b.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public static final ObjectStreamField[] f8032b = {new ObjectStreamField("bits", long[].class)};

    /* renamed from: c  reason: collision with root package name */
    public long[] f8033c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f8034d;

    /* renamed from: e  reason: collision with root package name */
    public transient boolean f8035e;

    public b() {
        this.f8034d = 0;
        this.f8035e = false;
        g(64);
        this.f8035e = false;
    }

    public b(int i) {
        this.f8034d = 0;
        this.f8035e = false;
        if (i >= 0) {
            g(i);
            this.f8035e = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i);
    }

    public b(long[] jArr) {
        this.f8034d = 0;
        this.f8035e = false;
        this.f8033c = jArr;
        this.f8034d = jArr.length;
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
        int i;
        int i2;
        if (!f8031a && (i2 = this.f8034d) != 0 && this.f8033c[i2 - 1] == 0) {
            throw new AssertionError();
        }
        if (!f8031a && ((i = this.f8034d) < 0 || i > this.f8033c.length)) {
            throw new AssertionError();
        }
        if (f8031a) {
            return;
        }
        int i3 = this.f8034d;
        long[] jArr = this.f8033c;
        if (i3 != jArr.length && jArr[i3] != 0) {
            throw new AssertionError();
        }
    }

    public static void d(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i2);
        } else if (i <= i2) {
        } else {
            throw new IndexOutOfBoundsException("fromIndex: " + i + " > toIndex: " + i2);
        }
    }

    private void e() {
        int i = this.f8034d - 1;
        while (i >= 0 && this.f8033c[i] == 0) {
            i--;
        }
        this.f8034d = i + 1;
    }

    public static int f(int i) {
        return i >> 6;
    }

    private void f() {
        int i = this.f8034d;
        long[] jArr = this.f8033c;
        if (i != jArr.length) {
            this.f8033c = Arrays.copyOf(jArr, i);
            d();
        }
    }

    private void g(int i) {
        this.f8033c = new long[f(i - 1) + 1];
    }

    private void h(int i) {
        long[] jArr = this.f8033c;
        if (jArr.length < i) {
            this.f8033c = Arrays.copyOf(this.f8033c, Math.max(jArr.length * 2, i));
            this.f8035e = false;
        }
    }

    private void i(int i) {
        int i2 = i + 1;
        if (this.f8034d < i2) {
            h(i2);
            this.f8034d = i2;
        }
    }

    public void a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int f2 = f(i);
        i(f2);
        long[] jArr = this.f8033c;
        jArr[f2] = jArr[f2] | (1 << i);
        d();
    }

    public void a(int i, int i2) {
        d(i, i2);
        if (i == i2) {
            return;
        }
        int f2 = f(i);
        int f3 = f(i2 - 1);
        i(f3);
        long j = (-1) << i;
        long j2 = (-1) >>> (-i2);
        if (f2 == f3) {
            long[] jArr = this.f8033c;
            jArr[f2] = (j2 & j) | jArr[f2];
        } else {
            long[] jArr2 = this.f8033c;
            jArr2[f2] = j | jArr2[f2];
            while (true) {
                f2++;
                if (f2 >= f3) {
                    break;
                }
                this.f8033c[f2] = -1;
            }
            long[] jArr3 = this.f8033c;
            jArr3[f3] = j2 | jArr3[f3];
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
        while (true) {
            int i = this.f8034d;
            if (i <= bVar.f8034d) {
                break;
            }
            long[] jArr = this.f8033c;
            int i2 = i - 1;
            this.f8034d = i2;
            jArr[i2] = 0;
        }
        for (int i3 = 0; i3 < this.f8034d; i3++) {
            long[] jArr2 = this.f8033c;
            jArr2[i3] = jArr2[i3] & bVar.f8033c[i3];
        }
        e();
        d();
    }

    public byte[] a() {
        int i = this.f8034d;
        if (i == 0) {
            return new byte[0];
        }
        int i2 = i - 1;
        int i3 = i2 * 8;
        for (long j = this.f8033c[i2]; j != 0; j >>>= 8) {
            i3++;
        }
        byte[] bArr = new byte[i3];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i4 = 0; i4 < i2; i4++) {
            order.putLong(this.f8033c[i4]);
        }
        for (long j2 = this.f8033c[i2]; j2 != 0; j2 >>>= 8) {
            order.put((byte) (255 & j2));
        }
        return bArr;
    }

    public int b() {
        int i = this.f8034d;
        if (i == 0) {
            return 0;
        }
        return ((i - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f8033c[i - 1]));
    }

    public void b(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
        }
        int f2 = f(i);
        if (f2 >= this.f8034d) {
            return;
        }
        long[] jArr = this.f8033c;
        jArr[f2] = jArr[f2] & (~(1 << i));
        e();
        d();
    }

    public void b(int i, int i2) {
        int f2;
        d(i, i2);
        if (i != i2 && (f2 = f(i)) < this.f8034d) {
            int f3 = f(i2 - 1);
            if (f3 >= this.f8034d) {
                i2 = b();
                f3 = this.f8034d - 1;
            }
            long j = (-1) << i;
            long j2 = (-1) >>> (-i2);
            if (f2 == f3) {
                long[] jArr = this.f8033c;
                jArr[f2] = (~(j2 & j)) & jArr[f2];
            } else {
                long[] jArr2 = this.f8033c;
                jArr2[f2] = (~j) & jArr2[f2];
                while (true) {
                    f2++;
                    if (f2 >= f3) {
                        break;
                    }
                    this.f8033c[f2] = 0;
                }
                long[] jArr3 = this.f8033c;
                jArr3[f3] = (~j2) & jArr3[f3];
            }
            e();
            d();
        }
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        int min = Math.min(this.f8034d, bVar.f8034d);
        int i = this.f8034d;
        int i2 = bVar.f8034d;
        if (i < i2) {
            h(i2);
            this.f8034d = bVar.f8034d;
        }
        for (int i3 = 0; i3 < min; i3++) {
            long[] jArr = this.f8033c;
            jArr[i3] = jArr[i3] | bVar.f8033c[i3];
        }
        if (min < bVar.f8034d) {
            System.arraycopy(bVar.f8033c, min, this.f8033c, min, this.f8034d - min);
        }
        d();
    }

    public int c() {
        int i = 0;
        for (int i2 = 0; i2 < this.f8034d; i2++) {
            i += Long.bitCount(this.f8033c[i2]);
        }
        return i;
    }

    public b c(int i, int i2) {
        int i3;
        long j;
        d(i, i2);
        d();
        int b2 = b();
        int i4 = 0;
        if (b2 <= i || i == i2) {
            return new b(0);
        }
        if (i2 > b2) {
            i2 = b2;
        }
        int i5 = i2 - i;
        b bVar = new b(i5);
        int f2 = f(i5 - 1) + 1;
        int f3 = f(i);
        int i6 = i & 63;
        boolean z = i6 == 0;
        while (true) {
            i3 = f2 - 1;
            if (i4 >= i3) {
                break;
            }
            long[] jArr = bVar.f8033c;
            long[] jArr2 = this.f8033c;
            jArr[i4] = z ? jArr2[f3] : (jArr2[f3] >>> i) | (jArr2[f3 + 1] << (-i));
            i4++;
            f3++;
        }
        long j2 = (-1) >>> (-i2);
        long[] jArr3 = bVar.f8033c;
        if (((i2 - 1) & 63) < i6) {
            long[] jArr4 = this.f8033c;
            j = ((jArr4[f3 + 1] & j2) << (-i)) | (jArr4[f3] >>> i);
        } else {
            j = (this.f8033c[f3] & j2) >>> i;
        }
        jArr3[i3] = j;
        bVar.f8034d = f2;
        bVar.e();
        bVar.d();
        return bVar;
    }

    public void c(b bVar) {
        int min = Math.min(this.f8034d, bVar.f8034d);
        int i = this.f8034d;
        int i2 = bVar.f8034d;
        if (i < i2) {
            h(i2);
            this.f8034d = bVar.f8034d;
        }
        for (int i3 = 0; i3 < min; i3++) {
            long[] jArr = this.f8033c;
            jArr[i3] = jArr[i3] ^ bVar.f8033c[i3];
        }
        int i4 = bVar.f8034d;
        if (min < i4) {
            System.arraycopy(bVar.f8033c, min, this.f8033c, min, i4 - min);
        }
        e();
        d();
    }

    public boolean c(int i) {
        if (i >= 0) {
            d();
            int f2 = f(i);
            return f2 < this.f8034d && (this.f8033c[f2] & (1 << i)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i);
    }

    public Object clone() {
        if (!this.f8035e) {
            f();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f8033c = (long[]) this.f8033c.clone();
            bVar.d();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int f2 = f(i);
        if (f2 >= this.f8034d) {
            return -1;
        }
        long j = this.f8033c[f2] & ((-1) << i);
        while (j == 0) {
            f2++;
            if (f2 == this.f8034d) {
                return -1;
            }
            j = this.f8033c[f2];
        }
        return (f2 * 64) + Long.numberOfTrailingZeros(j);
    }

    public void d(b bVar) {
        for (int min = Math.min(this.f8034d, bVar.f8034d) - 1; min >= 0; min--) {
            long[] jArr = this.f8033c;
            jArr[min] = jArr[min] & (~bVar.f8033c[min]);
        }
        e();
        d();
    }

    public int e(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i);
        }
        d();
        int f2 = f(i);
        if (f2 >= this.f8034d) {
            return i;
        }
        long j = (~this.f8033c[f2]) & ((-1) << i);
        while (j == 0) {
            f2++;
            int i2 = this.f8034d;
            if (f2 == i2) {
                return i2 * 64;
            }
            j = ~this.f8033c[f2];
        }
        return (f2 * 64) + Long.numberOfTrailingZeros(j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            d();
            bVar.d();
            if (this.f8034d != bVar.f8034d) {
                return false;
            }
            for (int i = 0; i < this.f8034d; i++) {
                if (this.f8033c[i] != bVar.f8033c[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f8034d;
        long j = 1234;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((j >> 32) ^ j);
            }
            j ^= this.f8033c[i] * (i + 1);
        }
    }

    public String toString() {
        d();
        int i = this.f8034d;
        StringBuilder sb = new StringBuilder(((i > 128 ? c() : i * 64) * 6) + 2);
        sb.append('{');
        int d2 = d(0);
        if (d2 != -1) {
            sb.append(d2);
            while (true) {
                d2 = d(d2 + 1);
                if (d2 < 0) {
                    break;
                }
                int e2 = e(d2);
                do {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(d2);
                    d2++;
                } while (d2 < e2);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
