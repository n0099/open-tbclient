package com.baidu.swan.apps.scheme.actions.k;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject ss(String str) {
        return cu(str, "");
    }

    public static JSONObject cu(String str, String str2) {
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
    public static String bN(JSONObject jSONObject) {
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

    /* JADX WARN: Type inference failed for: r0v14, types: [com.baidu.swan.apps.adaptation.b.d] */
    public static void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, String str) {
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage start.");
        String Y = ak.Y(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c px = com.baidu.swan.apps.v.f.axo().px(bVar.dag);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cKd = cVar.age();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aEU() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aEU().rL(bVar.dag);
        }
        bVar2.cKb = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aEU(), bVar.mPage);
        bVar2.cKf = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cKg = px.cKg;
        bVar2.cKa = String.valueOf(com.baidu.swan.apps.console.a.aiV());
        if (com.baidu.swan.apps.runtime.e.aEU() != null) {
            String rN = com.baidu.swan.apps.runtime.e.aEU().rN(bVar.dag);
            if (!TextUtils.isEmpty(rN)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + rN);
                }
                bVar2.cKh = rN;
            }
        }
        bVar2.cKc = DEBUG || com.baidu.swan.apps.v.f.axo().awS();
        bVar2.cKi = str;
        if (com.baidu.swan.apps.ad.a.a.aCr()) {
            bVar2.cKe = com.baidu.swan.apps.console.debugger.b.ajc();
        }
        com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aKh();
        cVar.agh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.ki(bVar2.cKf);
        com.baidu.swan.apps.v.f.axo().a(cVar.agj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cx(cVar.agj(), bVar2.cKf);
        com.baidu.swan.apps.core.slave.b.a(Y, cVar);
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage end.");
    }

    public static void U(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean st(@NonNull String str) {
        String aGm = aGm();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aGm + "\ncurPageUrl: " + str);
        }
        if (aGm == null || str == null) {
            return false;
        }
        String oO = com.baidu.swan.apps.u.c.b.oO(aGm);
        String oO2 = com.baidu.swan.apps.u.c.b.oO(str);
        return (TextUtils.equals(oO, oO2) || TextUtils.equals(Uri.decode(oO), oO2) || TextUtils.equals(oO, Uri.decode(oO2))) ? false : true;
    }

    private static String aGm() {
        com.baidu.swan.apps.adaptation.b.c amq;
        com.baidu.swan.apps.core.d.e amC = com.baidu.swan.apps.v.f.axo().amC();
        if (amC == null || (amq = amC.amq()) == null) {
            return null;
        }
        return amq.agg();
    }

    public static void su(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
                if (adm != null) {
                    adm.mM(str).amK().amM();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sw = j.sw(delAllParamsFromUrl);
        String kl = eVar.kl(delAllParamsFromUrl);
        String rL = eVar.rL(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", kl);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rL);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sw)) {
                if (!TextUtils.isEmpty(params)) {
                    sw = sw + "?" + params;
                }
                jSONObject.put("pageRoutePath", sw);
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

    public static List<String> e(com.baidu.swan.apps.core.d.f fVar) {
        com.baidu.swan.apps.core.d.c hP;
        if (fVar != null && fVar.amE() >= com.baidu.swan.apps.api.module.g.b.cua && (hP = fVar.hP(0)) != null && (hP instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) hP).amm();
        }
        return null;
    }
}
