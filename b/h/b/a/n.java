package b.h.b.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.d0.l;
import b.h.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w.b f33600a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f33601b;

    /* renamed from: c  reason: collision with root package name */
    public w f33602c;

    /* renamed from: d  reason: collision with root package name */
    public int f33603d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33604e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l.b f33605a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33606b;

        /* renamed from: c  reason: collision with root package name */
        public final long f33607c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33608d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33609e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f33610f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f33611g;

        public /* synthetic */ b(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, a aVar) {
            this(bVar, j, j2, j3, j4, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f33605a.a(i2), this.f33606b, this.f33607c, this.f33608d, this.f33609e, this.f33610f, this.f33611g) : (b) invokeI.objValue;
        }

        public b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new b(this.f33605a, j, this.f33607c, this.f33608d, this.f33609e, this.f33610f, this.f33611g) : (b) invokeJ.objValue;
        }

        public b(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33605a = bVar;
            this.f33606b = j;
            this.f33607c = j2;
            this.f33608d = j3;
            this.f33609e = j4;
            this.f33610f = z;
            this.f33611g = z2;
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
        this.f33600a = new w.b();
        this.f33601b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f33614c, oVar.f33616e, oVar.f33615d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.f33602c.f(bVar.f32816a, this.f33600a);
            if (bVar.b()) {
                if (this.f33600a.m(bVar.f32817b, bVar.f32818c)) {
                    return c(bVar.f32816a, bVar.f32817b, bVar.f32818c, j);
                }
                return null;
            }
            int d2 = this.f33600a.d(j2);
            return d(bVar.f32816a, j2, d2 == -1 ? Long.MIN_VALUE : this.f33600a.f(d2));
        }
        return (b) invokeCommon.objValue;
    }

    public final b c(int i2, int i3, int i4, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)})) == null) {
            l.b bVar = new l.b(i2, i3, i4);
            boolean i5 = i(bVar, Long.MIN_VALUE);
            boolean j2 = j(bVar, i5);
            return new b(bVar, i4 == this.f33600a.i(i3) ? this.f33600a.g() : 0L, Long.MIN_VALUE, j, this.f33602c.f(bVar.f32816a, this.f33600a).b(bVar.f32817b, bVar.f32818c), i5, j2, null);
        }
        return (b) invokeCommon.objValue;
    }

    public final b d(int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            l.b bVar = new l.b(i2);
            boolean i3 = i(bVar, j2);
            boolean j3 = j(bVar, i3);
            this.f33602c.f(bVar.f32816a, this.f33600a);
            return new b(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.f33600a.h() : j2, i3, j3, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar.f33610f) {
                int d2 = this.f33602c.d(bVar.f33605a.f32816a, this.f33600a, this.f33601b, this.f33603d, this.f33604e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f33602c.f(d2, this.f33600a).f33638c;
                long j3 = 0;
                if (this.f33602c.l(i2, this.f33601b).f33650f == d2) {
                    Pair<Integer, Long> j4 = this.f33602c.j(this.f33601b, this.f33600a, i2, -9223372036854775807L, Math.max(0L, (j + bVar.f33609e) - j2));
                    if (j4 == null) {
                        return null;
                    }
                    d2 = ((Integer) j4.first).intValue();
                    j3 = ((Long) j4.second).longValue();
                }
                return b(k(d2, j3), j3, j3);
            }
            l.b bVar2 = bVar.f33605a;
            if (bVar2.b()) {
                int i3 = bVar2.f32817b;
                this.f33602c.f(bVar2.f32816a, this.f33600a);
                int a2 = this.f33600a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f32818c + 1;
                if (i4 < a2) {
                    if (this.f33600a.m(i3, i4)) {
                        return c(bVar2.f32816a, i3, i4, bVar.f33608d);
                    }
                    return null;
                }
                int d3 = this.f33600a.d(bVar.f33608d);
                return d(bVar2.f32816a, bVar.f33608d, d3 == -1 ? Long.MIN_VALUE : this.f33600a.f(d3));
            }
            long j5 = bVar.f33607c;
            if (j5 != Long.MIN_VALUE) {
                int e2 = this.f33600a.e(j5);
                if (this.f33600a.m(e2, 0)) {
                    return c(bVar2.f32816a, e2, 0, bVar.f33607c);
                }
                return null;
            }
            int c2 = this.f33600a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f33600a.f(i5) == Long.MIN_VALUE && !this.f33600a.l(i5) && this.f33600a.m(i5, 0)) {
                    return c(bVar2.f32816a, i5, 0, this.f33600a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f33605a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f33605a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j2 = bVar.f33606b;
            long j3 = bVar.f33607c;
            boolean i2 = i(bVar2, j3);
            boolean j4 = j(bVar2, i2);
            this.f33602c.f(bVar2.f32816a, this.f33600a);
            if (bVar2.b()) {
                h2 = this.f33600a.b(bVar2.f32817b, bVar2.f32818c);
            } else if (j3 == Long.MIN_VALUE) {
                h2 = this.f33600a.h();
            } else {
                j = j3;
                return new b(bVar2, j2, j3, bVar.f33608d, j, i2, j4, null);
            }
            j = h2;
            return new b(bVar2, j2, j3, bVar.f33608d, j, i2, j4, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j)) == null) {
            int c2 = this.f33602c.f(bVar.f32816a, this.f33600a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f33600a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j == Long.MIN_VALUE;
            }
            int a2 = this.f33600a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f32817b == i2 && bVar.f32818c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f33600a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f33602c.l(this.f33602c.f(bVar.f32816a, this.f33600a).f33638c, this.f33601b).f33649e && this.f33602c.q(bVar.f32816a, this.f33600a, this.f33601b, this.f33603d, this.f33604e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            this.f33602c.f(i2, this.f33600a);
            int e2 = this.f33600a.e(j);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f33600a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f33603d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f33604e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f33602c = wVar;
        }
    }
}
