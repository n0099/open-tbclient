package c.a.r0.a.f2.f.o0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.e0.h.a;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.q0;
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
    public static String f6062b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.e0.h.a f6063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f6064f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f6065g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f6066h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.g f6067i;

        public a(c.a.r0.a.e0.h.a aVar, c.a.r0.a.h0.l.a aVar2, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f6063e = aVar;
            this.f6064f = aVar2;
            this.f6065g = bVar;
            this.f6066h = bVar2;
            this.f6067i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f6063e.i();
                c.a.r0.a.e0.h.a.g(0);
                c.a(this.f6064f, this.f6065g, this.f6066h, this.f6067i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f6068b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f6069c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6070d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f6071e;

        public b(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar, SwanAppAlertDialog swanAppAlertDialog) {
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
            this.f6068b = bVar;
            this.f6069c = bVar2;
            this.f6070d = gVar;
            this.f6071e = swanAppAlertDialog;
        }

        @Override // c.a.r0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.a, this.f6068b, this.f6069c, this.f6070d);
                this.f6071e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1935886157, "Lc/a/r0/a/f2/f/o0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1935886157, "Lc/a/r0/a/f2/f/o0/c;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
    }

    public static void a(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = c.a.r0.a.u1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
            SwanAppConfigData swanAppConfigData = gVar.f5142b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.getStackTraceString(new Exception("loadInfo.mConfigData is null."));
                    return;
                }
                return;
            }
            String d2 = d(U, bVar2, swanAppConfigData);
            String h2 = gVar.f5142b.h(d2);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.r0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f5142b, gVar, false);
                aVar.f(activity);
                bVar.f(activity);
                c.a.r0.a.h0.g.g V = U.V();
                if (V == null) {
                    return;
                }
                c.a.r0.a.m1.b e2 = c.a.r0.a.m1.b.e(d2, U.z());
                c.a.r0.a.h0.t.a.o(q0.a(e2.f7674g, e2.f7672e, e2.f7673f), bVar);
                g(V, d2);
                n.E();
                c.a.r0.a.n1.g.e(bVar.c());
                if (!TextUtils.isEmpty(h2)) {
                    c.a.r0.a.u1.h.l(h2);
                }
                n.F(true, bVar2.T());
                c.a.r0.a.a3.e loadingView = activity.getLoadingView();
                if (a) {
                    String str = "startFirstPage:: loadingView=" + loadingView;
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                c.a.r0.a.d2.d J = c.a.r0.a.d2.d.J();
                if (J.D() && TextUtils.equals(J.getAppId(), bVar2.H())) {
                    J.r().I(true);
                }
                c.a.r0.a.h0.i.f.f(true);
            } else if (a) {
                Log.getStackTraceString(new Exception("activity is invalid."));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.r0.a.h0.g.g V = U.V();
                if (V == null) {
                    c.a.r0.a.e0.d.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    c.a.r0.a.e0.d.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    c.a.r0.a.b3.d.b.a().k();
                    c.a.r0.a.a3.e loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    c.a.r0.a.d2.d J = c.a.r0.a.d2.d.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    c.a.r0.a.h0.i.f.f(true);
                    return;
                }
            }
            c.a.r0.a.e0.d.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6062b : (String) invokeV.objValue;
    }

    public static String d(c.a.r0.a.g1.f fVar, c.a.r0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
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
            f6062b = b2;
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
            c.a.r0.a.d2.e r = c.a.r0.a.d2.d.J().r();
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

    public static boolean f(c.a.r0.a.h0.g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gVar)) == null) ? gVar.k() >= 1 && (gVar.m() instanceof c.a.r0.a.h0.g.k) : invokeL.booleanValue;
    }

    public static void g(c.a.r0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, gVar, str) == null) || gVar == null) {
            return;
        }
        c.a.r0.a.h0.g.f.M3(null);
        c.a.r0.a.g1.f U = c.a.r0.a.g1.f.U();
        g.b i2 = gVar.i("init");
        int i3 = c.a.r0.a.h0.g.g.f6401i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", c.a.r0.a.m1.b.e(str, U.z()), true).a();
    }

    public static void h(c.a.r0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, gVar, str) == null) {
            if (gVar == null) {
                c.a.r0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(gVar)) {
                c.a.r0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                c.a.r0.a.h0.g.f.M3(null);
                g.b i2 = gVar.i("init");
                int i3 = c.a.r0.a.h0.g.g.f6401i;
                i2.n(i3, i3);
                i2.f();
                i2.l("web_mode", c.a.r0.a.m1.b.e(str, str), true).a();
                c.a.r0.a.b3.b.c().o(gVar.m());
            }
        }
    }

    public static void i(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, aVar, bVar, bVar2, gVar) == null) {
            if (!c.a.r0.a.x1.a.a.H() && c.a.r0.a.e0.h.a.e() != 2) {
                if (c.a.r0.a.x1.a.a.D()) {
                    c.a.r0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            c.a.r0.a.e0.d.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            c.a.r0.a.e0.h.a aVar2 = new c.a.r0.a.e0.h.a(c.a.r0.a.c1.a.c());
            SwanAppAlertDialog.a aVar3 = new SwanAppAlertDialog.a(c.a.r0.a.d2.d.J().x());
            aVar3.U(c.a.r0.a.h.aiapps_debug_start_inspect);
            aVar3.v(c.a.r0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new c.a.r0.a.a3.h.a());
            aVar3.m(false);
            aVar3.O(c.a.r0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            SwanAppAlertDialog X = aVar3.X();
            HybridUbcFlow o = c.a.r0.a.u1.h.o();
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
            b(c.a.r0.a.b3.c.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
