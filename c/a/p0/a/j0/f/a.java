package c.a.p0.a.j0.f;

import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d1.h;
import c.a.p0.a.d2.m;
import c.a.p0.a.d2.n;
import c.a.p0.a.l0.c;
import c.a.p0.a.o1.c.e.a;
import c.a.p0.a.p2.l0;
import c.a.p0.a.p2.w;
import c.a.p0.a.p2.y0;
import c.a.p0.a.q0.d;
import c.a.p0.a.v0.e.b;
import c.a.p0.a.w0.g;
import c.a.p0.a.x.g.g;
import c.a.p0.a.x.m.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes.dex */
public class a extends c.a.p0.a.j0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.j0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0334a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5780e;

        public RunnableC0334a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5780e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.p0.a.p2.f.d(this.f5780e.f5767f)) {
                c.a.p0.a.w1.d.g();
                c.a.p0.a.w0.f.U().registerReceiver(this.f5780e.f5767f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.f1.r.a.g().y();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.x.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.x.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.f5767f != null && bool.booleanValue()) {
                this.a.f5767f.onBackPressed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.a.l0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f5767f == null) {
                return;
            }
            this.a.f5767f.moveTaskToBack(true);
            y0.b().e(1);
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
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
                    this.a.l1();
                    c.a.p0.a.t1.d.J().t();
                    return true;
                } else if (i2 == 127) {
                    int d2 = c.a.p0.a.a1.f.b.d();
                    int a = c.a.p0.a.a1.f.b.a(d2);
                    if (!c.a.p0.a.a1.f.b.f()) {
                        c.a.p0.a.a1.f.a.a(Integer.valueOf(d2), String.valueOf(a));
                    }
                    return true;
                } else if (i2 == 129) {
                    int p = c.a.p0.a.p2.c.m().p();
                    c.a.p0.a.u.d.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.f5767f != null && this.a.f5767f.isBackground() && p != -1 && this.a.f5767f.getTaskId() != p) {
                        c.a.p0.a.u.d.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        c.a.p0.a.t1.d.J().t();
                    }
                    return true;
                } else if (i2 == 102) {
                    boolean a2 = c.a.p0.a.s0.a.M().a();
                    c.a.p0.a.s0.a.M().d(a2);
                    if (this.a.f5767f != null) {
                        this.a.f5767f.onNightModeCoverChanged(a2, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L != null) {
                        L.d0().i();
                        c.a.p0.a.f1.r.a.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
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

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.f2.b.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1433121067, "Lc/a/p0/a/j0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1433121067, "Lc/a/p0/a/j0/f/a;");
                return;
            }
        }
        v = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SwanAppActivity swanAppActivity, String str) {
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
    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.F0(i2);
        }
    }

    @Override // c.a.p0.a.j0.c
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.p0.a.u.d.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = w.d(Z().n("_naExtParams"));
            if (v) {
                String str = "onNewIntent launchPage : " + p1;
            }
            String v1 = v1(p1);
            if (z) {
                c.a.p0.a.d2.e.w();
                h.e().l(z2);
                HybridUbcFlow p = c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                b.a Z = Z();
                if (z2) {
                    if (v) {
                        String str2 = "onRelaunch launchPage : " + v1;
                    }
                    c.a.p0.a.x.q.b.k().x(Z.H(), true);
                    m.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            c.a.p0.a.v1.f.o0.a.f("backtohome", "message", v1);
                        } else {
                            boolean i2 = c.a.p0.a.v1.f.o0.a.i(v1);
                            c.a.p0.a.d2.e.u(v1, Z);
                            c.a.p0.a.x.i.f.f(i2);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a = c.a.p0.a.v1.f.f0.d.b().a(c.a.p0.a.c1.b.e(v1, c.a.p0.a.w0.f.U().z()));
                            c.a.p0.a.v1.f.o0.a.f("backtohome", a ? "message" : "relaunch", v1);
                            if (i2 && !a) {
                                c.a.p0.a.v1.f.o0.a.q("reLaunch");
                                c.a.p0.a.k.f.a.d().i();
                                c.a.p0.a.o0.k.f.b.d("2");
                            } else {
                                c.a.p0.a.o0.k.f.b.d("3");
                            }
                        }
                    } else if (c.a.p0.a.e2.d.a()) {
                        c.a.p0.a.v1.f.o0.a.f("backtohome", "relaunch", c.a.p0.a.w0.f.U().g());
                    } else {
                        h.e().m();
                        h.e().l(false);
                        c.a.p0.a.x.i.f.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        c.a.p0.a.o0.k.f.b.d("3");
                        c.a.p0.a.d2.e.s(Z);
                        c.a.p0.a.d2.e.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        c.a.p0.a.c2.a.d().i("na_page_show");
                    }
                    c.a.p0.a.c2.a.d().i("frame_new_intent");
                    c.a.p0.a.t1.e r = c.a.p0.a.t1.d.J().r();
                    r.d0().j();
                    r.M().a();
                    boolean z3 = v;
                    r.P();
                    if (v) {
                        c.a.p0.a.x.q.b.k().w();
                    }
                    n.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    c.a.p0.a.r2.d.b.b("0");
                }
                u1();
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    @NonNull
    public a.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (a.c) invokeV.objValue;
    }

    @Override // c.a.p0.a.j0.c
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.a();
    }

    @Override // c.a.p0.a.t1.m, c.a.p0.a.t1.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.a.j0.c
    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.p0.a.u.d.i("SwanApp", "onBackPressed back stack count:" + this.f5768g.k());
            n1(i2);
            c.a.p0.a.x.g.d m = this.f5768g.m();
            if (m == null || !m.K()) {
                if (e0()) {
                    c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
                    if (L != null) {
                        L.O().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.p0.a.t1.e.f0());
                    c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.d(hashMap));
                    c.a.p0.a.u.d.i("SwanAppFrame", com.alipay.sdk.widget.d.n);
                    g.a().d(false);
                    return;
                }
                c.a.p0.a.d2.i.f(UUID.randomUUID().toString(), 1);
                c.a.p0.a.p2.g.a(c0(), this.f5767f);
                g.b i3 = this.f5768g.i("navigateBack");
                i3.n(c.a.p0.a.x.g.g.f8376i, c.a.p0.a.x.g.g.f8375h);
                i3.g();
                i3.a();
            }
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.b();
    }

    @Override // c.a.p0.a.j0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f5767f.setRequestedOrientation(1);
            c.a.p0.a.p2.f.a(this.f5767f);
            if (c.a.p0.a.x.a.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            c.a.p0.a.c2.a.d().a();
            c.a.p0.a.c2.a.d().i("frame_create");
            h.e().l(true);
            h.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(c.a.p0.a.v0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) {
            if (bVar != null && !c.a.p0.a.n1.a.a.B(bVar)) {
                if (bVar.G() != 0) {
                    boolean z = v;
                    return false;
                }
                SwanAppConfigData P = c.a.p0.a.t1.d.J().r().P();
                if (P == null) {
                    boolean z2 = v;
                    return false;
                } else if (!d.e.i(bVar.H(), bVar.v1()).exists()) {
                    boolean z3 = v;
                    return false;
                } else {
                    return !c.a.p0.a.v1.f.o0.g.q(bVar, P);
                }
            }
            boolean z4 = v;
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = i2 != 2 ? i2 != 3 ? "virtual" : "gesture" : "click";
            c.a.p0.a.d2.s.e eVar = new c.a.p0.a.d2.s.e();
            eVar.f4950e = com.alipay.sdk.widget.d.u;
            c.a.p0.a.x.g.g gVar = this.f5768g;
            boolean z = true;
            eVar.f4952g = (gVar == null || gVar.k() <= 1) ? false : false ? "1" : "0";
            eVar.f4947b = str;
            c.a.p0.a.d2.d.a(eVar, Z());
            c.a.p0.a.d2.d.c(eVar);
        }
    }

    @Override // c.a.p0.a.j0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.a.w1.d.j();
            c.a.p0.a.w1.d.h();
            h.e().o();
            c.a.p0.a.s0.a.a0().a();
            c.a.p0.a.w0.f.U().unregisterReceiver(this.f5767f);
        }
    }

    public final c.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (c.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.p0.a.v0.e.b.m1(Z(), c.a.p0.a.w0.f.U().s()) : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.j0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // c.a.p0.a.j0.c
    public boolean r0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (c.a.p0.a.l0.a.b().c()) {
                    c.a.p0.a.l0.a.b().f(this.f5767f, new c(this));
                    return true;
                }
                c.a.p0.a.x.g.g gVar = this.f5768g;
                if (gVar != null && gVar.k() == 1) {
                    c.a.p0.a.l0.b bVar = new c.a.p0.a.l0.b();
                    bVar.h();
                    if (bVar.j()) {
                        c.a.p0.a.l0.c.c().j(this.f5767f, bVar.f(), bVar.e(), bVar, o1());
                        return true;
                    }
                    h.e().g();
                }
            }
            return super.r0(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (c.a.p0.a.t1.d.J().r().x0()) {
                c.a.p0.a.u.d.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            c.a.p0.a.d2.e.z();
            if (D()) {
                t1();
                b.a Z = Z();
                if (m1(Z)) {
                    boolean z = v;
                    c.a.p0.a.w0.f.U().d(Z, null);
                    return;
                }
                boolean z2 = v;
                c.a.p0.a.w0.f.U().E(Z, null);
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (c.a.p0.a.x.u.g.U().W() != null) {
                c.a.p0.a.x.u.g.U().W().f(this.f5767f);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.p0.a.t1.d J = c.a.p0.a.t1.d.J();
            if (J.D()) {
                b.a X = J.r().X();
                String T = X.T();
                String U = X.U();
                if (TextUtils.isEmpty(X.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                c.a.p0.a.t1.g T2 = r().T();
                if (T2.b(X.T())) {
                    return !T2.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b.a Z = Z();
            boolean z = v;
            if (Z == null) {
                boolean z2 = v;
            } else if (l0.f(Z.a0())) {
                c.a.p0.a.x.u.g.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = c.a.p0.a.x.u.g.U().T();
                ExtensionCore O = Z.O();
                boolean z3 = false;
                boolean z4 = j0 != null && l0.f(j0.swanCoreVersionName) && c.a.p0.a.v0.e.a.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && c.a.p0.a.v0.e.a.b(Z.S())) {
                    z3 = true;
                }
                if (z4 || z3) {
                    boolean z5 = v;
                    c.a.p0.a.x.u.g.N0(true);
                }
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            c.a.p0.a.k1.k.i.c.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            b.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? c.a.p0.a.w0.f.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.j0.c
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0334a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            b.a Z = Z();
            if (v) {
                r0 = "updateInvalidSwanCore cur swanCore: " + Z.j0();
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                boolean z = v;
                Z.Z0(c.a.p0.a.g2.b.g(0));
                if (v) {
                    str = "updateInvalidSwanCore end. new swan core: " + Z.j0();
                }
            }
        }
    }

    @Override // c.a.p0.a.j0.c
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // c.a.p0.a.j0.c
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.p0.a.k1.h.o().F(new UbcFlowEvent("frame_start_end"));
            c.a.p0.a.c2.a.d().i("frame_start_end");
        }
    }
}
