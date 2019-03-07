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
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = c.DEBUG;
    private static final Set<String> aQq = new HashSet();

    static {
        aQq.add("_baiduboxapp");
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
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("appId is empty");
            e.LG().b(hw);
            com.baidu.swan.apps.statistic.c.a(new d().gR(com.baidu.swan.apps.statistic.c.dC(0)).a(hw).aA("scheme", uri.toString()));
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
        com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
        cVar.mAppId = g;
        cVar.axG = uri.toString();
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(h)) {
            cVar.axH = b + "?" + h;
        } else if (!TextUtils.isEmpty(b)) {
            cVar.axH = b;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(IntentConfig.START, valueOf, ""));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        cVar.al("ext_stats_funnel_start", valueOf);
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                cVar.mFrom = jSONObject.optString("from");
                optJSONObject = jSONObject.optJSONObject("ext");
                cVar.al("srcAppId", jSONObject.optString("srcAppId"));
                cVar.al("extraData", jSONObject.optString("extraData"));
                cVar.al("srcAppPage", jSONObject.optString("srcAppPage"));
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            if (optJSONObject != null) {
                str = optJSONObject.optString("searchid");
                try {
                    str2 = optJSONObject.optString("url");
                    cVar.axQ = optJSONObject.optString("clkid");
                } catch (JSONException e3) {
                    e = e3;
                    if (DEBUG) {
                        Log.d("SwanAppLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    cVar.DC().putString("search_id", str);
                    cVar.DC().putString("search_url", str2);
                    cVar.DC().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                    cVar.al("ext_stats_funnel_scheme", valueOf2);
                    if (DEBUG) {
                    }
                    com.baidu.swan.apps.an.b.h(context, com.baidu.swan.apps.v.b.c.c(context, cVar));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                if (TextUtils.isEmpty(str) || TextUtils.equals("1002", cVar.mFrom)) {
                    cVar.DC().putString("search_id", str);
                    cVar.DC().putString("search_url", str2);
                    cVar.DC().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                }
                String valueOf22 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf22, ""));
                cVar.al("ext_stats_funnel_scheme", valueOf22);
                if (DEBUG) {
                    Log.d("SwanAppLaunchInterceptor", "launchParams: " + cVar);
                }
                com.baidu.swan.apps.an.b.h(context, com.baidu.swan.apps.v.b.c.c(context, cVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        cVar.DC().putString("search_id", str);
        cVar.DC().putString("search_url", str2);
        cVar.DC().putLong("search_dom_click_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.search.b.f(cVar);
        String valueOf222 = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf222, ""));
        cVar.al("ext_stats_funnel_scheme", valueOf222);
        if (DEBUG) {
        }
        com.baidu.swan.apps.an.b.h(context, com.baidu.swan.apps.v.b.c.c(context, cVar));
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
        return y.c(uri.getEncodedQuery(), aQq);
    }
}
