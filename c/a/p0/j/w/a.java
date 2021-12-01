package c.a.p0.j.w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.a1.d;
import c.a.p0.a.c2.b.f.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.k;
import c.a.p0.a.n2.n;
import c.a.p0.a.z2.o0;
import c.a.p0.a.z2.q0;
import c.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class a extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f10489b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.j.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0683a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10490b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10491c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10492d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10493e;

        /* renamed from: c.a.p0.j.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0684a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0683a f10494e;

            public RunnableC0684a(C0683a c0683a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0683a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10494e = c0683a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e.g(this.f10494e.a, "小游戏包下载成功").G();
                }
            }
        }

        /* renamed from: c.a.p0.j.w.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements c.a.p0.a.a1.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0683a a;

            public b(C0683a c0683a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0683a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0683a;
            }

            @Override // c.a.p0.a.a1.b
            public void a(int i2, c.a.p0.a.a1.a aVar) {
                c.a.p0.j.d0.a.a aVar2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                    a.c cVar = (a.c) aVar;
                    if (i2 != 0 || cVar == null || (aVar2 = cVar.f10468c) == null) {
                        return;
                    }
                    this.a.f10490b.Q0(aVar2.f10141b);
                    C0683a c0683a = this.a;
                    Intent g1 = c.g1(c0683a.a, c0683a.f10490b);
                    g1.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
                    g1.setFlags(268435456);
                    this.a.a.startActivity(g1);
                    C0683a c0683a2 = this.a;
                    UnitedSchemeUtility.callCallback(c0683a2.f10491c, c0683a2.f10492d, UnitedSchemeUtility.wrapCallbackParams(0));
                }
            }
        }

        public C0683a(a aVar, Context context, c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, cVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10493e = aVar;
            this.a = context;
            this.f10490b = cVar;
            this.f10491c = callbackHandler;
            this.f10492d = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.a1.d.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.a;
                c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                aVar.k(7L);
                aVar.i(9L);
                aVar.f("debug download pkg fail");
                c.a.p0.a.u2.e.a().f(aVar);
                c.a.p0.a.f1.d.a.e(this.a, aVar, 1, this.f10490b.H());
                this.f10492d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // c.a.p0.a.a1.d.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.p0.a.a1.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean unused = a.a;
                q0.e0(new RunnableC0684a(this));
                this.f10490b.a1("1.6.0");
                this.f10490b.A0(true);
                c.a.p0.a.f1.e.b d2 = this.f10493e.d(this.f10490b);
                if (d2 == null) {
                    return;
                }
                c.a.p0.j.t.a.c(d2, new b(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1100943968, "Lc/a/p0/j/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1100943968, "Lc/a/p0/j/w/a;");
                return;
            }
        }
        a = k.a;
        HashSet hashSet = new HashSet();
        f10489b = hashSet;
        hashSet.add("_baiduboxapp");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SuppressLint({"BDOfflineUrl"})
    public final b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a aVar = new b.a();
            aVar.B1("小程序测试");
            aVar.v0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
            aVar.O0(Color.parseColor("#FF308EF0"));
            aVar.I0("1230000000000000");
            aVar.y1("小程序简介");
            aVar.E1("测试服务类目");
            aVar.F1("测试主体信息");
            aVar.A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
            aVar.H1("1.0");
            aVar.C1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
            return aVar;
        }
        return (b) invokeV.objValue;
    }

    public final b d(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            b c2 = c();
            c2.v0(cVar.H());
            c2.I0(cVar.T());
            c2.R0(cVar.e0());
            c2.A0(cVar.n0());
            c2.y0(cVar.L());
            c2.D0(cVar.s0());
            c2.K0(cVar.W());
            c2.P0(cVar.c0());
            c2.Z0(cVar.j0());
            c2.C0(cVar.O());
            c2.a1(cVar.k0());
            c2.H1("0");
            c2.u0(cVar.G());
            return c2;
        }
        return (b) invokeL.objValue;
    }

    public final String e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                return null;
            }
            return pathSegments.get(0);
        }
        return (String) invokeL.objValue;
    }

    public final String f(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, uri)) == null) {
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            String substring = path.substring(str.length() + 1);
            return substring.endsWith(File.separator) ? substring.substring(0, substring.length() - 1) : substring;
        }
        return (String) invokeLL.objValue;
    }

    public final String g(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) ? o0.i(uri.getQuery(), f10489b) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "aigames_launch_interceptor" : (String) invokeV.objValue;
    }

    public final void h(c cVar, String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, cVar, str, context, unitedSchemeEntity, callbackHandler) == null) {
            d.C0167d c0167d = new d.C0167d();
            cVar.H();
            c0167d.a = str;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            c.a.p0.j.t.a.h(c0167d, new C0683a(this, applicationContext, cVar, callbackHandler, unitedSchemeEntity));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x018b  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        String str;
        String param;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String e2 = e(uri);
            if (a) {
                String str2 = "mAppId: " + e2;
            }
            if (TextUtils.isEmpty(e2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
                aVar.k(1L);
                aVar.i(1L);
                aVar.f("appId is empty");
                c.a.p0.a.u2.e.a().f(aVar);
                c.a.p0.a.n2.s.d dVar = new c.a.p0.a.n2.s.d();
                dVar.q(n.n(1));
                dVar.p(aVar);
                dVar.l("scheme", uri.toString());
                n.R(dVar);
                return true;
            }
            String f2 = f(e2, uri);
            if (a) {
                String str3 = "pagePath: " + f2;
            }
            String g2 = g(uri);
            if (a) {
                String str4 = "query: " + g2;
            }
            c.a aVar2 = (c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(e2)).K0(uri.toString())).u0(1)).G0(false);
            if (!TextUtils.isEmpty(f2)) {
                aVar2.R0(f2 + "?" + g2);
            }
            String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
            if (TextUtils.isEmpty(param2)) {
                str = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(param2);
                    aVar2.I0(jSONObject.optString("from"));
                    aVar2.P0(jSONObject.optString("notinhis"));
                    aVar2.r0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar2.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    str = jSONObject.optString("navi");
                    try {
                        JSONObject b2 = c.a.p0.w.c.b(aVar2.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                        if (b2 != null) {
                            aVar2.r0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                        }
                        String optString = jSONObject.optString("veloce");
                        if (!TextUtils.isEmpty(optString)) {
                            long optLong = new JSONObject(optString).optLong(LaunchedTaskSpeedStats.KEY_START_TIME);
                            if (optLong > 0) {
                                aVar2.x("veloce_start_time", optLong);
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        if (a) {
                            String str5 = "getLaunchFrom failed: " + Log.getStackTraceString(e);
                        }
                        if (a) {
                        }
                        param = unitedSchemeEntity.getParam(TTDownloadField.TT_DOWNLOAD_URL);
                        if (!c.a.p0.a.x1.a.a.x()) {
                        }
                        aVar2.G0(true);
                        h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
                        return true;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str = null;
                }
            }
            if (a) {
                String str6 = "launchParams: " + aVar2;
            }
            param = unitedSchemeEntity.getParam(TTDownloadField.TT_DOWNLOAD_URL);
            if ((!c.a.p0.a.x1.a.a.x() || a) && !TextUtils.isEmpty(param)) {
                aVar2.G0(true);
                h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            SwanLauncher.j().n(aVar2, null);
            c.a.p0.a.f1.a.n(str, e2, callbackHandler, unitedSchemeEntity, null);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
