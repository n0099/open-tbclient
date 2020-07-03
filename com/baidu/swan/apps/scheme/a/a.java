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
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.c;
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
    public static final Set<String> cHX = new HashSet();

    static {
        cHX.add("_baiduboxapp");
        cHX.add(BuyTBeanActivityConfig.CALLBACK);
        cHX.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        cHX.add("_naExtParams");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02be  */
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
        String j = ah.j(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + j);
        }
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("appId is empty");
            e.atW().g(pB);
            h.b(new d().oK(h.hf(0)).f(pB).bU(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            g.a(pB);
            return true;
        }
        String b = b(j, uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + b);
        }
        String e = e(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "query: " + e);
        }
        String uri2 = uri.toString();
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) new c.a().le(j)).li(!TextUtils.isEmpty(queryParameter) ? f(uri) : uri2);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(e)) {
            aVar.lj(b + "?" + e);
        } else if (!TextUtils.isEmpty(b)) {
            aVar.lj(b);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.lh(jSONObject.optString("from"));
                aVar.ll(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.bt("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bt("extraData", jSONObject.optString("extraData"));
                }
                aVar.bt("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a = com.baidu.swan.e.c.a(aVar.ahQ(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.bt("ubc", a.toString());
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
                        aVar.lk(optJSONObject.optString("clkid"));
                        aVar.bt("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.bt(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar.i("click_time", optJSONObject.optLong("click", -1L));
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
                        aVar.ahW().putString("search_id", str);
                        aVar.ahW().putString("search_url", str2);
                        aVar.ahW().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        com.baidu.swan.apps.statistic.search.b.e(aVar);
                        aVar.bu("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
                        aVar.bu("tool_port", unitedSchemeEntity.getParam("tport"));
                        aVar.bu("projectId", unitedSchemeEntity.getParam("projectId"));
                        aVar.bu("fromHost", unitedSchemeEntity.getParam("fromHost"));
                        aVar.bu("spuId", unitedSchemeEntity.getParam("spuId"));
                        aVar.bu("contentId", unitedSchemeEntity.getParam("contentId"));
                        Bundle bundle = null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        if (DEBUG) {
                        }
                        SwanLauncher.adE().a(aVar, bundle);
                        com.baidu.swan.apps.v.a.a(str3, j, callbackHandler, unitedSchemeEntity, null);
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
        if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.ahQ())) {
            aVar.ahW().putString("search_id", str);
            aVar.ahW().putString("search_url", str2);
            aVar.ahW().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        aVar.bu("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
        aVar.bu("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar.bu("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar.bu("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar.bu("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar.bu("contentId", unitedSchemeEntity.getParam("contentId"));
        Bundle bundle2 = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle2 = new Bundle();
            bundle2.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        SwanLauncher.adE().a(aVar, bundle2);
        com.baidu.swan.apps.v.a.a(str3, j, callbackHandler, unitedSchemeEntity, null);
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
        return ah.deleteQueryParam(uri.getEncodedQuery(), cHX);
    }

    private String f(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return ah.a(uri, hashSet);
    }
}
