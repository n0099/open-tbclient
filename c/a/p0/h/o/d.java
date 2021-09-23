package c.a.p0.h.o;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.m.h;
import c.a.p0.a.k;
import c.a.p0.a.r0.i;
import c.a.p0.a.v1.c.e.a;
import c.a.p0.a.v2.l0;
import c.a.p0.a.v2.q0;
import c.a.p0.h.s.a;
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
/* loaded from: classes3.dex */
public class d extends c.a.p0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public long v;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11398a;

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
            this.f11398a = dVar;
        }

        @Override // c.a.p0.a.a1.b
        public void a(int i2, c.a.p0.a.a1.a aVar) {
            a.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || (cVar = (a.c) aVar) == null || TextUtils.isEmpty(cVar.f11548a)) {
                return;
            }
            c.a.p0.h.o.c.m().I(this.f11398a.O());
            c.a.p0.h.o.c.m().x(cVar);
            c.a.p0.h.c.j.b.h();
            this.f11398a.Z0();
            this.f11398a.Y0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f11399a;

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
            this.f11399a = dVar;
        }

        @Override // c.a.p0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    c.a.p0.a.v1.c.a.e().h(new c.a.p0.a.v1.c.c(4));
                    this.f11399a.G0();
                    c.a.p0.h.o.c.m().H();
                    c.a.p0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 102) {
                    boolean a2 = c.a.p0.a.c1.a.H().a();
                    c.a.p0.a.c1.a.H().d(a2);
                    if (this.f11399a.f8637f != null) {
                        this.f11399a.f8637f.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    c.a.p0.a.a2.e i3 = c.a.p0.a.a2.e.i();
                    if (i3 != null) {
                        i3.T().i();
                        c.a.p0.a.n1.q.a.g().v();
                    }
                    this.f11399a.G0();
                    c.a.p0.h.o.c.m().H();
                    return true;
                } else if (i2 == 106) {
                    c.a.p0.a.a2.d.g().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            c.a.p0.a.v2.c.r(message);
                            return true;
                        case 124:
                            c.a.p0.a.v2.c.q(message);
                            return true;
                        case 125:
                            c.a.p0.a.v1.c.d.a.b(message);
                            return true;
                        case 126:
                            c.a.p0.a.v1.c.d.a.d(message);
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f11400e;

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
            this.f11400e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.w;
                this.f11400e.v = System.currentTimeMillis();
                c.a.p0.h.f0.h.f(this.f11400e.O());
                this.f11400e.f8637f.finishLoadingAnimator();
                c.a.p0.a.r1.h.h("preload", "startup");
                int j2 = c.a.p0.h.o.c.m().j();
                HybridUbcFlow p = c.a.p0.a.r1.h.p("startup");
                p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.A("codecache", String.valueOf(j2));
                p.C(new UbcFlowEvent("na_first_paint"));
                p.x();
                long e2 = p.e("na_first_paint", "naStart");
                c.a.p0.h.o.c.m().i(new c.a.p0.h.w.b(e2));
                if (d.w) {
                    String str = "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + e2;
                }
                c.a.p0.h.m0.d.A().D();
                c.a.p0.h.t.a.f().init();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158440505, "Lc/a/p0/h/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158440505, "Lc/a/p0/h/o/d;");
                return;
            }
        }
        w = k.f7085a;
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

    @Override // c.a.p0.a.t0.c
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (a.c) invokeV.objValue;
    }

    @Override // c.a.p0.a.t0.c
    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.a.a2.d.g().r().N().d0() == 1 : invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c1();
            if (c.a.p0.a.a2.d.g().C()) {
                f.V().G(O(), new a(this));
                if (c.a.p0.h.o.c.m().v() && c.a.p0.h.o.c.m().q()) {
                    c.a.p0.h.o.c.m().F(this.f8637f);
                }
            }
        }
    }

    public long W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.longValue;
    }

    public c.a.p0.a.l0.a X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.p0.h.o.c.m().n() : (c.a.p0.a.l0.a) invokeV.objValue;
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.h.m0.d.A().m();
        }
    }

    @Override // c.a.p0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f8638g.k());
            c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
            fVar.f7075e = com.alipay.sdk.widget.d.u;
            F(fVar);
            c.a.p0.a.h0.g.d m = this.f8638g.m();
            if (m == null || !m.J()) {
                if (T()) {
                    c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
                    if (i2 != null) {
                        i2.E().E();
                    }
                    c.a.p0.h.f0.h.e(com.alipay.sdk.widget.d.u, O());
                    return;
                }
                g.b i3 = this.f8638g.i("navigateBack");
                i3.n(g.f5938i, g.f5937h);
                i3.g();
                i3.a();
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.h.m0.d.A().F();
        }
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d1();
            c.a.p0.h.f0.b.c().b();
            c.a.p0.h.y.e.b.b().e();
            r().f(true);
            V0();
            V8Engine.setCrashKeyValue("game_title", O() == null ? "" : O().K());
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            q0.b0(new c(this));
            c.a.p0.h.m0.f.j();
            c.a.p0.h.m0.e.b();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.v = 0L;
        }
    }

    @Override // c.a.p0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.p0.h.b.d.w();
            i.i();
            c.a.p0.h.f0.h.e("exit", O());
            f.V().k(this.f8637f);
            f.c0();
            c.a.p0.h.l0.a.a().b();
            SwanInspectorEndpoint.v().q();
            c.a.p0.h.f0.b.c().b();
            c.a.p0.h.y.e.b.b().e();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && r().e()) {
            if (l0.f(O().a0())) {
                if (w) {
                    String str = "release SwanGameCoreRuntime minSwanVersion:" + O().a0();
                }
                c.a.p0.h.o.c.C();
                return;
            }
            SwanCoreVersion i0 = O().i0();
            if (i0 != null && l0.f(i0.swanCoreVersionName) && c.a.p0.a.f1.e.a.a(O().S())) {
                boolean z = w;
                c.a.p0.h.o.c.C();
            }
        }
    }

    @Override // c.a.p0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.h0();
            c.a.p0.h.o.c.m().h(this.f8637f);
        }
    }

    @Override // c.a.p0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // c.a.p0.a.a2.m, c.a.p0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            f.V().E(this.f8637f);
        }
    }

    @Override // c.a.p0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // c.a.p0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // c.a.p0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // c.a.p0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // c.a.p0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            c.a.p0.a.j2.k.A();
            if (z2) {
                c.a.p0.h.f0.h.f(O());
            }
        }
    }
}
