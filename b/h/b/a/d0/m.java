package b.h.b.a.d0;

import androidx.core.view.InputDeviceCompat;
import b.h.b.a.a0.m;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f32819a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f32820b;

    /* renamed from: c  reason: collision with root package name */
    public long[] f32821c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f32822d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f32823e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f32824f;

    /* renamed from: g  reason: collision with root package name */
    public m.a[] f32825g;

    /* renamed from: h  reason: collision with root package name */
    public Format[] f32826h;

    /* renamed from: i  reason: collision with root package name */
    public int f32827i;
    public int j;
    public int k;
    public int l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public Format q;
    public int r;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f32828a;

        /* renamed from: b  reason: collision with root package name */
        public long f32829b;

        /* renamed from: c  reason: collision with root package name */
        public m.a f32830c;

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
        this.f32819a = 1000;
        this.f32820b = new int[1000];
        this.f32821c = new long[1000];
        this.f32824f = new long[1000];
        this.f32823e = new int[1000];
        this.f32822d = new int[1000];
        this.f32825g = new m.a[1000];
        this.f32826h = new Format[1000];
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.p = true;
        this.o = true;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                int p = p(this.l);
                if (s() && j >= this.f32824f[p] && (j <= this.n || z2)) {
                    int k = k(p, this.f32827i - this.l, j, z);
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
                i2 = this.f32827i - this.l;
                this.l = this.f32827i;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            synchronized (this) {
                if (this.f32827i == 0) {
                    return j > this.m;
                } else if (Math.max(this.m, n(this.l)) >= j) {
                    return false;
                } else {
                    int i2 = this.f32827i;
                    int p = p(this.f32827i - 1);
                    while (i2 > this.l && this.f32824f[p] >= j) {
                        i2--;
                        p--;
                        if (p == -1) {
                            p = this.f32819a - 1;
                        }
                    }
                    j(this.j + i2);
                    return true;
                }
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized void d(long j, int i2, long j2, int i3, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), aVar}) == null) {
            synchronized (this) {
                if (this.o) {
                    if ((i2 & 1) == 0) {
                        return;
                    }
                    this.o = false;
                }
                b.h.b.a.i0.a.f(!this.p);
                e(j);
                int p = p(this.f32827i);
                this.f32824f[p] = j;
                this.f32821c[p] = j2;
                this.f32822d[p] = i3;
                this.f32823e[p] = i2;
                this.f32825g[p] = aVar;
                this.f32826h[p] = this.q;
                this.f32820b[p] = this.r;
                int i4 = this.f32827i + 1;
                this.f32827i = i4;
                if (i4 == this.f32819a) {
                    int i5 = this.f32819a + 1000;
                    int[] iArr = new int[i5];
                    long[] jArr = new long[i5];
                    long[] jArr2 = new long[i5];
                    int[] iArr2 = new int[i5];
                    int[] iArr3 = new int[i5];
                    m.a[] aVarArr = new m.a[i5];
                    Format[] formatArr = new Format[i5];
                    int i6 = this.f32819a - this.k;
                    System.arraycopy(this.f32821c, this.k, jArr, 0, i6);
                    System.arraycopy(this.f32824f, this.k, jArr2, 0, i6);
                    System.arraycopy(this.f32823e, this.k, iArr2, 0, i6);
                    System.arraycopy(this.f32822d, this.k, iArr3, 0, i6);
                    System.arraycopy(this.f32825g, this.k, aVarArr, 0, i6);
                    System.arraycopy(this.f32826h, this.k, formatArr, 0, i6);
                    System.arraycopy(this.f32820b, this.k, iArr, 0, i6);
                    int i7 = this.k;
                    System.arraycopy(this.f32821c, 0, jArr, i6, i7);
                    System.arraycopy(this.f32824f, 0, jArr2, i6, i7);
                    System.arraycopy(this.f32823e, 0, iArr2, i6, i7);
                    System.arraycopy(this.f32822d, 0, iArr3, i6, i7);
                    System.arraycopy(this.f32825g, 0, aVarArr, i6, i7);
                    System.arraycopy(this.f32826h, 0, formatArr, i6, i7);
                    System.arraycopy(this.f32820b, 0, iArr, i6, i7);
                    this.f32821c = jArr;
                    this.f32824f = jArr2;
                    this.f32823e = iArr2;
                    this.f32822d = iArr3;
                    this.f32825g = aVarArr;
                    this.f32826h = formatArr;
                    this.f32820b = iArr;
                    this.k = 0;
                    this.f32827i = this.f32819a;
                    this.f32819a = i5;
                }
            }
        }
    }

    public synchronized void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            synchronized (this) {
                this.n = Math.max(this.n, j);
            }
        }
    }

    public final long f(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.m = Math.max(this.m, n(i2));
            this.f32827i -= i2;
            this.j += i2;
            int i4 = this.k + i2;
            this.k = i4;
            int i5 = this.f32819a;
            if (i4 >= i5) {
                this.k = i4 - i5;
            }
            int i6 = this.l - i2;
            this.l = i6;
            if (i6 < 0) {
                this.l = 0;
            }
            if (this.f32827i == 0) {
                int i7 = this.k;
                if (i7 == 0) {
                    i7 = this.f32819a;
                }
                return this.f32821c[i7 - 1] + this.f32822d[i3];
            }
            return this.f32821c[this.k];
        }
        return invokeI.longValue;
    }

    public synchronized long g(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (this.f32827i != 0 && j >= this.f32824f[this.k]) {
                    int k = k(this.k, (!z2 || this.l == this.f32827i) ? this.f32827i : this.l + 1, j, z);
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
                if (this.f32827i == 0) {
                    return -1L;
                }
                return f(this.f32827i);
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
            b.h.b.a.i0.a.a(r >= 0 && r <= this.f32827i - this.l);
            int i3 = this.f32827i - r;
            this.f32827i = i3;
            this.n = Math.max(this.m, n(i3));
            int i4 = this.f32827i;
            if (i4 == 0) {
                return 0L;
            }
            int p = p(i4 - 1);
            return this.f32821c[p] + this.f32822d[p];
        }
        return invokeI.longValue;
    }

    public final int k(int i2, int i3, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int i4 = -1;
            for (int i5 = 0; i5 < i3 && this.f32824f[i2] <= j; i5++) {
                if (!z || (this.f32823e[i2] & 1) != 0) {
                    i4 = i5;
                }
                i2++;
                if (i2 == this.f32819a) {
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
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                j = this.n;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final long n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            long j = Long.MIN_VALUE;
            if (i2 == 0) {
                return Long.MIN_VALUE;
            }
            int p = p(i2 - 1);
            for (int i3 = 0; i3 < i2; i3++) {
                j = Math.max(j, this.f32824f[p]);
                if ((this.f32823e[p] & 1) != 0) {
                    break;
                }
                p--;
                if (p == -1) {
                    p = this.f32819a - 1;
                }
            }
            return j;
        }
        return invokeI.longValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j + this.l : invokeV.intValue;
    }

    public final int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int i3 = this.k + i2;
            int i4 = this.f32819a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j + this.f32827i : invokeV.intValue;
    }

    public synchronized boolean s() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                z = this.l != this.f32827i;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return s() ? this.f32820b[p(this.l)] : this.r;
        }
        return invokeV.intValue;
    }

    public synchronized int u(b.h.b.a.l lVar, b.h.b.a.y.e eVar, boolean z, boolean z2, Format format, a aVar) {
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
                        lVar.f33599a = this.q;
                        return -5;
                    }
                }
                int p = p(this.l);
                if (!z && this.f32826h[p] == format) {
                    if (eVar.q()) {
                        return -3;
                    }
                    eVar.f33760h = this.f32824f[p];
                    eVar.l(this.f32823e[p]);
                    aVar.f32828a = this.f32822d[p];
                    aVar.f32829b = this.f32821c[p];
                    aVar.f32830c = this.f32825g[p];
                    this.l++;
                    return -4;
                }
                lVar.f33599a = this.f32826h[p];
                return -5;
            }
        }
        return invokeCommon.intValue;
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f32827i = 0;
            this.j = 0;
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
