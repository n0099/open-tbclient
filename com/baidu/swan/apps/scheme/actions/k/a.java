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
    private static int cCT = -1;

    public static JSONObject oc(String str) {
        return bO(str, "");
    }

    public static JSONObject bO(String str, String str2) {
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
    public static String bg(JSONObject jSONObject) {
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
        String M = aj.M(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c lq = com.baidu.swan.apps.w.f.ahV().lq(bVar.coT);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cax = cVar.Tf();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aoF() != null) {
            bVar2.caw = com.baidu.swan.apps.runtime.e.aoF().nz(bVar.coT);
        }
        bVar2.cau = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aoF(), bVar.mPage);
        bVar2.caz = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.caA = lq.caA;
        bVar2.cat = String.valueOf(com.baidu.swan.apps.console.a.VO());
        if (com.baidu.swan.apps.runtime.e.aoF() != null) {
            String nB = com.baidu.swan.apps.runtime.e.aoF().nB(bVar.coT);
            if (!TextUtils.isEmpty(nB)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + nB);
                }
                bVar2.caB = nB;
            }
        }
        bVar2.cav = DEBUG || com.baidu.swan.apps.w.f.ahV().ahz();
        bVar2.caC = str;
        if (com.baidu.swan.apps.af.a.a.amr()) {
            bVar2.cay = com.baidu.swan.apps.console.debugger.b.VV();
        }
        com.baidu.swan.apps.performance.g.bA("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        z.atC();
        com.baidu.swan.apps.w.f.ahV().a(cVar.Tj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.bR(cVar.Tj(), bVar2.caz);
        com.baidu.swan.apps.core.slave.b.a(M, cVar);
        com.baidu.swan.apps.performance.f.D("route", "createAndLoadPage end.");
    }

    public static void I(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean od(@NonNull String str) {
        String apV;
        return (apU() <= 0 || (apV = apV()) == null || str == null || TextUtils.equals(com.baidu.swan.apps.v.b.b.kI(apV), com.baidu.swan.apps.v.b.b.kI(str))) ? false : true;
    }

    private static int apU() {
        if (cCT < 0) {
            cCT = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_app_relaunch_switch", 0);
        }
        if (DEBUG) {
            Log.d("ActionUtils", "getRelaunchSwitch:" + cCT);
        }
        return cCT;
    }

    private static String apV() {
        com.baidu.swan.apps.core.d.d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
        if (YQ == null) {
            return null;
        }
        String page = YQ.YF().getPage();
        String params = YQ.YF().getParams();
        return !TextUtils.isEmpty(params) ? page + "?" + params : page;
    }

    public static void oe(final String str) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
                if (QH != null) {
                    QH.jp(str).YZ().Zb();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
        String params = ah.getParams(str);
        String oh = j.oh(delAllParamsFromUrl);
        String nx = eVar.nx(delAllParamsFromUrl);
        String nz = eVar.nz(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", nx);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, nz);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, oh)) {
                if (!TextUtils.isEmpty(params)) {
                    oh = oh + "?" + params;
                }
                jSONObject.put("pageRoutePath", oh);
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
        com.baidu.swan.apps.core.d.b eM;
        if (eVar != null && eVar.YS() >= com.baidu.swan.apps.api.module.g.b.bLW && (eM = eVar.eM(0)) != null && (eM instanceof com.baidu.swan.apps.core.d.d)) {
            return ((com.baidu.swan.apps.core.d.d) eM).YC();
        }
        return null;
    }
}
