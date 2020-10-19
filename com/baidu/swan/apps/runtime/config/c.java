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
    public String cBK;
    public String dfQ;
    public String dfS;
    public boolean dfU;
    public boolean dfV;
    public boolean dfX;
    public String dgb;
    public boolean dfY = false;
    public boolean dfZ = true;
    public boolean dga = false;
    public int dfP = ViewCompat.MEASURED_STATE_MASK;
    public String dfR = "#ffffff";
    public String dfW = "default";
    public int backgroundColor = -1;
    public boolean dfT = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bE(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aEc();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aEc();
        }
        return bF(optJSONObject);
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

    private static c bF(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dfP = SwanAppConfigData.fv(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dfR = optString2;
        cVar.dfQ = jSONObject.optString("navigationBarTitleText");
        cVar.dfS = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fv(jSONObject.optString("backgroundColor"));
        cVar.dfT = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cBK = jSONObject.optString("onReachBottomDistance");
        cVar.dfU = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dfV = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dfW = jSONObject.optString("navigationStyle", "default");
        cVar.dfX = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dgb = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dfP = TextUtils.isEmpty(optString) ? cVar.dfP : SwanAppConfigData.fv(optString);
        cVar2.dfQ = jSONObject.optString("navigationBarTitleText", cVar.dfQ);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dfR;
        }
        cVar2.dfR = optString2;
        cVar2.dfS = jSONObject.optString("backgroundTextStyle", cVar.dfS);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fv(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dfT = jSONObject.optBoolean("enablePullDownRefresh", cVar.dfT);
        cVar2.cBK = jSONObject.optString("onReachBottomDistance", cVar.cBK);
        cVar2.dfU = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dfU);
        cVar2.dfV = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dfV);
        cVar2.dfW = jSONObject.optString("navigationStyle", cVar.dfW);
        cVar2.dfX = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dfX);
        cVar2.dfY = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dfZ = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aEc() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dfU || TextUtils.equals(cVar.dfW, "custom");
    }

    public void gh(boolean z) {
        if (z && !this.dga) {
            this.dga = true;
        }
    }
}
