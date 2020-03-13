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
    public String bQk;
    public String bQm;
    public boolean bQo;
    public boolean bQp;
    public boolean bQr;
    public String bsr;
    public boolean bQs = false;
    public boolean bQt = true;
    public int bQj = ViewCompat.MEASURED_STATE_MASK;
    public String bQl = "#ffffff";
    public String bQq = "default";
    public int backgroundColor = -1;
    public boolean bQn = false;

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
        cVar.bQj = SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bQk = jSONObject.optString("navigationBarTitleText");
        cVar.bQl = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bQm = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cG(jSONObject.optString("backgroundColor"));
        cVar.bQn = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bsr = jSONObject.optString("onReachBottomDistance");
        cVar.bQo = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bQp = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bQq = jSONObject.optString("navigationStyle", "default");
        cVar.bQr = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bQj = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bQj;
        cVar2.bQk = jSONObject.optString("navigationBarTitleText", cVar.bQk);
        cVar2.bQl = jSONObject.optString("navigationBarTextStyle", cVar.bQl);
        cVar2.bQm = jSONObject.optString("backgroundTextStyle", cVar.bQm);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cG(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bQn = jSONObject.optBoolean("enablePullDownRefresh", cVar.bQn);
        cVar2.bsr = jSONObject.optString("onReachBottomDistance", cVar.bsr);
        cVar2.bQo = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bQo);
        cVar2.bQp = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bQp);
        cVar2.bQq = jSONObject.optString("navigationStyle", cVar.bQq);
        cVar2.bQr = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bQr);
        cVar2.bQs = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bQt = jSONObject.optBoolean("pageFavoriteEnable", true);
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
        return cVar.bQo || TextUtils.equals(cVar.bQq, "custom");
    }
}
