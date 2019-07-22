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

    public static JSONObject hh(String str) {
        return ay(str, "");
    }

    public static JSONObject ay(String str, String str2) {
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
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(s(str, bVar.gJ(aa.iq(str2)), str2), 0).toString(), str3);
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
        com.baidu.swan.apps.performance.e.am("route", "createAndLoadPage start.");
        String x = ac.x(bVar.mBaseUrl, bVar.azs, bVar.mParams);
        com.baidu.swan.apps.ae.a.d fd = com.baidu.swan.apps.w.e.GF().fd(bVar.azs);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.auc = bVar.mBaseUrl;
        bVar2.auj = com.baidu.swan.apps.model.b.f(bVar);
        bVar2.auk = fd.aRz;
        bVar2.aug = String.valueOf(com.baidu.swan.apps.console.a.yd());
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            String gL = com.baidu.swan.apps.ae.b.Md().gL(bVar.azs);
            if (!TextUtils.isEmpty(gL)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + gL);
                }
                bVar2.aul = gL;
            }
        }
        bVar2.aui = DEBUG || com.baidu.swan.apps.w.e.GF().Gm();
        com.baidu.swan.apps.w.e.GF().a(cVar.xv(), com.baidu.swan.apps.core.j.b.b(bVar2));
        com.baidu.swan.apps.core.i.b.a(x, cVar);
        com.baidu.swan.apps.performance.e.am("route", "createAndLoadPage end.");
    }

    public static void t(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
