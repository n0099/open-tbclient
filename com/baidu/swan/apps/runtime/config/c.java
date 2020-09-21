package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cTI;
    public String cTK;
    public boolean cTM;
    public boolean cTN;
    public boolean cTP;
    public String cTT;
    public String cpw;
    public boolean cTQ = false;
    public boolean cTR = true;
    public boolean cTS = false;
    public int cTH = ViewCompat.MEASURED_STATE_MASK;
    public String cTJ = "#ffffff";
    public String cTO = "default";
    public int backgroundColor = -1;
    public boolean cTL = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aBt();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aBt();
        }
        return by(optJSONObject);
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

    private static c by(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.cTH = SwanAppConfigData.fq(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.cTJ = optString2;
        cVar.cTI = jSONObject.optString("navigationBarTitleText");
        cVar.cTK = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fq(jSONObject.optString("backgroundColor"));
        cVar.cTL = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cpw = jSONObject.optString("onReachBottomDistance");
        cVar.cTM = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cTN = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cTO = jSONObject.optString("navigationStyle", "default");
        cVar.cTP = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.cTT = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.cTH = TextUtils.isEmpty(optString) ? cVar.cTH : SwanAppConfigData.fq(optString);
        cVar2.cTI = jSONObject.optString("navigationBarTitleText", cVar.cTI);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.cTJ;
        }
        cVar2.cTJ = optString2;
        cVar2.cTK = jSONObject.optString("backgroundTextStyle", cVar.cTK);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fq(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cTL = jSONObject.optBoolean("enablePullDownRefresh", cVar.cTL);
        cVar2.cpw = jSONObject.optString("onReachBottomDistance", cVar.cpw);
        cVar2.cTM = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cTM);
        cVar2.cTN = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cTN);
        cVar2.cTO = jSONObject.optString("navigationStyle", cVar.cTO);
        cVar2.cTP = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cTP);
        cVar2.cTQ = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cTR = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aBt() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cTM || TextUtils.equals(cVar.cTO, "custom");
    }

    public void fL(boolean z) {
        if (z && !this.cTS) {
            this.cTS = true;
        }
    }
}
