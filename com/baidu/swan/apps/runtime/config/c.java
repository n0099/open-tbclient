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
    public String bQJ;
    public String cph;
    public String cpj;
    public boolean cpl;
    public boolean cpm;
    public boolean cpo;
    public boolean cpp = false;
    public boolean cpq = true;
    public int cpg = ViewCompat.MEASURED_STATE_MASK;
    public String cpi = "#ffffff";
    public String cpn = "default";
    public int backgroundColor = -1;
    public boolean cpk = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return alM();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return alM();
        }
        return aT(optJSONObject);
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

    private static c aT(JSONObject jSONObject) {
        c cVar = new c();
        cVar.cpg = SwanAppConfigData.dA(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.cph = jSONObject.optString("navigationBarTitleText");
        cVar.cpi = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.cpj = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.dA(jSONObject.optString("backgroundColor"));
        cVar.cpk = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bQJ = jSONObject.optString("onReachBottomDistance");
        cVar.cpl = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cpm = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cpn = jSONObject.optString("navigationStyle", "default");
        cVar.cpo = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.cpg = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.dA(jSONObject.optString("navigationBarBackgroundColor")) : cVar.cpg;
        cVar2.cph = jSONObject.optString("navigationBarTitleText", cVar.cph);
        cVar2.cpi = jSONObject.optString("navigationBarTextStyle", cVar.cpi);
        cVar2.cpj = jSONObject.optString("backgroundTextStyle", cVar.cpj);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.dA(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cpk = jSONObject.optBoolean("enablePullDownRefresh", cVar.cpk);
        cVar2.bQJ = jSONObject.optString("onReachBottomDistance", cVar.bQJ);
        cVar2.cpl = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cpl);
        cVar2.cpm = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cpm);
        cVar2.cpn = jSONObject.optString("navigationStyle", cVar.cpn);
        cVar2.cpo = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cpo);
        cVar2.cpp = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cpq = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c alM() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cpl || TextUtils.equals(cVar.cpn, "custom");
    }
}
