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
/* loaded from: classes8.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> dJB = new HashSet();

    static {
        dJB.add("_baiduboxapp");
        dJB.add(BuyTBeanActivityConfig.CALLBACK);
        dJB.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        dJB.add("_naExtParams");
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
        String atM = SwanLauncher.atM();
        d.aIJ().aIF().aIR().pi(atM);
        if (TextUtils.isEmpty(l)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(1L).dc(1L).tO("appId is empty");
            e.aNm().j(tO);
            h.b(new com.baidu.swan.apps.statistic.a.d().sW(h.jv(0)).i(tO).cw("scheme", uri.toString()));
            i.d(tO);
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
        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().oY(l)).pc(!TextUtils.isEmpty(queryParameter) ? h(uri) : uri2)).pi(atM);
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(g)) {
            aVar.pd(a2 + "?" + g);
        } else if (!TextUtils.isEmpty(a2)) {
            aVar.pd(a2);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.pb(jSONObject.optString("from"));
                aVar.pf(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.bS("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bS("extraData", jSONObject.optString("extraData"));
                }
                aVar.bS("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a3 = com.baidu.swan.c.c.a(aVar.azd(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a3 != null) {
                    aVar.bS("ubc", a3.toString());
                }
                if (optJSONObject != null) {
                    str = optJSONObject.optString(ETAG.KEY_SEARCH_ID);
                    str2 = optJSONObject.optString("url");
                    aVar.pe(optJSONObject.optString("clkid"));
                    aVar.bS("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                    aVar.bS(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                    aVar.n("click_time", optJSONObject.optLong("click", -1L));
                }
                String optString = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString)) {
                    long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.o("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                }
            }
        }
        if (!TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.azd())) {
            aVar.azj().putString("search_id", str);
            aVar.azj().putString("search_url", str2);
            aVar.azj().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        aVar.bT("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
        aVar.bT("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar.bT("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar.bT("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar.bT("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar.bT("contentId", unitedSchemeEntity.getParam("contentId"));
        Bundle bundle = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle = new Bundle();
            bundle.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        String param2 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.atL().a(aVar, bundle);
        com.baidu.swan.apps.u.a.a(str3, l, callbackHandler, unitedSchemeEntity, param2);
        return true;
    }

    private String g(Uri uri) {
        return ai.deleteQueryParam(uri.getEncodedQuery(), dJB);
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
