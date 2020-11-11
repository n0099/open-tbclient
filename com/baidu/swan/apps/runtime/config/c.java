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
    public String cPZ;
    public String dun;
    public String dup;
    public boolean dur;
    public boolean dus;
    public boolean duu;
    public String duy;
    public boolean duv = false;
    public boolean duw = true;
    public boolean dux = false;
    public int dum = ViewCompat.MEASURED_STATE_MASK;
    public String duo = "#ffffff";
    public String dut = "default";
    public int backgroundColor = -1;
    public boolean duq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aIw();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aIw();
        }
        return bO(optJSONObject);
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

    private static c bO(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dum = SwanAppConfigData.fv(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.duo = optString2;
        cVar.dun = jSONObject.optString("navigationBarTitleText");
        cVar.dup = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.fv(jSONObject.optString("backgroundColor"));
        cVar.duq = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cPZ = jSONObject.optString("onReachBottomDistance");
        cVar.dur = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dus = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dut = jSONObject.optString("navigationStyle", "default");
        cVar.duu = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.duy = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dum = TextUtils.isEmpty(optString) ? cVar.dum : SwanAppConfigData.fv(optString);
        cVar2.dun = jSONObject.optString("navigationBarTitleText", cVar.dun);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.duo;
        }
        cVar2.duo = optString2;
        cVar2.dup = jSONObject.optString("backgroundTextStyle", cVar.dup);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.fv(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.duq = jSONObject.optBoolean("enablePullDownRefresh", cVar.duq);
        cVar2.cPZ = jSONObject.optString("onReachBottomDistance", cVar.cPZ);
        cVar2.dur = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dur);
        cVar2.dus = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dus);
        cVar2.dut = jSONObject.optString("navigationStyle", cVar.dut);
        cVar2.duu = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.duu);
        cVar2.duv = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.duw = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aIw() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dur || TextUtils.equals(cVar.dut, "custom");
    }

    public void gD(boolean z) {
        if (z && !this.dux) {
            this.dux = true;
        }
    }
}
