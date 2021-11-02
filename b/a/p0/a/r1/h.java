package b.a.p0.a.r1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.v2.m;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7628a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7629b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7630c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f7631d;

    /* renamed from: e  reason: collision with root package name */
    public static String f7632e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static volatile b.a.p0.a.r1.b f7633f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f7634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f7635f;

        public a(b.a.p0.a.f1.e.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7634e = bVar;
            this.f7635f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.i(this.f7634e, this.f7635f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f7636e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7637f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7638g;

        public b(b.a.p0.a.f1.e.b bVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7636e = bVar;
            this.f7637f = str;
            this.f7638g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = h.p("startup");
                String S = TextUtils.isEmpty(this.f7636e.S()) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f7636e.S();
                if (this.f7636e.F() == 1) {
                    p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                }
                p.B("from", "swan");
                p.B("source", S);
                p.A("appid", this.f7636e.G());
                p.A("swan", b.a.p0.a.m2.b.i(this.f7636e.h0(), this.f7636e.F()));
                p.A("mobile", m.c());
                long l = this.f7636e.l("box_cold_launch", -1L);
                if (l < 0) {
                    l = b.a.p0.a.r1.c.a();
                }
                if (l > 0) {
                    p.A("box_cold_launch", String.valueOf(l));
                }
                p.A("net", SwanAppNetworkUtils.f().type);
                p.A("appversion", this.f7636e.s1());
                p.A("thirdversion", this.f7636e.t1());
                p.B("from", this.f7636e.F() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
                p.A("scheme", this.f7636e.V());
                HashSet hashSet = new HashSet();
                hashSet.add("callback");
                hashSet.add("upgrade");
                String i2 = o0.i(this.f7637f, hashSet);
                if (!TextUtils.isEmpty(i2) && i2.startsWith(File.separator)) {
                    i2 = i2.substring(1);
                }
                p.A("path", TextUtils.isEmpty(i2) ? "" : i2);
                if (h.f7628a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PerformanceUbc path: ");
                    if (TextUtils.isEmpty(i2)) {
                        i2 = "";
                    }
                    sb.append(i2);
                    sb.toString();
                }
                if (this.f7638g) {
                    p.B("value", "arrive_success");
                }
                p.A("launchid", this.f7636e.U());
                p.A("isPreDownloading", this.f7636e.q0().getString("aiapp_extra_pkg_downloading", "0"));
                p.A("isReloadApp", this.f7636e.d("launch_by_reload") ? "1" : "0");
                p.A("preAppReadyState", String.valueOf(b.a.p0.a.h0.u.b.a(this.f7636e)));
                if (this.f7636e.F() == 0) {
                    p.A("is_opti", b.a.p0.a.l1.d.d.f().g(this.f7636e.e0()) ? "1" : "0");
                    p.x();
                }
                b.a.p0.a.e0.d.h("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f7636e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends b.a.p0.a.j2.p.e {
        public static /* synthetic */ Interceptable $ic = null;
        public static int n = 35;
        public transient /* synthetic */ FieldHolder $fh;
        public final String k;
        public JSONObject l;
        public boolean m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1911153517, "Lb/a/p0/a/r1/h$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1911153517, "Lb/a/p0/a/r1/h$d;");
            }
        }

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.m = true;
            this.k = str;
        }

        @Override // b.a.p0.a.j2.p.e
        public JSONObject f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f6385c = TextUtils.isEmpty(this.f6385c) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f6385c;
                if (this.f6390h == null) {
                    this.f6390h = new JSONObject();
                }
                try {
                    if (this.l != null) {
                        if (this.m) {
                            String z = q0.z(n);
                            if (!TextUtils.isEmpty(z)) {
                                this.l.put("stacktrace", z);
                            }
                        }
                        this.f6390h.put("info", this.l);
                    }
                } catch (JSONException e2) {
                    if (b.a.p0.a.j2.p.e.j) {
                        e2.printStackTrace();
                    }
                }
                return super.f();
            }
            return (JSONObject) invokeV.objValue;
        }

        public d g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f6383a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f6385c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f6384b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1333830829, "Lb/a/p0/a/r1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1333830829, "Lb/a/p0/a/r1/h;");
                return;
            }
        }
        f7628a = k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_performance_aligned_search_switch", false);
        f7629b = false;
        b.a.p0.a.c1.a.Z().getSwitch("swan_app_use_performance_end_v2", false);
        f7630c = false;
    }

    public static String c(b.a.p0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            String d0 = bVar.d0();
            if (TextUtils.isEmpty(d0)) {
                if (TextUtils.isEmpty(f7632e)) {
                    f7632e = b.a.p0.a.c2.f.p0.c.b();
                    if (f7628a) {
                        String str = "chechPath- 冷启场景 path 为空，取首页 path: " + f7632e;
                    }
                } else if (f7628a) {
                    String str2 = "chechPath- 热启场景 path 为空，使用上次调起 path: " + f7632e;
                }
            } else {
                f7632e = d0;
                if (f7628a) {
                    String str3 = "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f7632e;
                }
            }
            return f7632e;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized HybridUbcFlow d(String str) {
        InterceptResult invokeL;
        HybridUbcFlow b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            synchronized (h.class) {
                b2 = f().b(str);
            }
            return b2;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public static synchronized HybridUbcFlow e(String str, String str2) {
        InterceptResult invokeLL;
        HybridUbcFlow c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            synchronized (h.class) {
                c2 = f().c(str, str2);
            }
            return c2;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public static b.a.p0.a.r1.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f7633f == null) {
                synchronized (b.a.p0.a.r1.b.class) {
                    if (f7633f == null) {
                        f7633f = new b.a.p0.a.r1.b();
                        g(f7633f);
                    }
                }
            }
            return f7633f;
        }
        return (b.a.p0.a.r1.b) invokeV.objValue;
    }

    public static void g(b.a.p0.a.r1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            bVar.d("preload", new b.a.p0.a.r1.m.a());
            bVar.d("startup", new b.a.p0.a.r1.m.c());
            bVar.d(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, new b.a.p0.a.r1.m.b());
            bVar.d("video", new b.a.p0.a.r1.m.d());
        }
    }

    public static synchronized void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            synchronized (h.class) {
                HybridUbcFlow b2 = f().b(str);
                if (b2 != null) {
                    f().e(str2).w(b2);
                    r(str);
                }
            }
        }
    }

    public static void i(b.a.p0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, bVar, z) == null) {
            b.a.p0.a.e0.d.h("SwanAppPerformanceUBC", "recordForStartup");
            if (bVar == null || bVar.O() == null) {
                return;
            }
            q.i(new b(bVar, c(bVar), z), "recordFromLaunchInfo");
        }
    }

    public static void j(b.a.p0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, bVar, z) == null) {
            b.a.p0.a.a2.d.i().post(new a(bVar, z));
        }
    }

    public static synchronized void k(b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            synchronized (h.class) {
                HybridUbcFlow m = m();
                if (m != null) {
                    m.B("value", SmsLoginView.f.l);
                    if (aVar != null) {
                        m.A(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, String.valueOf(aVar.a()));
                        m.A("launchid", b.a.p0.a.a2.d.g().r().K().U());
                    }
                    m.l();
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void l(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            switch (str.hashCode()) {
                case -952207494:
                    if (str.equals("independent")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -533350585:
                    if (str.equals("subNormal")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -285446714:
                    if (str.equals("dynamicLib")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3343801:
                    if (str.equals(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            p("startup").A("package_type", c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "-1" : "3" : "1" : "2" : "0");
        }
    }

    public static synchronized HybridUbcFlow m() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (h.class) {
                t();
                b.a.p0.a.y0.k.f.b.a();
                HybridUbcFlow d2 = d("startup");
                b.a.p0.a.p.e.b bVar = null;
                if (d2 == null) {
                    return null;
                }
                d2.C(new UbcFlowEvent("performanceEnd"));
                if (!d2.q()) {
                    d2.x();
                }
                b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
                if (U != null && (o = U.o()) != null) {
                    bVar = o.V2();
                }
                d2.z(bVar);
                if (!d2.u()) {
                    d2.P();
                }
                if (!d2.t()) {
                    d2.O();
                }
                return d2;
            }
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            Timer timer = new Timer();
            f7631d = timer;
            timer.schedule(new c(), 15000L);
        }
    }

    @Deprecated
    public static synchronized HybridUbcFlow o() {
        InterceptResult invokeV;
        HybridUbcFlow p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (h.class) {
                p = p("startup");
            }
            return p;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public static void onEvent(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dVar) == null) {
            if (f7628a) {
                String str = "onEvent " + dVar;
            }
            b.a.p0.a.j2.b.k(dVar.k, dVar.f());
        }
    }

    public static synchronized HybridUbcFlow p(String str) {
        InterceptResult invokeL;
        HybridUbcFlow e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            synchronized (h.class) {
                e2 = f().e(str);
            }
            return e2;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public static synchronized HybridUbcFlow q(String str, String str2) {
        InterceptResult invokeLL;
        HybridUbcFlow f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            synchronized (h.class) {
                f2 = f().f(str, str2);
            }
            return f2;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public static synchronized void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            synchronized (h.class) {
                f().g(str);
            }
        }
    }

    public static synchronized void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (h.class) {
                f().h(str, str2);
            }
        }
    }

    public static void t() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (timer = f7631d) == null) {
            return;
        }
        timer.cancel();
        f7631d = null;
    }
}
