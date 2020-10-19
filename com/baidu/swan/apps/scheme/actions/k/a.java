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

    public static JSONObject rY(String str) {
        return cn(str, "");
    }

    public static JSONObject cn(String str, String str2) {
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
    public static String bK(JSONObject jSONObject) {
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
        String R = ak.R(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c pe = com.baidu.swan.apps.v.f.avu().pe(bVar.cRK);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cBH = cVar.aek();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aDa() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aDa().rs(bVar.cRK);
        }
        bVar2.cBF = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aDa(), bVar.mPage);
        bVar2.cBJ = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cBK = pe.cBK;
        bVar2.cBE = String.valueOf(com.baidu.swan.apps.console.a.ahb());
        if (com.baidu.swan.apps.runtime.e.aDa() != null) {
            String ru = com.baidu.swan.apps.runtime.e.aDa().ru(bVar.cRK);
            if (!TextUtils.isEmpty(ru)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + ru);
                }
                bVar2.cBL = ru;
            }
        }
        bVar2.cBG = DEBUG || com.baidu.swan.apps.v.f.avu().auY();
        bVar2.cBM = str;
        if (com.baidu.swan.apps.ad.a.a.aAx()) {
            bVar2.cBI = com.baidu.swan.apps.console.debugger.b.ahi();
        }
        com.baidu.swan.apps.performance.i.bY("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aIn();
        cVar.aen().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.jP(bVar2.cBJ);
        com.baidu.swan.apps.v.f.avu().a(cVar.aep(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cq(cVar.aep(), bVar2.cBJ);
        com.baidu.swan.apps.core.slave.b.a(R, cVar);
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage end.");
    }

    public static void N(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean rZ(@NonNull String str) {
        String aEs = aEs();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aEs + "\ncurPageUrl: " + str);
        }
        if (aEs == null || str == null) {
            return false;
        }
        String ov = com.baidu.swan.apps.u.c.b.ov(aEs);
        String ov2 = com.baidu.swan.apps.u.c.b.ov(str);
        return (TextUtils.equals(ov, ov2) || TextUtils.equals(Uri.decode(ov), ov2) || TextUtils.equals(ov, Uri.decode(ov2))) ? false : true;
    }

    private static String aEs() {
        com.baidu.swan.apps.adaptation.b.c akw;
        com.baidu.swan.apps.core.d.e akI = com.baidu.swan.apps.v.f.avu().akI();
        if (akI == null || (akw = akI.akw()) == null) {
            return null;
        }
        return akw.aem();
    }

    public static void sa(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
                if (abs != null) {
                    abs.mt(str).akQ().akS();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sc = j.sc(delAllParamsFromUrl);
        String jS = eVar.jS(delAllParamsFromUrl);
        String rs = eVar.rs(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", jS);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rs);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sc)) {
                if (!TextUtils.isEmpty(params)) {
                    sc = sc + "?" + params;
                }
                jSONObject.put("pageRoutePath", sc);
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
        com.baidu.swan.apps.core.d.c hE;
        if (fVar != null && fVar.akK() >= com.baidu.swan.apps.api.module.g.b.clx && (hE = fVar.hE(0)) != null && (hE instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) hE).aks();
        }
        return null;
    }
}
