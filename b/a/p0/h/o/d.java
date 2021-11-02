package b.a.p0.h.o;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.m.h;
import b.a.p0.a.k;
import b.a.p0.a.r0.i;
import b.a.p0.a.v1.c.e.a;
import b.a.p0.a.v2.l0;
import b.a.p0.a.v2.q0;
import b.a.p0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
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
        public final /* synthetic */ d f10591a;

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
            this.f10591a = dVar;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            a.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || (cVar = (a.c) aVar) == null || TextUtils.isEmpty(cVar.f10740a)) {
                return;
            }
            b.a.p0.h.o.c.m().I(this.f10591a.O());
            b.a.p0.h.o.c.m().x(cVar);
            b.a.p0.h.c.j.b.h();
            this.f10591a.Y0();
            this.f10591a.X0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10592a;

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
            this.f10592a = dVar;
        }

        @Override // b.a.p0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(4));
                    this.f10592a.G0();
                    b.a.p0.h.o.c.m().H();
                    b.a.p0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 102) {
                    boolean a2 = b.a.p0.a.c1.a.H().a();
                    b.a.p0.a.c1.a.H().d(a2);
                    if (this.f10592a.f7905f != null) {
                        this.f10592a.f7905f.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    b.a.p0.a.a2.e i3 = b.a.p0.a.a2.e.i();
                    if (i3 != null) {
                        i3.S().i();
                        b.a.p0.a.n1.q.a.g().v();
                    }
                    this.f10592a.G0();
                    b.a.p0.h.o.c.m().H();
                    return true;
                } else if (i2 == 106) {
                    b.a.p0.a.a2.d.g().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            b.a.p0.a.v2.c.r(message);
                            return true;
                        case 124:
                            b.a.p0.a.v2.c.q(message);
                            return true;
                        case 125:
                            b.a.p0.a.v1.c.d.a.b(message);
                            return true;
                        case 126:
                            b.a.p0.a.v1.c.d.a.d(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    h.a(message);
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
        public final /* synthetic */ d f10593e;

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
            this.f10593e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.w;
                this.f10593e.v = System.currentTimeMillis();
                b.a.p0.h.f0.h.f(this.f10593e.O());
                this.f10593e.f7905f.finishLoadingAnimator();
                b.a.p0.a.r1.h.h("preload", "startup");
                int j = b.a.p0.h.o.c.m().j();
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.A("codecache", String.valueOf(j));
                p.C(new UbcFlowEvent("na_first_paint"));
                p.x();
                long e2 = p.e("na_first_paint", "naStart");
                b.a.p0.h.o.c.m().i(new b.a.p0.h.w.b(e2));
                if (d.w) {
                    String str = "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2;
                }
                b.a.p0.h.m0.d.A().D();
                b.a.p0.h.t.a.f().init();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865037498, "Lb/a/p0/h/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865037498, "Lb/a/p0/h/o/d;");
                return;
            }
        }
        w = k.f6397a;
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
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (a.c) invokeV.objValue;
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b1();
            if (b.a.p0.a.a2.d.g().C()) {
                f.T().E(O(), new a(this));
                if (b.a.p0.h.o.c.m().v() && b.a.p0.h.o.c.m().q()) {
                    b.a.p0.h.o.c.m().F(this.f7905f);
                }
            }
        }
    }

    @Override // b.a.p0.a.t0.c
    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.a2.d.g().r().M().c0() == 1 : invokeV.booleanValue;
    }

    public long V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.longValue;
    }

    public b.a.p0.a.l0.a W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.h.o.c.m().n() : (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.p0.h.m0.d.A().m();
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.h.m0.d.A().F();
        }
    }

    @Override // b.a.p0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f7906g.k());
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = com.alipay.sdk.widget.d.u;
            F(fVar);
            b.a.p0.a.h0.g.d m = this.f7906g.m();
            if (m == null || !m.I()) {
                if (T()) {
                    b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                    if (i2 != null) {
                        i2.D().E();
                    }
                    b.a.p0.h.f0.h.e(com.alipay.sdk.widget.d.u, O());
                    return;
                }
                g.b i3 = this.f7906g.i("navigateBack");
                i3.n(g.f5282i, g.f5281h);
                i3.g();
                i3.a();
            }
        }
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q0.b0(new c(this));
            b.a.p0.h.m0.f.j();
            b.a.p0.h.m0.e.b();
        }
    }

    @Override // b.a.p0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c1();
            b.a.p0.h.f0.b.c().b();
            b.a.p0.h.y.e.b.b().e();
            r().f(true);
            U0();
            V8Engine.setCrashKeyValue("game_title", O() == null ? "" : O().J());
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.v = 0L;
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && r().e()) {
            if (l0.f(O().Z())) {
                if (w) {
                    String str = "release SwanGameCoreRuntime minSwanVersion:" + O().Z();
                }
                b.a.p0.h.o.c.C();
                return;
            }
            SwanCoreVersion h0 = O().h0();
            if (h0 != null && l0.f(h0.swanCoreVersionName) && b.a.p0.a.f1.e.a.a(O().R())) {
                boolean z = w;
                b.a.p0.h.o.c.C();
            }
        }
    }

    @Override // b.a.p0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.p0.h.b.d.v();
            i.i();
            b.a.p0.h.f0.h.e("exit", O());
            f.T().unregisterReceiver(this.f7905f);
            f.a0();
            b.a.p0.h.l0.a.a().b();
            SwanInspectorEndpoint.v().q();
            b.a.p0.h.f0.b.c().b();
            b.a.p0.h.y.e.b.b().e();
        }
    }

    @Override // b.a.p0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.h0();
            b.a.p0.h.o.c.m().h(this.f7905f);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            f.T().registerReceiver(this.f7905f);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            b.a.p0.a.j2.k.A();
            if (z2) {
                b.a.p0.h.f0.h.f(O());
            }
        }
    }
}
