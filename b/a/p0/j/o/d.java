package b.a.p0.j.o;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.m.i;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.y1.c.e.a;
import b.a.p0.a.z2.l0;
import b.a.p0.a.z2.q0;
import b.a.p0.j.g0.h;
import b.a.p0.j.t.a;
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
/* loaded from: classes4.dex */
public class d extends b.a.p0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public long v;

    /* loaded from: classes4.dex */
    public class a implements b.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11304a;

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
            this.f11304a = dVar;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            a.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || (cVar = (a.c) aVar) == null || TextUtils.isEmpty(cVar.f11462a)) {
                return;
            }
            b.a.p0.j.o.c.m().I(this.f11304a.Z());
            b.a.p0.j.o.c.m().x(cVar);
            b.a.p0.j.c.j.b.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11305a;

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
            this.f11305a = dVar;
        }

        @Override // b.a.p0.a.y1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(4));
                    this.f11305a.Q0();
                    b.a.p0.j.o.c.m().H();
                    b.a.p0.a.d2.d.J().t();
                    return true;
                } else if (i2 == 102) {
                    boolean a2 = b.a.p0.a.c1.a.M().a();
                    b.a.p0.a.c1.a.M().d(a2);
                    if (this.f11305a.f8364f != null) {
                        this.f11305a.f8364f.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                    if (L != null) {
                        L.d0().i();
                        b.a.p0.a.p1.r.a.g().v();
                    }
                    this.f11305a.Q0();
                    b.a.p0.j.o.c.m().H();
                    b.a.p0.j.b.e.b();
                    return true;
                } else if (i2 == 106) {
                    b.a.p0.a.d2.d.J().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            b.a.p0.a.z2.c.r(message);
                            return true;
                        case 124:
                            b.a.p0.a.z2.c.q(message);
                            return true;
                        case 125:
                            b.a.p0.a.y1.c.d.a.b(message);
                            return true;
                        case 126:
                            b.a.p0.a.y1.c.d.a.d(message);
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

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f11306e;

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
            this.f11306e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.w;
                this.f11306e.v = System.currentTimeMillis();
                h.f(this.f11306e.Z());
                this.f11306e.f8364f.finishLoadingAnimator();
                b.a.p0.a.u1.h.h("preload", "startup");
                int j = b.a.p0.j.o.c.m().j();
                HybridUbcFlow p = b.a.p0.a.u1.h.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f2 = p.f("na_first_paint", "naStart");
                b.a.p0.j.o.c.m().i(new b.a.p0.j.x.b(f2));
                if (d.w) {
                    String str = "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f2;
                }
                b.a.p0.j.n0.d.A().D();
                b.a.p0.j.u.a.f().init();
            }
        }
    }

    /* renamed from: b.a.p0.j.o.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0610d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f11307e;

        public RunnableC0610d(d dVar) {
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
            this.f11307e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11307e.i1();
                this.f11307e.h1();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807779196, "Lb/a/p0/j/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807779196, "Lb/a/p0/j/o/d;");
                return;
            }
        }
        w = k.f6863a;
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

    @Override // b.a.p0.a.t0.c
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            n.E();
            if (z2) {
                h.f(Z());
                b.a.p0.j.b.e.b();
            }
        }
    }

    @Override // b.a.p0.a.t0.c
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
            if (b.a.p0.a.d2.d.J().D()) {
                f.U().E(Z(), new a(this));
                if (b.a.p0.j.o.c.m().v() && b.a.p0.j.o.c.m().q()) {
                    b.a.p0.j.o.c.m().F(this.f8364f);
                }
            }
        }
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : invokeV.longValue;
    }

    @Override // b.a.p0.a.t0.c
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b.a.p0.a.d2.d.J().r().X().d0() == 1 : invokeV.booleanValue;
    }

    public b.a.p0.a.l0.a g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.p0.j.o.c.m().n() : (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.p0.j.n0.d.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.p0.j.n0.d.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.t0.c
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.p0.a.e0.d.i("SwanApp", "onBackPressed back stack count:" + this.f8365g.k());
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7383e = com.alipay.sdk.widget.d.u;
            Q(fVar);
            b.a.p0.a.h0.g.d m = this.f8365g.m();
            if (m == null || !m.K()) {
                if (e0()) {
                    b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                    if (L != null) {
                        L.O().E();
                    }
                    h.e(com.alipay.sdk.widget.d.u, Z());
                    b.a.p0.j.b.e.g("0");
                    return;
                }
                g.b i2 = this.f8365g.i("navigateBack");
                i2.n(g.f5480i, g.f5479h);
                i2.g();
                i2.a();
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q0.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new RunnableC0610d(this), "SwanGameFrameRequestAd", 2);
            b.a.p0.j.n0.f.q();
            b.a.p0.j.n0.e.b();
        }
    }

    @Override // b.a.p0.a.d2.m, b.a.p0.a.d2.h
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

    @Override // b.a.p0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            b.a.p0.j.g0.b.c().b();
            b.a.p0.j.z.e.b.b().e();
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
                b.a.p0.j.o.c.C();
                return;
            }
            SwanCoreVersion j0 = Z().j0();
            if (j0 != null && l0.f(j0.swanCoreVersionName) && b.a.p0.a.f1.e.a.a(Z().S())) {
                boolean z = w;
                b.a.p0.j.o.c.C();
            }
        }
    }

    @Override // b.a.p0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.a.p0.j.b.d.v();
            b.a.p0.a.r0.i.i();
            h.e("exit", Z());
            f.U().unregisterReceiver(this.f8364f);
            f.b0();
            b.a.p0.j.m0.a.a().b();
            SwanInspectorEndpoint.v().q();
            b.a.p0.j.g0.b.c().b();
            b.a.p0.j.z.e.b.b().e();
        }
    }

    @Override // b.a.p0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            b.a.p0.j.o.c.m().h(this.f8364f);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            f.U().registerReceiver(this.f8364f);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }
}
