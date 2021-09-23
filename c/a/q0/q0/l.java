package c.a.q0.q0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public static l E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13712b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13713c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13714d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13715e;

    /* renamed from: f  reason: collision with root package name */
    public long f13716f;

    /* renamed from: g  reason: collision with root package name */
    public long f13717g;

    /* renamed from: h  reason: collision with root package name */
    public long f13718h;

    /* renamed from: i  reason: collision with root package name */
    public long f13719i;

    /* renamed from: j  reason: collision with root package name */
    public long f13720j;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(51155125, "Lc/a/q0/q0/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(51155125, "Lc/a/q0/q0/l;");
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
        this.f13712b = false;
        this.f13713c = false;
        this.f13714d = false;
        this.f13715e = false;
        this.f13716f = -1L;
        this.f13717g = -1L;
        this.f13718h = -1L;
        this.f13719i = -1L;
        this.f13720j = -1L;
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
            this.f13712b = z;
        }
    }

    public void B(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f13720j = j2;
        }
    }

    public void C(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13715e = z;
        }
    }

    public void E(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f13719i = j2;
        }
    }

    public void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
        }
    }

    public void G(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.y = j2;
        }
    }

    public void H(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.z > 0) {
            return;
        }
        this.z = j2;
    }

    public void I(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.A = j2;
        }
    }

    public void J(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.f13717g = j2;
        }
    }

    public void K(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.o = j2;
        }
    }

    public void L(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.n = j2;
        }
    }

    public void M(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.x = j2;
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f13716f : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.w : invokeV.longValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f13713c : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            long j2 = 0;
            if (this.D - this.f13716f <= 0 || this.f13714d || this.v <= 0 || !k.d().g()) {
                return;
            }
            long j3 = this.f13717g - this.f13716f;
            long j4 = this.t;
            long j5 = j4 > 0 ? this.u - j4 : -1L;
            this.f13714d = true;
            long j6 = this.D - this.C;
            c.a.e.e.n.a a2 = j.a();
            a2.b("procname", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
            a2.b("appc", String.valueOf(j3));
            a2.b("loadclass", String.valueOf(this.f13718h));
            a2.b("sapiinit", String.valueOf(this.f13719i));
            a2.b("acctinit", String.valueOf(this.A));
            a2.b("iminit", String.valueOf(this.y));
            a2.b("plugininit", String.valueOf(this.z));
            a2.b("patchloaded", String.valueOf(this.f13720j));
            a2.b("naslibinit", String.valueOf(this.k));
            a2.b("websocketinit", String.valueOf(this.l));
            a2.b("settinginit", String.valueOf(this.m));
            a2.b("toastinit", String.valueOf(this.n));
            a2.b("tiebastaticinit", String.valueOf(this.o));
            a2.b("cdninit", String.valueOf(this.p));
            a2.b("messagesetinit", String.valueOf(this.q));
            a2.b("logores", String.valueOf(this.B));
            a2.b("opttest", String.valueOf(c.a.q0.s.x.d.f14520b ? 1 : 0));
            long j7 = this.r;
            if (j7 > 0 && this.t > 0 && j5 > 0) {
                a2.b("adc", String.valueOf(j7 + this.s));
                a2.b("adshow", String.valueOf(j5));
                a2.b("adrequest", String.valueOf(this.s));
                j2 = this.r + this.s + j5;
                a2.b("hasad", "1");
            } else {
                a2.b("hasad", "0");
                long j8 = this.s;
                if (j8 > 0) {
                    j2 = j8;
                }
            }
            a2.b("tabc", String.valueOf(j6));
            a2.b("costt", String.valueOf(this.w - j2));
            a2.b("newinst", this.f13712b ? "1" : "0");
            a2.c("pluginloadsync", Boolean.valueOf(this.f13715e));
            a2.b("hptotal", String.valueOf(this.v));
            a2.b("locationinit", String.valueOf(j3 + this.B + this.r + j5 + this.s + j6 + this.v));
            a2.b("userperceptiont", String.valueOf(this.x - j2));
            BdStatisticsManager.getInstance().performance("startt", a2);
            h();
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) && k.d().g() && j2 > 0) {
            c.a.e.e.n.a a2 = j.a();
            a2.b("procname", "remote");
            a2.b("costt", String.valueOf(j2));
            BdStatisticsManager.getInstance().performance("startt", a2);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f13712b = false;
            this.f13713c = false;
            this.f13716f = -1L;
            this.f13717g = -1L;
            this.w = -1L;
            this.f13718h = -1L;
            this.f13719i = -1L;
            this.f13720j = -1L;
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
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
        }
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.r = j2;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j2) == null) {
            this.s = j2;
        }
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            this.u = j2;
        }
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.t = j2;
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.p = j2;
        }
    }

    public void o(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) || this.v > 0) {
            return;
        }
        this.v = j2;
        this.w = System.currentTimeMillis() - this.f13716f;
    }

    public void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
        }
    }

    public void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            this.k = j2;
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            this.m = j2;
        }
    }

    public void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j2) == null) {
            this.l = j2;
        }
    }

    public void t(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
            this.f13716f = j2;
        }
    }

    public void u(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
            this.f13718h = j2;
        }
    }

    public void v(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j2) == null) {
        }
    }

    public void w(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.B = j2;
        }
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j2) == null) {
            this.C = j2;
        }
    }

    public void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j2) == null) {
            this.D = j2;
            this.f13713c = true;
        }
    }

    public void z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j2) == null) {
            this.q = j2;
        }
    }
}
