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
    public String cIF;
    public String cIH;
    public boolean cIJ;
    public boolean cIK;
    public boolean cIM;
    public String cgZ;
    public boolean cIN = false;
    public boolean cIO = true;
    public boolean cIP = false;
    public int cIE = ViewCompat.MEASURED_STATE_MASK;
    public String cIG = "#ffffff";
    public String cIL = "default";
    public int backgroundColor = -1;
    public boolean cII = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return asy();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return asy();
        }
        return bo(optJSONObject);
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

    private static c bo(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.cIE = SwanAppConfigData.dU(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.cIG = optString2;
        cVar.cIF = jSONObject.optString("navigationBarTitleText");
        cVar.cIH = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.dU(jSONObject.optString("backgroundColor"));
        cVar.cII = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cgZ = jSONObject.optString("onReachBottomDistance");
        cVar.cIJ = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cIK = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cIL = jSONObject.optString("navigationStyle", "default");
        cVar.cIM = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.cIE = TextUtils.isEmpty(optString) ? cVar.cIE : SwanAppConfigData.dU(optString);
        cVar2.cIF = jSONObject.optString("navigationBarTitleText", cVar.cIF);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.cIG;
        }
        cVar2.cIG = optString2;
        cVar2.cIH = jSONObject.optString("backgroundTextStyle", cVar.cIH);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.dU(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cII = jSONObject.optBoolean("enablePullDownRefresh", cVar.cII);
        cVar2.cgZ = jSONObject.optString("onReachBottomDistance", cVar.cgZ);
        cVar2.cIJ = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cIJ);
        cVar2.cIK = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cIK);
        cVar2.cIL = jSONObject.optString("navigationStyle", cVar.cIL);
        cVar2.cIM = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cIM);
        cVar2.cIN = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cIO = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c asy() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cIJ || TextUtils.equals(cVar.cIL, "custom");
    }

    public void ft(boolean z) {
        if (z && !this.cIP) {
            this.cIP = true;
        }
    }
}
