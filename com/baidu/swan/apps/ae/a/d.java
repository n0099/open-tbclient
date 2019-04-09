package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aOH;
    public String aOI;
    public String aOJ;
    public String aOK;
    public boolean aOL;
    public String aOM;
    public boolean aON;
    public boolean aOO;
    public String aOP;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d Y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return JA();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return JA();
        }
        return Z(optJSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(String str, @NonNull d dVar) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return a(new JSONObject(str), dVar);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("WindowConfig", "buildWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                    return dVar;
                }
                return dVar;
            }
        }
        return dVar;
    }

    private static d Z(JSONObject jSONObject) {
        d dVar = new d();
        dVar.aOH = c.parseColor(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aOI = jSONObject.optString("navigationBarTitleText");
        dVar.aOJ = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aOK = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.parseColor(jSONObject.optString("backgroundColor"));
        dVar.aOL = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aOM = jSONObject.optString("onReachBottomDistance");
        dVar.aON = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aOO = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aOP = jSONObject.optString("navigationStyle", "default");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aOH = jSONObject.has("navigationBarBackgroundColor") ? c.parseColor(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aOH;
        dVar2.aOI = jSONObject.optString("navigationBarTitleText", dVar.aOI);
        dVar2.aOJ = jSONObject.optString("navigationBarTextStyle", dVar.aOJ);
        dVar2.aOK = jSONObject.optString("backgroundTextStyle", dVar.aOK);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.parseColor(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aOL = jSONObject.optBoolean("enablePullDownRefresh", dVar.aOL);
        dVar2.aOM = jSONObject.optString("onReachBottomDistance", dVar.aOM);
        dVar2.aON = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aON);
        dVar2.aOO = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aOO);
        dVar2.aOP = jSONObject.optString("navigationStyle", dVar.aOP);
        return dVar2;
    }

    public static d JA() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.aON || TextUtils.equals(dVar.aOP, "custom");
    }
}
