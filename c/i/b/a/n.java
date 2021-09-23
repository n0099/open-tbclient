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
    public final w.b f33946a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f33947b;

    /* renamed from: c  reason: collision with root package name */
    public w f33948c;

    /* renamed from: d  reason: collision with root package name */
    public int f33949d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33950e;

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
        public final l.b f33951a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33952b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33953c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33954d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33955e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33956f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f33957g;

        public /* synthetic */ b(l.b bVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, a aVar) {
            this(bVar, j2, j3, j4, j5, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f33951a.a(i2), this.f33952b, this.f33953c, this.f33954d, this.f33955e, this.f33956f, this.f33957g) : (b) invokeI.objValue;
        }

        public b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new b(this.f33951a, j2, this.f33953c, this.f33954d, this.f33955e, this.f33956f, this.f33957g) : (b) invokeJ.objValue;
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
            this.f33951a = bVar;
            this.f33952b = j2;
            this.f33953c = j3;
            this.f33954d = j4;
            this.f33955e = j5;
            this.f33956f = z;
            this.f33957g = z2;
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
        this.f33946a = new w.b();
        this.f33947b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f33960c, oVar.f33962e, oVar.f33961d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f33948c.f(bVar.f33114a, this.f33946a);
            if (bVar.b()) {
                if (this.f33946a.m(bVar.f33115b, bVar.f33116c)) {
                    return c(bVar.f33114a, bVar.f33115b, bVar.f33116c, j2);
                }
                return null;
            }
            int d2 = this.f33946a.d(j3);
            return d(bVar.f33114a, j3, d2 == -1 ? Long.MIN_VALUE : this.f33946a.f(d2));
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
            return new b(bVar, i4 == this.f33946a.i(i3) ? this.f33946a.g() : 0L, Long.MIN_VALUE, j2, this.f33948c.f(bVar.f33114a, this.f33946a).b(bVar.f33115b, bVar.f33116c), i5, j3, null);
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
            this.f33948c.f(bVar.f33114a, this.f33946a);
            return new b(bVar, j2, j3, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.f33946a.h() : j3, i3, j4, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (bVar.f33956f) {
                int d2 = this.f33948c.d(bVar.f33951a.f33114a, this.f33946a, this.f33947b, this.f33949d, this.f33950e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f33948c.f(d2, this.f33946a).f33985c;
                long j4 = 0;
                if (this.f33948c.l(i2, this.f33947b).f33998f == d2) {
                    Pair<Integer, Long> j5 = this.f33948c.j(this.f33947b, this.f33946a, i2, -9223372036854775807L, Math.max(0L, (j2 + bVar.f33955e) - j3));
                    if (j5 == null) {
                        return null;
                    }
                    d2 = ((Integer) j5.first).intValue();
                    j4 = ((Long) j5.second).longValue();
                }
                return b(k(d2, j4), j4, j4);
            }
            l.b bVar2 = bVar.f33951a;
            if (bVar2.b()) {
                int i3 = bVar2.f33115b;
                this.f33948c.f(bVar2.f33114a, this.f33946a);
                int a2 = this.f33946a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f33116c + 1;
                if (i4 < a2) {
                    if (this.f33946a.m(i3, i4)) {
                        return c(bVar2.f33114a, i3, i4, bVar.f33954d);
                    }
                    return null;
                }
                int d3 = this.f33946a.d(bVar.f33954d);
                return d(bVar2.f33114a, bVar.f33954d, d3 == -1 ? Long.MIN_VALUE : this.f33946a.f(d3));
            }
            long j6 = bVar.f33953c;
            if (j6 != Long.MIN_VALUE) {
                int e2 = this.f33946a.e(j6);
                if (this.f33946a.m(e2, 0)) {
                    return c(bVar2.f33114a, e2, 0, bVar.f33953c);
                }
                return null;
            }
            int c2 = this.f33946a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f33946a.f(i5) == Long.MIN_VALUE && !this.f33946a.l(i5) && this.f33946a.m(i5, 0)) {
                    return c(bVar2.f33114a, i5, 0, this.f33946a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f33951a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f33951a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j2;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j3 = bVar.f33952b;
            long j4 = bVar.f33953c;
            boolean i2 = i(bVar2, j4);
            boolean j5 = j(bVar2, i2);
            this.f33948c.f(bVar2.f33114a, this.f33946a);
            if (bVar2.b()) {
                h2 = this.f33946a.b(bVar2.f33115b, bVar2.f33116c);
            } else if (j4 == Long.MIN_VALUE) {
                h2 = this.f33946a.h();
            } else {
                j2 = j4;
                return new b(bVar2, j3, j4, bVar.f33954d, j2, i2, j5, null);
            }
            j2 = h2;
            return new b(bVar2, j3, j4, bVar.f33954d, j2, i2, j5, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j2)) == null) {
            int c2 = this.f33948c.f(bVar.f33114a, this.f33946a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f33946a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j2 == Long.MIN_VALUE;
            }
            int a2 = this.f33946a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f33115b == i2 && bVar.f33116c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f33946a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f33948c.l(this.f33948c.f(bVar.f33114a, this.f33946a).f33985c, this.f33947b).f33997e && this.f33948c.q(bVar.f33114a, this.f33946a, this.f33947b, this.f33949d, this.f33950e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            this.f33948c.f(i2, this.f33946a);
            int e2 = this.f33946a.e(j2);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f33946a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f33949d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f33950e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f33948c = wVar;
        }
    }
}
