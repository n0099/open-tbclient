package com.baidu.swan.apps.scheme.actions.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject mF(String str) {
        return bt(str, "");
    }

    public static JSONObject bt(String str, String str2) {
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

    public static JSONObject q(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            jSONObject.put("root", str2);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, str3);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("pageUrl", str4);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, String str, String str2, String str3) {
        if (eVar != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a(eVar, str2, str), 0).toString(), str3);
        }
    }

    public static void a(com.baidu.swan.apps.api.a.a aVar, com.baidu.swan.apps.runtime.e eVar, String str, String str2, String str3) {
        if (aVar != null && eVar != null && !TextUtils.isEmpty(str3)) {
            aVar.a(str3, new com.baidu.swan.apps.api.b.b(0, a(eVar, str2, str)));
        }
    }

    public static void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
    }

    public static void b(com.baidu.swan.apps.api.a.a aVar, String str) {
        if (aVar != null) {
            aVar.a(str, new com.baidu.swan.apps.api.b.b(1001, "No Package"));
        }
    }

    public static String a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return a(unitedSchemeEntity, str, "url");
    }

    @Nullable
    public static String aX(JSONObject jSONObject) {
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

    public static void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, String str) {
        com.baidu.swan.apps.performance.e.D("route", "createAndLoadPage start.");
        String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c ke = com.baidu.swan.apps.y.f.aeK().ke(bVar.mPage);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.bQG = cVar.QC();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            bVar2.bQF = com.baidu.swan.apps.runtime.e.akN().me(bVar.mPage);
        }
        bVar2.bQI = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.bQJ = ke.bQJ;
        bVar2.bQC = String.valueOf(com.baidu.swan.apps.console.a.Ti());
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            String mg = com.baidu.swan.apps.runtime.e.akN().mg(bVar.mPage);
            if (!TextUtils.isEmpty(mg)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + mg);
                }
                bVar2.bQK = mg;
            }
        }
        bVar2.bQE = DEBUG || com.baidu.swan.apps.y.f.aeK().aep();
        bVar2.bQL = str;
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            bVar2.bQH = com.baidu.swan.apps.console.debugger.b.Tp();
        }
        com.baidu.swan.apps.performance.f.bh("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        y.apc();
        com.baidu.swan.apps.y.f.aeK().a(cVar.QG(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bw(cVar.QG(), bVar2.bQI);
        com.baidu.swan.apps.core.slave.b.a(J, cVar);
        com.baidu.swan.apps.performance.e.D("route", "createAndLoadPage end.");
    }

    public static void F(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b(str, hashMap));
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        return q(str2, eVar.mc(delAllParamsFromUrl), eVar.me(delAllParamsFromUrl), str);
    }
}
