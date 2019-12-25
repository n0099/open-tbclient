package com.baidu.swan.apps.runtime.config;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bLA;
    public String bLt;
    public String bLv;
    public boolean bLx;
    public boolean bLy;
    public String bns;
    public boolean bLB = false;
    public boolean bLC = true;
    public int bLs = ViewCompat.MEASURED_STATE_MASK;
    public String bLu = "#ffffff";
    public String bLz = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    public int backgroundColor = -1;
    public boolean bLw = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return aaR();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return aaR();
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
        cVar.bLs = SwanAppConfigData.cy(jSONObject.optString("navigationBarBackgroundColor"));
        cVar.bLt = jSONObject.optString("navigationBarTitleText");
        cVar.bLu = jSONObject.optString("navigationBarTextStyle", "white");
        cVar.bLv = jSONObject.optString("backgroundTextStyle", "black");
        cVar.backgroundColor = SwanAppConfigData.cy(jSONObject.optString("backgroundColor"));
        cVar.bLw = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.bns = jSONObject.optString("onReachBottomDistance");
        cVar.bLx = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.bLy = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.bLz = jSONObject.optString("navigationStyle", DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        cVar.bLA = jSONObject.optBoolean("navigationHomeButtonHidden");
        return cVar;
    }

    private static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        cVar2.bLs = jSONObject.has("navigationBarBackgroundColor") ? SwanAppConfigData.cy(jSONObject.optString("navigationBarBackgroundColor")) : cVar.bLs;
        cVar2.bLt = jSONObject.optString("navigationBarTitleText", cVar.bLt);
        cVar2.bLu = jSONObject.optString("navigationBarTextStyle", cVar.bLu);
        cVar2.bLv = jSONObject.optString("backgroundTextStyle", cVar.bLv);
        cVar2.backgroundColor = jSONObject.has("backgroundColor") ? SwanAppConfigData.cy(jSONObject.optString("backgroundColor")) : cVar.backgroundColor;
        cVar2.bLw = jSONObject.optBoolean("enablePullDownRefresh", cVar.bLw);
        cVar2.bns = jSONObject.optString("onReachBottomDistance", cVar.bns);
        cVar2.bLx = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.bLx);
        cVar2.bLy = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.bLy);
        cVar2.bLz = jSONObject.optString("navigationStyle", cVar.bLz);
        cVar2.bLA = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.bLA);
        cVar2.bLB = jSONObject.optBoolean("disableSwipeBack", false);
        cVar2.bLC = jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static c aaR() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.bLx || TextUtils.equals(cVar.bLz, "custom");
    }
}
