package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cRI;
    public String cRK;
    public boolean cRM;
    public boolean cRN;
    public boolean cRP;
    public String cRT;
    public String cns;
    public boolean cRQ = false;
    public boolean cRR = true;
    public boolean cRS = false;
    public int cRH = ViewCompat.MEASURED_STATE_MASK;
    public String cRJ = "#ffffff";
    public String cRO = "default";
    public int backgroundColor = -1;
    public boolean cRL = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bu(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aAK();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aAK();
        }
        return bv(optJSONObject);
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

    private static c bv(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.cRH = SwanAppConfigData.fo(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.cRJ = optString2;
        cVar.cRI = jSONObject.optString("navigationBarTitleText");
        cVar.cRK = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fo(jSONObject.optString("backgroundColor"));
        cVar.cRL = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cns = jSONObject.optString("onReachBottomDistance");
        cVar.cRM = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cRN = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cRO = jSONObject.optString("navigationStyle", "default");
        cVar.cRP = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.cRT = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.cRH = TextUtils.isEmpty(optString) ? cVar.cRH : SwanAppConfigData.fo(optString);
        cVar2.cRI = jSONObject.optString("navigationBarTitleText", cVar.cRI);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.cRJ;
        }
        cVar2.cRJ = optString2;
        cVar2.cRK = jSONObject.optString("backgroundTextStyle", cVar.cRK);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fo(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cRL = jSONObject.optBoolean("enablePullDownRefresh", cVar.cRL);
        cVar2.cns = jSONObject.optString("onReachBottomDistance", cVar.cns);
        cVar2.cRM = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cRM);
        cVar2.cRN = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cRN);
        cVar2.cRO = jSONObject.optString("navigationStyle", cVar.cRO);
        cVar2.cRP = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cRP);
        cVar2.cRQ = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cRR = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aAK() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cRM || TextUtils.equals(cVar.cRO, "custom");
    }

    public void fN(boolean z) {
        if (z && !this.cRS) {
            this.cRS = true;
        }
    }
}
