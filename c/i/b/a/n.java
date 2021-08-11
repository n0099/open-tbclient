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
    public final w.b f33708a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f33709b;

    /* renamed from: c  reason: collision with root package name */
    public w f33710c;

    /* renamed from: d  reason: collision with root package name */
    public int f33711d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33712e;

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
        public final l.b f33713a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33714b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33715c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33716d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33717e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33718f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f33719g;

        public /* synthetic */ b(l.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, a aVar) {
            this(bVar, j2, j3, j4, j5, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f33713a.a(i2), this.f33714b, this.f33715c, this.f33716d, this.f33717e, this.f33718f, this.f33719g) : (b) invokeI.objValue;
        }

        public b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new b(this.f33713a, j2, this.f33715c, this.f33716d, this.f33717e, this.f33718f, this.f33719g) : (b) invokeJ.objValue;
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
            this.f33713a = bVar;
            this.f33714b = j2;
            this.f33715c = j3;
            this.f33716d = j4;
            this.f33717e = j5;
            this.f33718f = z;
            this.f33719g = z2;
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
        this.f33708a = new w.b();
        this.f33709b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f33722c, oVar.f33724e, oVar.f33723d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f33710c.f(bVar.f32876a, this.f33708a);
            if (bVar.b()) {
                if (this.f33708a.m(bVar.f32877b, bVar.f32878c)) {
                    return c(bVar.f32876a, bVar.f32877b, bVar.f32878c, j2);
                }
                return null;
            }
            int d2 = this.f33708a.d(j3);
            return d(bVar.f32876a, j3, d2 == -1 ? Long.MIN_VALUE : this.f33708a.f(d2));
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
            return new b(bVar, i4 == this.f33708a.i(i3) ? this.f33708a.g() : 0L, Long.MIN_VALUE, j2, this.f33710c.f(bVar.f32876a, this.f33708a).b(bVar.f32877b, bVar.f32878c), i5, j3, null);
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
            this.f33710c.f(bVar.f32876a, this.f33708a);
            return new b(bVar, j2, j3, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.f33708a.h() : j3, i3, j4, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (bVar.f33718f) {
                int d2 = this.f33710c.d(bVar.f33713a.f32876a, this.f33708a, this.f33709b, this.f33711d, this.f33712e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f33710c.f(d2, this.f33708a).f33747c;
                long j4 = 0;
                if (this.f33710c.l(i2, this.f33709b).f33760f == d2) {
                    Pair<Integer, Long> j5 = this.f33710c.j(this.f33709b, this.f33708a, i2, -9223372036854775807L, Math.max(0L, (j2 + bVar.f33717e) - j3));
                    if (j5 == null) {
                        return null;
                    }
                    d2 = ((Integer) j5.first).intValue();
                    j4 = ((Long) j5.second).longValue();
                }
                return b(k(d2, j4), j4, j4);
            }
            l.b bVar2 = bVar.f33713a;
            if (bVar2.b()) {
                int i3 = bVar2.f32877b;
                this.f33710c.f(bVar2.f32876a, this.f33708a);
                int a2 = this.f33708a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f32878c + 1;
                if (i4 < a2) {
                    if (this.f33708a.m(i3, i4)) {
                        return c(bVar2.f32876a, i3, i4, bVar.f33716d);
                    }
                    return null;
                }
                int d3 = this.f33708a.d(bVar.f33716d);
                return d(bVar2.f32876a, bVar.f33716d, d3 == -1 ? Long.MIN_VALUE : this.f33708a.f(d3));
            }
            long j6 = bVar.f33715c;
            if (j6 != Long.MIN_VALUE) {
                int e2 = this.f33708a.e(j6);
                if (this.f33708a.m(e2, 0)) {
                    return c(bVar2.f32876a, e2, 0, bVar.f33715c);
                }
                return null;
            }
            int c2 = this.f33708a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f33708a.f(i5) == Long.MIN_VALUE && !this.f33708a.l(i5) && this.f33708a.m(i5, 0)) {
                    return c(bVar2.f32876a, i5, 0, this.f33708a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f33713a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f33713a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j2;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j3 = bVar.f33714b;
            long j4 = bVar.f33715c;
            boolean i2 = i(bVar2, j4);
            boolean j5 = j(bVar2, i2);
            this.f33710c.f(bVar2.f32876a, this.f33708a);
            if (bVar2.b()) {
                h2 = this.f33708a.b(bVar2.f32877b, bVar2.f32878c);
            } else if (j4 == Long.MIN_VALUE) {
                h2 = this.f33708a.h();
            } else {
                j2 = j4;
                return new b(bVar2, j3, j4, bVar.f33716d, j2, i2, j5, null);
            }
            j2 = h2;
            return new b(bVar2, j3, j4, bVar.f33716d, j2, i2, j5, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j2)) == null) {
            int c2 = this.f33710c.f(bVar.f32876a, this.f33708a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f33708a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j2 == Long.MIN_VALUE;
            }
            int a2 = this.f33708a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f32877b == i2 && bVar.f32878c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f33708a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f33710c.l(this.f33710c.f(bVar.f32876a, this.f33708a).f33747c, this.f33709b).f33759e && this.f33710c.q(bVar.f32876a, this.f33708a, this.f33709b, this.f33711d, this.f33712e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.f33710c.f(i2, this.f33708a);
            int e2 = this.f33708a.e(j2);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f33708a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f33711d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f33712e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f33710c = wVar;
        }
    }
}
