package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.v.b.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aTT = new HashSet();

    static {
        aTT.add("_baiduboxapp");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01dc  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONException e;
        String str;
        JSONObject optJSONObject;
        String str2 = null;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String g = g(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "mAppId: " + g);
        }
        if (TextUtils.isEmpty(g)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(1L).aa(1L).ig("appId is empty");
            e.OZ().b(ig);
            com.baidu.swan.apps.statistic.e.b(new d().hv(com.baidu.swan.apps.statistic.e.dP(0)).a(ig).aC("scheme", uri.toString()));
            return true;
        }
        String b = b(g, uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "pagePath: " + b);
        }
        String h = h(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "query: " + h);
        }
        c cVar = new c();
        cVar.mAppId = g;
        cVar.azw = uri.toString();
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(h)) {
            cVar.azs = b + "?" + h;
        } else if (!TextUtils.isEmpty(b)) {
            cVar.azs = b;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(IntentConfig.START, valueOf, ""));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        cVar.aj("ext_stats_funnel_start", valueOf);
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                cVar.mFrom = jSONObject.optString("from");
                optJSONObject = jSONObject.optJSONObject("ext");
                cVar.aj("srcAppId", jSONObject.optString("srcAppId"));
                cVar.aj("extraData", jSONObject.optString("extraData"));
                cVar.aj("srcAppPage", jSONObject.optString("srcAppPage"));
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            if (optJSONObject != null) {
                str = optJSONObject.optString("searchid");
                try {
                    str2 = optJSONObject.optString("url");
                    cVar.azv = optJSONObject.optString("clkid");
                } catch (JSONException e3) {
                    e = e3;
                    if (DEBUG) {
                        Log.d("SwanAppLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    cVar.Fu().putString("search_id", str);
                    cVar.Fu().putString("search_url", str2);
                    cVar.Fu().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                    cVar.aj("ext_stats_funnel_scheme", valueOf2);
                    if (DEBUG) {
                    }
                    com.baidu.swan.apps.an.b.h(context, c.c(context, cVar));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                if (TextUtils.isEmpty(str) || TextUtils.equals("1002", cVar.mFrom)) {
                    cVar.Fu().putString("search_id", str);
                    cVar.Fu().putString("search_url", str2);
                    cVar.Fu().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                }
                String valueOf22 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf22, ""));
                cVar.aj("ext_stats_funnel_scheme", valueOf22);
                if (DEBUG) {
                    Log.d("SwanAppLaunchInterceptor", "launchParams: " + cVar);
                }
                com.baidu.swan.apps.an.b.h(context, c.c(context, cVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        cVar.Fu().putString("search_id", str);
        cVar.Fu().putString("search_url", str2);
        cVar.Fu().putLong("search_dom_click_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.search.b.f(cVar);
        String valueOf222 = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf222, ""));
        cVar.aj("ext_stats_funnel_scheme", valueOf222);
        if (DEBUG) {
        }
        com.baidu.swan.apps.an.b.h(context, c.c(context, cVar));
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private String g(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    private String b(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        return substring.replaceAll("/+", "/");
    }

    private String h(Uri uri) {
        return aa.d(uri.getEncodedQuery(), aTT);
    }
}
