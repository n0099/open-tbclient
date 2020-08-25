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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject qS(String str) {
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
    public static String bA(JSONObject jSONObject) {
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
        com.baidu.swan.apps.runtime.config.c nW = com.baidu.swan.apps.v.f.arY().nW(bVar.cDC);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cnl = cVar.aaP();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.azI().qm(bVar.cDC);
        }
        bVar2.cnj = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.azI(), bVar.mPage);
        bVar2.cnn = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cno = nW.cno;
        bVar2.cni = String.valueOf(com.baidu.swan.apps.console.a.adG());
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            String qo = com.baidu.swan.apps.runtime.e.azI().qo(bVar.cDC);
            if (!TextUtils.isEmpty(qo)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + qo);
                }
                bVar2.cnp = qo;
            }
        }
        bVar2.cnk = DEBUG || com.baidu.swan.apps.v.f.arY().arC();
        bVar2.cnq = str;
        if (com.baidu.swan.apps.ad.a.a.axd()) {
            bVar2.cnm = com.baidu.swan.apps.console.debugger.b.adN();
        }
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aEU();
        cVar.aaS().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.iJ(bVar2.cnn);
        com.baidu.swan.apps.v.f.arY().a(cVar.aaU(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cl(cVar.aaU(), bVar2.cnn);
        com.baidu.swan.apps.core.slave.b.a(Q, cVar);
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage end.");
    }

    public static void M(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean qT(@NonNull String str) {
        String aBa = aBa();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aBa + "\ncurPageUrl: " + str);
        }
        if (aBa == null || str == null) {
            return false;
        }
        String nn = com.baidu.swan.apps.u.c.b.nn(aBa);
        String nn2 = com.baidu.swan.apps.u.c.b.nn(str);
        return (TextUtils.equals(nn, nn2) || TextUtils.equals(Uri.decode(nn), nn2) || TextUtils.equals(nn, Uri.decode(nn2))) ? false : true;
    }

    private static String aBa() {
        com.baidu.swan.apps.adaptation.b.c ahb;
        com.baidu.swan.apps.core.d.e ahn = com.baidu.swan.apps.v.f.arY().ahn();
        if (ahn == null || (ahb = ahn.ahb()) == null) {
            return null;
        }
        return ahb.aaR();
    }

    public static void qU(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
                if (XX != null) {
                    XX.ln(str).ahv().ahx();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String qW = j.qW(delAllParamsFromUrl);
        String iM = eVar.iM(delAllParamsFromUrl);
        String qm = eVar.qm(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", iM);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, qm);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, qW)) {
                if (!TextUtils.isEmpty(params)) {
                    qW = qW + "?" + params;
                }
                jSONObject.put("pageRoutePath", qW);
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
        com.baidu.swan.apps.core.d.c gY;
        if (fVar != null && fVar.ahp() >= com.baidu.swan.apps.api.module.g.b.bXd && (gY = fVar.gY(0)) != null && (gY instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) gY).agX();
        }
        return null;
    }
}
