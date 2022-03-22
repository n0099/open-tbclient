package c.a.n0.a.v1.g;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import c.a.n0.a.d2.n;
import c.a.n0.a.k1.h;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import c.a.n0.a.v0.e.c;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class a extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6925b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.v1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0505a implements c.a.n0.q.e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Uri f6926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6927c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6928d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6929e;

        public C0505a(a aVar, String str, Uri uri, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, uri, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6929e = aVar;
            this.a = str;
            this.f6926b = uri;
            this.f6927c = str2;
            this.f6928d = unitedSchemeEntity;
        }

        @Override // c.a.n0.q.e.c
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null) {
                return;
            }
            this.f6929e.e(this.f6926b, map.get(this.a), this.f6927c, this.f6928d);
        }

        @Override // c.a.n0.q.e.c
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && a.a) {
                Log.e("SwanLaunchInterceptor", "getOpenBundleId", exc);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(397482017, "Lc/a/n0/a/v1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(397482017, "Lc/a/n0/a/v1/g/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        HashSet hashSet = new HashSet();
        f6925b = hashSet;
        hashSet.add("_baiduboxapp");
        f6925b.add(WebChromeClient.KEY_ARG_CALLBACK);
        f6925b.add("upgrade");
        f6925b.add("_naExtParams");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            if (uri == null) {
                return "";
            }
            HashSet hashSet = new HashSet();
            hashSet.add("_naExtParams");
            return o0.m(uri, hashSet);
        }
        return (String) invokeL.objValue;
    }

    public final String d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) ? o0.i(uri.getEncodedQuery(), f6925b) : (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Uri uri, String str, String str2, UnitedSchemeEntity unitedSchemeEntity) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, str, str2, unitedSchemeEntity) == null) {
            String d2 = d(uri);
            if (a) {
                Log.d("SwanLaunchInterceptor", "query: " + d2);
            }
            String n = o0.n(str, uri, true);
            if (a) {
                Log.d("SwanLaunchInterceptor", "pagePath: " + n);
            }
            String h2 = SwanLauncher.h();
            d.J().r().V().J0(h2);
            String uri2 = uri.toString();
            String queryParameter = uri.getQueryParameter("_naExtParams");
            if (!TextUtils.isEmpty(queryParameter)) {
                uri2 = c(uri);
            }
            c.a aVar = (c.a) ((c.a) ((c.a) new c.a().v0(str)).K0(uri2)).J0(h2);
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2)) {
                aVar.R0(n + "?" + d2);
            } else if (!TextUtils.isEmpty(n)) {
                aVar.R0(n);
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = "_naExtParams";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    long nanoTime = a ? System.nanoTime() : 0L;
                    c.a.n0.a.b2.c.h(jSONObject, str);
                    if (a) {
                        Log.d("SwanLaunchInterceptor", "SwanAppStabilityConfig#parseConfig 耗时(ns): " + (System.nanoTime() - nanoTime));
                    }
                    aVar.I0(jSONObject.optString("from"));
                    aVar.P0(jSONObject.optString("notinhis"));
                    aVar.X0(jSONObject.optString("subscribeWithoutClick"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                    aVar.r0("srcAppId", jSONObject.optString("srcAppId"));
                    if (e.a0() != null) {
                        String N = e.a0().N();
                        aVar.r0("srcAppKey", N);
                        int type = e.a0().V().getType();
                        str3 = "_naExtParams";
                        try {
                            aVar.q0("srcPkgType", type);
                            if (a) {
                                Log.d("SwanLaunchInterceptor", "srcAppKey = " + N + "  ,srcPkgType = " + type);
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (a) {
                                Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                            }
                            aVar.z("tool_ip", unitedSchemeEntity.getParam("tip"));
                            aVar.z("tool_port", unitedSchemeEntity.getParam("tport"));
                            aVar.z("projectId", unitedSchemeEntity.getParam("projectId"));
                            aVar.z("fromHost", unitedSchemeEntity.getParam("fromHost"));
                            aVar.z("spuId", unitedSchemeEntity.getParam("spuId"));
                            aVar.z("contentId", unitedSchemeEntity.getParam("contentId"));
                            Bundle bundle = null;
                            if (!TextUtils.isEmpty(queryParameter)) {
                            }
                            if (a) {
                            }
                            SwanLauncher.j().n(aVar, bundle);
                        }
                    } else {
                        str3 = "_naExtParams";
                    }
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    aVar.r0("srcAppPage", jSONObject.optString("srcAppPage"));
                    JSONObject b2 = c.a.n0.w.c.b(aVar.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                    if (b2 != null) {
                        aVar.r0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                    }
                    if (optJSONObject != null) {
                        aVar.y0(optJSONObject.optString("clkid"));
                        aVar.r0("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.r0(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar.q0("click_time", optJSONObject.optLong("click", -1L));
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong(LaunchedTaskSpeedStats.KEY_START_TIME);
                        if (optLong > 0) {
                            aVar.x("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = "_naExtParams";
                }
            }
            aVar.z("tool_ip", unitedSchemeEntity.getParam("tip"));
            aVar.z("tool_port", unitedSchemeEntity.getParam("tport"));
            aVar.z("projectId", unitedSchemeEntity.getParam("projectId"));
            aVar.z("fromHost", unitedSchemeEntity.getParam("fromHost"));
            aVar.z("spuId", unitedSchemeEntity.getParam("spuId"));
            aVar.z("contentId", unitedSchemeEntity.getParam("contentId"));
            Bundle bundle2 = null;
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle2 = new Bundle();
                bundle2.putString(str3, queryParameter);
            }
            if (a) {
                Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
            }
            SwanLauncher.j().n(aVar, bundle2);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "aiapps_launch_interceptor" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String j = o0.j(uri);
            if (a) {
                Log.d("SwanLaunchInterceptor", "mAppId: " + j);
            }
            if (TextUtils.isEmpty(j)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(1L);
                aVar.i(1L);
                aVar.f("appId is empty");
                c.a.n0.a.k2.e.a().f(aVar);
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.q(n.n(0));
                dVar.p(aVar);
                dVar.l("scheme", uri.toString());
                n.R(dVar);
                h.k(aVar);
                return true;
            }
            c.a.n0.u.n.f().b(5000);
            String uri2 = uri.toString();
            c.a.n0.a.u.d.i("SwanLaunchInterceptor", "launch scheme = " + uri2);
            String param = unitedSchemeEntity.getParam("_baiduboxapp");
            String str = null;
            if (!TextUtils.isEmpty(param)) {
                try {
                    str = new JSONObject(param).optString("navi");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            String str2 = str;
            if (c.a.n0.q.j.j.b.e().g(!q0.G()) && TextUtils.equals(str2, "naviTo")) {
                if (!PMSConstants.a(c.a.n0.q.c.b())) {
                    c.a.n0.a.u.d.c("SwanLaunchInterceptor", "STOP :: Not Support BDTLS");
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(j);
                c.a.n0.q.b.e(arrayList, d.J().r().N(), new C0505a(this, j, uri, param, unitedSchemeEntity));
            } else {
                e(uri, j, param, unitedSchemeEntity);
            }
            c.a.n0.a.v0.a.n(str2, j, callbackHandler, unitedSchemeEntity, unitedSchemeEntity.getParam("cb"));
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
