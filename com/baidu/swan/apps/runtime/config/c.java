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
    public String cBd;
    public String cBf;
    public boolean cBh;
    public boolean cBi;
    public boolean cBk;
    public String caA;
    public boolean cBl = false;
    public boolean cBm = true;
    public boolean cBn = false;
    public int cBc = ViewCompat.MEASURED_STATE_MASK;
    public String cBe = "#ffffff";
    public String cBj = "default";
    public int backgroundColor = -1;
    public boolean cBg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return apJ();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return apJ();
        }
        return bc(optJSONObject);
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

    private static c bc(JSONObject jSONObject) {
        c cVar = new c();
        cVar.cBc = SwanAppConfigData.dT(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.cBd = jSONObject.optString("navigationBarTitleText");
        cVar.cBe = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.cBf = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.dT(jSONObject.optString("backgroundColor"));
        cVar.cBg = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.caA = jSONObject.optString("onReachBottomDistance");
        cVar.cBh = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.cBi = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.cBj = jSONObject.optString("navigationStyle", "default");
        cVar.cBk = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.cBc = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.dT(jSONObject.optString("navigationBarBackgroundColor")) : cVar.cBc;
        cVar2.cBd = jSONObject.optString("navigationBarTitleText", cVar.cBd);
        cVar2.cBe = jSONObject.optString("navigationBarTextStyle", cVar.cBe);
        cVar2.cBf = jSONObject.optString("backgroundTextStyle", cVar.cBf);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.dT(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.cBg = jSONObject.optBoolean("enablePullDownRefresh", cVar.cBg);
        cVar2.caA = jSONObject.optString("onReachBottomDistance", cVar.caA);
        cVar2.cBh = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.cBh);
        cVar2.cBi = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.cBi);
        cVar2.cBj = jSONObject.optString("navigationStyle", cVar.cBj);
        cVar2.cBk = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.cBk);
        cVar2.cBl = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.cBm = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c apJ() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cBh || TextUtils.equals(cVar.cBj, "custom");
    }

    public void ff(boolean z) {
        if (z && !this.cBn) {
            this.cBn = true;
        }
    }
}
