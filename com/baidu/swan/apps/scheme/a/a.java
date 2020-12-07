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
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.c;
import com.baidu.webkit.internal.ETAG;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> dCd = new HashSet();

    static {
        dCd.add("_baiduboxapp");
        dCd.add(BuyTBeanActivityConfig.CALLBACK);
        dCd.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        dCd.add("_naExtParams");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02f3  */
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
        String j = ai.j(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + j);
        }
        String avM = SwanLauncher.avM();
        d.aJQ().aJM().aJY().qb(avM);
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(1L).cV(1L).uC("appId is empty");
            e.aOs().j(uC);
            h.b(new com.baidu.swan.apps.statistic.a.d().tK(h.kS(0)).i(uC).cE("scheme", uri.toString()));
            i.d(uC);
            return true;
        }
        String a2 = ai.a(j, uri, true);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + a2);
        }
        String e = e(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "query: " + e);
        }
        String uri2 = uri.toString();
        com.baidu.swan.apps.console.c.i("SwanLaunchInterceptor", "launch scheme = " + uri2);
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().pR(j)).pV(!TextUtils.isEmpty(queryParameter) ? f(uri) : uri2)).qb(avM);
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(e)) {
            aVar.pW(a2 + "?" + e);
        } else if (!TextUtils.isEmpty(a2)) {
            aVar.pW(a2);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.pU(jSONObject.optString("from"));
                aVar.pY(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.ca("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.ca("extraData", jSONObject.optString("extraData"));
                }
                aVar.ca("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a3 = com.baidu.swan.c.c.a(aVar.aBe(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a3 != null) {
                    aVar.ca("ubc", a3.toString());
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
                        aVar.pX(optJSONObject.optString("clkid"));
                        aVar.ca("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.ca(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar.o("click_time", optJSONObject.optLong("click", -1L));
                        str2 = optString;
                        str = optString2;
                    } catch (JSONException e3) {
                        str2 = optString;
                        str = optString2;
                        e = e3;
                        if (DEBUG) {
                            Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        aVar.aBk().putString("search_id", str);
                        aVar.aBk().putString("search_url", str2);
                        aVar.aBk().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        com.baidu.swan.apps.statistic.search.b.e(aVar);
                        aVar.cb("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
                        aVar.cb("tool_port", unitedSchemeEntity.getParam("tport"));
                        aVar.cb("projectId", unitedSchemeEntity.getParam("projectId"));
                        aVar.cb("fromHost", unitedSchemeEntity.getParam("fromHost"));
                        aVar.cb("spuId", unitedSchemeEntity.getParam("spuId"));
                        aVar.cb("contentId", unitedSchemeEntity.getParam("contentId"));
                        Bundle bundle = null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        if (DEBUG) {
                        }
                        String param2 = unitedSchemeEntity.getParam("cb");
                        SwanLauncher.avL().a(aVar, bundle);
                        com.baidu.swan.apps.u.a.a(str3, j, callbackHandler, unitedSchemeEntity, param2);
                        return true;
                    }
                }
                String optString3 = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString3)) {
                    long optLong = new JSONObject(optString3).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.p("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e4) {
                e = e4;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.aBe())) {
            aVar.aBk().putString("search_id", str);
            aVar.aBk().putString("search_url", str2);
            aVar.aBk().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        aVar.cb("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
        aVar.cb("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar.cb("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar.cb("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar.cb("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar.cb("contentId", unitedSchemeEntity.getParam("contentId"));
        Bundle bundle2 = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle2 = new Bundle();
            bundle2.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        String param22 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.avL().a(aVar, bundle2);
        com.baidu.swan.apps.u.a.a(str3, j, callbackHandler, unitedSchemeEntity, param22);
        return true;
    }

    private String e(Uri uri) {
        return ai.deleteQueryParam(uri.getEncodedQuery(), dCd);
    }

    private String f(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return ai.a(uri, hashSet);
    }
}
