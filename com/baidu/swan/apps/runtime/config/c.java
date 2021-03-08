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
    public String cZe;
    public String dHd;
    public String dHf;
    public boolean dHh;
    public boolean dHi;
    public boolean dHk;
    public String dHo;
    public boolean dHl = false;
    public boolean dHm = true;
    public boolean dHn = false;
    public int dHc = ViewCompat.MEASURED_STATE_MASK;
    public String dHe = "#ffffff";
    public String dHj = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    public int backgroundColor = -1;
    public boolean dHg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bQ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aJP();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aJP();
        }
        return bR(optJSONObject);
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

    private static c bR(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dHc = SwanAppConfigData.rT(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dHe = optString2;
        cVar.dHd = jSONObject.optString("navigationBarTitleText");
        cVar.dHf = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.rT(jSONObject.optString("backgroundColor"));
        cVar.dHg = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cZe = jSONObject.optString("onReachBottomDistance");
        cVar.dHh = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dHi = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dHj = jSONObject.optString("navigationStyle", DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        cVar.dHk = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dHo = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dHc = TextUtils.isEmpty(optString) ? cVar.dHc : SwanAppConfigData.rT(optString);
        cVar2.dHd = jSONObject.optString("navigationBarTitleText", cVar.dHd);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dHe;
        }
        cVar2.dHe = optString2;
        cVar2.dHf = jSONObject.optString("backgroundTextStyle", cVar.dHf);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.rT(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dHg = jSONObject.optBoolean("enablePullDownRefresh", cVar.dHg);
        cVar2.cZe = jSONObject.optString("onReachBottomDistance", cVar.cZe);
        cVar2.dHh = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dHh);
        cVar2.dHi = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dHi);
        cVar2.dHj = jSONObject.optString("navigationStyle", cVar.dHj);
        cVar2.dHk = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dHk);
        cVar2.dHl = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dHm = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aJP() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dHh || TextUtils.equals(cVar.dHj, "custom");
    }

    public void hl(boolean z) {
        if (z && !this.dHn) {
            this.dHn = true;
        }
    }
}
