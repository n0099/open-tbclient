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
    public String cFN;
    public String cFP;
    public boolean cFR;
    public boolean cFS;
    public boolean cFU;
    public String cfp;
    public boolean cFV = false;
    public boolean cFW = true;
    public boolean cFX = false;
    public int cFM = ViewCompat.MEASURED_STATE_MASK;
    public String cFO = "#ffffff";
    public String cFT = "default";
    public int backgroundColor = -1;
    public boolean cFQ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bi(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aqP();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aqP();
        }
        return bj(optJSONObject);
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

    private static c bj(JSONObject jSONObject) {
        c cVar = new c();
        cVar.cFM = SwanAppConfigData.dV(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.cFN = jSONObject.optString("navigationBarTitleText");
        cVar.cFO = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.cFP = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.dV(jSONObject.optString("backgroundColor"));
        cVar.cFQ = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cfp = jSONObject.optString("onReachBottomDistance");
        cVar.cFR = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cFS = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cFT = jSONObject.optString("navigationStyle", "default");
        cVar.cFU = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.cFM = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.dV(jSONObject.optString("navigationBarBackgroundColor")) : cVar.cFM;
        cVar2.cFN = jSONObject.optString("navigationBarTitleText", cVar.cFN);
        cVar2.cFO = jSONObject.optString("navigationBarTextStyle", cVar.cFO);
        cVar2.cFP = jSONObject.optString("backgroundTextStyle", cVar.cFP);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.dV(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cFQ = jSONObject.optBoolean("enablePullDownRefresh", cVar.cFQ);
        cVar2.cfp = jSONObject.optString("onReachBottomDistance", cVar.cfp);
        cVar2.cFR = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cFR);
        cVar2.cFS = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cFS);
        cVar2.cFT = jSONObject.optString("navigationStyle", cVar.cFT);
        cVar2.cFU = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cFU);
        cVar2.cFV = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cFW = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aqP() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cFR || TextUtils.equals(cVar.cFT, "custom");
    }

    public void fk(boolean z) {
        if (z && !this.cFX) {
            this.cFX = true;
        }
    }
}
