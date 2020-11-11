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

    public static JSONObject sG(String str) {
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
    public static String bT(JSONObject jSONObject) {
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
        com.baidu.swan.apps.runtime.config.c pL = com.baidu.swan.apps.v.f.azO().pL(bVar.dgd);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cPW = cVar.aiE();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aHu() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aHu().rZ(bVar.dgd);
        }
        bVar2.cPU = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aHu(), bVar.mPage);
        bVar2.cPY = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cPZ = pL.cPZ;
        bVar2.cPT = String.valueOf(com.baidu.swan.apps.console.a.alv());
        if (com.baidu.swan.apps.runtime.e.aHu() != null) {
            String sb = com.baidu.swan.apps.runtime.e.aHu().sb(bVar.dgd);
            if (!TextUtils.isEmpty(sb)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + sb);
                }
                bVar2.cQa = sb;
            }
        }
        bVar2.cPV = DEBUG || com.baidu.swan.apps.v.f.azO().azs();
        bVar2.cQb = str;
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            bVar2.cPX = com.baidu.swan.apps.console.debugger.b.alC();
        }
        com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aMH();
        cVar.aiH().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.kx(bVar2.cPY);
        com.baidu.swan.apps.v.f.azO().a(cVar.aiJ(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cx(cVar.aiJ(), bVar2.cPY);
        com.baidu.swan.apps.core.slave.b.a(Y, cVar);
        com.baidu.swan.apps.performance.h.E("route", "createAndLoadPage end.");
    }

    public static void U(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean sH(@NonNull String str) {
        String aIM = aIM();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aIM + "\ncurPageUrl: " + str);
        }
        if (aIM == null || str == null) {
            return false;
        }
        String pc = com.baidu.swan.apps.u.c.b.pc(aIM);
        String pc2 = com.baidu.swan.apps.u.c.b.pc(str);
        return (TextUtils.equals(pc, pc2) || TextUtils.equals(Uri.decode(pc), pc2) || TextUtils.equals(pc, Uri.decode(pc2))) ? false : true;
    }

    private static String aIM() {
        com.baidu.swan.apps.adaptation.b.c aoQ;
        com.baidu.swan.apps.core.d.e apc = com.baidu.swan.apps.v.f.azO().apc();
        if (apc == null || (aoQ = apc.aoQ()) == null) {
            return null;
        }
        return aoQ.aiG();
    }

    public static void sI(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
                if (afM != null) {
                    afM.nb(str).apl().apn();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sK = j.sK(delAllParamsFromUrl);
        String kA = eVar.kA(delAllParamsFromUrl);
        String rZ = eVar.rZ(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", kA);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rZ);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sK)) {
                if (!TextUtils.isEmpty(params)) {
                    sK = sK + "?" + params;
                }
                jSONObject.put("pageRoutePath", sK);
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
        com.baidu.swan.apps.core.d.c hZ;
        if (fVar != null && fVar.ape() >= com.baidu.swan.apps.api.module.g.b.czV && (hZ = fVar.hZ(0)) != null && (hZ instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) hZ).aoM();
        }
        return null;
    }
}
