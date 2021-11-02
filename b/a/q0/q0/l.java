package b.a.q0.q0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes4.dex */
public class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static l E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12864b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12865c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12866d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12867e;

    /* renamed from: f  reason: collision with root package name */
    public long f12868f;

    /* renamed from: g  reason: collision with root package name */
    public long f12869g;

    /* renamed from: h  reason: collision with root package name */
    public long f12870h;

    /* renamed from: i  reason: collision with root package name */
    public long f12871i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-77927594, "Lb/a/q0/q0/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-77927594, "Lb/a/q0/q0/l;");
        }
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12864b = false;
        this.f12865c = false;
        this.f12866d = false;
        this.f12867e = false;
        this.f12868f = -1L;
        this.f12869g = -1L;
        this.f12870h = -1L;
        this.f12871i = -1L;
        this.j = -1L;
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = -1L;
        this.o = -1L;
        this.p = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.v = -1L;
        this.w = -1L;
        this.x = -1L;
        this.y = -1L;
        this.z = -1L;
        this.A = -1L;
        this.B = -1L;
        this.C = -1L;
        this.D = -1L;
    }

    public static l b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (E == null) {
                synchronized (l.class) {
                    if (E == null) {
                        E = new l();
                    }
                }
            }
            return E;
        }
        return (l) invokeV.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f12864b = z;
        }
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.j = j;
        }
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12867e = z;
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f12871i = j;
        }
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
        }
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.y = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || this.z > 0) {
            return;
        }
        this.z = j;
    }

    public void I(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.A = j;
        }
    }

    public void J(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f12869g = j;
        }
    }

    public void K(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.o = j;
        }
    }

    public void L(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.n = j;
        }
    }

    public void M(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.x = j;
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f12868f : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.w : invokeV.longValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f12865c : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            long j = 0;
            if (this.D - this.f12868f <= 0 || this.f12866d || this.v <= 0 || !k.d().g()) {
                return;
            }
            long j2 = this.f12869g - this.f12868f;
            long j3 = this.t;
            long j4 = j3 > 0 ? this.u - j3 : -1L;
            this.f12866d = true;
            long j5 = this.D - this.C;
            b.a.e.e.n.a a2 = j.a();
            a2.b("procname", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
            a2.b("appc", String.valueOf(j2));
            a2.b("loadclass", String.valueOf(this.f12870h));
            a2.b("sapiinit", String.valueOf(this.f12871i));
            a2.b("acctinit", String.valueOf(this.A));
            a2.b("iminit", String.valueOf(this.y));
            a2.b("plugininit", String.valueOf(this.z));
            a2.b("patchloaded", String.valueOf(this.j));
            a2.b("naslibinit", String.valueOf(this.k));
            a2.b("websocketinit", String.valueOf(this.l));
            a2.b("settinginit", String.valueOf(this.m));
            a2.b("toastinit", String.valueOf(this.n));
            a2.b("tiebastaticinit", String.valueOf(this.o));
            a2.b("cdninit", String.valueOf(this.p));
            a2.b("messagesetinit", String.valueOf(this.q));
            a2.b("logores", String.valueOf(this.B));
            a2.b("opttest", String.valueOf(b.a.q0.s.x.d.f13643b ? 1 : 0));
            long j6 = this.r;
            if (j6 > 0 && this.t > 0 && j4 > 0) {
                a2.b("adc", String.valueOf(j6 + this.s));
                a2.b(SpeedStatsMainTable.AD_SHOW, String.valueOf(j4));
                a2.b("adrequest", String.valueOf(this.s));
                j = this.r + this.s + j4;
                a2.b("hasad", "1");
            } else {
                a2.b("hasad", "0");
                long j7 = this.s;
                if (j7 > 0) {
                    j = j7;
                }
            }
            a2.b("tabc", String.valueOf(j5));
            a2.b("costt", String.valueOf(this.w - j));
            a2.b("newinst", this.f12864b ? "1" : "0");
            a2.c("pluginloadsync", Boolean.valueOf(this.f12867e));
            a2.b("hptotal", String.valueOf(this.v));
            a2.b("locationinit", String.valueOf(j2 + this.B + this.r + j4 + this.s + j5 + this.v));
            a2.b("userperceptiont", String.valueOf(this.x - j));
            BdStatisticsManager.getInstance().performance("startt", a2);
            h();
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048593, this, j) == null) && k.d().g() && j > 0) {
            b.a.e.e.n.a a2 = j.a();
            a2.b("procname", "remote");
            a2.b("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", a2);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f12864b = false;
            this.f12865c = false;
            this.f12868f = -1L;
            this.f12869g = -1L;
            this.w = -1L;
            this.f12870h = -1L;
            this.f12871i = -1L;
            this.j = -1L;
            this.B = -1L;
            this.t = -1L;
            this.u = -1L;
            this.r = -1L;
            this.C = -1L;
            this.D = -1L;
            this.k = -1L;
            this.l = -1L;
            this.m = -1L;
            this.n = -1L;
            this.o = -1L;
            this.p = -1L;
            this.q = -1L;
            this.s = -1L;
            this.v = -1L;
            this.x = -1L;
            this.y = -1L;
            this.z = -1L;
            this.A = -1L;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.r = j;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.s = j;
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.u = j;
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.t = j;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.p = j;
        }
    }

    public void o(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048601, this, j) == null) || this.v > 0) {
            return;
        }
        this.v = j;
        this.w = System.currentTimeMillis() - this.f12868f;
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.k = j;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.m = j;
        }
    }

    public void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.l = j;
        }
    }

    public void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.f12868f = j;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.f12870h = j;
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.B = j;
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.C = j;
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            this.D = j;
            this.f12865c = true;
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.q = j;
        }
    }
}
