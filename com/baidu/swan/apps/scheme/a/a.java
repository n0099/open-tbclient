package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
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
/* loaded from: classes11.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bSm = new HashSet();

    static {
        bSm.add("_baiduboxapp");
        bSm.add(BuyTBeanActivityConfig.CALLBACK);
        bSm.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        bSm.add("_naExtParams");
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
        String h = ag.h(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "mAppId: " + h);
        }
        if (TextUtils.isEmpty(h)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).mz("appId is empty");
            e.ago().f(mz);
            f.b(new d().lN(f.gs(0)).e(mz).bo(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            return true;
        }
        String b = b(h, uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "pagePath: " + b);
        }
        String e = e(uri);
        if (DEBUG) {
            Log.d("SwanAppLaunchInterceptor", "query: " + e);
        }
        String uri2 = uri.toString();
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) new c.a().iy(h)).iC(!TextUtils.isEmpty(queryParameter) ? f(uri) : uri2);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(e)) {
            aVar.iD(b + "?" + e);
        } else if (!TextUtils.isEmpty(b)) {
            aVar.iD(b);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.iB(jSONObject.optString("from"));
                aVar.iF(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.aR("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.aR("extraData", jSONObject.optString("extraData"));
                }
                aVar.aR("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a = com.baidu.swan.d.b.a(aVar.VJ(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.aR("ubc", a.toString());
                }
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(ETAG.KEY_SEARCH_ID);
                    try {
                        optString = optJSONObject.optString("url");
                    } catch (JSONException e2) {
                        str = optString2;
                        e = e2;
                    }
                    try {
                        aVar.iE(optJSONObject.optString("clkid"));
                        aVar.aR("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.aR(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        str2 = optString;
                        str = optString2;
                    } catch (JSONException e3) {
                        str2 = optString;
                        str = optString2;
                        e = e3;
                        if (DEBUG) {
                            Log.d("SwanAppLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        aVar.VP().putString("search_id", str);
                        aVar.VP().putString("search_url", str2);
                        aVar.VP().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        com.baidu.swan.apps.statistic.search.b.e(aVar);
                        Bundle bundle = null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        if (DEBUG) {
                        }
                        SwanLauncher.RG().a(aVar, bundle);
                        com.baidu.swan.apps.x.a.a(str3, h, callbackHandler, unitedSchemeEntity);
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
            } catch (JSONException e4) {
                e = e4;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.VJ())) {
            aVar.VP().putString("search_id", str);
            aVar.VP().putString("search_url", str2);
            aVar.VP().putLong("search_dom_click_timestamp", System.currentTimeMillis());
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
        SwanLauncher.RG().a(aVar, bundle2);
        com.baidu.swan.apps.x.a.a(str3, h, callbackHandler, unitedSchemeEntity);
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

    private String e(Uri uri) {
        return ag.deleteQueryParam(uri.getEncodedQuery(), bSm);
    }

    private String f(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return ag.a(uri, hashSet);
    }
}
