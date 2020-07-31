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
import com.baidu.swan.apps.aq.aj;
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
/* loaded from: classes7.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Set<String> cLf = new HashSet();

    static {
        cLf.add("_baiduboxapp");
        cLf.add(BuyTBeanActivityConfig.CALLBACK);
        cLf.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        cLf.add("_naExtParams");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aiapps_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02d9  */
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
        String j = aj.j(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "mAppId: " + j);
        }
        String aeM = SwanLauncher.aeM();
        d.arr().arn().arz().lO(aeM);
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("appId is empty");
            e.avX().g(qm);
            h.b(new com.baidu.swan.apps.statistic.a.d().pu(h.ho(0)).f(qm).bV(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            i.a(qm);
            return true;
        }
        String a = aj.a(j, uri, true);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "pagePath: " + a);
        }
        String e = e(uri);
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "query: " + e);
        }
        String uri2 = uri.toString();
        String queryParameter = uri.getQueryParameter("_naExtParams");
        c.a aVar = (c.a) ((c.a) ((c.a) new c.a().lE(j)).lI(!TextUtils.isEmpty(queryParameter) ? f(uri) : uri2)).lO(aeM);
        if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(e)) {
            aVar.lJ(a + "?" + e);
        } else if (!TextUtils.isEmpty(a)) {
            aVar.lJ(a);
        }
        String str = null;
        String str2 = null;
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        String str3 = null;
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                aVar.lH(jSONObject.optString("from"));
                aVar.lL(jSONObject.optString("notinhis"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                str3 = jSONObject.optString("navi");
                aVar.bv("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bv("extraData", jSONObject.optString("extraData"));
                }
                aVar.bv("srcAppPage", jSONObject.optString("srcAppPage"));
                JSONObject a2 = com.baidu.swan.d.c.a(aVar.ajg(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a2 != null) {
                    aVar.bv("ubc", a2.toString());
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
                        aVar.lK(optJSONObject.optString("clkid"));
                        aVar.bv("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.bv(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar.j("click_time", optJSONObject.optLong("click", -1L));
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
                        aVar.ajm().putString("search_id", str);
                        aVar.ajm().putString("search_url", str2);
                        aVar.ajm().putLong("search_dom_click_timestamp", System.currentTimeMillis());
                        com.baidu.swan.apps.statistic.search.b.e(aVar);
                        aVar.bw("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
                        aVar.bw("tool_port", unitedSchemeEntity.getParam("tport"));
                        aVar.bw("projectId", unitedSchemeEntity.getParam("projectId"));
                        aVar.bw("fromHost", unitedSchemeEntity.getParam("fromHost"));
                        aVar.bw("spuId", unitedSchemeEntity.getParam("spuId"));
                        aVar.bw("contentId", unitedSchemeEntity.getParam("contentId"));
                        Bundle bundle = null;
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                        if (DEBUG) {
                        }
                        String param2 = unitedSchemeEntity.getParam("cb");
                        SwanLauncher.aeL().a(aVar, bundle);
                        com.baidu.swan.apps.u.a.a(str3, j, callbackHandler, unitedSchemeEntity, param2);
                        return true;
                    }
                }
                String optString3 = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString3)) {
                    long optLong = new JSONObject(optString3).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.k("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e4) {
                e = e4;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(PayHelper.STATUS_FAIL, aVar.ajg())) {
            aVar.ajm().putString("search_id", str);
            aVar.ajm().putString("search_url", str2);
            aVar.ajm().putLong("search_dom_click_timestamp", System.currentTimeMillis());
            com.baidu.swan.apps.statistic.search.b.e(aVar);
        }
        aVar.bw("tool_ip", unitedSchemeEntity.getParam(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
        aVar.bw("tool_port", unitedSchemeEntity.getParam("tport"));
        aVar.bw("projectId", unitedSchemeEntity.getParam("projectId"));
        aVar.bw("fromHost", unitedSchemeEntity.getParam("fromHost"));
        aVar.bw("spuId", unitedSchemeEntity.getParam("spuId"));
        aVar.bw("contentId", unitedSchemeEntity.getParam("contentId"));
        Bundle bundle2 = null;
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle2 = new Bundle();
            bundle2.putString("_naExtParams", queryParameter);
        }
        if (DEBUG) {
            Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
        }
        String param22 = unitedSchemeEntity.getParam("cb");
        SwanLauncher.aeL().a(aVar, bundle2);
        com.baidu.swan.apps.u.a.a(str3, j, callbackHandler, unitedSchemeEntity, param22);
        return true;
    }

    private String e(Uri uri) {
        return aj.deleteQueryParam(uri.getEncodedQuery(), cLf);
    }

    private String f(Uri uri) {
        if (uri == null) {
            return "";
        }
        HashSet hashSet = new HashSet();
        hashSet.add("_naExtParams");
        return aj.a(uri, hashSet);
    }
}
