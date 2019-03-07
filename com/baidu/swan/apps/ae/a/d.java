package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public int aOC;
    public String aOD;
    public String aOE;
    public String aOF;
    public boolean aOG;
    public String aOH;
    public boolean aOI;
    public boolean aOJ;
    public String aOK;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d Y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return JC();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return JC();
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
        dVar.aOC = c.parseColor(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aOD = jSONObject.optString("navigationBarTitleText");
        dVar.aOE = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aOF = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.parseColor(jSONObject.optString("backgroundColor"));
        dVar.aOG = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aOH = jSONObject.optString("onReachBottomDistance");
        dVar.aOI = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aOJ = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aOK = jSONObject.optString("navigationStyle", "default");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aOC = jSONObject.has("navigationBarBackgroundColor") ? c.parseColor(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aOC;
        dVar2.aOD = jSONObject.optString("navigationBarTitleText", dVar.aOD);
        dVar2.aOE = jSONObject.optString("navigationBarTextStyle", dVar.aOE);
        dVar2.aOF = jSONObject.optString("backgroundTextStyle", dVar.aOF);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.parseColor(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aOG = jSONObject.optBoolean("enablePullDownRefresh", dVar.aOG);
        dVar2.aOH = jSONObject.optString("onReachBottomDistance", dVar.aOH);
        dVar2.aOI = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aOI);
        dVar2.aOJ = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aOJ);
        dVar2.aOK = jSONObject.optString("navigationStyle", dVar.aOK);
        return dVar2;
    }

    public static d JC() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.aOI || TextUtils.equals(dVar.aOK, "custom");
    }
}
