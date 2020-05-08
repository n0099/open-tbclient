package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bQO;
    public String cpn;
    public String cpp;
    public boolean cpr;
    public boolean cps;
    public boolean cpv;
    public boolean cpw = false;
    public boolean cpx = true;
    public int cpm = ViewCompat.MEASURED_STATE_MASK;
    public String cpo = "#ffffff";
    public String cpt = "default";
    public int backgroundColor = -1;
    public boolean cpq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return alL();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return alL();
        }
        return aT(optJSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(String str, @NonNull c cVar) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return a(new JSONObject(str), cVar);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                    return cVar;
                }
                return cVar;
            }
        }
        return cVar;
    }

    private static c aT(JSONObject jSONObject) {
        c cVar = new c();
        cVar.cpm = SwanAppConfigData.dA(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.cpn = jSONObject.optString("navigationBarTitleText");
        cVar.cpo = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.cpp = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.dA(jSONObject.optString("backgroundColor"));
        cVar.cpq = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bQO = jSONObject.optString("onReachBottomDistance");
        cVar.cpr = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cps = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cpt = jSONObject.optString("navigationStyle", "default");
        cVar.cpv = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.cpm = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.dA(jSONObject.optString("navigationBarBackgroundColor")) : cVar.cpm;
        cVar2.cpn = jSONObject.optString("navigationBarTitleText", cVar.cpn);
        cVar2.cpo = jSONObject.optString("navigationBarTextStyle", cVar.cpo);
        cVar2.cpp = jSONObject.optString("backgroundTextStyle", cVar.cpp);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.dA(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cpq = jSONObject.optBoolean("enablePullDownRefresh", cVar.cpq);
        cVar2.bQO = jSONObject.optString("onReachBottomDistance", cVar.bQO);
        cVar2.cpr = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cpr);
        cVar2.cps = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cps);
        cVar2.cpt = jSONObject.optString("navigationStyle", cVar.cpt);
        cVar2.cpv = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cpv);
        cVar2.cpw = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cpx = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c alL() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cpr || TextUtils.equals(cVar.cpt, "custom");
    }
}
