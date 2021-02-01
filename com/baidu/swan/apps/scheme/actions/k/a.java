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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject sm(String str) {
        return cs(str, "");
    }

    public static JSONObject cs(String str, String str2) {
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
    public static String bU(JSONObject jSONObject) {
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
        com.baidu.swan.apps.performance.h.B("route", "createAndLoadPage start.");
        String ae = ak.ae(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c pm = com.baidu.swan.apps.v.f.aAl().pm(bVar.dnO);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cXB = cVar.aiT();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aIK() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aIK().rF(bVar.dnO);
        }
        bVar2.cXz = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIK(), bVar.mPage);
        bVar2.cXD = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cXE = pm.cXE;
        bVar2.cXy = String.valueOf(com.baidu.swan.apps.console.a.alL());
        if (com.baidu.swan.apps.runtime.e.aIK() != null) {
            String rH = com.baidu.swan.apps.runtime.e.aIK().rH(bVar.dnO);
            if (!TextUtils.isEmpty(rH)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + rH);
                }
                bVar2.cXF = rH;
            }
        }
        bVar2.cXA = DEBUG || com.baidu.swan.apps.v.f.aAl().azP();
        bVar2.cXG = str;
        if (com.baidu.swan.apps.ad.a.a.aFm()) {
            bVar2.cXC = com.baidu.swan.apps.console.debugger.b.alT();
        }
        com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aNX();
        cVar.aiW().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.jY(bVar2.cXD);
        com.baidu.swan.apps.v.f.aAl().a(cVar.aiY(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cv(cVar.aiY(), bVar2.cXD);
        com.baidu.swan.apps.core.slave.b.a(ae, cVar);
        com.baidu.swan.apps.performance.h.B("route", "createAndLoadPage end.");
    }

    public static void aa(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean sn(@NonNull String str) {
        String aKc = aKc();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aKc + "\ncurPageUrl: " + str);
        }
        if (aKc == null || str == null) {
            return false;
        }
        String oD = com.baidu.swan.apps.u.c.b.oD(aKc);
        String oD2 = com.baidu.swan.apps.u.c.b.oD(str);
        return (TextUtils.equals(oD, oD2) || TextUtils.equals(Uri.decode(oD), oD2) || TextUtils.equals(oD, Uri.decode(oD2))) ? false : true;
    }

    private static String aKc() {
        com.baidu.swan.apps.adaptation.b.c apm;
        com.baidu.swan.apps.core.d.e apy = com.baidu.swan.apps.v.f.aAl().apy();
        if (apy == null || (apm = apy.apm()) == null) {
            return null;
        }
        return apm.aiV();
    }

    public static void so(final String str) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
                if (afX != null) {
                    afX.mC(str).apG().apI();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sq = j.sq(delAllParamsFromUrl);
        String kb = eVar.kb(delAllParamsFromUrl);
        String rF = eVar.rF(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", kb);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rF);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sq)) {
                if (!TextUtils.isEmpty(params)) {
                    sq = sq + "?" + params;
                }
                jSONObject.put("pageRoutePath", sq);
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
        com.baidu.swan.apps.core.d.c gL;
        if (fVar != null && fVar.apA() >= com.baidu.swan.apps.api.module.g.b.cHC && (gL = fVar.gL(0)) != null && (gL instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) gL).aph();
        }
        return null;
    }
}
