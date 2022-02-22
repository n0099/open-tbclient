package c.a.s0.a.f2.f.o0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a1.d;
import c.a.s0.a.e0.h.a;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.n2.n;
import c.a.s0.a.z2.q0;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6304b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.e0.h.a f6305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.l.a f6306f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f6307g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6308h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.g f6309i;

        public a(c.a.s0.a.e0.h.a aVar, c.a.s0.a.h0.l.a aVar2, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6305e = aVar;
            this.f6306f = aVar2;
            this.f6307g = bVar;
            this.f6308h = bVar2;
            this.f6309i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f6305e.i();
                c.a.s0.a.e0.h.a.g(0);
                c.a(this.f6306f, this.f6307g, this.f6308h, this.f6309i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f6310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f6311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f6313e;

        public b(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar, SwanAppAlertDialog swanAppAlertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2, gVar, swanAppAlertDialog};
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
            this.f6310b = bVar;
            this.f6311c = bVar2;
            this.f6312d = gVar;
            this.f6313e = swanAppAlertDialog;
        }

        @Override // c.a.s0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.a, this.f6310b, this.f6311c, this.f6312d);
                this.f6313e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428334348, "Lc/a/s0/a/f2/f/o0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-428334348, "Lc/a/s0/a/f2/f/o0/c;");
                return;
            }
        }
        a = c.a.s0.a.k.a;
    }

    public static void a(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = c.a.s0.a.u1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
            SwanAppConfigData swanAppConfigData = gVar.f5384b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.getStackTraceString(new Exception("loadInfo.mConfigData is null."));
                    return;
                }
                return;
            }
            String d2 = d(U, bVar2, swanAppConfigData);
            String h2 = gVar.f5384b.h(d2);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.s0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f5384b, gVar, false);
                aVar.f(activity);
                bVar.f(activity);
                c.a.s0.a.h0.g.g V = U.V();
                if (V == null) {
                    return;
                }
                c.a.s0.a.m1.b e2 = c.a.s0.a.m1.b.e(d2, U.z());
                c.a.s0.a.h0.t.a.o(q0.a(e2.f7916g, e2.f7914e, e2.f7915f), bVar);
                g(V, d2);
                n.E();
                c.a.s0.a.n1.g.e(bVar.c());
                if (!TextUtils.isEmpty(h2)) {
                    c.a.s0.a.u1.h.l(h2);
                }
                n.F(true, bVar2.T());
                c.a.s0.a.a3.e loadingView = activity.getLoadingView();
                if (a) {
                    String str = "startFirstPage:: loadingView=" + loadingView;
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                c.a.s0.a.d2.d J = c.a.s0.a.d2.d.J();
                if (J.D() && TextUtils.equals(J.getAppId(), bVar2.H())) {
                    J.r().I(true);
                }
                c.a.s0.a.h0.i.f.f(true);
            } else if (a) {
                Log.getStackTraceString(new Exception("activity is invalid."));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.s0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.s0.a.e0.d.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    c.a.s0.a.e0.d.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    c.a.s0.a.b3.d.b.a().k();
                    c.a.s0.a.a3.e loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    c.a.s0.a.d2.d J = c.a.s0.a.d2.d.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    c.a.s0.a.h0.i.f.f(true);
                    return;
                }
            }
            c.a.s0.a.e0.d.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6304b : (String) invokeV.objValue;
    }

    public static String d(c.a.s0.a.g1.f fVar, c.a.s0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar, bVar, swanAppConfigData)) == null) {
            String b2 = fVar.b();
            if (TextUtils.isEmpty(b2)) {
                if (bVar.o0()) {
                    b2 = swanAppConfigData.g(bVar.h0());
                } else {
                    b2 = fVar.g();
                }
            }
            f6304b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        b.a V;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
            if (r == null || (V = r.V()) == null || (f0 = V.f0()) == null) {
                return null;
            }
            String str = f0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(c.a.s0.a.h0.g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gVar)) == null) ? gVar.k() >= 1 && (gVar.m() instanceof c.a.s0.a.h0.g.k) : invokeL.booleanValue;
    }

    public static void g(c.a.s0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, gVar, str) == null) || gVar == null) {
            return;
        }
        c.a.s0.a.h0.g.f.M3(null);
        c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
        g.b i2 = gVar.i("init");
        int i3 = c.a.s0.a.h0.g.g.f6643i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", c.a.s0.a.m1.b.e(str, U.z()), true).a();
    }

    public static void h(c.a.s0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, gVar, str) == null) {
            if (gVar == null) {
                c.a.s0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(gVar)) {
                c.a.s0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                c.a.s0.a.h0.g.f.M3(null);
                g.b i2 = gVar.i("init");
                int i3 = c.a.s0.a.h0.g.g.f6643i;
                i2.n(i3, i3);
                i2.f();
                i2.l("web_mode", c.a.s0.a.m1.b.e(str, str), true).a();
                c.a.s0.a.b3.b.c().o(gVar.m());
            }
        }
    }

    public static void i(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, aVar, bVar, bVar2, gVar) == null) {
            if (!c.a.s0.a.x1.a.a.H() && c.a.s0.a.e0.h.a.e() != 2) {
                if (c.a.s0.a.x1.a.a.D()) {
                    c.a.s0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            c.a.s0.a.e0.d.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            c.a.s0.a.e0.h.a aVar2 = new c.a.s0.a.e0.h.a(c.a.s0.a.c1.a.c());
            SwanAppAlertDialog.a aVar3 = new SwanAppAlertDialog.a(c.a.s0.a.d2.d.J().x());
            aVar3.U(c.a.s0.a.h.aiapps_debug_start_inspect);
            aVar3.v(c.a.s0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new c.a.s0.a.a3.h.a());
            aVar3.m(false);
            aVar3.O(c.a.s0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            SwanAppAlertDialog X = aVar3.X();
            HybridUbcFlow o = c.a.s0.a.u1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(c.a.s0.a.b3.c.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
