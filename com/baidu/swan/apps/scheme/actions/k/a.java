package com.baidu.swan.apps.scheme.actions.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
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

    public static JSONObject rT(String str) {
        return cy(str, "");
    }

    public static JSONObject cy(String str, String str2) {
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
    public static String bX(JSONObject jSONObject) {
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
        String ad = ak.ad(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c oU = com.baidu.swan.apps.v.f.azN().oU(bVar.dlD);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cVp = cVar.aiv();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aIr() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aIr().rm(bVar.dlD);
        }
        bVar2.cVn = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIr(), bVar.mPage);
        bVar2.cVr = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cVs = oU.cVs;
        bVar2.cVm = String.valueOf(com.baidu.swan.apps.console.a.aln());
        if (com.baidu.swan.apps.runtime.e.aIr() != null) {
            String ro = com.baidu.swan.apps.runtime.e.aIr().ro(bVar.dlD);
            if (!TextUtils.isEmpty(ro)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + ro);
                }
                bVar2.cVt = ro;
            }
        }
        bVar2.cVo = DEBUG || com.baidu.swan.apps.v.f.azN().azr();
        bVar2.cVu = str;
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            bVar2.cVq = com.baidu.swan.apps.console.debugger.b.alv();
        }
        com.baidu.swan.apps.performance.i.cj("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aNE();
        cVar.aiy().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.jG(bVar2.cVr);
        com.baidu.swan.apps.v.f.azN().a(cVar.aiA(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cB(cVar.aiA(), bVar2.cVr);
        com.baidu.swan.apps.core.slave.b.a(ad, cVar);
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage end.");
    }

    public static void Z(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean rU(@NonNull String str) {
        String aJJ = aJJ();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aJJ + "\ncurPageUrl: " + str);
        }
        if (aJJ == null || str == null) {
            return false;
        }
        String ok = com.baidu.swan.apps.u.c.b.ok(aJJ);
        String ok2 = com.baidu.swan.apps.u.c.b.ok(str);
        return (TextUtils.equals(ok, ok2) || TextUtils.equals(Uri.decode(ok), ok2) || TextUtils.equals(ok, Uri.decode(ok2))) ? false : true;
    }

    private static String aJJ() {
        com.baidu.swan.apps.adaptation.b.c aoN;
        com.baidu.swan.apps.core.d.e aoZ = com.baidu.swan.apps.v.f.azN().aoZ();
        if (aoZ == null || (aoN = aoZ.aoN()) == null) {
            return null;
        }
        return aoN.aix();
    }

    public static void rV(final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
                if (afz != null) {
                    afz.mk(str).aph().apk();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String rX = j.rX(delAllParamsFromUrl);
        String jJ = eVar.jJ(delAllParamsFromUrl);
        String rm = eVar.rm(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", jJ);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rm);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, rX)) {
                if (!TextUtils.isEmpty(params)) {
                    rX = rX + "?" + params;
                }
                jSONObject.put("pageRoutePath", rX);
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
        com.baidu.swan.apps.core.d.c gI;
        if (fVar != null && fVar.apb() >= com.baidu.swan.apps.api.module.g.b.cFh && (gI = fVar.gI(0)) != null && (gI instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) gI).aoJ();
        }
        return null;
    }
}
