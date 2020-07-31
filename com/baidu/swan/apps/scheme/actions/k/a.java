package com.baidu.swan.apps.scheme.actions.k;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
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
    private static int cKG = -1;

    public static JSONObject oV(String str) {
        return bR(str, "");
    }

    public static JSONObject bR(String str, String str2) {
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
    public static String bs(JSONObject jSONObject) {
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
        com.baidu.swan.apps.performance.h.C("route", "createAndLoadPage start.");
        String N = al.N(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c lZ = com.baidu.swan.apps.v.f.akr().lZ(bVar.cvJ);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cgW = cVar.UM();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.arv() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.arv().op(bVar.cvJ);
        }
        bVar2.cgU = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.arv(), bVar.mPage);
        bVar2.cgY = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cgZ = lZ.cgZ;
        bVar2.cgT = String.valueOf(com.baidu.swan.apps.console.a.XA());
        if (com.baidu.swan.apps.runtime.e.arv() != null) {
            String or = com.baidu.swan.apps.runtime.e.arv().or(bVar.cvJ);
            if (!TextUtils.isEmpty(or)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + or);
                }
                bVar2.cha = or;
            }
        }
        bVar2.cgV = DEBUG || com.baidu.swan.apps.v.f.akr().ajV();
        bVar2.chb = str;
        if (com.baidu.swan.apps.ae.a.a.apg()) {
            bVar2.cgX = com.baidu.swan.apps.console.debugger.b.XH();
        }
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        aa.awK();
        cVar.UP().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.ho(bVar2.cgY);
        com.baidu.swan.apps.v.f.akr().a(cVar.UR(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.bU(cVar.UR(), bVar2.cgY);
        com.baidu.swan.apps.core.slave.b.a(N, cVar);
        com.baidu.swan.apps.performance.h.C("route", "createAndLoadPage end.");
    }

    public static void J(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean oW(@NonNull String str) {
        if (asR() <= 0) {
            return false;
        }
        String asS = asS();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + asS + "\ncurPageUrl: " + str);
        }
        if (asS == null || str == null) {
            return false;
        }
        String lq = com.baidu.swan.apps.u.c.b.lq(asS);
        String lq2 = com.baidu.swan.apps.u.c.b.lq(str);
        return (TextUtils.equals(lq, lq2) || TextUtils.equals(Uri.decode(lq), lq2) || TextUtils.equals(lq, Uri.decode(lq2))) ? false : true;
    }

    private static int asR() {
        if (cKG < 0) {
            cKG = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_app_relaunch_switch", 0);
        }
        if (DEBUG) {
            Log.d("ActionUtils", "getRelaunchSwitch:" + cKG);
        }
        return cKG;
    }

    private static String asS() {
        com.baidu.swan.apps.adaptation.b.c aaQ;
        com.baidu.swan.apps.core.d.e aba = com.baidu.swan.apps.v.f.akr().aba();
        if (aba == null || (aaQ = aba.aaQ()) == null) {
            return null;
        }
        return aaQ.UO();
    }

    public static void oX(final String str) {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
                if (Sc != null) {
                    Sc.jO(str).abj().abl();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = aj.delAllParamsFromUrl(str);
        String params = aj.getParams(str);
        String oZ = j.oZ(delAllParamsFromUrl);
        String hq = eVar.hq(delAllParamsFromUrl);
        String op = eVar.op(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", hq);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, op);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, oZ)) {
                if (!TextUtils.isEmpty(params)) {
                    oZ = oZ + "?" + params;
                }
                jSONObject.put("pageRoutePath", oZ);
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
        com.baidu.swan.apps.core.d.c fc;
        if (fVar != null && fVar.abc() >= com.baidu.swan.apps.api.module.g.b.bRB && (fc = fVar.fc(0)) != null && (fc instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) fc).aaM();
        }
        return null;
    }
}
