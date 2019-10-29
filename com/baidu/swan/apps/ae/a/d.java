package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bkW;
    public String bkX;
    public String bkY;
    public String bkZ;
    public boolean bla;
    public String blb;
    public boolean blc;
    public boolean bld;
    public String ble;
    public boolean blf;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d av(JSONObject jSONObject) {
        if (jSONObject == null) {
            return RF();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return RF();
        }
        return aw(optJSONObject);
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

    private static d aw(JSONObject jSONObject) {
        d dVar = new d();
        dVar.bkW = c.bR(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.bkX = jSONObject.optString("navigationBarTitleText");
        dVar.bkY = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.bkZ = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.bR(jSONObject.optString("backgroundColor"));
        dVar.bla = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.blb = jSONObject.optString("onReachBottomDistance");
        dVar.blc = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.bld = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.ble = jSONObject.optString("navigationStyle", "default");
        dVar.blf = jSONObject.optBoolean("navigationHomeButtonHidden");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.bkW = jSONObject.has("navigationBarBackgroundColor") ? c.bR(jSONObject.optString("navigationBarBackgroundColor")) : dVar.bkW;
        dVar2.bkX = jSONObject.optString("navigationBarTitleText", dVar.bkX);
        dVar2.bkY = jSONObject.optString("navigationBarTextStyle", dVar.bkY);
        dVar2.bkZ = jSONObject.optString("backgroundTextStyle", dVar.bkZ);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.bR(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.bla = jSONObject.optBoolean("enablePullDownRefresh", dVar.bla);
        dVar2.blb = jSONObject.optString("onReachBottomDistance", dVar.blb);
        dVar2.blc = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.blc);
        dVar2.bld = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.bld);
        dVar2.ble = jSONObject.optString("navigationStyle", dVar.ble);
        dVar2.blf = jSONObject.optBoolean("navigationHomeButtonHidden", dVar.blf);
        return dVar2;
    }

    public static d RF() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.blc || TextUtils.equals(dVar.ble, "custom");
    }
}
