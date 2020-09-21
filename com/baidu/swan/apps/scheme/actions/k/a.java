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
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject rm(String str) {
        return ci(str, "");
    }

    public static JSONObject ci(String str, String str2) {
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
    public static String bD(JSONObject jSONObject) {
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
        String Q = ak.Q(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c os = com.baidu.swan.apps.v.f.asJ().os(bVar.cFG);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cps = cVar.aby();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aAr() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aAr().qG(bVar.cFG);
        }
        bVar2.cpq = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aAr(), bVar.mPage);
        bVar2.cpv = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cpw = os.cpw;
        bVar2.cpp = String.valueOf(com.baidu.swan.apps.console.a.aeq());
        if (com.baidu.swan.apps.runtime.e.aAr() != null) {
            String qI = com.baidu.swan.apps.runtime.e.aAr().qI(bVar.cFG);
            if (!TextUtils.isEmpty(qI)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + qI);
                }
                bVar2.cpx = qI;
            }
        }
        bVar2.cpr = DEBUG || com.baidu.swan.apps.v.f.asJ().asn();
        bVar2.cpy = str;
        if (com.baidu.swan.apps.ad.a.a.axM()) {
            bVar2.cpt = com.baidu.swan.apps.console.debugger.b.aex();
        }
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aFE();
        cVar.abB().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.jd(bVar2.cpv);
        com.baidu.swan.apps.v.f.asJ().a(cVar.abD(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cl(cVar.abD(), bVar2.cpv);
        com.baidu.swan.apps.core.slave.b.a(Q, cVar);
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage end.");
    }

    public static void M(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean rn(@NonNull String str) {
        String aBJ = aBJ();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aBJ + "\ncurPageUrl: " + str);
        }
        if (aBJ == null || str == null) {
            return false;
        }
        String nH = com.baidu.swan.apps.u.c.b.nH(aBJ);
        String nH2 = com.baidu.swan.apps.u.c.b.nH(str);
        return (TextUtils.equals(nH, nH2) || TextUtils.equals(Uri.decode(nH), nH2) || TextUtils.equals(nH, Uri.decode(nH2))) ? false : true;
    }

    private static String aBJ() {
        com.baidu.swan.apps.adaptation.b.c ahL;
        com.baidu.swan.apps.core.d.e ahX = com.baidu.swan.apps.v.f.asJ().ahX();
        if (ahX == null || (ahL = ahX.ahL()) == null) {
            return null;
        }
        return ahL.abA();
    }

    public static void ro(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
                if (YG != null) {
                    YG.lH(str).aif().aih();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String rq = j.rq(delAllParamsFromUrl);
        String jg = eVar.jg(delAllParamsFromUrl);
        String qG = eVar.qG(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", jg);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, qG);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, rq)) {
                if (!TextUtils.isEmpty(params)) {
                    rq = rq + "?" + params;
                }
                jSONObject.put("pageRoutePath", rq);
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
        com.baidu.swan.apps.core.d.c hh;
        if (fVar != null && fVar.ahZ() >= com.baidu.swan.apps.api.module.g.b.bZi && (hh = fVar.hh(0)) != null && (hh instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) hh).ahH();
        }
        return null;
    }
}
