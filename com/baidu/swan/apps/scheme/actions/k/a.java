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

    public static JSONObject su(String str) {
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
    public static String bW(JSONObject jSONObject) {
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
        com.baidu.swan.apps.runtime.config.c pt = com.baidu.swan.apps.v.f.aAo().pt(bVar.dps);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.cZb = cVar.aiW();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aIN() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aIN().rM(bVar.dps);
        }
        bVar2.cYZ = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aIN(), bVar.mPage);
        bVar2.cZd = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.cZe = pt.cZe;
        bVar2.cYY = String.valueOf(com.baidu.swan.apps.console.a.alO());
        if (com.baidu.swan.apps.runtime.e.aIN() != null) {
            String rO = com.baidu.swan.apps.runtime.e.aIN().rO(bVar.dps);
            if (!TextUtils.isEmpty(rO)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + rO);
                }
                bVar2.cZf = rO;
            }
        }
        bVar2.cZa = DEBUG || com.baidu.swan.apps.v.f.aAo().azS();
        bVar2.cZg = str;
        if (com.baidu.swan.apps.ad.a.a.aFp()) {
            bVar2.cZc = com.baidu.swan.apps.console.debugger.b.alW();
        }
        com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aOa();
        cVar.aiZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.kf(bVar2.cZd);
        com.baidu.swan.apps.v.f.aAo().a(cVar.ajb(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cv(cVar.ajb(), bVar2.cZd);
        com.baidu.swan.apps.core.slave.b.a(ae, cVar);
        com.baidu.swan.apps.performance.h.B("route", "createAndLoadPage end.");
    }

    public static void aa(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean sv(@NonNull String str) {
        String aKf = aKf();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aKf + "\ncurPageUrl: " + str);
        }
        if (aKf == null || str == null) {
            return false;
        }
        String oK = com.baidu.swan.apps.u.c.b.oK(aKf);
        String oK2 = com.baidu.swan.apps.u.c.b.oK(str);
        return (TextUtils.equals(oK, oK2) || TextUtils.equals(Uri.decode(oK), oK2) || TextUtils.equals(oK, Uri.decode(oK2))) ? false : true;
    }

    private static String aKf() {
        com.baidu.swan.apps.adaptation.b.c app;
        com.baidu.swan.apps.core.d.e apB = com.baidu.swan.apps.v.f.aAo().apB();
        if (apB == null || (app = apB.app()) == null) {
            return null;
        }
        return app.aiY();
    }

    public static void sw(final String str) {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
                if (aga != null) {
                    aga.mJ(str).apJ().apL();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String sy = j.sy(delAllParamsFromUrl);
        String ki = eVar.ki(delAllParamsFromUrl);
        String rM = eVar.rM(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", ki);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, rM);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, sy)) {
                if (!TextUtils.isEmpty(params)) {
                    sy = sy + "?" + params;
                }
                jSONObject.put("pageRoutePath", sy);
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
        com.baidu.swan.apps.core.d.c gM;
        if (fVar != null && fVar.apD() >= com.baidu.swan.apps.api.module.g.b.cJc && (gM = fVar.gM(0)) != null && (gM instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) gM).apl();
        }
        return null;
    }
}
