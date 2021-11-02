package b.a.p0.a.t0.f;

import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g1.g;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.i.i;
import b.a.p0.a.h0.m.h;
import b.a.p0.a.j2.j;
import b.a.p0.a.k;
import b.a.p0.a.v0.c;
import b.a.p0.a.v1.c.e.a;
import b.a.p0.a.v2.l0;
import b.a.p0.a.v2.w;
import b.a.p0.a.v2.x0;
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
public class a extends b.a.p0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.t0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0370a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7919e;

        public RunnableC0370a(a aVar) {
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
            this.f7919e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && b.a.p0.a.v2.f.d(this.f7919e.f7905f)) {
                b.a.p0.a.d2.d.g();
                b.a.p0.a.g1.f.T().registerReceiver(this.f7919e.f7905f);
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
                b.a.p0.a.n1.q.a.g().y();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7920a;

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
            this.f7920a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.f7920a.f7905f != null && bool.booleanValue()) {
                this.f7920a.f7905f.onBackPressed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7921a;

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
            this.f7921a = aVar;
        }

        @Override // b.a.p0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7921a.f7905f == null) {
                return;
            }
            this.f7921a.f7905f.moveTaskToBack(true);
            x0.b().e(1);
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7922a;

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
            this.f7922a = aVar;
        }

        @Override // b.a.p0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(4));
                    this.f7922a.G0();
                    this.f7922a.b1();
                    b.a.p0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 127) {
                    int c2 = b.a.p0.a.j1.e.b.c();
                    int a2 = b.a.p0.a.j1.e.b.a(c2);
                    if (!b.a.p0.a.j1.e.b.e()) {
                        b.a.p0.a.j1.e.a.a(Integer.valueOf(c2), String.valueOf(a2));
                    }
                    return true;
                } else if (i2 == 129) {
                    int p = b.a.p0.a.v2.c.m().p();
                    b.a.p0.a.e0.d.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.f7922a.f7905f != null && this.f7922a.f7905f.isBackground() && p != -1 && this.f7922a.f7905f.getTaskId() != p) {
                        b.a.p0.a.e0.d.g("SwanAppFrame", "resetCore: purgeSwanApp");
                        b.a.p0.a.a2.d.g().t();
                    }
                    return true;
                } else if (i2 == 102) {
                    boolean a3 = b.a.p0.a.c1.a.H().a();
                    b.a.p0.a.c1.a.H().d(a3);
                    if (this.f7922a.f7905f != null) {
                        this.f7922a.f7905f.onNightModeCoverChanged(a3, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    b.a.p0.a.a2.e i3 = b.a.p0.a.a2.e.i();
                    if (i3 != null) {
                        i3.S().i();
                        b.a.p0.a.n1.q.a.g().v();
                    }
                    this.f7922a.G0();
                    this.f7922a.a1();
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
                b.a.p0.a.l2.b.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-637484672, "Lb/a/p0/a/t0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-637484672, "Lb/a/p0/a/t0/f/a;");
                return;
            }
        }
        v = k.f6397a;
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

    @Override // b.a.p0.a.t0.c
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this) : (a.c) invokeV.objValue;
    }

    @Override // b.a.p0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a0(1);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.p0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f7906g.k());
            d1(i2);
            b.a.p0.a.h0.g.d m = this.f7906g.m();
            if (m == null || !m.I()) {
                if (T()) {
                    b.a.p0.a.a2.e i3 = b.a.p0.a.a2.e.i();
                    if (i3 != null) {
                        i3.D().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, b.a.p0.a.a2.e.U());
                    b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.c(hashMap));
                    b.a.p0.a.e0.d.g("SwanAppFrame", com.alipay.sdk.widget.d.n);
                    g.a().d(false);
                    return;
                }
                b.a.p0.a.v2.g.a(R(), this.f7905f);
                g.b i4 = this.f7906g.i("navigateBack");
                i4.n(b.a.p0.a.h0.g.g.f5282i, b.a.p0.a.h0.g.g.f5281h);
                i4.g();
                i4.a();
            }
        }
    }

    public final void a1() {
        f g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (g1 = g1()) == null) {
            return;
        }
        g1.a();
    }

    @Override // b.a.p0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f7905f.setRequestedOrientation(1);
            b.a.p0.a.v2.f.a(this.f7905f);
            if (b.a.p0.a.h0.a.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            b.a.p0.a.i2.a.d().a();
            b.a.p0.a.i2.a.d().i("frame_create");
            b.a.p0.a.m1.g.f().n(true);
            b.a.p0.a.m1.g.f().p();
            m1();
            h1();
            V8Engine.setCrashKeyValue("app_title", O().J());
        }
    }

    public final void b1() {
        f g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (g1 = g1()) == null) {
            return;
        }
        g1.b();
    }

    public final boolean c1(b.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (bVar != null && !b.a.p0.a.u1.a.a.A(bVar)) {
                if (bVar.F() != 0) {
                    boolean z = v;
                    return false;
                }
                SwanAppConfigData E = b.a.p0.a.a2.d.g().r().E();
                if (E == null) {
                    boolean z2 = v;
                    return false;
                } else if (!e.C0109e.i(bVar.G(), bVar.s1()).exists()) {
                    boolean z3 = v;
                    return false;
                } else {
                    return !b.a.p0.a.c2.f.p0.g.p(bVar, E);
                }
            }
            boolean z4 = v;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.d2.d.j();
            b.a.p0.a.d2.d.h();
            b.a.p0.a.m1.g.f().q();
            b.a.p0.a.c1.a.U().a();
            b.a.p0.a.g1.f.T().unregisterReceiver(this.f7905f);
            b.a.p0.a.n2.h.b.n();
        }
    }

    public final void d1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            String str = i2 != 2 ? i2 != 3 ? "virtual" : "gesture" : PrefetchEvent.STATE_CLICK;
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6387e = com.alipay.sdk.widget.d.u;
            b.a.p0.a.h0.g.g gVar = this.f7906g;
            boolean z = true;
            eVar.f6389g = (gVar == null || gVar.k() <= 1) ? false : false ? "1" : "0";
            eVar.f6384b = str;
            b.a.p0.a.j2.d.a(eVar, O());
            b.a.p0.a.j2.d.c(eVar);
        }
    }

    public final c.b e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new d(this) : (c.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.t0.c
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final String f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? b.a.p0.a.f1.e.b.j1(O(), b.a.p0.a.g1.f.T().r()) : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.t0.c
    public boolean g0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (b.a.p0.a.v0.a.b().c()) {
                    b.a.p0.a.v0.a.b().f(this.f7905f, new c(this));
                    return true;
                }
                b.a.p0.a.h0.g.g gVar = this.f7906g;
                if (gVar != null && gVar.k() == 1) {
                    b.a.p0.a.v0.b bVar = new b.a.p0.a.v0.b();
                    bVar.h();
                    if (bVar.k()) {
                        b.a.p0.a.v0.c.c().j(this.f7905f, bVar.f(), bVar.e(), bVar, e1());
                        return true;
                    }
                    b.a.p0.a.m1.g.f().i();
                }
            }
            return super.g0(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Inject(force = false)
    public final f g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // b.a.p0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.h0();
            if (b.a.p0.a.h0.u.g.M().O() != null) {
                b.a.p0.a.h0.u.g.M().O().e(this.f7905f);
            }
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b.a.p0.a.j2.e.z();
            if (C()) {
                j1();
                b.a O = O();
                if (c1(O)) {
                    boolean z = v;
                    b.a.p0.a.g1.f.T().c(O, null);
                    return;
                }
                boolean z2 = v;
                b.a.p0.a.g1.f.T().E(O, null);
            }
        }
    }

    public final boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            if (g2.C()) {
                b.a M = g2.r().M();
                String S = M.S();
                String T = M.T();
                if (TextUtils.isEmpty(M.S()) || TextUtils.equals(S, T)) {
                    return false;
                }
                b.a.p0.a.a2.g I = r().I();
                if (I.b(M.S())) {
                    return !I.c(S, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b.a O = O();
            boolean z = v;
            if (O == null) {
                boolean z2 = v;
            } else if (l0.f(O.Z())) {
                b.a.p0.a.h0.u.g.z0(true);
            } else {
                SwanCoreVersion h0 = O.h0();
                ExtensionCore L = b.a.p0.a.h0.u.g.M().L();
                ExtensionCore N = O.N();
                boolean z3 = false;
                boolean z4 = h0 != null && l0.f(h0.swanCoreVersionName) && b.a.p0.a.f1.e.a.a(O.R());
                if (L != null && N != null && L.extensionCoreVersionCode < N.extensionCoreVersionCode && b.a.p0.a.f1.e.a.b(O.R())) {
                    z3 = true;
                }
                if (z4 || z3) {
                    boolean z5 = v;
                    b.a.p0.a.h0.u.g.z0(true);
                }
            }
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && i1()) {
            b.a.p0.a.r1.k.i.b.e().f(new b(this), "tryUpdateAsync");
        }
    }

    @Override // b.a.p0.a.a2.m, b.a.p0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0370a(this), "registerScreenshotEvent", 2);
        }
    }

    public final String l1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            b.a O = O();
            return (TextUtils.isEmpty(str) && O != null && W(O.G())) ? b.a.p0.a.g1.f.T().f() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void m1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a O = O();
            if (v) {
                r0 = "updateInvalidSwanCore cur swanCore: " + O.h0();
            }
            if (O.h0() == null || !O.h0().isAvailable()) {
                boolean z = v;
                O.W0(b.a.p0.a.m2.b.g(0));
                if (v) {
                    str = "updateInvalidSwanCore end. new swan core: " + O.h0();
                }
            }
        }
    }

    @Override // b.a.p0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            b.a.p0.a.r1.h.o().C(new UbcFlowEvent("frame_start_end"));
            b.a.p0.a.i2.a.d().i("frame_start_end");
        }
    }

    @Override // b.a.p0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // b.a.p0.a.t0.c
    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            super.u0(i2);
            b.a.p0.a.n2.h.b.m(i2);
        }
    }

    @Override // b.a.p0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.p0.a.e0.d.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String f1 = f1();
            JSONObject d2 = w.d(O().n("_naExtParams"));
            if (v) {
                String str = "onNewIntent launchPage : " + f1;
            }
            String l1 = l1(f1);
            if (z) {
                b.a.p0.a.j2.e.w();
                b.a.p0.a.m1.g.f().n(z2);
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                b.a O = O();
                if (z2) {
                    if (v) {
                        String str2 = "onRelaunch launchPage : " + l1;
                    }
                    b.a.p0.a.h0.q.b.g().p(O.G(), true);
                    j.c(2);
                    b.a.p0.a.n2.h.b.o();
                    if (!TextUtils.isEmpty(l1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            b.a.p0.a.c2.f.p0.a.f("backtohome", "message", l1);
                        } else {
                            boolean i2 = b.a.p0.a.c2.f.p0.a.i(l1);
                            b.a.p0.a.j2.e.u(l1, O);
                            i.h(i2);
                            p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.B("type", "2");
                            boolean a2 = b.a.p0.a.c2.f.g0.d.b().a(b.a.p0.a.l1.b.e(l1, b.a.p0.a.g1.f.T().z()));
                            b.a.p0.a.c2.f.p0.a.f("backtohome", a2 ? "message" : "relaunch", l1);
                            if (i2 && !a2) {
                                b.a.p0.a.c2.f.p0.a.q("reLaunch");
                                b.a.p0.a.u.f.a.d().i();
                                if (b.a.p0.a.h0.n.a.a.c()) {
                                    b.a.p0.a.y0.k.f.b.d("0");
                                } else {
                                    b.a.p0.a.y0.k.f.b.e("2");
                                }
                            } else if (b.a.p0.a.h0.n.a.a.c()) {
                                b.a.p0.a.y0.k.f.b.d("0");
                            } else {
                                b.a.p0.a.y0.k.f.b.e("3");
                            }
                        }
                    } else if (b.a.p0.a.k2.d.a()) {
                        b.a.p0.a.c2.f.p0.a.f("backtohome", "relaunch", b.a.p0.a.g1.f.T().f());
                    } else {
                        b.a.p0.a.m1.g.f().o();
                        b.a.p0.a.m1.g.f().n(false);
                        i.h(false);
                        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.B("type", "3");
                        if (b.a.p0.a.h0.n.a.a.c()) {
                            b.a.p0.a.y0.k.f.b.d("0");
                        } else {
                            b.a.p0.a.y0.k.f.b.e("3");
                        }
                        b.a.p0.a.j2.e.s(O);
                        b.a.p0.a.j2.e.p(O);
                    }
                    if (P().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.C(ubcFlowEvent);
                        b.a.p0.a.i2.a.d().i("na_page_show");
                    }
                    b.a.p0.a.i2.a.d().i("frame_new_intent");
                    b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
                    r.S().j();
                    r.j().a();
                    boolean z3 = v;
                    r.E();
                    if (v) {
                        b.a.p0.a.h0.q.b.g().o();
                    }
                    b.a.p0.a.j2.k.A();
                } else {
                    p.F(HybridUbcFlow.SubmitStrategy.HYBRID);
                }
                k1();
            }
        }
    }
}
