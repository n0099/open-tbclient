package b.a.p0.a.c2.f.p0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.e0.h.a;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.v2.q0;
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
    public static final boolean f4360a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4361b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e0.h.a f4362e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4363f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4364g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4365h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e.g f4366i;

        public a(b.a.p0.a.e0.h.a aVar, b.a.p0.a.h0.l.a aVar2, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4362e = aVar;
            this.f4363f = aVar2;
            this.f4364g = bVar;
            this.f4365h = bVar2;
            this.f4366i = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f4362e.i();
                b.a.p0.a.e0.h.a.g(0);
                c.a(this.f4363f, this.f4364g, this.f4365h, this.f4366i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4368b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4369c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4370d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f4371e;

        public b(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar, SwanAppAlertDialog swanAppAlertDialog) {
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
            this.f4367a = aVar;
            this.f4368b = bVar;
            this.f4369c = bVar2;
            this.f4370d = gVar;
            this.f4371e = swanAppAlertDialog;
        }

        @Override // b.a.p0.a.e0.h.a.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a(this.f4367a, this.f4368b, this.f4369c, this.f4370d);
                this.f4371e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(778913428, "Lb/a/p0/a/c2/f/p0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(778913428, "Lb/a/p0/a/c2/f/p0/c;");
                return;
            }
        }
        f4360a = b.a.p0.a.k.f6397a;
    }

    public static void a(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, aVar, bVar, bVar2, gVar) == null) {
            HybridUbcFlow o = b.a.p0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            SwanAppConfigData swanAppConfigData = gVar.f3904b;
            if (swanAppConfigData == null) {
                if (f4360a) {
                    Log.getStackTraceString(new Exception("loadInfo.mConfigData is null."));
                    return;
                }
                return;
            }
            String c2 = c(T, bVar2, swanAppConfigData);
            String g2 = gVar.f3904b.g(c2);
            SwanAppActivity activity = T.getActivity();
            if (activity != null && !activity.isFinishing()) {
                b.a.p0.a.h0.p.b.c().b(aVar, bVar, bVar2, gVar.f3904b, gVar, false);
                aVar.e(activity);
                bVar.e(activity);
                b.a.p0.a.h0.g.g U = T.U();
                if (U == null) {
                    return;
                }
                b.a.p0.a.l1.b e2 = b.a.p0.a.l1.b.e(c2, T.z());
                b.a.p0.a.h0.t.a.m(q0.a(e2.f6557g, e2.f6555e, e2.f6556f), bVar);
                d(U, c2);
                b.a.p0.a.j2.k.A();
                b.a.p0.a.m1.f.e(bVar.b());
                if (!TextUtils.isEmpty(g2)) {
                    b.a.p0.a.r1.h.l(g2);
                }
                b.a.p0.a.j2.k.B(true, bVar2.S());
                b.a.p0.a.w2.e loadingView = activity.getLoadingView();
                if (f4360a) {
                    String str = "startFirstPage:: loadingView=" + loadingView;
                }
                if (loadingView != null) {
                    loadingView.H(1);
                }
                b.a.p0.a.a2.d g3 = b.a.p0.a.a2.d.g();
                if (g3.C() && TextUtils.equals(g3.getAppId(), bVar2.G())) {
                    g3.r().f(true);
                }
                b.a.p0.a.h0.i.i.h(true);
            } else if (f4360a) {
                Log.getStackTraceString(new Exception("activity is invalid."));
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f4361b : (String) invokeV.objValue;
    }

    public static String c(b.a.p0.a.g1.f fVar, b.a.p0.a.f1.e.b bVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, fVar, bVar, swanAppConfigData)) == null) {
            String a2 = fVar.a();
            if (TextUtils.isEmpty(a2)) {
                if (bVar.m0()) {
                    a2 = swanAppConfigData.f(bVar.g0());
                } else {
                    a2 = fVar.f();
                }
            }
            f4361b = a2;
            return a2;
        }
        return (String) invokeLLL.objValue;
    }

    public static void d(b.a.p0.a.h0.g.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar, str) == null) || gVar == null) {
            return;
        }
        b.a.p0.a.h0.g.f.y3(null);
        b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
        g.b i2 = gVar.i("init");
        int i3 = b.a.p0.a.h0.g.g.f5282i;
        i2.n(i3, i3);
        i2.f();
        i2.l("normal", b.a.p0.a.l1.b.e(str, T.z()), true).a();
    }

    public static void e(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, bVar, bVar2, gVar) == null) {
            if (!b.a.p0.a.u1.a.a.G() && b.a.p0.a.e0.h.a.e() != 2) {
                if (b.a.p0.a.u1.a.a.C()) {
                    b.a.p0.a.e0.f.d.f.k().q(aVar, bVar, bVar2, gVar);
                    return;
                } else {
                    a(aVar, bVar, bVar2, gVar);
                    return;
                }
            }
            b.a.p0.a.e0.d.g("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            b.a.p0.a.e0.h.a aVar2 = new b.a.p0.a.e0.h.a(b.a.p0.a.c1.a.b());
            SwanAppAlertDialog.a aVar3 = new SwanAppAlertDialog.a(b.a.p0.a.a2.d.g().x());
            aVar3.U(b.a.p0.a.h.aiapps_debug_start_inspect);
            aVar3.v(b.a.p0.a.h.aiapps_debug_inspect_waiting);
            aVar3.n(new b.a.p0.a.w2.h.a());
            aVar3.m(false);
            aVar3.O(b.a.p0.a.h.aiapps_debug_inspect_skip, new a(aVar2, aVar, bVar, bVar2, gVar));
            SwanAppAlertDialog X = aVar3.X();
            HybridUbcFlow o = b.a.p0.a.r1.h.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.C(ubcFlowEvent);
            aVar2.f(new b(aVar, bVar, bVar2, gVar, X));
            aVar2.h();
        }
    }
}
