package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cOp;
    public String dsF;
    public String dsH;
    public boolean dsJ;
    public boolean dsK;
    public boolean dsM;
    public String dsQ;
    public boolean dsN = false;
    public boolean dsO = true;
    public boolean dsP = false;
    public int dsE = ViewCompat.MEASURED_STATE_MASK;
    public String dsG = "#ffffff";
    public String dsL = "default";
    public int backgroundColor = -1;
    public boolean dsI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aHO();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aHO();
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
        cVar.dsE = SwanAppConfigData.sa(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dsG = optString2;
        cVar.dsF = jSONObject.optString("navigationBarTitleText");
        cVar.dsH = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.sa(jSONObject.optString("backgroundColor"));
        cVar.dsI = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cOp = jSONObject.optString("onReachBottomDistance");
        cVar.dsJ = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dsK = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dsL = jSONObject.optString("navigationStyle", "default");
        cVar.dsM = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dsQ = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dsE = TextUtils.isEmpty(optString) ? cVar.dsE : SwanAppConfigData.sa(optString);
        cVar2.dsF = jSONObject.optString("navigationBarTitleText", cVar.dsF);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dsG;
        }
        cVar2.dsG = optString2;
        cVar2.dsH = jSONObject.optString("backgroundTextStyle", cVar.dsH);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.sa(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dsI = jSONObject.optBoolean("enablePullDownRefresh", cVar.dsI);
        cVar2.cOp = jSONObject.optString("onReachBottomDistance", cVar.cOp);
        cVar2.dsJ = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dsJ);
        cVar2.dsK = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dsK);
        cVar2.dsL = jSONObject.optString("navigationStyle", cVar.dsL);
        cVar2.dsM = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dsM);
        cVar2.dsN = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dsO = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aHO() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dsJ || TextUtils.equals(cVar.dsL, "custom");
    }

    public void gG(boolean z) {
        if (z && !this.dsP) {
            this.dsP = true;
        }
    }
}
