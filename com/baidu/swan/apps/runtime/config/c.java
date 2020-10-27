package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cKg;
    public String doD;
    public String dor;
    public String dou;
    public boolean dow;
    public boolean dox;
    public boolean doz;
    public boolean doA = false;
    public boolean doB = true;
    public boolean doC = false;
    public int doq = ViewCompat.MEASURED_STATE_MASK;
    public String dos = "#ffffff";
    public String doy = "default";
    public int backgroundColor = -1;
    public boolean dov = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aFW();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aFW();
        }
        return bI(optJSONObject);
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

    private static c bI(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.doq = SwanAppConfigData.fv(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dos = optString2;
        cVar.dor = jSONObject.optString("navigationBarTitleText");
        cVar.dou = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fv(jSONObject.optString("backgroundColor"));
        cVar.dov = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cKg = jSONObject.optString("onReachBottomDistance");
        cVar.dow = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dox = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.doy = jSONObject.optString("navigationStyle", "default");
        cVar.doz = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.doD = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.doq = TextUtils.isEmpty(optString) ? cVar.doq : SwanAppConfigData.fv(optString);
        cVar2.dor = jSONObject.optString("navigationBarTitleText", cVar.dor);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dos;
        }
        cVar2.dos = optString2;
        cVar2.dou = jSONObject.optString("backgroundTextStyle", cVar.dou);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fv(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dov = jSONObject.optBoolean("enablePullDownRefresh", cVar.dov);
        cVar2.cKg = jSONObject.optString("onReachBottomDistance", cVar.cKg);
        cVar2.dow = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dow);
        cVar2.dox = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dox);
        cVar2.doy = jSONObject.optString("navigationStyle", cVar.doy);
        cVar2.doz = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.doz);
        cVar2.doA = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.doB = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aFW() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dow || TextUtils.equals(cVar.doy, "custom");
    }

    public void gu(boolean z) {
        if (z && !this.doC) {
            this.doC = true;
        }
    }
}
