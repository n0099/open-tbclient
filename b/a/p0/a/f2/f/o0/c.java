package b.a.p0.a.f2.f.o0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.e0.h.a;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5077a;

    /* renamed from: b  reason: collision with root package name */
    public static String f5078b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e0.h.a f5079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f5080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f5081g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5082h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.g f5083i;

        public a(b.a.p0.a.e0.h.a aVar, b.a.p0.a.h0.l.a aVar2, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5079e = aVar;
            this.f5080f = aVar2;
            this.f5081g = bVar;
            this.f5082h = bVar2;
            this.f5083i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5079e.i();
                b.a.p0.a.e0.h.a.g(0);
                c.a(this.f5080f, this.f5081g, this.f5082h, this.f5083i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f5084a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f5085b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5086c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5087d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f5088e;

        public b(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar, SwanAppAlertDialog swanAppAlertDialog) {
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
            this.f5084a = aVar;
            this.f5085b = bVar;
            this.f5086c = bVar2;
            this.f5087d = gVar;
            this.f5088e = swanAppAlertDialog;
        }

        @Override // b.a.p0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f5084a, this.f5085b, this.f5086c, this.f5087d);
                this.f5088e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188449392, "Lb/a/p0/a/f2/f/o0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(188449392, "Lb/a/p0/a/f2/f/o0/c;");
                return;
            }
        }
        f5077a = b.a.p0.a.k.f6863a;
    }

    public static void a(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = b.a.p0.a.u1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            SwanAppConfigData swanAppConfigData = gVar.f3997b;
            if (swanAppConfigData == null) {
                if (f5077a) {
                    Log.getStackTraceString(new Exception("loadInfo.mConfigData is null."));
                    return;
                }
                return;
            }
            String d2 = d(U, bVar2, swanAppConfigData);
            String h2 = gVar.f3997b.h(d2);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.a.p0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f3997b, gVar, false);
                aVar.f(activity);
                bVar.f(activity);
                b.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    return;
                }
                b.a.p0.a.m1.b e2 = b.a.p0.a.m1.b.e(d2, U.z());
                b.a.p0.a.h0.t.a.o(q0.a(e2.f7016g, e2.f7014e, e2.f7015f), bVar);
                g(V, d2);
                n.E();
                b.a.p0.a.n1.g.e(bVar.c());
                if (!TextUtils.isEmpty(h2)) {
                    b.a.p0.a.u1.h.l(h2);
                }
                n.F(true, bVar2.T());
                b.a.p0.a.a3.e loadingView = activity.getLoadingView();
                if (f5077a) {
                    String str = "startFirstPage:: loadingView=" + loadingView;
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
                if (J.D() && TextUtils.equals(J.getAppId(), bVar2.H())) {
                    J.r().I(true);
                }
                b.a.p0.a.h0.i.f.f(true);
            } else if (f5077a) {
                Log.getStackTraceString(new Exception("activity is invalid."));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.a.p0.a.h0.g.g V = U.V();
                if (V == null) {
                    b.a.p0.a.e0.d.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    b.a.p0.a.e0.d.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    b.a.p0.a.b3.d.b.a().k();
                    b.a.p0.a.a3.e loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    b.a.p0.a.h0.i.f.f(true);
                    return;
                }
            }
            b.a.p0.a.e0.d.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f5078b : (String) invokeV.objValue;
    }

    public static String d(b.a.p0.a.g1.f fVar, b.a.p0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar, bVar, swanAppConfigData)) == null) {
            String a2 = fVar.a();
            if (TextUtils.isEmpty(a2)) {
                if (bVar.o0()) {
                    a2 = swanAppConfigData.g(bVar.h0());
                } else {
                    a2 = fVar.f();
                }
            }
            f5078b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        b.a V;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
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

    public static boolean f(b.a.p0.a.h0.g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, gVar)) == null) ? gVar.k() >= 1 && (gVar.m() instanceof b.a.p0.a.h0.g.k) : invokeL.booleanValue;
    }

    public static void g(b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, gVar, str) == null) || gVar == null) {
            return;
        }
        b.a.p0.a.h0.g.f.P3(null);
        b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
        g.b i2 = gVar.i("init");
        int i3 = b.a.p0.a.h0.g.g.f5480i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", b.a.p0.a.m1.b.e(str, U.z()), true).a();
    }

    public static void h(b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, gVar, str) == null) {
            if (gVar == null) {
                b.a.p0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(gVar)) {
                b.a.p0.a.e0.d.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                b.a.p0.a.h0.g.f.P3(null);
                g.b i2 = gVar.i("init");
                int i3 = b.a.p0.a.h0.g.g.f5480i;
                i2.n(i3, i3);
                i2.f();
                i2.l("web_mode", b.a.p0.a.m1.b.e(str, str), true).a();
                b.a.p0.a.b3.b.c().o(gVar.m());
            }
        }
    }

    public static void i(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, aVar, bVar, bVar2, gVar) == null) {
            if (!b.a.p0.a.x1.a.a.H() && b.a.p0.a.e0.h.a.e() != 2) {
                if (b.a.p0.a.x1.a.a.D()) {
                    b.a.p0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            b.a.p0.a.e0.d.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            b.a.p0.a.e0.h.a aVar2 = new b.a.p0.a.e0.h.a(b.a.p0.a.c1.a.c());
            SwanAppAlertDialog.a aVar3 = new SwanAppAlertDialog.a(b.a.p0.a.d2.d.J().x());
            aVar3.U(b.a.p0.a.h.aiapps_debug_start_inspect);
            aVar3.v(b.a.p0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new b.a.p0.a.a3.h.a());
            aVar3.m(false);
            aVar3.O(b.a.p0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            SwanAppAlertDialog X = aVar3.X();
            HybridUbcFlow o = b.a.p0.a.u1.h.o();
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
            b(b.a.p0.a.b3.c.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
