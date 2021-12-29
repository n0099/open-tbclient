package c.a.r0.a.u1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.z2.m;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kwad.v8.NodeJS;
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
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Timer f9548b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9549c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static volatile c.a.r0.a.u1.b f9550d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f9551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f9552f;

        public a(c.a.r0.a.f1.e.b bVar, boolean z) {
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
            this.f9551e = bVar;
            this.f9552f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.i(this.f9551e, this.f9552f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f9553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f9555g;

        /* loaded from: classes.dex */
        public class a implements c.a.r0.a.z2.g1.d<c.a.r0.a.d2.n.g> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.d
            /* renamed from: a */
            public c.a.r0.a.d2.n.g create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.a.g1.f.U().f(this.a) : (c.a.r0.a.d2.n.g) invokeV.objValue;
            }
        }

        public b(c.a.r0.a.f1.e.b bVar, String str, boolean z) {
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
            this.f9553e = bVar;
            this.f9554f = str;
            this.f9555g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                String T = TextUtils.isEmpty(this.f9553e.T()) ? "NA" : this.f9553e.T();
                if (this.f9553e.G() == 1) {
                    p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                }
                p.E("from", "swan");
                p.E("source", T);
                p.D("appid", this.f9553e.H());
                p.D("swan", c.a.r0.a.q2.b.i(this.f9553e.j0(), this.f9553e.G()));
                p.D("mobile", m.c());
                long l = this.f9553e.l("box_cold_launch", -1L);
                if (l < 0) {
                    l = c.a.r0.a.u1.c.a();
                }
                if (l > 0) {
                    p.D("box_cold_launch", String.valueOf(l));
                }
                p.D("net", SwanAppNetworkUtils.f().type);
                p.D("appversion", this.f9553e.v1());
                p.D("thirdversion", this.f9553e.w1());
                p.D("useNaRequest", c.a.r0.a.u.e.i.e.i() ? "1" : "0");
                p.E("from", this.f9553e.G() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
                p.D("scheme", this.f9553e.W());
                HashSet hashSet = new HashSet();
                hashSet.add("callback");
                hashSet.add("upgrade");
                String i2 = o0.i(this.f9554f, hashSet);
                if (!TextUtils.isEmpty(i2) && i2.startsWith(File.separator)) {
                    i2 = i2.substring(1);
                }
                p.D("path", TextUtils.isEmpty(i2) ? "" : i2);
                if (h.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PerformanceUbc path: ");
                    if (TextUtils.isEmpty(i2)) {
                        i2 = "";
                    }
                    sb.append(i2);
                    sb.toString();
                }
                p.D("view_mode", ((c.a.r0.a.d2.n.g) c.a.r0.a.z2.g1.a.b(new a(this, o0.f(this.f9554f)))).r);
                if (this.f9555g) {
                    p.E("value", "arrive_success");
                }
                p.D("launchid", this.f9553e.V());
                p.D("isPreDownloading", this.f9553e.s0().getString("aiapp_extra_pkg_downloading", "0"));
                p.D("isReloadApp", this.f9553e.d("launch_by_reload") ? "1" : "0");
                p.D("preAppReadyState", String.valueOf(c.a.r0.a.h0.u.b.a(this.f9553e)));
                if (this.f9553e.G() == 0) {
                    p.D("is_opti", c.a.r0.a.m1.d.d.g().h(this.f9553e.f0()) ? "1" : "0");
                    p.A();
                }
                c.a.r0.a.e0.d.k("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f9553e);
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
    public static class d extends c.a.r0.a.n2.s.e {
        public static /* synthetic */ Interceptable $ic = null;
        public static int n = 35;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: k  reason: collision with root package name */
        public final String f9556k;
        public JSONObject l;
        public boolean m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(26328525, "Lc/a/r0/a/u1/h$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26328525, "Lc/a/r0/a/u1/h$d;");
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
            this.f9556k = str;
        }

        @Override // c.a.r0.a.n2.s.e
        public JSONObject f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f8158c = TextUtils.isEmpty(this.f8158c) ? "NA" : this.f8158c;
                if (this.f8163h == null) {
                    this.f8163h = new JSONObject();
                }
                try {
                    if (this.l != null) {
                        if (this.m) {
                            String z = q0.z(n);
                            if (!TextUtils.isEmpty(z)) {
                                this.l.put("stacktrace", z);
                            }
                        }
                        this.f8163h.put("info", this.l);
                    }
                } catch (JSONException e2) {
                    if (c.a.r0.a.n2.s.e.f8156j) {
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
                this.a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f8158c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f8157b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438015757, "Lc/a/r0/a/u1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438015757, "Lc/a/r0/a/u1/h;");
                return;
            }
        }
        a = k.a;
    }

    public static String c(c.a.r0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            String e0 = bVar.e0();
            if (TextUtils.isEmpty(e0)) {
                if (TextUtils.isEmpty(f9549c)) {
                    f9549c = c.a.r0.a.f2.f.o0.c.c();
                    if (a) {
                        String str = "chechPath- 冷启场景 path 为空，取首页 path: " + f9549c;
                    }
                } else if (a) {
                    String str2 = "chechPath- 热启场景 path 为空，使用上次调起 path: " + f9549c;
                }
            } else {
                f9549c = e0;
                if (a) {
                    String str3 = "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f9549c;
                }
            }
            return f9549c;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            synchronized (h.class) {
                c2 = f().c(str, str2);
            }
            return c2;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public static c.a.r0.a.u1.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f9550d == null) {
                synchronized (c.a.r0.a.u1.b.class) {
                    if (f9550d == null) {
                        f9550d = new c.a.r0.a.u1.b();
                        g(f9550d);
                    }
                }
            }
            return f9550d;
        }
        return (c.a.r0.a.u1.b) invokeV.objValue;
    }

    public static void g(c.a.r0.a.u1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            bVar.d("preload", new c.a.r0.a.u1.m.a());
            bVar.d(NodeJS.STARTUP_SCRIPT_NAME, new c.a.r0.a.u1.m.c());
            bVar.d(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, new c.a.r0.a.u1.m.b());
            bVar.d("video", new c.a.r0.a.u1.m.e());
            bVar.d(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, new c.a.r0.a.u1.m.d());
            bVar.d(PrefetchEvent.MODULE, new c.a.r0.a.h0.o.j.a());
        }
    }

    public static synchronized void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            synchronized (h.class) {
                HybridUbcFlow b2 = f().b(str);
                if (b2 != null) {
                    f().e(str2).z(b2);
                    r(str);
                }
            }
        }
    }

    public static void i(c.a.r0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, bVar, z) == null) {
            c.a.r0.a.e0.d.k("SwanAppPerformanceUBC", "recordForStartup");
            if (bVar == null || bVar.P() == null) {
                return;
            }
            q.j(new b(bVar, c(bVar), z), "recordFromLaunchInfo");
        }
    }

    public static void j(c.a.r0.a.f1.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, bVar, z) == null) {
            c.a.r0.a.d2.d.L().post(new a(bVar, z));
        }
    }

    public static synchronized void k(c.a.r0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            synchronized (h.class) {
                HybridUbcFlow m = m();
                if (m != null) {
                    m.E("value", SmsLoginView.f.l);
                    if (aVar != null) {
                        m.D(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, String.valueOf(aVar.a()));
                        m.D("launchid", c.a.r0.a.d2.d.J().r().V().V());
                    }
                    m.n();
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
                    if (str.equals("main")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            p(NodeJS.STARTUP_SCRIPT_NAME).D("package_type", c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "-1" : "3" : "1" : "2" : "0");
        }
    }

    public static synchronized HybridUbcFlow m() {
        InterceptResult invokeV;
        c.a.r0.a.h0.g.f o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (h.class) {
                t();
                c.a.r0.a.y0.k.f.b.a();
                HybridUbcFlow d2 = d(NodeJS.STARTUP_SCRIPT_NAME);
                c.a.r0.a.p.e.b bVar = null;
                if (d2 == null) {
                    return null;
                }
                d2.F(new UbcFlowEvent("performanceEnd"));
                if (!d2.s()) {
                    d2.A();
                }
                c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
                if (V != null && (o = V.o()) != null) {
                    bVar = o.i3();
                }
                d2.C(bVar);
                if (!d2.x()) {
                    d2.T();
                }
                if (!d2.w()) {
                    d2.S();
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
            f9548b = timer;
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
                p = p(NodeJS.STARTUP_SCRIPT_NAME);
            }
            return p;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public static void onEvent(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dVar) == null) {
            if (a) {
                String str = "onEvent " + dVar;
            }
            c.a.r0.a.n2.b.k(dVar.f9556k, dVar.f());
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
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (timer = f9548b) == null) {
            return;
        }
        timer.cancel();
        f9548b = null;
    }
}
