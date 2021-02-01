package com.baidu.swan.apps.runtime.config;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cXE;
    public String dFC;
    public String dFE;
    public boolean dFG;
    public boolean dFH;
    public boolean dFJ;
    public String dFN;
    public boolean dFK = false;
    public boolean dFL = true;
    public boolean dFM = false;
    public int dFB = ViewCompat.MEASURED_STATE_MASK;
    public String dFD = "#ffffff";
    public String dFI = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    public int backgroundColor = -1;
    public boolean dFF = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aJM();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aJM();
        }
        return bP(optJSONObject);
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

    private static c bP(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.dFB = SwanAppConfigData.rM(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.dFD = optString2;
        cVar.dFC = jSONObject.optString("navigationBarTitleText");
        cVar.dFE = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.rM(jSONObject.optString("backgroundColor"));
        cVar.dFF = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.cXE = jSONObject.optString("onReachBottomDistance");
        cVar.dFG = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.dFH = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.dFI = jSONObject.optString("navigationStyle", DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        cVar.dFJ = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.dFN = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.dFB = TextUtils.isEmpty(optString) ? cVar.dFB : SwanAppConfigData.rM(optString);
        cVar2.dFC = jSONObject.optString("navigationBarTitleText", cVar.dFC);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.dFD;
        }
        cVar2.dFD = optString2;
        cVar2.dFE = jSONObject.optString("backgroundTextStyle", cVar.dFE);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.rM(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.dFF = jSONObject.optBoolean("enablePullDownRefresh", cVar.dFF);
        cVar2.cXE = jSONObject.optString("onReachBottomDistance", cVar.cXE);
        cVar2.dFG = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.dFG);
        cVar2.dFH = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.dFH);
        cVar2.dFI = jSONObject.optString("navigationStyle", cVar.dFI);
        cVar2.dFJ = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.dFJ);
        cVar2.dFK = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.dFL = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aJM() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dFG || TextUtils.equals(cVar.dFI, "custom");
    }

    public void hl(boolean z) {
        if (z && !this.dFM) {
            this.dFM = true;
        }
    }
}
