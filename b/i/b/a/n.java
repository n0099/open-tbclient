package b.i.b.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.l;
import b.i.b.a.w;
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
    public final w.b f32742a;

    /* renamed from: b  reason: collision with root package name */
    public final w.c f32743b;

    /* renamed from: c  reason: collision with root package name */
    public w f32744c;

    /* renamed from: d  reason: collision with root package name */
    public int f32745d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32746e;

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
        public final l.b f32747a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32748b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32749c;

        /* renamed from: d  reason: collision with root package name */
        public final long f32750d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32751e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f32752f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f32753g;

        public /* synthetic */ b(l.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, a aVar) {
            this(bVar, j, j2, j3, j4, z, z2);
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new b(this.f32747a.a(i2), this.f32748b, this.f32749c, this.f32750d, this.f32751e, this.f32752f, this.f32753g) : (b) invokeI.objValue;
        }

        public b b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new b(this.f32747a, j, this.f32749c, this.f32750d, this.f32751e, this.f32752f, this.f32753g) : (b) invokeJ.objValue;
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
            this.f32747a = bVar;
            this.f32748b = j;
            this.f32749c = j2;
            this.f32750d = j3;
            this.f32751e = j4;
            this.f32752f = z;
            this.f32753g = z2;
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
        this.f32742a = new w.b();
        this.f32743b = new w.c();
    }

    public b a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? b(oVar.f32756c, oVar.f32758e, oVar.f32757d) : (b) invokeL.objValue;
    }

    public final b b(l.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.f32744c.f(bVar.f31958a, this.f32742a);
            if (bVar.b()) {
                if (this.f32742a.m(bVar.f31959b, bVar.f31960c)) {
                    return c(bVar.f31958a, bVar.f31959b, bVar.f31960c, j);
                }
                return null;
            }
            int d2 = this.f32742a.d(j2);
            return d(bVar.f31958a, j2, d2 == -1 ? Long.MIN_VALUE : this.f32742a.f(d2));
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
            return new b(bVar, i4 == this.f32742a.i(i3) ? this.f32742a.g() : 0L, Long.MIN_VALUE, j, this.f32744c.f(bVar.f31958a, this.f32742a).b(bVar.f31959b, bVar.f31960c), i5, j2, null);
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
            this.f32744c.f(bVar.f31958a, this.f32742a);
            return new b(bVar, j, j2, -9223372036854775807L, j2 == Long.MIN_VALUE ? this.f32742a.h() : j2, i3, j3, null);
        }
        return (b) invokeCommon.objValue;
    }

    public b e(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar.f32752f) {
                int d2 = this.f32744c.d(bVar.f32747a.f31958a, this.f32742a, this.f32743b, this.f32745d, this.f32746e);
                if (d2 == -1) {
                    return null;
                }
                int i2 = this.f32744c.f(d2, this.f32742a).f32780c;
                long j3 = 0;
                if (this.f32744c.l(i2, this.f32743b).f32792f == d2) {
                    Pair<Integer, Long> j4 = this.f32744c.j(this.f32743b, this.f32742a, i2, -9223372036854775807L, Math.max(0L, (j + bVar.f32751e) - j2));
                    if (j4 == null) {
                        return null;
                    }
                    d2 = ((Integer) j4.first).intValue();
                    j3 = ((Long) j4.second).longValue();
                }
                return b(k(d2, j3), j3, j3);
            }
            l.b bVar2 = bVar.f32747a;
            if (bVar2.b()) {
                int i3 = bVar2.f31959b;
                this.f32744c.f(bVar2.f31958a, this.f32742a);
                int a2 = this.f32742a.a(i3);
                if (a2 == -1) {
                    return null;
                }
                int i4 = bVar2.f31960c + 1;
                if (i4 < a2) {
                    if (this.f32742a.m(i3, i4)) {
                        return c(bVar2.f31958a, i3, i4, bVar.f32750d);
                    }
                    return null;
                }
                int d3 = this.f32742a.d(bVar.f32750d);
                return d(bVar2.f31958a, bVar.f32750d, d3 == -1 ? Long.MIN_VALUE : this.f32742a.f(d3));
            }
            long j5 = bVar.f32749c;
            if (j5 != Long.MIN_VALUE) {
                int e2 = this.f32742a.e(j5);
                if (this.f32742a.m(e2, 0)) {
                    return c(bVar2.f31958a, e2, 0, bVar.f32749c);
                }
                return null;
            }
            int c2 = this.f32742a.c();
            if (c2 != 0) {
                int i5 = c2 - 1;
                if (this.f32742a.f(i5) == Long.MIN_VALUE && !this.f32742a.l(i5) && this.f32742a.m(i5, 0)) {
                    return c(bVar2.f31958a, i5, 0, this.f32742a.h());
                }
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public b f(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) ? h(bVar, bVar.f32747a) : (b) invokeL.objValue;
    }

    public b g(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? h(bVar, bVar.f32747a.a(i2)) : (b) invokeLI.objValue;
    }

    public final b h(b bVar, l.b bVar2) {
        InterceptResult invokeLL;
        long j;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, bVar2)) == null) {
            long j2 = bVar.f32748b;
            long j3 = bVar.f32749c;
            boolean i2 = i(bVar2, j3);
            boolean j4 = j(bVar2, i2);
            this.f32744c.f(bVar2.f31958a, this.f32742a);
            if (bVar2.b()) {
                h2 = this.f32742a.b(bVar2.f31959b, bVar2.f31960c);
            } else if (j3 == Long.MIN_VALUE) {
                h2 = this.f32742a.h();
            } else {
                j = j3;
                return new b(bVar2, j2, j3, bVar.f32750d, j, i2, j4, null);
            }
            j = h2;
            return new b(bVar2, j2, j3, bVar.f32750d, j, i2, j4, null);
        }
        return (b) invokeLL.objValue;
    }

    public final boolean i(l.b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, j)) == null) {
            int c2 = this.f32744c.f(bVar.f31958a, this.f32742a).c();
            if (c2 == 0) {
                return true;
            }
            int i2 = c2 - 1;
            boolean b2 = bVar.b();
            if (this.f32742a.f(i2) != Long.MIN_VALUE) {
                return !b2 && j == Long.MIN_VALUE;
            }
            int a2 = this.f32742a.a(i2);
            if (a2 == -1) {
                return false;
            }
            if (b2 && bVar.f31959b == i2 && bVar.f31960c == a2 + (-1)) {
                return true;
            }
            return !b2 && this.f32742a.i(i2) == a2;
        }
        return invokeLJ.booleanValue;
    }

    public final boolean j(l.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) == null) ? !this.f32744c.l(this.f32744c.f(bVar.f31958a, this.f32742a).f32780c, this.f32743b).f32791e && this.f32744c.q(bVar.f31958a, this.f32742a, this.f32743b, this.f32745d, this.f32746e) && z : invokeLZ.booleanValue;
    }

    public l.b k(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            this.f32744c.f(i2, this.f32742a);
            int e2 = this.f32742a.e(j);
            if (e2 == -1) {
                return new l.b(i2);
            }
            return new l.b(i2, e2, this.f32742a.i(e2));
        }
        return (l.b) invokeCommon.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f32745d = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f32746e = z;
        }
    }

    public void n(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, wVar) == null) {
            this.f32744c = wVar;
        }
    }
}
