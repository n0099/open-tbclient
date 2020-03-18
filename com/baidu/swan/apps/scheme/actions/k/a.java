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

    public static JSONObject ls(String str) {
        return bj(str, "");
    }

    public static JSONObject bj(String str, String str2) {
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
    public static String aM(JSONObject jSONObject) {
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
        com.baidu.swan.apps.performance.e.z("route", "createAndLoadPage start.");
        String J = ai.J(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c iR = com.baidu.swan.apps.y.f.WV().iR(bVar.mPage);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.bsA = cVar.IQ();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.acI() != null) {
            bVar2.bsz = com.baidu.swan.apps.runtime.e.acI().kR(bVar.mPage);
        }
        bVar2.bsC = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.bsD = iR.bsD;
        bVar2.bsw = String.valueOf(com.baidu.swan.apps.console.a.Lu());
        if (com.baidu.swan.apps.runtime.e.acI() != null) {
            String kT = com.baidu.swan.apps.runtime.e.acI().kT(bVar.mPage);
            if (!TextUtils.isEmpty(kT)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + kT);
                }
                bVar2.bsE = kT;
            }
        }
        bVar2.bsy = DEBUG || com.baidu.swan.apps.y.f.WV().WA();
        bVar2.bsF = str;
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            bVar2.bsB = com.baidu.swan.apps.console.debugger.b.LB();
        }
        com.baidu.swan.apps.performance.f.aX("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        y.agV();
        com.baidu.swan.apps.y.f.WV().a(cVar.IU(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bm(cVar.IU(), bVar2.bsC);
        com.baidu.swan.apps.core.slave.b.a(J, cVar);
        com.baidu.swan.apps.performance.e.z("route", "createAndLoadPage end.");
    }

    public static void F(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b(str, hashMap));
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        return q(str2, eVar.kP(delAllParamsFromUrl), eVar.kR(delAllParamsFromUrl), str);
    }
}
