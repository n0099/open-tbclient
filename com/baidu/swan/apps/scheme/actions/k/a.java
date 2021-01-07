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

    public static JSONObject tf(String str) {
        return cz(str, "");
    }

    public static JSONObject cz(String str, String str2) {
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
        String ae = ak.ae(bVar.mBaseUrl, bVar.mPage, bVar.mParams);
        com.baidu.swan.apps.runtime.config.c qf = com.baidu.swan.apps.v.f.aDH().qf(bVar.dqt);
        com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
        bVar2.dab = cVar.amp();
        bVar2.appPath = bVar.mBaseUrl;
        if (com.baidu.swan.apps.runtime.e.aMl() != null) {
            bVar2.pageType = com.baidu.swan.apps.runtime.e.aMl().sy(bVar.dqt);
        }
        bVar2.cZZ = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aMl(), bVar.mPage);
        bVar2.dad = com.baidu.swan.apps.model.b.d(bVar);
        bVar2.dae = qf.dae;
        bVar2.cZY = String.valueOf(com.baidu.swan.apps.console.a.aph());
        if (com.baidu.swan.apps.runtime.e.aMl() != null) {
            String sA = com.baidu.swan.apps.runtime.e.aMl().sA(bVar.dqt);
            if (!TextUtils.isEmpty(sA)) {
                if (DEBUG) {
                    Log.d("ActionUtils", "add initData: " + sA);
                }
                bVar2.daf = sA;
            }
        }
        bVar2.daa = DEBUG || com.baidu.swan.apps.v.f.aDH().aDl();
        bVar2.dag = str;
        if (com.baidu.swan.apps.ad.a.a.aIL()) {
            bVar2.dac = com.baidu.swan.apps.console.debugger.b.apq();
        }
        com.baidu.swan.apps.performance.i.ck("route", str).f(new UbcFlowEvent("slave_dispatch_start"));
        ab.aRy();
        cVar.ams().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar.getPage());
        cVar.kR(bVar2.dad);
        com.baidu.swan.apps.v.f.aDH().a(cVar.amu(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
        com.baidu.swan.apps.statistic.e.cC(cVar.amu(), bVar2.dad);
        com.baidu.swan.apps.core.slave.b.a(ae, cVar);
        com.baidu.swan.apps.performance.h.D("route", "createAndLoadPage end.");
    }

    public static void aa(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b(str, hashMap));
    }

    public static boolean tg(@NonNull String str) {
        String aND = aND();
        if (DEBUG) {
            Log.i("ActionUtils", "lastPageUrl: " + aND + "\ncurPageUrl: " + str);
        }
        if (aND == null || str == null) {
            return false;
        }
        String pw = com.baidu.swan.apps.u.c.b.pw(aND);
        String pw2 = com.baidu.swan.apps.u.c.b.pw(str);
        return (TextUtils.equals(pw, pw2) || TextUtils.equals(Uri.decode(pw), pw2) || TextUtils.equals(pw, Uri.decode(pw2))) ? false : true;
    }

    private static String aND() {
        com.baidu.swan.apps.adaptation.b.c asJ;
        com.baidu.swan.apps.core.d.e asV = com.baidu.swan.apps.v.f.aDH().asV();
        if (asV == null || (asJ = asV.asJ()) == null) {
            return null;
        }
        return asJ.amr();
    }

    public static void th(final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
                if (ajt != null) {
                    ajt.nv(str).atd().atf();
                }
            }
        });
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.runtime.e eVar, String str, String str2, List<String> list) {
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        String params = ai.getParams(str);
        String tj = j.tj(delAllParamsFromUrl);
        String kU = eVar.kU(delAllParamsFromUrl);
        String sy = eVar.sy(delAllParamsFromUrl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", kU);
            jSONObject.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, sy);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(delAllParamsFromUrl, tj)) {
                if (!TextUtils.isEmpty(params)) {
                    tj = tj + "?" + params;
                }
                jSONObject.put("pageRoutePath", tj);
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
        com.baidu.swan.apps.core.d.c io2;
        if (fVar != null && fVar.asX() >= com.baidu.swan.apps.api.module.g.b.cJT && (io2 = fVar.io(0)) != null && (io2 instanceof com.baidu.swan.apps.core.d.e)) {
            return ((com.baidu.swan.apps.core.d.e) io2).asF();
        }
        return null;
    }
}
