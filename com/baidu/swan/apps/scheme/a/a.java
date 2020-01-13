package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.c;
import com.baidu.webkit.internal.ETAG;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bOf = new HashSet();

    static {
        bOf.add("_baiduboxapp");
        bOf.add(BuyTBeanActivityConfig.CALLBACK);
        bOf.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        bOf.add("_naExtParams");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0252  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String optString;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String g = ag.g(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "mAppId: " + g);
        }
        if (TextUtils.isEmpty(g)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(1L).aF(1L).mk("appId is empty");
            e.adY().f(mk);
            f.b(new d().ly(f.gb(0)).e(mk).bf(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            return true;
        }
        String b = b(g, uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "pagePath: " + b);
        }
        String d = d(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "query: " + d);
        }
        String uri2 = uri.toString();
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) new c.a().ij(g)).in(!TextUtils.isEmpty(queryParameter) ? e(uri) : uri2);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(d)) {
            aVar.io(b + "?" + d);
        } else if (!TextUtils.isEmpty(b)) {
            aVar.io(b);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.im(jSONObject.optString("from"));
                aVar.iq(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.aH("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.aH("extraData", jSONObject.optString("extraData"));
                }
                aVar.aH("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a = com.baidu.swan.d.b.a(aVar.Tt(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.aH("ubc", a.toString());
                }
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(ETAG.KEY_SEARCH_ID);
                    try {
                        optString = optJSONObject.optString("url");
                    } catch (JSONException e) {
                        str = optString2;
                        e = e;
                    }
                    try {
                        aVar.ip(optJSONObject.optString("clkid"));
                        aVar.aH("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.aH("third_ext", optJSONObject.optString("third_ext"));
                        str2 = optString;
                        str = optString2;
                    } catch (JSONException e2) {
                        str2 = optString;
                        str = optString2;
                        e = e2;
                        if (DEBUG) {
                            Log.d("SwanAppLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        aVar.Tz().putString("search_id", str);
                        aVar.Tz().putString("search_url", str2);
                        aVar.Tz().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        com.baidu.swan.apps.statistic.search.b.e(aVar);
                        Bundle bundle = null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        if (DEBUG) {
                        }
                        SwanLauncher.Pq().a(aVar, bundle);
                        com.baidu.swan.apps.x.a.a(str3, g, callbackHandler, unitedSchemeEntity);
                        return true;
                    }
                }
                String optString3 = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString3)) {
                    long optLong = new JSONObject(optString3).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.j("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e3) {
                e = e3;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.Tt())) {
            aVar.Tz().putString("search_id", str);
            aVar.Tz().putString("search_url", str2);
            aVar.Tz().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        Bundle bundle2 = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle2 = new Bundle();
            bundle2.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        SwanLauncher.Pq().a(aVar, bundle2);
        com.baidu.swan.apps.x.a.a(str3, g, callbackHandler, unitedSchemeEntity);
        return true;
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

    private String d(Uri uri) {
        return ag.deleteQueryParam(uri.getEncodedQuery(), bOf);
    }

    private String e(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return ag.a(uri, hashSet);
    }
}
