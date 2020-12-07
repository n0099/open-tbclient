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
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject ti(String str) {
        return cA(str, "");
    }

    public static JSONObject cA(String str, String str2) {
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
    public static String bP(JSONObject jSONObject) {
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
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage start.");
        String ab = ak.ab(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c qm = com.baidu.swan.apps.v.f.aCp().qm(bVar.dlu);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cVf = cVar.ale();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aJU().sB(bVar.dlu);
        }
        bVar2.cVd = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aJU(), bVar.mPage);
        bVar2.cVh = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cVi = qm.cVi;
        bVar2.cVc = String.valueOf(com.baidu.swan.apps.console.a.anV());
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            String sD = com.baidu.swan.apps.runtime.e.aJU().sD(bVar.dlu);
            if (!TextUtils.isEmpty(sD)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + sD);
                }
                bVar2.cVj = sD;
            }
        }
        bVar2.cVe = DEBUG || com.baidu.swan.apps.v.f.aCp().aBT();
        bVar2.cVk = str;
        if (com.baidu.swan.apps.ad.a.a.aHr()) {
            bVar2.cVg = com.baidu.swan.apps.console.debugger.b.aoc();
        }
        com.baidu.swan.apps.performance.i.cl("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aPg();
        cVar.alh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.kY(bVar2.cVh);
        com.baidu.swan.apps.v.f.aCp().a(cVar.alj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cD(cVar.alj(), bVar2.cVh);
        com.baidu.swan.apps.core.slave.b.a(ab, cVar);
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage end.");
    }

    public static void X(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean tj(@NonNull String str) {
        String aLm = aLm();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aLm + "\ncurPageUrl: " + str);
        }
        if (aLm == null || str == null) {
            return false;
        }
        String pD = com.baidu.swan.apps.u.c.b.pD(aLm);
        String pD2 = com.baidu.swan.apps.u.c.b.pD(str);
        return (TextUtils.equals(pD, pD2) || TextUtils.equals(Uri.decode(pD), pD2) || TextUtils.equals(pD, Uri.decode(pD2))) ? false : true;
    }

    private static String aLm() {
        com.baidu.swan.apps.adaptation.b.c arq;
        com.baidu.swan.apps.core.d.e arC = com.baidu.swan.apps.v.f.aCp().arC();
        if (arC == null || (arq = arC.arq()) == null) {
            return null;
        }
        return arq.alg();
    }

    public static void tk(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
                if (aim != null) {
                    aim.nC(str).arK().arM();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String tm = j.tm(delAllParamsFromUrl);
        String lb = eVar.lb(delAllParamsFromUrl);
        String sB = eVar.sB(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", lb);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, sB);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, tm)) {
                if (!TextUtils.isEmpty(params)) {
                    tm = tm + "?" + params;
                }
                jSONObject.put("pageRoutePath", tm);
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
        com.baidu.swan.apps.core.d.c it;
        if (fVar != null && fVar.arE() >= com.baidu.swan.apps.api.module.g.b.cFd && (it = fVar.it(0)) != null && (it instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) it).arm();
        }
        return null;
    }
}
