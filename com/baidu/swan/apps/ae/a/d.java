package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bkE;
    public String bkF;
    public String bkG;
    public String bkH;
    public boolean bkI;
    public String bkJ;
    public boolean bkK;
    public boolean bkL;
    public String bkM;
    public boolean bkN;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d aw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return RH();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return RH();
        }
        return ax(optJSONObject);
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

    private static d ax(JSONObject jSONObject) {
        d dVar = new d();
        dVar.bkE = c.bR(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.bkF = jSONObject.optString("navigationBarTitleText");
        dVar.bkG = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.bkH = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.bR(jSONObject.optString("backgroundColor"));
        dVar.bkI = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.bkJ = jSONObject.optString("onReachBottomDistance");
        dVar.bkK = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.bkL = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.bkM = jSONObject.optString("navigationStyle", "default");
        dVar.bkN = jSONObject.optBoolean("navigationHomeButtonHidden");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.bkE = jSONObject.has("navigationBarBackgroundColor") ? c.bR(jSONObject.optString("navigationBarBackgroundColor")) : dVar.bkE;
        dVar2.bkF = jSONObject.optString("navigationBarTitleText", dVar.bkF);
        dVar2.bkG = jSONObject.optString("navigationBarTextStyle", dVar.bkG);
        dVar2.bkH = jSONObject.optString("backgroundTextStyle", dVar.bkH);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.bR(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.bkI = jSONObject.optBoolean("enablePullDownRefresh", dVar.bkI);
        dVar2.bkJ = jSONObject.optString("onReachBottomDistance", dVar.bkJ);
        dVar2.bkK = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.bkK);
        dVar2.bkL = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.bkL);
        dVar2.bkM = jSONObject.optString("navigationStyle", dVar.bkM);
        dVar2.bkN = jSONObject.optBoolean("navigationHomeButtonHidden", dVar.bkN);
        return dVar2;
    }

    public static d RH() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.bkK || TextUtils.equals(dVar.bkM, "custom");
    }
}
