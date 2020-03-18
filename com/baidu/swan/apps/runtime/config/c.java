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
    public boolean bQA;
    public boolean bQC;
    public String bQv;
    public String bQx;
    public boolean bQz;
    public String bsD;
    public boolean bQD = false;
    public boolean bQE = true;
    public int bQu = ViewCompat.MEASURED_STATE_MASK;
    public String bQw = "#ffffff";
    public String bQB = "default";
    public int backgroundColor = -1;
    public boolean bQy = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return adH();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return adH();
        }
        return aI(optJSONObject);
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

    private static c aI(JSONObject jSONObject) {
        c cVar = new c();
        cVar.bQu = SwanAppConfigData.cF(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bQv = jSONObject.optString("navigationBarTitleText");
        cVar.bQw = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bQx = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cF(jSONObject.optString("backgroundColor"));
        cVar.bQy = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bsD = jSONObject.optString("onReachBottomDistance");
        cVar.bQz = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bQA = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bQB = jSONObject.optString("navigationStyle", "default");
        cVar.bQC = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bQu = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cF(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bQu;
        cVar2.bQv = jSONObject.optString("navigationBarTitleText", cVar.bQv);
        cVar2.bQw = jSONObject.optString("navigationBarTextStyle", cVar.bQw);
        cVar2.bQx = jSONObject.optString("backgroundTextStyle", cVar.bQx);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cF(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bQy = jSONObject.optBoolean("enablePullDownRefresh", cVar.bQy);
        cVar2.bsD = jSONObject.optString("onReachBottomDistance", cVar.bsD);
        cVar2.bQz = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bQz);
        cVar2.bQA = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bQA);
        cVar2.bQB = jSONObject.optString("navigationStyle", cVar.bQB);
        cVar2.bQC = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bQC);
        cVar2.bQD = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bQE = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c adH() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.bQz || TextUtils.equals(cVar.bQB, "custom");
    }
}
