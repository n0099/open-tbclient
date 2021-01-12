package com.baidu.swan.apps.runtime.config;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cVs;
    public String dDA;
    public boolean dDC;
    public boolean dDD;
    public boolean dDF;
    public String dDJ;
    public String dDy;
    public boolean dDG = false;
    public boolean dDH = true;
    public boolean dDI = false;
    public int dDx = ViewCompat.MEASURED_STATE_MASK;
    public String dDz = "#ffffff";
    public String dDE = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    public int backgroundColor = -1;
    public boolean dDB = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aJt();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aJt();
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
        cVar.dDx = SwanAppConfigData.rt(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dDz = optString2;
        cVar.dDy = jSONObject.optString("navigationBarTitleText");
        cVar.dDA = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.rt(jSONObject.optString("backgroundColor"));
        cVar.dDB = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cVs = jSONObject.optString("onReachBottomDistance");
        cVar.dDC = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dDD = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dDE = jSONObject.optString("navigationStyle", DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        cVar.dDF = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dDJ = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dDx = TextUtils.isEmpty(optString) ? cVar.dDx : SwanAppConfigData.rt(optString);
        cVar2.dDy = jSONObject.optString("navigationBarTitleText", cVar.dDy);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dDz;
        }
        cVar2.dDz = optString2;
        cVar2.dDA = jSONObject.optString("backgroundTextStyle", cVar.dDA);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.rt(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dDB = jSONObject.optBoolean("enablePullDownRefresh", cVar.dDB);
        cVar2.cVs = jSONObject.optString("onReachBottomDistance", cVar.cVs);
        cVar2.dDC = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dDC);
        cVar2.dDD = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dDD);
        cVar2.dDE = jSONObject.optString("navigationStyle", cVar.dDE);
        cVar2.dDF = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dDF);
        cVar2.dDG = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dDH = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aJt() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dDC || TextUtils.equals(cVar.dDE, "custom");
    }

    public void hj(boolean z) {
        if (z && !this.dDI) {
            this.dDI = true;
        }
    }
}
