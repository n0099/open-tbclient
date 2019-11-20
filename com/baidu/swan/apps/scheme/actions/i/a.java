package com.baidu.swan.apps.scheme.actions.i;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static JSONObject hM(String str) {
        return aG(str, "");
    }

    public static JSONObject aG(String str, String str2) {
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

    public static JSONObject y(String str, String str2, String str3) {
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
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(y(str, bVar.hp(aa.iV(str2)), str2), 0).toString(), str3);
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
        com.baidu.swan.apps.performance.e.au("route", "createAndLoadPage start.");
        String B = ac.B(bVar.mBaseUrl, bVar.aSM, bVar.mParams);
        com.baidu.swan.apps.ae.a.d fM = com.baidu.swan.apps.w.e.LE().fM(bVar.aSM);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.aNz = bVar.mBaseUrl;
        bVar2.aNG = com.baidu.swan.apps.model.b.f(bVar);
        bVar2.aNH = fM.bkJ;
        bVar2.aND = String.valueOf(com.baidu.swan.apps.console.a.Dd());
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            String hr = com.baidu.swan.apps.ae.b.Ra().hr(bVar.aSM);
            if (!TextUtils.isEmpty(hr)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + hr);
                }
                bVar2.aNI = hr;
            }
        }
        bVar2.aNF = DEBUG || com.baidu.swan.apps.w.e.LE().Ll();
        com.baidu.swan.apps.w.e.LE().a(cVar.Cu(), com.baidu.swan.apps.core.j.b.b(bVar2));
        com.baidu.swan.apps.core.i.b.a(B, cVar);
        com.baidu.swan.apps.performance.e.au("route", "createAndLoadPage end.");
    }

    public static void z(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
