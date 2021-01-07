package com.baidu.swan.apps.scheme.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.c;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.webkit.internal.ETAG;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> dKI = new HashSet();

    static {
        dKI.add("_baiduboxapp");
        dKI.add(BuyTBeanActivityConfig.CALLBACK);
        dKI.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        dKI.add("_naExtParams");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME)) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String l = ai.l(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + l);
        }
        String axf = SwanLauncher.axf();
        d.aMh().aMd().aMp().pU(axf);
        if (TextUtils.isEmpty(l)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).uz("appId is empty");
            e.aQK().j(uz);
            h.b(new com.baidu.swan.apps.statistic.a.d().tH(h.kX(0)).i(uz).cD("scheme", uri.toString()));
            i.d(uz);
            return true;
        }
        String a2 = ai.a(l, uri, true);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + a2);
        }
        String g = g(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "query: " + g);
        }
        String uri2 = uri.toString();
        com.baidu.swan.apps.console.c.i("SwanLaunchInterceptor", "launch scheme = " + uri2);
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pK(l)).pO(!TextUtils.isEmpty(queryParameter) ? h(uri) : uri2)).pU(axf);
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(g)) {
            aVar.pP(a2 + "?" + g);
        } else if (!TextUtils.isEmpty(a2)) {
            aVar.pP(a2);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.pN(jSONObject.optString("from"));
                aVar.pR(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.bZ("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bZ("extraData", jSONObject.optString("extraData"));
                }
                aVar.bZ("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a3 = com.baidu.swan.c.c.a(aVar.aCw(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a3 != null) {
                    aVar.bZ("ubc", a3.toString());
                }
                if (optJSONObject != null) {
                    str = optJSONObject.optString(ETAG.KEY_SEARCH_ID);
                    str2 = optJSONObject.optString("url");
                    aVar.pQ(optJSONObject.optString("clkid"));
                    aVar.bZ("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                    aVar.bZ(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                    aVar.o("click_time", optJSONObject.optLong("click", -1L));
                }
                String optString = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString)) {
                    long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.p("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                }
            }
        }
        if (!TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.aCw())) {
            aVar.aCC().putString("search_id", str);
            aVar.aCC().putString("search_url", str2);
            aVar.aCC().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        aVar.ca("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
        aVar.ca("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar.ca("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar.ca("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar.ca("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar.ca("contentId", unitedSchemeEntity.getParam("contentId"));
        Bundle bundle = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle = new Bundle();
            bundle.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        String param2 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.axe().a(aVar, bundle);
        com.baidu.swan.apps.u.a.a(str3, l, callbackHandler, unitedSchemeEntity, param2);
        return true;
    }

    private String g(Uri uri) {
        return ai.deleteQueryParam(uri.getEncodedQuery(), dKI);
    }

    private String h(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return ai.a(uri, hashSet);
    }
}
