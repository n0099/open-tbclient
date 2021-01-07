package com.baidu.swan.apps.runtime.config;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dIk;
    public String dIm;
    public boolean dIo;
    public boolean dIp;
    public boolean dIr;
    public String dIv;
    public String dae;
    public boolean dIs = false;
    public boolean dIt = true;
    public boolean dIu = false;
    public int dIj = ViewCompat.MEASURED_STATE_MASK;
    public String dIl = "#ffffff";
    public String dIq = "default";
    public int backgroundColor = -1;
    public boolean dIn = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aNn();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aNn();
        }
        return bS(optJSONObject);
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

    private static c bS(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dIj = SwanAppConfigData.sF(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dIl = optString2;
        cVar.dIk = jSONObject.optString("navigationBarTitleText");
        cVar.dIm = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.sF(jSONObject.optString("backgroundColor"));
        cVar.dIn = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.dae = jSONObject.optString("onReachBottomDistance");
        cVar.dIo = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dIp = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dIq = jSONObject.optString("navigationStyle", "default");
        cVar.dIr = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dIv = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dIj = TextUtils.isEmpty(optString) ? cVar.dIj : SwanAppConfigData.sF(optString);
        cVar2.dIk = jSONObject.optString("navigationBarTitleText", cVar.dIk);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dIl;
        }
        cVar2.dIl = optString2;
        cVar2.dIm = jSONObject.optString("backgroundTextStyle", cVar.dIm);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.sF(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dIn = jSONObject.optBoolean("enablePullDownRefresh", cVar.dIn);
        cVar2.dae = jSONObject.optString("onReachBottomDistance", cVar.dae);
        cVar2.dIo = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dIo);
        cVar2.dIp = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dIp);
        cVar2.dIq = jSONObject.optString("navigationStyle", cVar.dIq);
        cVar2.dIr = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dIr);
        cVar2.dIs = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dIt = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aNn() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dIo || TextUtils.equals(cVar.dIq, "custom");
    }

    public void hn(boolean z) {
        if (z && !this.dIu) {
            this.dIu = true;
        }
    }
}
