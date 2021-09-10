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
/* loaded from: classes4.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w.b f33923a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f33924b;

    /* renamed from: c  reason: collision with root package name */
    public w f33925c;

    /* renamed from: d  reason: collision with root package name */
    public int f33926d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33927e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l.b f33928a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33929b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33930c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33931d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33932e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33933f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f33934g;

        public /* synthetic */ b(l.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, a aVar) {
            this(bVar, j2, j3, j4, j5, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f33928a.a(i2), this.f33929b, this.f33930c, this.f33931d, this.f33932e, this.f33933f, this.f33934g) : (b) invokeI.objValue;
        }

        public b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new b(this.f33928a, j2, this.f33930c, this.f33931d, this.f33932e, this.f33933f, this.f33934g) : (b) invokeJ.objValue;
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
            this.f33928a = bVar;
            this.f33929b = j2;
            this.f33930c = j3;
            this.f33931d = j4;
            this.f33932e = j5;
            this.f33933f = z;
            this.f33934g = z2;
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
        this.f33923a = new w.b();
        this.f33924b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f33937c, oVar.f33939e, oVar.f33938d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f33925c.f(bVar.f33091a, this.f33923a);
            if (bVar.b()) {
                if (this.f33923a.m(bVar.f33092b, bVar.f33093c)) {
                    return c(bVar.f33091a, bVar.f33092b, bVar.f33093c, j2);
                }
                return null;
            }
            int d2 = this.f33923a.d(j3);
            return d(bVar.f33091a, j3, d2 == -1 ? Long.MIN_VALUE : this.f33923a.f(d2));
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
            return new b(bVar, i4 == this.f33923a.i(i3) ? this.f33923a.g() : 0L, Long.MIN_VALUE, j2, this.f33925c.f(bVar.f33091a, this.f33923a).b(bVar.f33092b, bVar.f33093c), i5, j3, null);
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
            this.f33925c.f(bVar.f33091a, this.f33923a);
            return new b(bVar, j2, j3, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.f33923a.h() : j3, i3, j4, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (bVar.f33933f) {
                int d2 = this.f33925c.d(bVar.f33928a.f33091a, this.f33923a, this.f33924b, this.f33926d, this.f33927e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f33925c.f(d2, this.f33923a).f33962c;
                long j4 = 0;
                if (this.f33925c.l(i2, this.f33924b).f33975f == d2) {
                    Pair<Integer, Long> j5 = this.f33925c.j(this.f33924b, this.f33923a, i2, -9223372036854775807L, Math.max(0L, (j2 + bVar.f33932e) - j3));
                    if (j5 == null) {
                        return null;
                    }
                    d2 = ((Integer) j5.first).intValue();
                    j4 = ((Long) j5.second).longValue();
                }
                return b(k(d2, j4), j4, j4);
            }
            l.b bVar2 = bVar.f33928a;
            if (bVar2.b()) {
                int i3 = bVar2.f33092b;
                this.f33925c.f(bVar2.f33091a, this.f33923a);
                int a2 = this.f33923a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f33093c + 1;
                if (i4 < a2) {
                    if (this.f33923a.m(i3, i4)) {
                        return c(bVar2.f33091a, i3, i4, bVar.f33931d);
                    }
                    return null;
                }
                int d3 = this.f33923a.d(bVar.f33931d);
                return d(bVar2.f33091a, bVar.f33931d, d3 == -1 ? Long.MIN_VALUE : this.f33923a.f(d3));
            }
            long j6 = bVar.f33930c;
            if (j6 != Long.MIN_VALUE) {
                int e2 = this.f33923a.e(j6);
                if (this.f33923a.m(e2, 0)) {
                    return c(bVar2.f33091a, e2, 0, bVar.f33930c);
                }
                return null;
            }
            int c2 = this.f33923a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f33923a.f(i5) == Long.MIN_VALUE && !this.f33923a.l(i5) && this.f33923a.m(i5, 0)) {
                    return c(bVar2.f33091a, i5, 0, this.f33923a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f33928a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f33928a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j2;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j3 = bVar.f33929b;
            long j4 = bVar.f33930c;
            boolean i2 = i(bVar2, j4);
            boolean j5 = j(bVar2, i2);
            this.f33925c.f(bVar2.f33091a, this.f33923a);
            if (bVar2.b()) {
                h2 = this.f33923a.b(bVar2.f33092b, bVar2.f33093c);
            } else if (j4 == Long.MIN_VALUE) {
                h2 = this.f33923a.h();
            } else {
                j2 = j4;
                return new b(bVar2, j3, j4, bVar.f33931d, j2, i2, j5, null);
            }
            j2 = h2;
            return new b(bVar2, j3, j4, bVar.f33931d, j2, i2, j5, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j2)) == null) {
            int c2 = this.f33925c.f(bVar.f33091a, this.f33923a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f33923a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j2 == Long.MIN_VALUE;
            }
            int a2 = this.f33923a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f33092b == i2 && bVar.f33093c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f33923a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f33925c.l(this.f33925c.f(bVar.f33091a, this.f33923a).f33962c, this.f33924b).f33974e && this.f33925c.q(bVar.f33091a, this.f33923a, this.f33924b, this.f33926d, this.f33927e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.f33925c.f(i2, this.f33923a);
            int e2 = this.f33923a.e(j2);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f33923a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f33926d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f33927e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f33925c = wVar;
        }
    }
}
