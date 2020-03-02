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
    public String bQj;
    public String bQl;
    public boolean bQn;
    public boolean bQo;
    public boolean bQq;
    public String bsq;
    public boolean bQr = false;
    public boolean bQs = true;
    public int bQi = ViewCompat.MEASURED_STATE_MASK;
    public String bQk = "#ffffff";
    public String bQp = "default";
    public int backgroundColor = -1;
    public boolean bQm = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return adE();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return adE();
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
        cVar.bQi = SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bQj = jSONObject.optString("navigationBarTitleText");
        cVar.bQk = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bQl = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cG(jSONObject.optString("backgroundColor"));
        cVar.bQm = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bsq = jSONObject.optString("onReachBottomDistance");
        cVar.bQn = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bQo = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bQp = jSONObject.optString("navigationStyle", "default");
        cVar.bQq = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bQi = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bQi;
        cVar2.bQj = jSONObject.optString("navigationBarTitleText", cVar.bQj);
        cVar2.bQk = jSONObject.optString("navigationBarTextStyle", cVar.bQk);
        cVar2.bQl = jSONObject.optString("backgroundTextStyle", cVar.bQl);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bQm = jSONObject.optBoolean("enablePullDownRefresh", cVar.bQm);
        cVar2.bsq = jSONObject.optString("onReachBottomDistance", cVar.bsq);
        cVar2.bQn = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bQn);
        cVar2.bQo = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bQo);
        cVar2.bQp = jSONObject.optString("navigationStyle", cVar.bQp);
        cVar2.bQq = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bQq);
        cVar2.bQr = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bQs = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c adE() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.bQn || TextUtils.equals(cVar.bQp, "custom");
    }
}
