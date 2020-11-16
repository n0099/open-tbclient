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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject sB(String str) {
        return ct(str, "");
    }

    public static JSONObject ct(String str, String str2) {
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
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage start.");
        String Y = ak.Y(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c pF = com.baidu.swan.apps.v.f.azg().pF(bVar.dew);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cOm = cVar.ahW();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aGM() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aGM().rT(bVar.dew);
        }
        bVar2.cOk = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aGM(), bVar.mPage);
        bVar2.cOo = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cOp = pF.cOp;
        bVar2.cOj = String.valueOf(com.baidu.swan.apps.console.a.akN());
        if (com.baidu.swan.apps.runtime.e.aGM() != null) {
            String rV = com.baidu.swan.apps.runtime.e.aGM().rV(bVar.dew);
            if (!TextUtils.isEmpty(rV)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + rV);
                }
                bVar2.cOq = rV;
            }
        }
        bVar2.cOl = DEBUG || com.baidu.swan.apps.v.f.azg().ayK();
        bVar2.cOr = str;
        if (com.baidu.swan.apps.ad.a.a.aEj()) {
            bVar2.cOn = com.baidu.swan.apps.console.debugger.b.akU();
        }
        com.baidu.swan.apps.performance.i.ce("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aLZ();
        cVar.ahZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.kr(bVar2.cOo);
        com.baidu.swan.apps.v.f.azg().a(cVar.aib(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cw(cVar.aib(), bVar2.cOo);
        com.baidu.swan.apps.core.slave.b.a(Y, cVar);
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage end.");
    }

    public static void U(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean sC(@NonNull String str) {
        String aIe = aIe();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aIe + "\ncurPageUrl: " + str);
        }
        if (aIe == null || str == null) {
            return false;
        }
        String oW = com.baidu.swan.apps.u.c.b.oW(aIe);
        String oW2 = com.baidu.swan.apps.u.c.b.oW(str);
        return (TextUtils.equals(oW, oW2) || TextUtils.equals(Uri.decode(oW), oW2) || TextUtils.equals(oW, Uri.decode(oW2))) ? false : true;
    }

    private static String aIe() {
        com.baidu.swan.apps.adaptation.b.c aoi;
        com.baidu.swan.apps.core.d.e aou = com.baidu.swan.apps.v.f.azg().aou();
        if (aou == null || (aoi = aou.aoi()) == null) {
            return null;
        }
        return aoi.ahY();
    }

    public static void sD(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
                if (afe != null) {
                    afe.mV(str).aoC().aoE();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sF = j.sF(delAllParamsFromUrl);
        String ku = eVar.ku(delAllParamsFromUrl);
        String rT = eVar.rT(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", ku);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rT);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sF)) {
                if (!TextUtils.isEmpty(params)) {
                    sF = sF + "?" + params;
                }
                jSONObject.put("pageRoutePath", sF);
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
        com.baidu.swan.apps.core.d.c hV;
        if (fVar != null && fVar.aow() >= com.baidu.swan.apps.api.module.g.b.cyl && (hV = fVar.hV(0)) != null && (hV instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) hV).aoe();
        }
        return null;
    }
}
