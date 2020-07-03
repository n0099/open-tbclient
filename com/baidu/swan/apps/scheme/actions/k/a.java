package com.baidu.swan.apps.scheme.actions.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cHD = -1;

    public static JSONObject ol(String str) {
        return bQ(str, "");
    }

    public static JSONObject bQ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("pageUrl", str2);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list, String str3) {
        if (eVar != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a(eVar, str2, str, list), 0).toString(), str3);
        }
    }

    public static void a(com.baidu.swan.apps.api.a.a aVar, com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list, String str3) {
        if (aVar != null && eVar != null && !TextUtils.isEmpty(str3)) {
            aVar.a(str3, new com.baidu.swan.apps.api.c.b(0, a(eVar, str2, str, list)));
        }
    }

    public static void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
    }

    public static void b(com.baidu.swan.apps.api.a.a aVar, String str) {
        if (aVar != null) {
            aVar.a(str, new com.baidu.swan.apps.api.c.b(1001, "No Package"));
        }
    }

    public static String a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return a(unitedSchemeEntity, str, "url");
    }

    @Nullable
    public static String bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("url");
    }

    public static String a(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            return new JSONObject(str3).optString(str2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, String str) {
        com.baidu.swan.apps.performance.f.D("route", "createAndLoadPage start.");
        String N = aj.N(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c ly = com.baidu.swan.apps.w.f.ajb().ly(bVar.ctH);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cfm = cVar.Ul();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.apM().nH(bVar.ctH);
        }
        bVar2.cfk = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.apM(), bVar.mPage);
        bVar2.cfo = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cfp = ly.cfp;
        bVar2.cfj = String.valueOf(com.baidu.swan.apps.console.a.WU());
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            String nJ = com.baidu.swan.apps.runtime.e.apM().nJ(bVar.ctH);
            if (!TextUtils.isEmpty(nJ)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + nJ);
                }
                bVar2.cfq = nJ;
            }
        }
        bVar2.cfl = DEBUG || com.baidu.swan.apps.w.f.ajb().aiF();
        bVar2.cfr = str;
        if (com.baidu.swan.apps.af.a.a.anx()) {
            bVar2.cfn = com.baidu.swan.apps.console.debugger.b.Xb();
        }
        com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        z.auI();
        com.baidu.swan.apps.w.f.ajb().a(cVar.Up(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.bT(cVar.Up(), bVar2.cfo);
        com.baidu.swan.apps.core.slave.b.a(N, cVar);
        com.baidu.swan.apps.performance.f.D("route", "createAndLoadPage end.");
    }

    public static void J(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean om(@NonNull String str) {
        String arb;
        return (ara() <= 0 || (arb = arb()) == null || str == null || TextUtils.equals(com.baidu.swan.apps.v.b.b.kQ(arb), com.baidu.swan.apps.v.b.b.kQ(str))) ? false : true;
    }

    private static int ara() {
        if (cHD < 0) {
            cHD = com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_relaunch_switch", 0);
        }
        if (DEBUG) {
            Log.d("ActionUtils", "getRelaunchSwitch:" + cHD);
        }
        return cHD;
    }

    private static String arb() {
        com.baidu.swan.apps.core.d.d ZW = com.baidu.swan.apps.w.f.ajb().ZW();
        if (ZW == null) {
            return null;
        }
        String page = ZW.ZL().getPage();
        String params = ZW.ZL().getParams();
        return !TextUtils.isEmpty(params) ? page + "?" + params : page;
    }

    public static void oo(final String str) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
                if (RN != null) {
                    RN.jx(str).aaf().aah();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
        String params = ah.getParams(str);
        String oq = j.oq(delAllParamsFromUrl);
        String nF = eVar.nF(delAllParamsFromUrl);
        String nH = eVar.nH(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", nF);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, nH);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, oq)) {
                if (!TextUtils.isEmpty(params)) {
                    oq = oq + "?" + params;
                }
                jSONObject.put("pageRoutePath", oq);
            }
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : list) {
                    jSONArray.put(str3);
                }
                jSONObject.put("removedSlaveIDs", jSONArray);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static List<String> e(com.baidu.swan.apps.core.d.e eVar) {
        com.baidu.swan.apps.core.d.b eX;
        if (eVar != null && eVar.ZY() >= com.baidu.swan.apps.api.module.g.b.bQK && (eX = eVar.eX(0)) != null && (eX instanceof com.baidu.swan.apps.core.d.d)) {
            return ((com.baidu.swan.apps.core.d.d) eX).ZI();
        }
        return null;
    }
}
