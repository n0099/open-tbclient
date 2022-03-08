package c.a.p0.j.o;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.o1.c.e.a;
import c.a.p0.a.p2.l0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.w0.f;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.m.i;
import c.a.p0.j.g0.h;
import c.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
/* loaded from: classes2.dex */
public class d extends c.a.p0.a.j0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public long v;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.a.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.q0.b
        public void a(int i2, c.a.p0.a.q0.a aVar) {
            a.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || (cVar = (a.c) aVar) == null || TextUtils.isEmpty(cVar.a)) {
                return;
            }
            c.a.p0.j.o.c.m().I(this.a.Z());
            c.a.p0.j.o.c.m().x(cVar);
            c.a.p0.j.c.j.b.h();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.o1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    c.a.p0.a.o1.c.a.e().h(new c.a.p0.a.o1.c.c(4));
                    this.a.Q0();
                    c.a.p0.j.o.c.m().H();
                    c.a.p0.a.t1.d.J().t();
                    return true;
                } else if (i2 == 102) {
                    boolean a = c.a.p0.a.s0.a.M().a();
                    c.a.p0.a.s0.a.M().d(a);
                    if (this.a.f5767f != null) {
                        this.a.f5767f.onNightModeCoverChanged(a, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L != null) {
                        L.d0().i();
                        c.a.p0.a.f1.r.a.g().v();
                    }
                    this.a.Q0();
                    c.a.p0.j.o.c.m().H();
                    c.a.p0.j.b.e.b();
                    return true;
                } else if (i2 == 106) {
                    c.a.p0.a.t1.d.J().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            c.a.p0.a.p2.c.r(message);
                            return true;
                        case 124:
                            c.a.p0.a.p2.c.q(message);
                            return true;
                        case 125:
                            c.a.p0.a.o1.c.d.a.b(message);
                            return true;
                        case 126:
                            c.a.p0.a.o1.c.d.a.d(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    i.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10592e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10592e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.w;
                this.f10592e.v = System.currentTimeMillis();
                h.f(this.f10592e.Z());
                this.f10592e.f5767f.finishLoadingAnimator();
                c.a.p0.a.k1.h.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                int j2 = c.a.p0.j.o.c.m().j();
                HybridUbcFlow p = c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j2));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f2 = p.f("na_first_paint", "naStart");
                c.a.p0.j.o.c.m().i(new c.a.p0.j.x.b(f2));
                if (d.w) {
                    String str = "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f2;
                }
                c.a.p0.j.n0.d.A().D();
                c.a.p0.j.u.a.f().init();
            }
        }
    }

    /* renamed from: c.a.p0.j.o.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0724d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10593e;

        public RunnableC0724d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10593e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10593e.i1();
                this.f10593e.h1();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101182203, "Lc/a/p0/j/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101182203, "Lc/a/p0/j/o/d;");
                return;
            }
        }
        w = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.p0.a.j0.c
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.p0.a.j0.c
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            n.E();
            if (z2) {
                h.f(Z());
                c.a.p0.j.b.e.b();
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    @NonNull
    public a.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (a.c) invokeV.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (c.a.p0.a.t1.d.J().D()) {
                f.U().E(Z(), new a(this));
                if (c.a.p0.j.o.c.m().v() && c.a.p0.j.o.c.m().q()) {
                    c.a.p0.j.o.c.m().F(this.f5767f);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : invokeV.longValue;
    }

    @Override // c.a.p0.a.j0.c
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.p0.a.t1.d.J().r().X().d0() == 1 : invokeV.booleanValue;
    }

    public c.a.p0.a.b0.a g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.p0.j.o.c.m().n() : (c.a.p0.a.b0.a) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.j.n0.d.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.j.n0.d.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.j0.c
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.a.u.d.i("SwanApp", "onBackPressed back stack count:" + this.f5768g.k());
            c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
            fVar.f4950e = com.alipay.sdk.widget.d.u;
            Q(fVar);
            c.a.p0.a.x.g.d m = this.f5768g.m();
            if (m == null || !m.K()) {
                if (e0()) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L != null) {
                        L.O().E();
                    }
                    h.e(com.alipay.sdk.widget.d.u, Z());
                    c.a.p0.j.b.e.g("0");
                    return;
                }
                g.b i2 = this.f5768g.i("navigateBack");
                i2.n(g.f8376i, g.f8375h);
                i2.g();
                i2.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q0.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new RunnableC0724d(this), "SwanGameFrameRequestAd", 2);
            c.a.p0.j.n0.f.q();
            c.a.p0.j.n0.e.b();
        }
    }

    @Override // c.a.p0.a.t1.m, c.a.p0.a.t1.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.v = 0L;
        }
    }

    @Override // c.a.p0.a.j0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            c.a.p0.j.g0.b.c().b();
            c.a.p0.j.z.e.b.b().e();
            r().I(true);
            e1();
            V8Engine.setCrashKeyValue("game_title", Z() == null ? "" : Z().K());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && r().H()) {
            if (l0.f(Z().a0())) {
                if (w) {
                    String str = "release SwanGameCoreRuntime minSwanVersion:" + Z().a0();
                }
                c.a.p0.j.o.c.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && l0.f(j0.swanCoreVersionName) && c.a.p0.a.v0.e.a.a(Z().S())) {
                boolean z = w;
                c.a.p0.j.o.c.C();
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.p0.j.b.d.v();
            c.a.p0.a.h0.i.i();
            h.e("exit", Z());
            f.U().unregisterReceiver(this.f5767f);
            f.b0();
            c.a.p0.j.m0.a.a().b();
            SwanInspectorEndpoint.v().q();
            c.a.p0.j.g0.b.c().b();
            c.a.p0.j.z.e.b.b().e();
        }
    }

    @Override // c.a.p0.a.j0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            c.a.p0.j.o.c.m().h(this.f5767f);
        }
    }

    @Override // c.a.p0.a.j0.c
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // c.a.p0.a.j0.c
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            f.U().registerReceiver(this.f5767f);
        }
    }

    @Override // c.a.p0.a.j0.c
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // c.a.p0.a.j0.c
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
