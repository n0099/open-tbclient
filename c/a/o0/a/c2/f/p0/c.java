package c.a.o0.a.c2.f.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.e0.h.a;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
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
    public static final boolean f4946a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4947b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e0.h.a f4948e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f4949f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f4950g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f4951h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f4952i;

        public a(c.a.o0.a.e0.h.a aVar, c.a.o0.a.h0.l.a aVar2, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4948e = aVar;
            this.f4949f = aVar2;
            this.f4950g = bVar;
            this.f4951h = bVar2;
            this.f4952i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f4948e.i();
                c.a.o0.a.e0.h.a.g(0);
                c.a(this.f4949f, this.f4950g, this.f4951h, this.f4952i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f4953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f4954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f4955c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4956d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f4957e;

        public b(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar, SwanAppAlertDialog swanAppAlertDialog) {
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
            this.f4953a = aVar;
            this.f4954b = bVar;
            this.f4955c = bVar2;
            this.f4956d = gVar;
            this.f4957e = swanAppAlertDialog;
        }

        @Override // c.a.o0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f4953a, this.f4954b, this.f4955c, this.f4956d);
                this.f4957e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1573110252, "Lc/a/o0/a/c2/f/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1573110252, "Lc/a/o0/a/c2/f/p0/c;");
                return;
            }
        }
        f4946a = c.a.o0.a.k.f7049a;
    }

    public static void a(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = c.a.o0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
            SwanAppConfigData swanAppConfigData = gVar.f4471b;
            if (swanAppConfigData == null) {
                if (f4946a) {
                    Log.getStackTraceString(new Exception("loadInfo.mConfigData is null."));
                    return;
                }
                return;
            }
            String c2 = c(V, bVar2, swanAppConfigData);
            String g2 = gVar.f4471b.g(c2);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c.a.o0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f4471b, gVar, false);
                aVar.f(activity);
                bVar.f(activity);
                c.a.o0.a.h0.g.g W = V.W();
                if (W == null) {
                    return;
                }
                c.a.o0.a.l1.b g3 = c.a.o0.a.l1.b.g(c2, V.A());
                c.a.o0.a.h0.t.a.m(q0.a(g3.f7210g, g3.f7208e, g3.f7209f), bVar);
                d(W, c2);
                c.a.o0.a.j2.k.A();
                c.a.o0.a.m1.f.e(bVar.c());
                if (!TextUtils.isEmpty(g2)) {
                    c.a.o0.a.r1.h.l(g2);
                }
                c.a.o0.a.j2.k.B(true, bVar2.T());
                c.a.o0.a.w2.e loadingView = activity.getLoadingView();
                if (f4946a) {
                    String str = "startFirstPage:: loadingView=" + loadingView;
                }
                if (loadingView != null) {
                    loadingView.H(1);
                }
                c.a.o0.a.a2.d g4 = c.a.o0.a.a2.d.g();
                if (g4.C() && TextUtils.equals(g4.getAppId(), bVar2.H())) {
                    g4.r().f(true);
                }
                c.a.o0.a.h0.i.i.h(true);
            } else if (f4946a) {
                Log.getStackTraceString(new Exception("activity is invalid."));
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f4947b : (String) invokeV.objValue;
    }

    public static String c(c.a.o0.a.g1.f fVar, c.a.o0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, fVar, bVar, swanAppConfigData)) == null) {
            String a2 = fVar.a();
            if (TextUtils.isEmpty(a2)) {
                if (bVar.n0()) {
                    a2 = swanAppConfigData.f(bVar.h0());
                } else {
                    a2 = fVar.f();
                }
            }
            f4947b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(c.a.o0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar, str) == null) || gVar == null) {
            return;
        }
        c.a.o0.a.h0.g.f.C3(null);
        c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
        g.b i2 = gVar.i("init");
        int i3 = c.a.o0.a.h0.g.g.f5902i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", c.a.o0.a.l1.b.g(str, V.A()), true).a();
    }

    public static void e(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, gVar) == null) {
            if (!c.a.o0.a.u1.a.a.G() && c.a.o0.a.e0.h.a.e() != 2) {
                if (c.a.o0.a.u1.a.a.C()) {
                    c.a.o0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            c.a.o0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            c.a.o0.a.e0.h.a aVar2 = new c.a.o0.a.e0.h.a(c.a.o0.a.c1.a.b());
            SwanAppAlertDialog.a aVar3 = new SwanAppAlertDialog.a(c.a.o0.a.a2.d.g().x());
            aVar3.U(c.a.o0.a.h.aiapps_debug_start_inspect);
            aVar3.v(c.a.o0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new c.a.o0.a.w2.h.a());
            aVar3.m(false);
            aVar3.O(c.a.o0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            SwanAppAlertDialog X = aVar3.X();
            HybridUbcFlow o = c.a.o0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }
}
