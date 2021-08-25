package c.a.o0.a.r1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.v2.m;
import c.a.o0.a.v2.o0;
import c.a.o0.a.v2.q;
import c.a.o0.a.v2.q0;
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
    public static final boolean f8317a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8318b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8319c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f8320d;

    /* renamed from: e  reason: collision with root package name */
    public static String f8321e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static volatile c.a.o0.a.r1.b f8322f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f8323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8324f;

        public a(c.a.o0.a.f1.e.b bVar, boolean z) {
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
            this.f8323e = bVar;
            this.f8324f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.i(this.f8323e, this.f8324f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f8325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8327g;

        public b(c.a.o0.a.f1.e.b bVar, String str, boolean z) {
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
            this.f8325e = bVar;
            this.f8326f = str;
            this.f8327g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = h.p("startup");
                String T = TextUtils.isEmpty(this.f8325e.T()) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f8325e.T();
                if (this.f8325e.G() == 1) {
                    p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                }
                p.B("from", "swan");
                p.B("source", T);
                p.A("appid", this.f8325e.H());
                p.A("swan", c.a.o0.a.m2.b.i(this.f8325e.i0(), this.f8325e.G()));
                p.A("mobile", m.c());
                long l = this.f8325e.l("box_cold_launch", -1L);
                if (l < 0) {
                    l = c.a.o0.a.r1.c.a();
                }
                if (l > 0) {
                    p.A("box_cold_launch", String.valueOf(l));
                }
                p.A("net", SwanAppNetworkUtils.f().type);
                p.A("appversion", this.f8325e.u1());
                p.A("thirdversion", this.f8325e.v1());
                p.B("from", this.f8325e.G() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
                p.A("scheme", this.f8325e.W());
                HashSet hashSet = new HashSet();
                hashSet.add("callback");
                hashSet.add("upgrade");
                String i2 = o0.i(this.f8326f, hashSet);
                if (!TextUtils.isEmpty(i2) && i2.startsWith(File.separator)) {
                    i2 = i2.substring(1);
                }
                p.A("path", TextUtils.isEmpty(i2) ? "" : i2);
                if (h.f8317a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PerformanceUbc path: ");
                    if (TextUtils.isEmpty(i2)) {
                        i2 = "";
                    }
                    sb.append(i2);
                    sb.toString();
                }
                if (this.f8327g) {
                    p.B("value", "arrive_success");
                }
                p.A("launchid", this.f8325e.V());
                p.A("isPreDownloading", this.f8325e.r0().getString("aiapp_extra_pkg_downloading", "0"));
                p.A("isReloadApp", this.f8325e.d("launch_by_reload") ? "1" : "0");
                p.A("preAppReadyState", String.valueOf(c.a.o0.a.h0.u.b.a(this.f8325e)));
                if (this.f8325e.G() == 0) {
                    p.A("is_opti", c.a.o0.a.l1.d.d.f().g(this.f8325e.f0()) ? "1" : "0");
                    p.x();
                }
                c.a.o0.a.e0.d.h("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f8325e);
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
    public static class d extends c.a.o0.a.j2.p.e {
        public static /* synthetic */ Interceptable $ic = null;
        public static int n = 35;
        public transient /* synthetic */ FieldHolder $fh;
        public final String k;
        public JSONObject l;
        public boolean m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1271536621, "Lc/a/o0/a/r1/h$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1271536621, "Lc/a/o0/a/r1/h$d;");
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

        @Override // c.a.o0.a.j2.p.e
        public JSONObject f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f7037c = TextUtils.isEmpty(this.f7037c) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f7037c;
                if (this.f7042h == null) {
                    this.f7042h = new JSONObject();
                }
                try {
                    if (this.l != null) {
                        if (this.m) {
                            String z = q0.z(n);
                            if (!TextUtils.isEmpty(z)) {
                                this.l.put("stacktrace", z);
                            }
                        }
                        this.f7042h.put("info", this.l);
                    }
                } catch (JSONException e2) {
                    if (c.a.o0.a.j2.p.e.f7034j) {
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
                this.f7035a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f7037c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f7036b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1024785709, "Lc/a/o0/a/r1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1024785709, "Lc/a/o0/a/r1/h;");
                return;
            }
        }
        f8317a = k.f7049a;
        c.a.o0.a.c1.a.Z().getSwitch("swan_performance_aligned_search_switch", false);
        f8318b = false;
        c.a.o0.a.c1.a.Z().getSwitch("swan_app_use_performance_end_v2", false);
        f8319c = false;
    }

    public static String c(c.a.o0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            String e0 = bVar.e0();
            if (TextUtils.isEmpty(e0)) {
                if (TextUtils.isEmpty(f8321e)) {
                    f8321e = c.a.o0.a.c2.f.p0.c.b();
                    if (f8317a) {
                        String str = "chechPath- 冷启场景 path 为空，取首页 path: " + f8321e;
                    }
                } else if (f8317a) {
                    String str2 = "chechPath- 热启场景 path 为空，使用上次调起 path: " + f8321e;
                }
            } else {
                f8321e = e0;
                if (f8317a) {
                    String str3 = "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f8321e;
                }
            }
            return f8321e;
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

    public static c.a.o0.a.r1.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f8322f == null) {
                synchronized (c.a.o0.a.r1.b.class) {
                    if (f8322f == null) {
                        f8322f = new c.a.o0.a.r1.b();
                        g(f8322f);
                    }
                }
            }
            return f8322f;
        }
        return (c.a.o0.a.r1.b) invokeV.objValue;
    }

    public static void g(c.a.o0.a.r1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            bVar.d("preload", new c.a.o0.a.r1.m.a());
            bVar.d("startup", new c.a.o0.a.r1.m.c());
            bVar.d(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, new c.a.o0.a.r1.m.b());
            bVar.d("video", new c.a.o0.a.r1.m.d());
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

    public static void i(c.a.o0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, bVar, z) == null) {
            c.a.o0.a.e0.d.h("SwanAppPerformanceUBC", "recordForStartup");
            if (bVar == null || bVar.P() == null) {
                return;
            }
            q.i(new b(bVar, c(bVar), z), "recordFromLaunchInfo");
        }
    }

    public static void j(c.a.o0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, bVar, z) == null) {
            c.a.o0.a.a2.d.i().post(new a(bVar, z));
        }
    }

    public static synchronized void k(c.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            synchronized (h.class) {
                HybridUbcFlow m = m();
                if (m != null) {
                    m.B("value", SmsLoginView.f.l);
                    if (aVar != null) {
                        m.A("statusCode", String.valueOf(aVar.a()));
                        m.A("launchid", c.a.o0.a.a2.d.g().r().L().V());
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
        c.a.o0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (h.class) {
                t();
                c.a.o0.a.y0.k.f.b.a();
                HybridUbcFlow d2 = d("startup");
                c.a.o0.a.p.e.b bVar = null;
                if (d2 == null) {
                    return null;
                }
                d2.C(new UbcFlowEvent("performanceEnd"));
                if (!d2.q()) {
                    d2.x();
                }
                c.a.o0.a.h0.g.g W = c.a.o0.a.g1.f.V().W();
                if (W != null && (o = W.o()) != null) {
                    bVar = o.Z2();
                }
                d2.z(bVar);
                if (!d2.u()) {
                    d2.Q();
                }
                if (!d2.t()) {
                    d2.P();
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
            f8320d = timer;
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
            if (f8317a) {
                String str = "onEvent " + dVar;
            }
            c.a.o0.a.j2.b.k(dVar.k, dVar.f());
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
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (timer = f8320d) == null) {
            return;
        }
        timer.cancel();
        f8320d = null;
    }
}
