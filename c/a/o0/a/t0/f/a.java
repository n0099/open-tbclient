package c.a.o0.a.t0.f;

import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.g1.g;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.h0.i.i;
import c.a.o0.a.h0.m.h;
import c.a.o0.a.j2.j;
import c.a.o0.a.k;
import c.a.o0.a.v0.c;
import c.a.o0.a.v1.c.e.a;
import c.a.o0.a.v2.l0;
import c.a.o0.a.v2.w;
import c.a.o0.a.v2.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import java.util.HashMap;
import org.json.JSONObject;
@Autowired
/* loaded from: classes.dex */
public class a extends c.a.o0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.t0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0373a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8616e;

        public RunnableC0373a(a aVar) {
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
            this.f8616e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.o0.a.v2.f.d(this.f8616e.f8601f)) {
                c.a.o0.a.d2.d.g();
                c.a.o0.a.g1.f.V().E(this.f8616e.f8601f);
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
                c.a.o0.a.n1.q.a.g().y();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8617a;

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
            this.f8617a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.f8617a.f8601f != null && bool.booleanValue()) {
                this.f8617a.f8601f.onBackPressed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8618a;

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
            this.f8618a = aVar;
        }

        @Override // c.a.o0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8618a.f8601f == null) {
                return;
            }
            this.f8618a.f8601f.moveTaskToBack(true);
            x0.b().e(1);
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8619a;

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
            this.f8619a = aVar;
        }

        @Override // c.a.o0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    c.a.o0.a.v1.c.a.e().h(new c.a.o0.a.v1.c.c(4));
                    this.f8619a.G0();
                    this.f8619a.c1();
                    c.a.o0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 127) {
                    int c2 = c.a.o0.a.j1.e.b.c();
                    int a2 = c.a.o0.a.j1.e.b.a(c2);
                    if (!c.a.o0.a.j1.e.b.e()) {
                        c.a.o0.a.j1.e.a.a(Integer.valueOf(c2), String.valueOf(a2));
                    }
                    return true;
                } else if (i2 == 129) {
                    int p = c.a.o0.a.v2.c.m().p();
                    c.a.o0.a.e0.d.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.f8619a.f8601f != null && this.f8619a.f8601f.isBackground() && p != -1 && this.f8619a.f8601f.getTaskId() != p) {
                        c.a.o0.a.e0.d.g("SwanAppFrame", "resetCore: purgeSwanApp");
                        c.a.o0.a.a2.d.g().t();
                    }
                    return true;
                } else if (i2 == 102) {
                    boolean a3 = c.a.o0.a.c1.a.H().a();
                    c.a.o0.a.c1.a.H().d(a3);
                    if (this.f8619a.f8601f != null) {
                        this.f8619a.f8601f.onNightModeCoverChanged(a3, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    c.a.o0.a.a2.e i3 = c.a.o0.a.a2.e.i();
                    if (i3 != null) {
                        i3.T().i();
                        c.a.o0.a.n1.q.a.g().v();
                    }
                    this.f8619a.G0();
                    this.f8619a.b1();
                    return true;
                } else if (i2 == 106) {
                    c.a.o0.a.a2.d.g().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            c.a.o0.a.v2.c.r(message);
                            return true;
                        case 124:
                            c.a.o0.a.v2.c.q(message);
                            return true;
                        case 125:
                            c.a.o0.a.v1.c.d.a.b(message);
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
                c.a.o0.a.l2.b.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1277101568, "Lc/a/o0/a/t0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1277101568, "Lc/a/o0/a/t0/f/a;");
                return;
            }
        }
        v = k.f7049a;
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

    @Override // c.a.o0.a.t0.c
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this) : (a.c) invokeV.objValue;
    }

    @Override // c.a.o0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a0(1);
        }
    }

    @Override // c.a.o0.a.t0.c
    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.o0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f8602g.k());
            e1(i2);
            c.a.o0.a.h0.g.d m = this.f8602g.m();
            if (m == null || !m.J()) {
                if (T()) {
                    c.a.o0.a.a2.e i3 = c.a.o0.a.a2.e.i();
                    if (i3 != null) {
                        i3.E().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.o0.a.a2.e.V());
                    c.a.o0.a.g1.f.V().v(new c.a.o0.a.o0.d.c(hashMap));
                    c.a.o0.a.e0.d.g("SwanAppFrame", com.alipay.sdk.widget.d.f36018e);
                    g.a().d(false);
                    return;
                }
                c.a.o0.a.v2.g.a(R(), this.f8601f);
                g.b i4 = this.f8602g.i("navigateBack");
                i4.n(c.a.o0.a.h0.g.g.f5902i, c.a.o0.a.h0.g.g.f5901h);
                i4.g();
                i4.a();
            }
        }
    }

    @Override // c.a.o0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f8601f.setRequestedOrientation(1);
            c.a.o0.a.v2.f.a(this.f8601f);
            if (c.a.o0.a.h0.a.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            c.a.o0.a.i2.a.d().a();
            c.a.o0.a.i2.a.d().i("frame_create");
            c.a.o0.a.m1.g.f().n(true);
            c.a.o0.a.m1.g.f().p();
            n1();
            i1();
            V8Engine.setCrashKeyValue("app_title", O().K());
        }
    }

    public final void b1() {
        f h1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h1 = h1()) == null) {
            return;
        }
        h1.a();
    }

    public final void c1() {
        f h1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (h1 = h1()) == null) {
            return;
        }
        h1.b();
    }

    @Override // c.a.o0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.o0.a.d2.d.j();
            c.a.o0.a.d2.d.h();
            c.a.o0.a.m1.g.f().q();
            c.a.o0.a.c1.a.U().a();
            c.a.o0.a.g1.f.V().k(this.f8601f);
            c.a.o0.a.n2.h.b.n();
        }
    }

    public final boolean d1(c.a.o0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar != null && !c.a.o0.a.u1.a.a.A(bVar)) {
                if (bVar.G() != 0) {
                    boolean z = v;
                    return false;
                }
                SwanAppConfigData F = c.a.o0.a.a2.d.g().r().F();
                if (F == null) {
                    boolean z2 = v;
                    return false;
                } else if (!e.C0112e.i(bVar.H(), bVar.u1()).exists()) {
                    boolean z3 = v;
                    return false;
                } else {
                    return !c.a.o0.a.c2.f.p0.g.p(bVar, F);
                }
            }
            boolean z4 = v;
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void e1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            String str = i2 != 2 ? i2 != 3 ? "virtual" : "gesture" : PrefetchEvent.STATE_CLICK;
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7039e = com.alipay.sdk.widget.d.l;
            c.a.o0.a.h0.g.g gVar = this.f8602g;
            boolean z = true;
            eVar.f7041g = (gVar == null || gVar.k() <= 1) ? false : false ? "1" : "0";
            eVar.f7036b = str;
            c.a.o0.a.j2.d.a(eVar, O());
            c.a.o0.a.j2.d.c(eVar);
        }
    }

    @Override // c.a.o0.a.t0.c
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final c.b f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new d(this) : (c.b) invokeV.objValue;
    }

    @Override // c.a.o0.a.t0.c
    public boolean g0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (c.a.o0.a.v0.a.b().c()) {
                    c.a.o0.a.v0.a.b().f(this.f8601f, new c(this));
                    return true;
                }
                c.a.o0.a.h0.g.g gVar = this.f8602g;
                if (gVar != null && gVar.k() == 1) {
                    c.a.o0.a.v0.b bVar = new c.a.o0.a.v0.b();
                    bVar.h();
                    if (bVar.k()) {
                        c.a.o0.a.v0.c.c().j(this.f8601f, bVar.f(), bVar.e(), bVar, f1());
                        return true;
                    }
                    c.a.o0.a.m1.g.f().i();
                }
            }
            return super.g0(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.o0.a.f1.e.b.k1(O(), c.a.o0.a.g1.f.V().s()) : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.h0();
            if (c.a.o0.a.h0.u.g.N().P() != null) {
                c.a.o0.a.h0.u.g.N().P().f(this.f8601f);
            }
        }
    }

    @Inject(force = false)
    public final f h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.o0.a.j2.e.z();
            if (C()) {
                k1();
                b.a O = O();
                if (d1(O)) {
                    boolean z = v;
                    c.a.o0.a.g1.f.V().c(O, null);
                    return;
                }
                boolean z2 = v;
                c.a.o0.a.g1.f.V().G(O, null);
            }
        }
    }

    @Override // c.a.o0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.o0.a.a2.d g2 = c.a.o0.a.a2.d.g();
            if (g2.C()) {
                b.a N = g2.r().N();
                String T = N.T();
                String U = N.U();
                if (TextUtils.isEmpty(N.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                c.a.o0.a.a2.g J = r().J();
                if (J.b(N.T())) {
                    return !J.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b.a O = O();
            boolean z = v;
            if (O == null) {
                boolean z2 = v;
            } else if (l0.f(O.a0())) {
                c.a.o0.a.h0.u.g.A0(true);
            } else {
                SwanCoreVersion i0 = O.i0();
                ExtensionCore M = c.a.o0.a.h0.u.g.N().M();
                ExtensionCore O2 = O.O();
                boolean z3 = false;
                boolean z4 = i0 != null && l0.f(i0.swanCoreVersionName) && c.a.o0.a.f1.e.a.a(O.S());
                if (M != null && O2 != null && M.extensionCoreVersionCode < O2.extensionCoreVersionCode && c.a.o0.a.f1.e.a.b(O.S())) {
                    z3 = true;
                }
                if (z4 || z3) {
                    boolean z5 = v;
                    c.a.o0.a.h0.u.g.A0(true);
                }
            }
        }
    }

    @Override // c.a.o0.a.a2.m, c.a.o0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0373a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && j1()) {
            c.a.o0.a.r1.k.i.b.e().f(new b(this), "tryUpdateAsync");
        }
    }

    @Override // c.a.o0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public final String m1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            b.a O = O();
            return (TextUtils.isEmpty(str) && O != null && W(O.H())) ? c.a.o0.a.g1.f.V().f() : str;
        }
        return (String) invokeL.objValue;
    }

    public final void n1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a O = O();
            if (v) {
                r0 = "updateInvalidSwanCore cur swanCore: " + O.i0();
            }
            if (O.i0() == null || !O.i0().isAvailable()) {
                boolean z = v;
                O.X0(c.a.o0.a.m2.b.g(0));
                if (v) {
                    str = "updateInvalidSwanCore end. new swan core: " + O.i0();
                }
            }
        }
    }

    @Override // c.a.o0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.o0.a.r1.h.o().C(new UbcFlowEvent("frame_start_end"));
            c.a.o0.a.i2.a.d().i("frame_start_end");
        }
    }

    @Override // c.a.o0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // c.a.o0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // c.a.o0.a.t0.c
    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            super.u0(i2);
            c.a.o0.a.n2.h.b.m(i2);
        }
    }

    @Override // c.a.o0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.o0.a.e0.d.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String g1 = g1();
            JSONObject d2 = w.d(O().n("_naExtParams"));
            if (v) {
                String str = "onNewIntent launchPage : " + g1;
            }
            String m1 = m1(g1);
            if (z) {
                c.a.o0.a.j2.e.w();
                c.a.o0.a.m1.g.f().n(z2);
                HybridUbcFlow p = c.a.o0.a.r1.h.p("startup");
                b.a O = O();
                if (z2) {
                    if (v) {
                        String str2 = "onRelaunch launchPage : " + m1;
                    }
                    c.a.o0.a.h0.q.b.g().p(O.H(), true);
                    j.c(2);
                    c.a.o0.a.n2.h.b.o();
                    if (!TextUtils.isEmpty(m1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            c.a.o0.a.c2.f.p0.a.f("backtohome", "message", m1);
                        } else {
                            boolean i2 = c.a.o0.a.c2.f.p0.a.i(m1);
                            c.a.o0.a.j2.e.u(m1, O);
                            i.h(i2);
                            p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.B("type", "2");
                            boolean a2 = c.a.o0.a.c2.f.g0.d.b().a(c.a.o0.a.l1.b.g(m1, c.a.o0.a.g1.f.V().A()));
                            c.a.o0.a.c2.f.p0.a.f("backtohome", a2 ? "message" : "relaunch", m1);
                            if (i2 && !a2) {
                                c.a.o0.a.c2.f.p0.a.q("reLaunch");
                                c.a.o0.a.u.f.a.d().i();
                                if (c.a.o0.a.h0.n.a.a.c()) {
                                    c.a.o0.a.y0.k.f.b.d("0");
                                } else {
                                    c.a.o0.a.y0.k.f.b.e("2");
                                }
                            } else if (c.a.o0.a.h0.n.a.a.c()) {
                                c.a.o0.a.y0.k.f.b.d("0");
                            } else {
                                c.a.o0.a.y0.k.f.b.e("3");
                            }
                        }
                    } else if (c.a.o0.a.k2.d.a()) {
                        c.a.o0.a.c2.f.p0.a.f("backtohome", "relaunch", c.a.o0.a.g1.f.V().f());
                    } else {
                        c.a.o0.a.m1.g.f().o();
                        c.a.o0.a.m1.g.f().n(false);
                        i.h(false);
                        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.B("type", "3");
                        if (c.a.o0.a.h0.n.a.a.c()) {
                            c.a.o0.a.y0.k.f.b.d("0");
                        } else {
                            c.a.o0.a.y0.k.f.b.e("3");
                        }
                        c.a.o0.a.j2.e.s(O);
                        c.a.o0.a.j2.e.p(O);
                    }
                    if (P().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.C(ubcFlowEvent);
                        c.a.o0.a.i2.a.d().i("na_page_show");
                    }
                    c.a.o0.a.i2.a.d().i("frame_new_intent");
                    c.a.o0.a.a2.e r = c.a.o0.a.a2.d.g().r();
                    r.T().j();
                    r.j().a();
                    boolean z3 = v;
                    r.F();
                    if (v) {
                        c.a.o0.a.h0.q.b.g().o();
                    }
                    c.a.o0.a.j2.k.A();
                } else {
                    p.F(HybridUbcFlow.SubmitStrategy.HYBRID);
                }
                l1();
            }
        }
    }
}
