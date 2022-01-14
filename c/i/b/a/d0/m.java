package c.i.b.a.d0;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.m;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes9.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f29106b;

    /* renamed from: c  reason: collision with root package name */
    public long[] f29107c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f29108d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f29109e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f29110f;

    /* renamed from: g  reason: collision with root package name */
    public m.a[] f29111g;

    /* renamed from: h  reason: collision with root package name */
    public Format[] f29112h;

    /* renamed from: i  reason: collision with root package name */
    public int f29113i;

    /* renamed from: j  reason: collision with root package name */
    public int f29114j;
    public int k;
    public int l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public Format q;
    public int r;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f29115b;

        /* renamed from: c  reason: collision with root package name */
        public m.a f29116c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1000;
        this.f29106b = new int[1000];
        this.f29107c = new long[1000];
        this.f29110f = new long[1000];
        this.f29109e = new int[1000];
        this.f29108d = new int[1000];
        this.f29111g = new m.a[1000];
        this.f29112h = new Format[1000];
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.p = true;
        this.o = true;
    }

    public synchronized int a(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                int p = p(this.l);
                if (s() && j2 >= this.f29110f[p] && (j2 <= this.n || z2)) {
                    int k = k(p, this.f29113i - this.l, j2, z);
                    if (k == -1) {
                        return -1;
                    }
                    this.l += k;
                    return k;
                }
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public synchronized int b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i2 = this.f29113i - this.l;
                this.l = this.f29113i;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            synchronized (this) {
                if (this.f29113i == 0) {
                    return j2 > this.m;
                } else if (Math.max(this.m, n(this.l)) >= j2) {
                    return false;
                } else {
                    int i2 = this.f29113i;
                    int p = p(this.f29113i - 1);
                    while (i2 > this.l && this.f29110f[p] >= j2) {
                        i2--;
                        p--;
                        if (p == -1) {
                            p = this.a - 1;
                        }
                    }
                    j(this.f29114j + i2);
                    return true;
                }
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized void d(long j2, int i2, long j3, int i3, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), aVar}) == null) {
            synchronized (this) {
                if (this.o) {
                    if ((i2 & 1) == 0) {
                        return;
                    }
                    this.o = false;
                }
                c.i.b.a.i0.a.f(!this.p);
                e(j2);
                int p = p(this.f29113i);
                this.f29110f[p] = j2;
                this.f29107c[p] = j3;
                this.f29108d[p] = i3;
                this.f29109e[p] = i2;
                this.f29111g[p] = aVar;
                this.f29112h[p] = this.q;
                this.f29106b[p] = this.r;
                int i4 = this.f29113i + 1;
                this.f29113i = i4;
                if (i4 == this.a) {
                    int i5 = this.a + 1000;
                    int[] iArr = new int[i5];
                    long[] jArr = new long[i5];
                    long[] jArr2 = new long[i5];
                    int[] iArr2 = new int[i5];
                    int[] iArr3 = new int[i5];
                    m.a[] aVarArr = new m.a[i5];
                    Format[] formatArr = new Format[i5];
                    int i6 = this.a - this.k;
                    System.arraycopy(this.f29107c, this.k, jArr, 0, i6);
                    System.arraycopy(this.f29110f, this.k, jArr2, 0, i6);
                    System.arraycopy(this.f29109e, this.k, iArr2, 0, i6);
                    System.arraycopy(this.f29108d, this.k, iArr3, 0, i6);
                    System.arraycopy(this.f29111g, this.k, aVarArr, 0, i6);
                    System.arraycopy(this.f29112h, this.k, formatArr, 0, i6);
                    System.arraycopy(this.f29106b, this.k, iArr, 0, i6);
                    int i7 = this.k;
                    System.arraycopy(this.f29107c, 0, jArr, i6, i7);
                    System.arraycopy(this.f29110f, 0, jArr2, i6, i7);
                    System.arraycopy(this.f29109e, 0, iArr2, i6, i7);
                    System.arraycopy(this.f29108d, 0, iArr3, i6, i7);
                    System.arraycopy(this.f29111g, 0, aVarArr, i6, i7);
                    System.arraycopy(this.f29112h, 0, formatArr, i6, i7);
                    System.arraycopy(this.f29106b, 0, iArr, i6, i7);
                    this.f29107c = jArr;
                    this.f29110f = jArr2;
                    this.f29109e = iArr2;
                    this.f29108d = iArr3;
                    this.f29111g = aVarArr;
                    this.f29112h = formatArr;
                    this.f29106b = iArr;
                    this.k = 0;
                    this.f29113i = this.a;
                    this.a = i5;
                }
            }
        }
    }

    public synchronized void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            synchronized (this) {
                this.n = Math.max(this.n, j2);
            }
        }
    }

    public final long f(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.m = Math.max(this.m, n(i2));
            this.f29113i -= i2;
            this.f29114j += i2;
            int i4 = this.k + i2;
            this.k = i4;
            int i5 = this.a;
            if (i4 >= i5) {
                this.k = i4 - i5;
            }
            int i6 = this.l - i2;
            this.l = i6;
            if (i6 < 0) {
                this.l = 0;
            }
            if (this.f29113i == 0) {
                int i7 = this.k;
                if (i7 == 0) {
                    i7 = this.a;
                }
                return this.f29107c[i7 - 1] + this.f29108d[i3];
            }
            return this.f29107c[this.k];
        }
        return invokeI.longValue;
    }

    public synchronized long g(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (this.f29113i != 0 && j2 >= this.f29110f[this.k]) {
                    int k = k(this.k, (!z2 || this.l == this.f29113i) ? this.f29113i : this.l + 1, j2, z);
                    if (k == -1) {
                        return -1L;
                    }
                    return f(k);
                }
                return -1L;
            }
        }
        return invokeCommon.longValue;
    }

    public synchronized long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (this.f29113i == 0) {
                    return -1L;
                }
                return f(this.f29113i);
            }
        }
        return invokeV.longValue;
    }

    public synchronized long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (this.l == 0) {
                    return -1L;
                }
                return f(this.l);
            }
        }
        return invokeV.longValue;
    }

    public long j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int r = r() - i2;
            c.i.b.a.i0.a.a(r >= 0 && r <= this.f29113i - this.l);
            int i3 = this.f29113i - r;
            this.f29113i = i3;
            this.n = Math.max(this.m, n(i3));
            int i4 = this.f29113i;
            if (i4 == 0) {
                return 0L;
            }
            int p = p(i4 - 1);
            return this.f29107c[p] + this.f29108d[p];
        }
        return invokeI.longValue;
    }

    public final int k(int i2, int i3, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            int i4 = -1;
            for (int i5 = 0; i5 < i3 && this.f29110f[i2] <= j2; i5++) {
                if (!z || (this.f29109e[i2] & 1) != 0) {
                    i4 = i5;
                }
                i2++;
                if (i2 == this.a) {
                    i2 = 0;
                }
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public synchronized boolean l(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, format)) == null) {
            synchronized (this) {
                if (format == null) {
                    this.p = true;
                    return false;
                }
                this.p = false;
                if (v.a(format, this.q)) {
                    return false;
                }
                this.q = format;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized long m() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                j2 = this.n;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final long n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            long j2 = Long.MIN_VALUE;
            if (i2 == 0) {
                return Long.MIN_VALUE;
            }
            int p = p(i2 - 1);
            for (int i3 = 0; i3 < i2; i3++) {
                j2 = Math.max(j2, this.f29110f[p]);
                if ((this.f29109e[p] & 1) != 0) {
                    break;
                }
                p--;
                if (p == -1) {
                    p = this.a - 1;
                }
            }
            return j2;
        }
        return invokeI.longValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29114j + this.l : invokeV.intValue;
    }

    public final int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int i3 = this.k + i2;
            int i4 = this.a;
            return i3 < i4 ? i3 : i3 - i4;
        }
        return invokeI.intValue;
    }

    public synchronized Format q() {
        InterceptResult invokeV;
        Format format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                format = this.p ? null : this.q;
            }
            return format;
        }
        return (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f29114j + this.f29113i : invokeV.intValue;
    }

    public synchronized boolean s() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                z = this.l != this.f29113i;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return s() ? this.f29106b[p(this.l)] : this.r;
        }
        return invokeV.intValue;
    }

    public synchronized int u(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z, boolean z2, Format format, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), format, aVar})) == null) {
            synchronized (this) {
                if (!s()) {
                    if (z2) {
                        eVar.l(4);
                        return -4;
                    } else if (this.q == null || (!z && this.q == format)) {
                        return -3;
                    } else {
                        lVar.a = this.q;
                        return -5;
                    }
                }
                int p = p(this.l);
                if (!z && this.f29112h[p] == format) {
                    if (eVar.q()) {
                        return -3;
                    }
                    eVar.f29957h = this.f29110f[p];
                    eVar.l(this.f29109e[p]);
                    aVar.a = this.f29108d[p];
                    aVar.f29115b = this.f29107c[p];
                    aVar.f29116c = this.f29111g[p];
                    this.l++;
                    return -4;
                }
                lVar.a = this.f29112h[p];
                return -5;
            }
        }
        return invokeCommon.intValue;
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f29113i = 0;
            this.f29114j = 0;
            this.k = 0;
            this.l = 0;
            this.o = true;
            this.m = Long.MIN_VALUE;
            this.n = Long.MIN_VALUE;
            if (z) {
                this.q = null;
                this.p = true;
            }
        }
    }

    public synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this) {
                this.l = 0;
            }
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.r = i2;
        }
    }
}
