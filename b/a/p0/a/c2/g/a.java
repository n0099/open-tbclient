package b.a.p0.a.c2.g;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.a2.d;
import b.a.p0.a.f1.e.c;
import b.a.p0.a.k;
import b.a.p0.a.q2.e;
import b.a.p0.a.r1.h;
import b.a.p0.a.v2.o0;
import b.a.p0.r.n;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class a extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4512a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f4513b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1512110028, "Lb/a/p0/a/c2/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1512110028, "Lb/a/p0/a/c2/g/a;");
                return;
            }
        }
        f4512a = k.f6397a;
        HashSet hashSet = new HashSet();
        f4513b = hashSet;
        hashSet.add("_baiduboxapp");
        f4513b.add("callback");
        f4513b.add("upgrade");
        f4513b.add("_naExtParams");
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

    public final String a(Uri uri) {
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

    public final String b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) ? o0.i(uri.getEncodedQuery(), f4513b) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "aiapps_launch_interceptor" : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026a  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        String str;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String j = o0.j(uri);
            if (f4512a) {
                String str2 = "mAppId: " + j;
            }
            String h2 = SwanLauncher.h();
            d.g().r().K().H0(h2);
            if (TextUtils.isEmpty(j)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(1L);
                aVar.h(1L);
                aVar.e("appId is empty");
                e.a().f(aVar);
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.q(b.a.p0.a.j2.k.m(0));
                dVar.p(aVar);
                dVar.l("scheme", uri.toString());
                b.a.p0.a.j2.k.L(dVar);
                h.k(aVar);
                return true;
            }
            String n = o0.n(j, uri, true);
            if (f4512a) {
                String str3 = "pagePath: " + n;
            }
            String b2 = b(uri);
            if (f4512a) {
                String str4 = "query: " + b2;
            }
            b.a.p0.a.c1.a.g0().b(b.a.p0.a.r1.l.e.o());
            n.f().b(b.a.p0.a.r1.l.e.f());
            String uri2 = uri.toString();
            b.a.p0.a.e0.d.g("SwanLaunchInterceptor", "launch scheme = " + uri2);
            String queryParameter = uri.getQueryParameter("_naExtParams");
            if (!TextUtils.isEmpty(queryParameter)) {
                uri2 = a(uri);
            }
            c.a aVar2 = (c.a) ((c.a) ((c.a) new c.a().t0(j)).I0(uri2)).H0(h2);
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(b2)) {
                aVar2.P0(n + "?" + b2);
            } else if (!TextUtils.isEmpty(n)) {
                aVar2.P0(n);
            }
            String param = unitedSchemeEntity.getParam("_baiduboxapp");
            if (TextUtils.isEmpty(param)) {
                str = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(param);
                    aVar2.G0(jSONObject.optString("from"));
                    aVar2.N0(jSONObject.optString("notinhis"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                    str = jSONObject.optString("navi");
                    try {
                        aVar2.p0("srcAppId", jSONObject.optString("srcAppId"));
                        if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                            aVar2.p0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                        }
                        aVar2.p0("srcAppPage", jSONObject.optString("srcAppPage"));
                        JSONObject b3 = b.a.p0.t.c.b(aVar2.S(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                        if (b3 != null) {
                            aVar2.p0(UBCCloudControlProcessor.UBC_KEY, b3.toString());
                        }
                        if (optJSONObject != null) {
                            aVar2.w0(optJSONObject.optString("clkid"));
                            aVar2.p0("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                            aVar2.p0(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                            aVar2.o0("click_time", optJSONObject.optLong(PrefetchEvent.STATE_CLICK, -1L));
                        }
                        String optString = jSONObject.optString("veloce");
                        if (!TextUtils.isEmpty(optString)) {
                            long optLong = new JSONObject(optString).optLong(LaunchedTaskSpeedStats.KEY_START_TIME);
                            if (optLong > 0) {
                                aVar2.w("veloce_start_time", optLong);
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        if (f4512a) {
                            String str5 = "getLaunchFrom failed: " + Log.getStackTraceString(e);
                        }
                        aVar2.y("tool_ip", unitedSchemeEntity.getParam("tip"));
                        aVar2.y("tool_port", unitedSchemeEntity.getParam("tport"));
                        aVar2.y("projectId", unitedSchemeEntity.getParam("projectId"));
                        aVar2.y("fromHost", unitedSchemeEntity.getParam("fromHost"));
                        aVar2.y("spuId", unitedSchemeEntity.getParam("spuId"));
                        aVar2.y("contentId", unitedSchemeEntity.getParam("contentId"));
                        if (TextUtils.isEmpty(queryParameter)) {
                        }
                        if (f4512a) {
                        }
                        String param2 = unitedSchemeEntity.getParam("cb");
                        SwanLauncher.j().n(aVar2, bundle);
                        b.a.p0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param2);
                        return true;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = null;
                }
            }
            aVar2.y("tool_ip", unitedSchemeEntity.getParam("tip"));
            aVar2.y("tool_port", unitedSchemeEntity.getParam("tport"));
            aVar2.y("projectId", unitedSchemeEntity.getParam("projectId"));
            aVar2.y("fromHost", unitedSchemeEntity.getParam("fromHost"));
            aVar2.y("spuId", unitedSchemeEntity.getParam("spuId"));
            aVar2.y("contentId", unitedSchemeEntity.getParam("contentId"));
            if (TextUtils.isEmpty(queryParameter)) {
                bundle = new Bundle();
                bundle.putString("_naExtParams", queryParameter);
            } else {
                bundle = null;
            }
            if (f4512a) {
                String str6 = "launchParams: " + aVar2 + " \n_naExtParmas: " + queryParameter;
            }
            String param22 = unitedSchemeEntity.getParam("cb");
            SwanLauncher.j().n(aVar2, bundle);
            b.a.p0.a.f1.a.l(str, j, callbackHandler, unitedSchemeEntity, param22);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
