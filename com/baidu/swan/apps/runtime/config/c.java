package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cVi;
    public String dzF;
    public String dzH;
    public boolean dzJ;
    public boolean dzK;
    public boolean dzM;
    public String dzQ;
    public boolean dzN = false;
    public boolean dzO = true;
    public boolean dzP = false;
    public int dzE = ViewCompat.MEASURED_STATE_MASK;
    public String dzG = "#ffffff";
    public String dzL = "default";
    public int backgroundColor = -1;
    public boolean dzI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aKW();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aKW();
        }
        return bK(optJSONObject);
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

    private static c bK(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dzE = SwanAppConfigData.sI(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dzG = optString2;
        cVar.dzF = jSONObject.optString("navigationBarTitleText");
        cVar.dzH = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.sI(jSONObject.optString("backgroundColor"));
        cVar.dzI = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cVi = jSONObject.optString("onReachBottomDistance");
        cVar.dzJ = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dzK = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dzL = jSONObject.optString("navigationStyle", "default");
        cVar.dzM = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dzQ = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dzE = TextUtils.isEmpty(optString) ? cVar.dzE : SwanAppConfigData.sI(optString);
        cVar2.dzF = jSONObject.optString("navigationBarTitleText", cVar.dzF);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dzG;
        }
        cVar2.dzG = optString2;
        cVar2.dzH = jSONObject.optString("backgroundTextStyle", cVar.dzH);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.sI(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dzI = jSONObject.optBoolean("enablePullDownRefresh", cVar.dzI);
        cVar2.cVi = jSONObject.optString("onReachBottomDistance", cVar.cVi);
        cVar2.dzJ = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dzJ);
        cVar2.dzK = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dzK);
        cVar2.dzL = jSONObject.optString("navigationStyle", cVar.dzL);
        cVar2.dzM = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dzM);
        cVar2.dzN = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dzO = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aKW() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dzJ || TextUtils.equals(cVar.dzL, "custom");
    }

    public void gV(boolean z) {
        if (z && !this.dzP) {
            this.dzP = true;
        }
    }
}
