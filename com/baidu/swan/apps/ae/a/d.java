package com.baidu.swan.apps.ae.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.vivo.push.util.NotifyAdapterUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aRS;
    public String aRT;
    public String aRU;
    public String aRV;
    public boolean aRW;
    public String aRX;
    public boolean aRY;
    public boolean aRZ;
    public String aSa;
    public boolean aSb;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d X(JSONObject jSONObject) {
        if (jSONObject == null) {
            return MN();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return MN();
        }
        return Y(optJSONObject);
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

    private static d Y(JSONObject jSONObject) {
        d dVar = new d();
        dVar.aRS = c.cE(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aRT = jSONObject.optString("navigationBarTitleText");
        dVar.aRU = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aRV = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.cE(jSONObject.optString("backgroundColor"));
        dVar.aRW = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aRX = jSONObject.optString("onReachBottomDistance");
        dVar.aRY = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aRZ = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aSa = jSONObject.optString("navigationStyle", NotifyAdapterUtil.PRIMARY_CHANNEL);
        dVar.aSb = jSONObject.optBoolean("navigationHomeButtonHidden");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aRS = jSONObject.has("navigationBarBackgroundColor") ? c.cE(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aRS;
        dVar2.aRT = jSONObject.optString("navigationBarTitleText", dVar.aRT);
        dVar2.aRU = jSONObject.optString("navigationBarTextStyle", dVar.aRU);
        dVar2.aRV = jSONObject.optString("backgroundTextStyle", dVar.aRV);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.cE(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aRW = jSONObject.optBoolean("enablePullDownRefresh", dVar.aRW);
        dVar2.aRX = jSONObject.optString("onReachBottomDistance", dVar.aRX);
        dVar2.aRY = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aRY);
        dVar2.aRZ = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aRZ);
        dVar2.aSa = jSONObject.optString("navigationStyle", dVar.aSa);
        dVar2.aSb = jSONObject.optBoolean("navigationHomeButtonHidden", dVar.aSb);
        return dVar2;
    }

    public static d MN() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.aRY || TextUtils.equals(dVar.aSa, "custom");
    }
}
