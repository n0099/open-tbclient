package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.v.b.c;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bnv = new HashSet();

    static {
        bnv.add("_baiduboxapp");
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
        String e2 = e(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "mAppId: " + e2);
        }
        if (TextUtils.isEmpty(e2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(1L).at(1L).iL("appId is empty");
            e.TT().b(iL);
            com.baidu.swan.apps.statistic.e.b(new d().ia(com.baidu.swan.apps.statistic.e.eL(0)).a(iL).aK("scheme", uri.toString()));
            return true;
        }
        String b = b(e2, uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "pagePath: " + b);
        }
        String f = f(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "query: " + f);
        }
        c cVar = new c();
        cVar.mAppId = e2;
        cVar.aTi = uri.toString();
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(f)) {
            cVar.aTe = b + "?" + f;
        } else if (!TextUtils.isEmpty(b)) {
            cVar.aTe = b;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("start", valueOf, ""));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        cVar.ar("ext_stats_funnel_start", valueOf);
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                cVar.mFrom = jSONObject.optString("from");
                optJSONObject = jSONObject.optJSONObject("ext");
                cVar.ar("srcAppId", jSONObject.optString("srcAppId"));
                cVar.ar("extraData", jSONObject.optString("extraData"));
                cVar.ar("srcAppPage", jSONObject.optString("srcAppPage"));
            } catch (JSONException e3) {
                e = e3;
                str = null;
            }
            if (optJSONObject != null) {
                str = optJSONObject.optString("searchid");
                try {
                    str2 = optJSONObject.optString("url");
                    cVar.aTh = optJSONObject.optString("clkid");
                } catch (JSONException e4) {
                    e = e4;
                    if (DEBUG) {
                        Log.d("SwanAppLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    cVar.Ks().putString("search_id", str);
                    cVar.Ks().putString("search_url", str2);
                    cVar.Ks().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf2, ""));
                    cVar.ar("ext_stats_funnel_scheme", valueOf2);
                    if (DEBUG) {
                    }
                    com.baidu.swan.apps.an.b.e(context, c.c(context, cVar));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, cVar.mFrom)) {
                    cVar.Ks().putString("search_id", str);
                    cVar.Ks().putString("search_url", str2);
                    cVar.Ks().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                    com.baidu.swan.apps.statistic.search.b.f(cVar);
                }
                String valueOf22 = String.valueOf(System.currentTimeMillis());
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf22, ""));
                cVar.ar("ext_stats_funnel_scheme", valueOf22);
                if (DEBUG) {
                    Log.d("SwanAppLaunchInterceptor", "launchParams: " + cVar);
                }
                com.baidu.swan.apps.an.b.e(context, c.c(context, cVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        cVar.Ks().putString("search_id", str);
        cVar.Ks().putString("search_url", str2);
        cVar.Ks().putLong("search_dom_click_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.search.b.f(cVar);
        String valueOf222 = String.valueOf(System.currentTimeMillis());
        com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("scheme", valueOf222, ""));
        cVar.ar("ext_stats_funnel_scheme", valueOf222);
        if (DEBUG) {
        }
        com.baidu.swan.apps.an.b.e(context, c.c(context, cVar));
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private String e(Uri uri) {
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

    private String f(Uri uri) {
        return aa.d(uri.getEncodedQuery(), bnv);
    }
}
