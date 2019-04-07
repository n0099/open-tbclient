package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aOG;
    public String aOH;
    public String aOI;
    public String aOJ;
    public boolean aOK;
    public String aOL;
    public boolean aOM;
    public boolean aON;
    public String aOO;
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
        dVar.aOG = c.parseColor(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aOH = jSONObject.optString("navigationBarTitleText");
        dVar.aOI = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aOJ = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.parseColor(jSONObject.optString("backgroundColor"));
        dVar.aOK = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aOL = jSONObject.optString("onReachBottomDistance");
        dVar.aOM = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aON = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aOO = jSONObject.optString("navigationStyle", "default");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aOG = jSONObject.has("navigationBarBackgroundColor") ? c.parseColor(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aOG;
        dVar2.aOH = jSONObject.optString("navigationBarTitleText", dVar.aOH);
        dVar2.aOI = jSONObject.optString("navigationBarTextStyle", dVar.aOI);
        dVar2.aOJ = jSONObject.optString("backgroundTextStyle", dVar.aOJ);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.parseColor(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aOK = jSONObject.optBoolean("enablePullDownRefresh", dVar.aOK);
        dVar2.aOL = jSONObject.optString("onReachBottomDistance", dVar.aOL);
        dVar2.aOM = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aOM);
        dVar2.aON = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aON);
        dVar2.aOO = jSONObject.optString("navigationStyle", dVar.aOO);
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
        return dVar.aOM || TextUtils.equals(dVar.aOO, "custom");
    }
}
