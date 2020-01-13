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
    public String bMd;
    public String bMf;
    public boolean bMh;
    public boolean bMi;
    public boolean bMk;
    public String bog;
    public boolean bMl = false;
    public boolean bMm = true;
    public int bMc = ViewCompat.MEASURED_STATE_MASK;
    public String bMe = "#ffffff";
    public String bMj = "default";
    public int backgroundColor = -1;
    public boolean bMg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return abo();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return abo();
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
        cVar.bMc = SwanAppConfigData.cy(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bMd = jSONObject.optString("navigationBarTitleText");
        cVar.bMe = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bMf = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cy(jSONObject.optString("backgroundColor"));
        cVar.bMg = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bog = jSONObject.optString("onReachBottomDistance");
        cVar.bMh = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bMi = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bMj = jSONObject.optString("navigationStyle", "default");
        cVar.bMk = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bMc = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cy(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bMc;
        cVar2.bMd = jSONObject.optString("navigationBarTitleText", cVar.bMd);
        cVar2.bMe = jSONObject.optString("navigationBarTextStyle", cVar.bMe);
        cVar2.bMf = jSONObject.optString("backgroundTextStyle", cVar.bMf);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cy(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bMg = jSONObject.optBoolean("enablePullDownRefresh", cVar.bMg);
        cVar2.bog = jSONObject.optString("onReachBottomDistance", cVar.bog);
        cVar2.bMh = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bMh);
        cVar2.bMi = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bMi);
        cVar2.bMj = jSONObject.optString("navigationStyle", cVar.bMj);
        cVar2.bMk = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bMk);
        cVar2.bMl = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bMm = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c abo() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.bMh || TextUtils.equals(cVar.bMj, "custom");
    }
}
