package c.a.p0.h.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.a1.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.j2.p.d;
import c.a.p0.a.k;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.q0;
import c.a.p0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
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
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11570a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f11571b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.h.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0598a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f11572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f11574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f11575d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11576e;

        /* renamed from: c.a.p0.h.v.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0599a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0598a f11577e;

            public RunnableC0599a(C0598a c0598a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0598a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11577e = c0598a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.z1.b.f.e.g(this.f11577e.f11572a, "小游戏包下载成功").F();
                }
            }
        }

        /* renamed from: c.a.p0.h.v.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements c.a.p0.a.a1.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0598a f11578a;

            public b(C0598a c0598a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0598a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11578a = c0598a;
            }

            @Override // c.a.p0.a.a1.b
            public void a(int i2, c.a.p0.a.a1.a aVar) {
                c.a.p0.h.c0.a.a aVar2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                    a.c cVar = (a.c) aVar;
                    if (i2 != 0 || cVar == null || (aVar2 = cVar.f11542c) == null) {
                        return;
                    }
                    this.f11578a.f11573b.P0(aVar2.f11118b);
                    C0598a c0598a = this.f11578a;
                    Intent d1 = c.d1(c0598a.f11572a, c0598a.f11573b);
                    d1.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
                    d1.setFlags(268435456);
                    this.f11578a.f11572a.startActivity(d1);
                    C0598a c0598a2 = this.f11578a;
                    UnitedSchemeUtility.callCallback(c0598a2.f11574c, c0598a2.f11575d, UnitedSchemeUtility.wrapCallbackParams(0));
                }
            }
        }

        public C0598a(a aVar, Context context, c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f11576e = aVar;
            this.f11572a = context;
            this.f11573b = cVar;
            this.f11574c = callbackHandler;
            this.f11575d = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.f11570a;
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(7L);
                aVar.h(9L);
                aVar.e("debug download pkg fail");
                c.a.p0.a.q2.e.a().f(aVar);
                c.a.p0.a.f1.d.a.d(this.f11572a, aVar, 1, this.f11573b.H());
                this.f11575d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onProgressChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.p0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean unused = a.f11570a;
                q0.b0(new RunnableC0599a(this));
                this.f11573b.Y0("1.6.0");
                this.f11573b.z0(true);
                c.a.p0.a.f1.e.b d2 = this.f11576e.d(this.f11573b);
                if (d2 == null) {
                    return;
                }
                c.a.p0.h.s.a.c(d2, new b(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158232061, "Lc/a/p0/h/v/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158232061, "Lc/a/p0/h/v/a;");
                return;
            }
        }
        f11570a = k.f7077a;
        HashSet hashSet = new HashSet();
        f11571b = hashSet;
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
            aVar.A1("小程序测试");
            aVar.u0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
            aVar.N0(Color.parseColor("#FF308EF0"));
            aVar.H0("1230000000000000");
            aVar.x1("小程序简介");
            aVar.D1("测试服务类目");
            aVar.E1("测试主体信息");
            aVar.z1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
            aVar.G1("1.0");
            aVar.B1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
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
            c2.u0(cVar.H());
            c2.H0(cVar.T());
            c2.Q0(cVar.e0());
            c2.z0(cVar.m0());
            c2.x0(cVar.L());
            c2.C0(cVar.r0());
            c2.J0(cVar.W());
            c2.O0(cVar.c0());
            c2.X0(cVar.i0());
            c2.B0(cVar.O());
            c2.Y0(cVar.j0());
            c2.G1("0");
            c2.t0(cVar.G());
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) ? o0.i(uri.getQuery(), f11571b) : (String) invokeL.objValue;
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
            e.d dVar = new e.d();
            cVar.H();
            dVar.f4497a = str;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            c.a.p0.h.s.a.h(dVar, new C0598a(this, applicationContext, cVar, callbackHandler, unitedSchemeEntity));
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
            if (f11570a) {
                String str2 = "mAppId: " + e2;
            }
            if (TextUtils.isEmpty(e2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(1L);
                aVar.h(1L);
                aVar.e("appId is empty");
                c.a.p0.a.q2.e.a().f(aVar);
                d dVar = new d();
                dVar.q(c.a.p0.a.j2.k.m(1));
                dVar.p(aVar);
                dVar.l("scheme", uri.toString());
                c.a.p0.a.j2.k.L(dVar);
                return true;
            }
            String f2 = f(e2, uri);
            if (f11570a) {
                String str3 = "pagePath: " + f2;
            }
            String g2 = g(uri);
            if (f11570a) {
                String str4 = "query: " + g2;
            }
            c.a aVar2 = (c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(e2)).J0(uri.toString())).t0(1)).F0(false);
            if (!TextUtils.isEmpty(f2)) {
                aVar2.Q0(f2 + "?" + g2);
            }
            String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
            if (TextUtils.isEmpty(param2)) {
                str = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(param2);
                    aVar2.H0(jSONObject.optString("from"));
                    aVar2.O0(jSONObject.optString("notinhis"));
                    aVar2.q0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar2.q0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    str = jSONObject.optString("navi");
                    try {
                        JSONObject b2 = c.a.p0.t.c.b(aVar2.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                        if (b2 != null) {
                            aVar2.q0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                        }
                        String optString = jSONObject.optString("veloce");
                        if (!TextUtils.isEmpty(optString)) {
                            long optLong = new JSONObject(optString).optLong(LaunchedTaskSpeedStats.KEY_START_TIME);
                            if (optLong > 0) {
                                aVar2.w("veloce_start_time", optLong);
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        if (f11570a) {
                            String str5 = "getLaunchFrom failed: " + Log.getStackTraceString(e);
                        }
                        if (f11570a) {
                        }
                        param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                        if (!c.a.p0.a.u1.a.a.w()) {
                        }
                        aVar2.F0(true);
                        h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
                        return true;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str = null;
                }
            }
            if (f11570a) {
                String str6 = "launchParams: " + aVar2;
            }
            param = unitedSchemeEntity.getParam(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
            if ((!c.a.p0.a.u1.a.a.w() || f11570a) && !TextUtils.isEmpty(param)) {
                aVar2.F0(true);
                h(aVar2, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            SwanLauncher.j().n(aVar2, null);
            c.a.p0.a.f1.a.l(str, e2, callbackHandler, unitedSchemeEntity, null);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
