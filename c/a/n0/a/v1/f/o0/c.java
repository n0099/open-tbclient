package c.a.n0.a.v1.f.o0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.u.h.a;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.g;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
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
    public static String f6808b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.u.h.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.l.a f6809b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6810c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6811d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.g f6812e;

        public a(c.a.n0.a.u.h.a aVar, c.a.n0.a.x.l.a aVar2, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6809b = aVar2;
            this.f6810c = bVar;
            this.f6811d = bVar2;
            this.f6812e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                c.a.n0.a.u.h.a.g(0);
                c.a(this.f6809b, this.f6810c, this.f6811d, this.f6812e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6813b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6814c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6815d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.s1.b.b.h f6816e;

        public b(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar, c.a.n0.a.s1.b.b.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2, gVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6813b = bVar;
            this.f6814c = bVar2;
            this.f6815d = gVar;
            this.f6816e = hVar;
        }

        @Override // c.a.n0.a.u.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.a, this.f6813b, this.f6814c, this.f6815d);
                this.f6816e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712920418, "Lc/a/n0/a/v1/f/o0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-712920418, "Lc/a/n0/a/v1/f/o0/c;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void a(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = c.a.n0.a.k1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            SwanAppConfigData swanAppConfigData = gVar.f5965b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d2 = d(U, bVar2, swanAppConfigData);
            String h2 = gVar.f5965b.h(d2);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.n0.a.x.p.b.c().b(aVar, bVar, bVar2, gVar.f5965b, gVar, false);
                aVar.f(activity);
                bVar.f(activity);
                c.a.n0.a.x.g.g V = U.V();
                if (V == null) {
                    return;
                }
                c.a.n0.a.c1.b d3 = c.a.n0.a.c1.b.d(d2, U.z());
                c.a.n0.a.x.t.a.o(q0.a(d3.f3948c, d3.a, d3.f3947b), bVar);
                g(V, d2);
                n.E();
                c.a.n0.a.d1.g.e(bVar.c());
                if (!TextUtils.isEmpty(h2)) {
                    c.a.n0.a.k1.h.l(h2);
                }
                n.F(true, bVar2.T());
                c.a.n0.a.q2.e loadingView = activity.getLoadingView();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + loadingView);
                }
                if (loadingView != null) {
                    loadingView.F(1);
                }
                c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
                if (J.D() && TextUtils.equals(J.getAppId(), bVar2.H())) {
                    J.r().I(true);
                }
                c.a.n0.a.x.i.f.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.n0.a.x.g.g V = U.V();
                if (V == null) {
                    c.a.n0.a.u.d.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    c.a.n0.a.u.d.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    c.a.n0.a.r2.d.b.a().k();
                    c.a.n0.a.q2.e loadingView = activity.getLoadingView();
                    if (loadingView != null) {
                        loadingView.F(1);
                    }
                    c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
                    if (J.D()) {
                        J.r().I(true);
                    }
                    c.a.n0.a.x.i.f.f(true);
                    return;
                }
            }
            c.a.n0.a.u.d.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6808b : (String) invokeV.objValue;
    }

    public static String d(c.a.n0.a.w0.f fVar, c.a.n0.a.v0.e.b bVar, SwanAppConfigData swanAppConfigData) {
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
            f6808b = b2;
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
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
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

    public static boolean f(c.a.n0.a.x.g.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gVar)) == null) ? gVar.k() >= 1 && (gVar.m() instanceof c.a.n0.a.x.g.k) : invokeL.booleanValue;
    }

    public static void g(c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, gVar, str) == null) || gVar == null) {
            return;
        }
        c.a.n0.a.x.g.f.Q3(null);
        c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
        g.b i = gVar.i("init");
        int i2 = c.a.n0.a.x.g.g.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", c.a.n0.a.c1.b.d(str, U.z()), true).a();
    }

    public static void h(c.a.n0.a.x.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, gVar, str) == null) {
            if (gVar == null) {
                c.a.n0.a.u.d.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(gVar)) {
                c.a.n0.a.u.d.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                c.a.n0.a.x.g.f.Q3(null);
                g.b i = gVar.i("init");
                int i2 = c.a.n0.a.x.g.g.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", c.a.n0.a.c1.b.d(str, str), true).a();
                c.a.n0.a.r2.b.c().o(gVar.m());
            }
        }
    }

    public static void i(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, aVar, bVar, bVar2, gVar) == null) {
            if (!c.a.n0.a.n1.a.a.H() && c.a.n0.a.u.h.a.e() != 2) {
                if (c.a.n0.a.n1.a.a.D()) {
                    c.a.n0.a.u.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            c.a.n0.a.u.d.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            c.a.n0.a.u.h.a aVar2 = new c.a.n0.a.u.h.a(c.a.n0.a.s0.a.c());
            h.a aVar3 = new h.a(c.a.n0.a.t1.d.J().x());
            aVar3.U(R.string.obfuscated_res_0x7f0f0145);
            aVar3.v(R.string.obfuscated_res_0x7f0f0134);
            aVar3.n(new c.a.n0.a.q2.h.a());
            aVar3.m(false);
            aVar3.O(R.string.obfuscated_res_0x7f0f0133, new a(aVar2, aVar, bVar, bVar2, gVar));
            c.a.n0.a.s1.b.b.h X = aVar3.X();
            HybridUbcFlow o = c.a.n0.a.k1.h.o();
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
            b(c.a.n0.a.r2.c.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
