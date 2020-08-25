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
    public String cRE;
    public String cRG;
    public boolean cRI;
    public boolean cRJ;
    public boolean cRL;
    public String cRP;
    public String cno;
    public boolean cRM = false;
    public boolean cRN = true;
    public boolean cRO = false;
    public int cRD = ViewCompat.MEASURED_STATE_MASK;
    public String cRF = "#ffffff";
    public String cRK = "default";
    public int backgroundColor = -1;
    public boolean cRH = false;

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
        cVar.cRD = SwanAppConfigData.fn(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.cRF = optString2;
        cVar.cRE = jSONObject.optString("navigationBarTitleText");
        cVar.cRG = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fn(jSONObject.optString("backgroundColor"));
        cVar.cRH = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cno = jSONObject.optString("onReachBottomDistance");
        cVar.cRI = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cRJ = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cRK = jSONObject.optString("navigationStyle", "default");
        cVar.cRL = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.cRP = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.cRD = TextUtils.isEmpty(optString) ? cVar.cRD : SwanAppConfigData.fn(optString);
        cVar2.cRE = jSONObject.optString("navigationBarTitleText", cVar.cRE);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.cRF;
        }
        cVar2.cRF = optString2;
        cVar2.cRG = jSONObject.optString("backgroundTextStyle", cVar.cRG);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fn(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cRH = jSONObject.optBoolean("enablePullDownRefresh", cVar.cRH);
        cVar2.cno = jSONObject.optString("onReachBottomDistance", cVar.cno);
        cVar2.cRI = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cRI);
        cVar2.cRJ = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cRJ);
        cVar2.cRK = jSONObject.optString("navigationStyle", cVar.cRK);
        cVar2.cRL = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cRL);
        cVar2.cRM = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cRN = jSONObject.optBoolean("pageFavoriteEnable", true);
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
        return cVar.cRI || TextUtils.equals(cVar.cRK, "custom");
    }

    public void fM(boolean z) {
        if (z && !this.cRO) {
            this.cRO = true;
        }
    }
}
