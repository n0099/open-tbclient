package com.baidu.swan.apps.scheme.actions.h;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject gG(String str) {
        return ax(str, "");
    }

    public static JSONObject ax(String str, String str2) {
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

    public static JSONObject s(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            jSONObject.put("root", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("pageUrl", str3);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, String str, String str2, String str3) {
        if (bVar != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(s(str, bVar.gh(y.hF(str2)), str2), 0).toString(), str3);
        }
    }

    public static void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), str);
    }

    public static String b(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return a(unitedSchemeEntity, str, "url");
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

    public static void a(com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.model.b bVar) {
        com.baidu.swan.apps.performance.e.as("route", "createAndLoadPage start.");
        String x = aa.x(bVar.mBaseUrl, bVar.axI, bVar.mParams);
        com.baidu.swan.apps.ae.a.d eN = com.baidu.swan.apps.w.e.Ec().eN(bVar.axI);
        com.baidu.swan.apps.core.i.b bVar2 = new com.baidu.swan.apps.core.i.b();
        bVar2.atg = bVar.mBaseUrl;
        bVar2.atm = com.baidu.swan.apps.model.b.f(bVar);
        bVar2.atn = eN.aOI;
        bVar2.atk = String.valueOf(com.baidu.swan.apps.console.a.wI());
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            String gj = com.baidu.swan.apps.ae.b.IX().gj(bVar.axI);
            if (!TextUtils.isEmpty(gj)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + gj);
                }
                bVar2.ato = gj;
            }
        }
        com.baidu.swan.apps.w.e.Ec().a(cVar.we(), com.baidu.swan.apps.core.i.b.a(bVar2));
        com.baidu.swan.apps.core.h.b.b(x, cVar);
        com.baidu.swan.apps.performance.e.as("route", "createAndLoadPage end.");
    }

    public static void t(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.w.e.Ec().a(new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
