package c.a.s0.s0;

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
/* loaded from: classes6.dex */
public class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static l E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13766b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13767c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13768d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13769e;

    /* renamed from: f  reason: collision with root package name */
    public long f13770f;

    /* renamed from: g  reason: collision with root package name */
    public long f13771g;

    /* renamed from: h  reason: collision with root package name */
    public long f13772h;

    /* renamed from: i  reason: collision with root package name */
    public long f13773i;

    /* renamed from: j  reason: collision with root package name */
    public long f13774j;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-756344459, "Lc/a/s0/s0/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-756344459, "Lc/a/s0/s0/l;");
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
        this.f13766b = false;
        this.f13767c = false;
        this.f13768d = false;
        this.f13769e = false;
        this.f13770f = -1L;
        this.f13771g = -1L;
        this.f13772h = -1L;
        this.f13773i = -1L;
        this.f13774j = -1L;
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
            this.f13766b = z;
        }
    }

    public void B(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f13773i = j2;
        }
    }

    public void C(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
        }
    }

    public void D(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.y = j2;
        }
    }

    public void E(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.z > 0) {
            return;
        }
        this.z = j2;
    }

    public void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.A = j2;
        }
    }

    public void G(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f13771g = j2;
        }
    }

    public void H(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.o = j2;
        }
    }

    public void I(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.n = j2;
        }
    }

    public void J(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.x = j2;
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13770f : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.longValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13767c : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long j2 = 0;
            if (this.D - this.f13770f <= 0 || this.f13768d || this.v <= 0 || !k.d().g()) {
                return;
            }
            long j3 = this.f13771g - this.f13770f;
            long j4 = this.t;
            long j5 = j4 > 0 ? this.u - j4 : -1L;
            this.f13768d = true;
            long j6 = this.D - this.C;
            c.a.d.f.n.a a = j.a();
            a.b("procname", "main");
            a.b("appc", String.valueOf(j3));
            a.b("loadclass", String.valueOf(this.f13772h));
            a.b("sapiinit", String.valueOf(this.f13773i));
            a.b("acctinit", String.valueOf(this.A));
            a.b("iminit", String.valueOf(this.y));
            a.b("plugininit", String.valueOf(this.z));
            a.b("patchloaded", String.valueOf(this.f13774j));
            a.b("naslibinit", String.valueOf(this.k));
            a.b("websocketinit", String.valueOf(this.l));
            a.b("settinginit", String.valueOf(this.m));
            a.b("toastinit", String.valueOf(this.n));
            a.b("tiebastaticinit", String.valueOf(this.o));
            a.b("cdninit", String.valueOf(this.p));
            a.b("messagesetinit", String.valueOf(this.q));
            a.b("logores", String.valueOf(this.B));
            a.b("opttest", String.valueOf(c.a.s0.s.x.d.f13673b ? 1 : 0));
            long j7 = this.r;
            if (j7 > 0 && this.t > 0 && j5 > 0) {
                a.b("adc", String.valueOf(j7 + this.s));
                a.b(SpeedStatsMainTable.AD_SHOW, String.valueOf(j5));
                a.b("adrequest", String.valueOf(this.s));
                j2 = this.r + this.s + j5;
                a.b("hasad", "1");
            } else {
                a.b("hasad", "0");
                long j8 = this.s;
                if (j8 > 0) {
                    j2 = j8;
                }
            }
            a.b("tabc", String.valueOf(j6));
            a.b("costt", String.valueOf(this.w - j2));
            a.b("newinst", this.f13766b ? "1" : "0");
            a.c("pluginloadsync", Boolean.valueOf(this.f13769e));
            a.b("hptotal", String.valueOf(this.v));
            a.b("locationinit", String.valueOf(j3 + this.B + this.r + j5 + this.s + j6 + this.v));
            a.b("userperceptiont", String.valueOf(this.x - j2));
            BdStatisticsManager.getInstance().performance("startt", a);
            h();
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) && k.d().g() && j2 > 0) {
            c.a.d.f.n.a a = j.a();
            a.b("procname", "remote");
            a.b("costt", String.valueOf(j2));
            BdStatisticsManager.getInstance().performance("startt", a);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13766b = false;
            this.f13767c = false;
            this.f13770f = -1L;
            this.f13771g = -1L;
            this.w = -1L;
            this.f13772h = -1L;
            this.f13773i = -1L;
            this.f13774j = -1L;
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

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
        }
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            this.r = j2;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.s = j2;
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.u = j2;
        }
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.t = j2;
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j2) == null) {
            this.p = j2;
        }
    }

    public void o(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) || this.v > 0) {
            return;
        }
        this.v = j2;
        this.w = System.currentTimeMillis() - this.f13770f;
    }

    public void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
        }
    }

    public void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.k = j2;
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            this.m = j2;
        }
    }

    public void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            this.l = j2;
        }
    }

    public void t(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            this.f13770f = j2;
        }
    }

    public void u(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            this.f13772h = j2;
        }
    }

    public void v(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j2) == null) {
        }
    }

    public void w(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
            this.B = j2;
        }
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
            this.C = j2;
        }
    }

    public void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j2) == null) {
            this.D = j2;
            this.f13767c = true;
        }
    }

    public void z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.q = j2;
        }
    }
}
