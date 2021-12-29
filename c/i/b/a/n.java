package c.i.b.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.l;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w.b a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f30776b;

    /* renamed from: c  reason: collision with root package name */
    public w f30777c;

    /* renamed from: d  reason: collision with root package name */
    public int f30778d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30779e;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final l.b a;

        /* renamed from: b  reason: collision with root package name */
        public final long f30780b;

        /* renamed from: c  reason: collision with root package name */
        public final long f30781c;

        /* renamed from: d  reason: collision with root package name */
        public final long f30782d;

        /* renamed from: e  reason: collision with root package name */
        public final long f30783e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f30784f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f30785g;

        public /* synthetic */ b(l.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, a aVar) {
            this(bVar, j2, j3, j4, j5, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.a.a(i2), this.f30780b, this.f30781c, this.f30782d, this.f30783e, this.f30784f, this.f30785g) : (b) invokeI.objValue;
        }

        public b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new b(this.a, j2, this.f30781c, this.f30782d, this.f30783e, this.f30784f, this.f30785g) : (b) invokeJ.objValue;
        }

        public b(l.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {bVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f30780b = j2;
            this.f30781c = j3;
            this.f30782d = j4;
            this.f30783e = j5;
            this.f30784f = z;
            this.f30785g = z2;
        }
    }

    public n() {
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
        this.a = new w.b();
        this.f30776b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f30787c, oVar.f30789e, oVar.f30788d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f30777c.f(bVar.a, this.a);
            if (bVar.b()) {
                if (this.a.m(bVar.f30033b, bVar.f30034c)) {
                    return c(bVar.a, bVar.f30033b, bVar.f30034c, j2);
                }
                return null;
            }
            int d2 = this.a.d(j3);
            return d(bVar.a, j3, d2 == -1 ? Long.MIN_VALUE : this.a.f(d2));
        }
        return (b) invokeCommon.objValue;
    }

    public final b c(int i2, int i3, int i4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)})) == null) {
            l.b bVar = new l.b(i2, i3, i4);
            boolean i5 = i(bVar, Long.MIN_VALUE);
            boolean j3 = j(bVar, i5);
            return new b(bVar, i4 == this.a.i(i3) ? this.a.g() : 0L, Long.MIN_VALUE, j2, this.f30777c.f(bVar.a, this.a).b(bVar.f30033b, bVar.f30034c), i5, j3, null);
        }
        return (b) invokeCommon.objValue;
    }

    public final b d(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            l.b bVar = new l.b(i2);
            boolean i3 = i(bVar, j3);
            boolean j4 = j(bVar, i3);
            this.f30777c.f(bVar.a, this.a);
            return new b(bVar, j2, j3, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.a.h() : j3, i3, j4, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (bVar.f30784f) {
                int d2 = this.f30777c.d(bVar.a.a, this.a, this.f30776b, this.f30778d, this.f30779e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f30777c.f(d2, this.a).f30808c;
                long j4 = 0;
                if (this.f30777c.l(i2, this.f30776b).f30821f == d2) {
                    Pair<Integer, Long> j5 = this.f30777c.j(this.f30776b, this.a, i2, -9223372036854775807L, Math.max(0L, (j2 + bVar.f30783e) - j3));
                    if (j5 == null) {
                        return null;
                    }
                    d2 = ((Integer) j5.first).intValue();
                    j4 = ((Long) j5.second).longValue();
                }
                return b(k(d2, j4), j4, j4);
            }
            l.b bVar2 = bVar.a;
            if (bVar2.b()) {
                int i3 = bVar2.f30033b;
                this.f30777c.f(bVar2.a, this.a);
                int a2 = this.a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f30034c + 1;
                if (i4 < a2) {
                    if (this.a.m(i3, i4)) {
                        return c(bVar2.a, i3, i4, bVar.f30782d);
                    }
                    return null;
                }
                int d3 = this.a.d(bVar.f30782d);
                return d(bVar2.a, bVar.f30782d, d3 == -1 ? Long.MIN_VALUE : this.a.f(d3));
            }
            long j6 = bVar.f30781c;
            if (j6 != Long.MIN_VALUE) {
                int e2 = this.a.e(j6);
                if (this.a.m(e2, 0)) {
                    return c(bVar2.a, e2, 0, bVar.f30781c);
                }
                return null;
            }
            int c2 = this.a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.a.f(i5) == Long.MIN_VALUE && !this.a.l(i5) && this.a.m(i5, 0)) {
                    return c(bVar2.a, i5, 0, this.a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j2;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j3 = bVar.f30780b;
            long j4 = bVar.f30781c;
            boolean i2 = i(bVar2, j4);
            boolean j5 = j(bVar2, i2);
            this.f30777c.f(bVar2.a, this.a);
            if (bVar2.b()) {
                h2 = this.a.b(bVar2.f30033b, bVar2.f30034c);
            } else if (j4 == Long.MIN_VALUE) {
                h2 = this.a.h();
            } else {
                j2 = j4;
                return new b(bVar2, j3, j4, bVar.f30782d, j2, i2, j5, null);
            }
            j2 = h2;
            return new b(bVar2, j3, j4, bVar.f30782d, j2, i2, j5, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j2)) == null) {
            int c2 = this.f30777c.f(bVar.a, this.a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j2 == Long.MIN_VALUE;
            }
            int a2 = this.a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f30033b == i2 && bVar.f30034c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f30777c.l(this.f30777c.f(bVar.a, this.a).f30808c, this.f30776b).f30820e && this.f30777c.q(bVar.a, this.a, this.f30776b, this.f30778d, this.f30779e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.f30777c.f(i2, this.a);
            int e2 = this.a.e(j2);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f30778d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f30779e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f30777c = wVar;
        }
    }
}
