package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aOD;
    public String aOE;
    public String aOF;
    public String aOG;
    public boolean aOH;
    public String aOI;
    public boolean aOJ;
    public boolean aOK;
    public String aOL;
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
        dVar.aOD = c.parseColor(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aOE = jSONObject.optString("navigationBarTitleText");
        dVar.aOF = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aOG = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.parseColor(jSONObject.optString("backgroundColor"));
        dVar.aOH = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aOI = jSONObject.optString("onReachBottomDistance");
        dVar.aOJ = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aOK = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aOL = jSONObject.optString("navigationStyle", "default");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aOD = jSONObject.has("navigationBarBackgroundColor") ? c.parseColor(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aOD;
        dVar2.aOE = jSONObject.optString("navigationBarTitleText", dVar.aOE);
        dVar2.aOF = jSONObject.optString("navigationBarTextStyle", dVar.aOF);
        dVar2.aOG = jSONObject.optString("backgroundTextStyle", dVar.aOG);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.parseColor(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aOH = jSONObject.optBoolean("enablePullDownRefresh", dVar.aOH);
        dVar2.aOI = jSONObject.optString("onReachBottomDistance", dVar.aOI);
        dVar2.aOJ = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aOJ);
        dVar2.aOK = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aOK);
        dVar2.aOL = jSONObject.optString("navigationStyle", dVar.aOL);
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
        return dVar.aOJ || TextUtils.equals(dVar.aOL, "custom");
    }
}
