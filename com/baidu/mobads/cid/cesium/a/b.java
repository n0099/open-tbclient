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
    public static final /* synthetic */ boolean f8034a = !b.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public static final ObjectStreamField[] f8035b = {new ObjectStreamField("bits", long[].class)};

    /* renamed from: c  reason: collision with root package name */
    public long[] f8036c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f8037d;

    /* renamed from: e  reason: collision with root package name */
    public transient boolean f8038e;

    public b() {
        this.f8037d = 0;
        this.f8038e = false;
        g(64);
        this.f8038e = false;
    }

    public b(int i2) {
        this.f8037d = 0;
        this.f8038e = false;
        if (i2 >= 0) {
            g(i2);
            this.f8038e = true;
            return;
        }
        throw new NegativeArraySizeException("nbits < 0: " + i2);
    }

    public b(long[] jArr) {
        this.f8037d = 0;
        this.f8038e = false;
        this.f8036c = jArr;
        this.f8037d = jArr.length;
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
        int i2;
        int i3;
        if (!f8034a && (i3 = this.f8037d) != 0 && this.f8036c[i3 - 1] == 0) {
            throw new AssertionError();
        }
        if (!f8034a && ((i2 = this.f8037d) < 0 || i2 > this.f8036c.length)) {
            throw new AssertionError();
        }
        if (f8034a) {
            return;
        }
        int i4 = this.f8037d;
        long[] jArr = this.f8036c;
        if (i4 != jArr.length && jArr[i4] != 0) {
            throw new AssertionError();
        }
    }

    public static void d(int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + i3);
        } else if (i2 <= i3) {
        } else {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + " > toIndex: " + i3);
        }
    }

    private void e() {
        int i2 = this.f8037d - 1;
        while (i2 >= 0 && this.f8036c[i2] == 0) {
            i2--;
        }
        this.f8037d = i2 + 1;
    }

    public static int f(int i2) {
        return i2 >> 6;
    }

    private void f() {
        int i2 = this.f8037d;
        long[] jArr = this.f8036c;
        if (i2 != jArr.length) {
            this.f8036c = Arrays.copyOf(jArr, i2);
            d();
        }
    }

    private void g(int i2) {
        this.f8036c = new long[f(i2 - 1) + 1];
    }

    private void h(int i2) {
        long[] jArr = this.f8036c;
        if (jArr.length < i2) {
            this.f8036c = Arrays.copyOf(this.f8036c, Math.max(jArr.length * 2, i2));
            this.f8038e = false;
        }
    }

    private void i(int i2) {
        int i3 = i2 + 1;
        if (this.f8037d < i3) {
            h(i3);
            this.f8037d = i3;
        }
    }

    public void a(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int f2 = f(i2);
        i(f2);
        long[] jArr = this.f8036c;
        jArr[f2] = jArr[f2] | (1 << i2);
        d();
    }

    public void a(int i2, int i3) {
        d(i2, i3);
        if (i2 == i3) {
            return;
        }
        int f2 = f(i2);
        int f3 = f(i3 - 1);
        i(f3);
        long j = (-1) << i2;
        long j2 = (-1) >>> (-i3);
        if (f2 == f3) {
            long[] jArr = this.f8036c;
            jArr[f2] = (j2 & j) | jArr[f2];
        } else {
            long[] jArr2 = this.f8036c;
            jArr2[f2] = j | jArr2[f2];
            while (true) {
                f2++;
                if (f2 >= f3) {
                    break;
                }
                this.f8036c[f2] = -1;
            }
            long[] jArr3 = this.f8036c;
            jArr3[f3] = j2 | jArr3[f3];
        }
        d();
    }

    public void a(int i2, int i3, boolean z) {
        if (z) {
            a(i2, i3);
        } else {
            b(i2, i3);
        }
    }

    public void a(int i2, boolean z) {
        if (z) {
            a(i2);
        } else {
            b(i2);
        }
    }

    public void a(b bVar) {
        if (this == bVar) {
            return;
        }
        while (true) {
            int i2 = this.f8037d;
            if (i2 <= bVar.f8037d) {
                break;
            }
            long[] jArr = this.f8036c;
            int i3 = i2 - 1;
            this.f8037d = i3;
            jArr[i3] = 0;
        }
        for (int i4 = 0; i4 < this.f8037d; i4++) {
            long[] jArr2 = this.f8036c;
            jArr2[i4] = jArr2[i4] & bVar.f8036c[i4];
        }
        e();
        d();
    }

    public byte[] a() {
        int i2 = this.f8037d;
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = i2 - 1;
        int i4 = i3 * 8;
        for (long j = this.f8036c[i3]; j != 0; j >>>= 8) {
            i4++;
        }
        byte[] bArr = new byte[i4];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i5 = 0; i5 < i3; i5++) {
            order.putLong(this.f8036c[i5]);
        }
        for (long j2 = this.f8036c[i3]; j2 != 0; j2 >>>= 8) {
            order.put((byte) (255 & j2));
        }
        return bArr;
    }

    public int b() {
        int i2 = this.f8037d;
        if (i2 == 0) {
            return 0;
        }
        return ((i2 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.f8036c[i2 - 1]));
    }

    public void b(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
        }
        int f2 = f(i2);
        if (f2 >= this.f8037d) {
            return;
        }
        long[] jArr = this.f8036c;
        jArr[f2] = jArr[f2] & (~(1 << i2));
        e();
        d();
    }

    public void b(int i2, int i3) {
        int f2;
        d(i2, i3);
        if (i2 != i3 && (f2 = f(i2)) < this.f8037d) {
            int f3 = f(i3 - 1);
            if (f3 >= this.f8037d) {
                i3 = b();
                f3 = this.f8037d - 1;
            }
            long j = (-1) << i2;
            long j2 = (-1) >>> (-i3);
            if (f2 == f3) {
                long[] jArr = this.f8036c;
                jArr[f2] = (~(j2 & j)) & jArr[f2];
            } else {
                long[] jArr2 = this.f8036c;
                jArr2[f2] = (~j) & jArr2[f2];
                while (true) {
                    f2++;
                    if (f2 >= f3) {
                        break;
                    }
                    this.f8036c[f2] = 0;
                }
                long[] jArr3 = this.f8036c;
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
        int min = Math.min(this.f8037d, bVar.f8037d);
        int i2 = this.f8037d;
        int i3 = bVar.f8037d;
        if (i2 < i3) {
            h(i3);
            this.f8037d = bVar.f8037d;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f8036c;
            jArr[i4] = jArr[i4] | bVar.f8036c[i4];
        }
        if (min < bVar.f8037d) {
            System.arraycopy(bVar.f8036c, min, this.f8036c, min, this.f8037d - min);
        }
        d();
    }

    public int c() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f8037d; i3++) {
            i2 += Long.bitCount(this.f8036c[i3]);
        }
        return i2;
    }

    public b c(int i2, int i3) {
        int i4;
        long j;
        d(i2, i3);
        d();
        int b2 = b();
        int i5 = 0;
        if (b2 <= i2 || i2 == i3) {
            return new b(0);
        }
        if (i3 > b2) {
            i3 = b2;
        }
        int i6 = i3 - i2;
        b bVar = new b(i6);
        int f2 = f(i6 - 1) + 1;
        int f3 = f(i2);
        int i7 = i2 & 63;
        boolean z = i7 == 0;
        while (true) {
            i4 = f2 - 1;
            if (i5 >= i4) {
                break;
            }
            long[] jArr = bVar.f8036c;
            long[] jArr2 = this.f8036c;
            jArr[i5] = z ? jArr2[f3] : (jArr2[f3] >>> i2) | (jArr2[f3 + 1] << (-i2));
            i5++;
            f3++;
        }
        long j2 = (-1) >>> (-i3);
        long[] jArr3 = bVar.f8036c;
        if (((i3 - 1) & 63) < i7) {
            long[] jArr4 = this.f8036c;
            j = ((jArr4[f3 + 1] & j2) << (-i2)) | (jArr4[f3] >>> i2);
        } else {
            j = (this.f8036c[f3] & j2) >>> i2;
        }
        jArr3[i4] = j;
        bVar.f8037d = f2;
        bVar.e();
        bVar.d();
        return bVar;
    }

    public void c(b bVar) {
        int min = Math.min(this.f8037d, bVar.f8037d);
        int i2 = this.f8037d;
        int i3 = bVar.f8037d;
        if (i2 < i3) {
            h(i3);
            this.f8037d = bVar.f8037d;
        }
        for (int i4 = 0; i4 < min; i4++) {
            long[] jArr = this.f8036c;
            jArr[i4] = jArr[i4] ^ bVar.f8036c[i4];
        }
        int i5 = bVar.f8037d;
        if (min < i5) {
            System.arraycopy(bVar.f8036c, min, this.f8036c, min, i5 - min);
        }
        e();
        d();
    }

    public boolean c(int i2) {
        if (i2 >= 0) {
            d();
            int f2 = f(i2);
            return f2 < this.f8037d && (this.f8036c[f2] & (1 << i2)) != 0;
        }
        throw new IndexOutOfBoundsException("bitIndex < 0: " + i2);
    }

    public Object clone() {
        if (!this.f8038e) {
            f();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f8036c = (long[]) this.f8036c.clone();
            bVar.d();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        d();
        int f2 = f(i2);
        if (f2 >= this.f8037d) {
            return -1;
        }
        long j = this.f8036c[f2] & ((-1) << i2);
        while (j == 0) {
            f2++;
            if (f2 == this.f8037d) {
                return -1;
            }
            j = this.f8036c[f2];
        }
        return (f2 * 64) + Long.numberOfTrailingZeros(j);
    }

    public void d(b bVar) {
        for (int min = Math.min(this.f8037d, bVar.f8037d) - 1; min >= 0; min--) {
            long[] jArr = this.f8036c;
            jArr[min] = jArr[min] & (~bVar.f8036c[min]);
        }
        e();
        d();
    }

    public int e(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + i2);
        }
        d();
        int f2 = f(i2);
        if (f2 >= this.f8037d) {
            return i2;
        }
        long j = (~this.f8036c[f2]) & ((-1) << i2);
        while (j == 0) {
            f2++;
            int i3 = this.f8037d;
            if (f2 == i3) {
                return i3 * 64;
            }
            j = ~this.f8036c[f2];
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
            if (this.f8037d != bVar.f8037d) {
                return false;
            }
            for (int i2 = 0; i2 < this.f8037d; i2++) {
                if (this.f8036c[i2] != bVar.f8036c[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f8037d;
        long j = 1234;
        while (true) {
            i2--;
            if (i2 < 0) {
                return (int) ((j >> 32) ^ j);
            }
            j ^= this.f8036c[i2] * (i2 + 1);
        }
    }

    public String toString() {
        d();
        int i2 = this.f8037d;
        StringBuilder sb = new StringBuilder(((i2 > 128 ? c() : i2 * 64) * 6) + 2);
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
