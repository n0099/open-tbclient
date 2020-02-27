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
    public String bQi;
    public String bQk;
    public boolean bQm;
    public boolean bQn;
    public boolean bQp;
    public String bsp;
    public boolean bQq = false;
    public boolean bQr = true;
    public int bQh = ViewCompat.MEASURED_STATE_MASK;
    public String bQj = "#ffffff";
    public String bQo = "default";
    public int backgroundColor = -1;
    public boolean bQl = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return adC();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return adC();
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
        cVar.bQh = SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bQi = jSONObject.optString("navigationBarTitleText");
        cVar.bQj = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bQk = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cG(jSONObject.optString("backgroundColor"));
        cVar.bQl = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bsp = jSONObject.optString("onReachBottomDistance");
        cVar.bQm = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bQn = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bQo = jSONObject.optString("navigationStyle", "default");
        cVar.bQp = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bQh = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bQh;
        cVar2.bQi = jSONObject.optString("navigationBarTitleText", cVar.bQi);
        cVar2.bQj = jSONObject.optString("navigationBarTextStyle", cVar.bQj);
        cVar2.bQk = jSONObject.optString("backgroundTextStyle", cVar.bQk);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bQl = jSONObject.optBoolean("enablePullDownRefresh", cVar.bQl);
        cVar2.bsp = jSONObject.optString("onReachBottomDistance", cVar.bsp);
        cVar2.bQm = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bQm);
        cVar2.bQn = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bQn);
        cVar2.bQo = jSONObject.optString("navigationStyle", cVar.bQo);
        cVar2.bQp = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bQp);
        cVar2.bQq = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bQr = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c adC() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.bQm || TextUtils.equals(cVar.bQo, "custom");
    }
}
