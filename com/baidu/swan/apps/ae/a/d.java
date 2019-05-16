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
    public int aQK;
    public String aQL;
    public String aQM;
    public String aQN;
    public boolean aQO;
    public String aQP;
    public boolean aQQ;
    public boolean aQR;
    public String aQS;
    public boolean aQT;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d X(JSONObject jSONObject) {
        if (jSONObject == null) {
            return LV();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return LV();
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
        dVar.aQK = c.parseColor(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aQL = jSONObject.optString("navigationBarTitleText");
        dVar.aQM = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aQN = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.parseColor(jSONObject.optString("backgroundColor"));
        dVar.aQO = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aQP = jSONObject.optString("onReachBottomDistance");
        dVar.aQQ = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aQR = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aQS = jSONObject.optString("navigationStyle", NotifyAdapterUtil.PRIMARY_CHANNEL);
        dVar.aQT = jSONObject.optBoolean("navigationHomeButtonHidden");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aQK = jSONObject.has("navigationBarBackgroundColor") ? c.parseColor(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aQK;
        dVar2.aQL = jSONObject.optString("navigationBarTitleText", dVar.aQL);
        dVar2.aQM = jSONObject.optString("navigationBarTextStyle", dVar.aQM);
        dVar2.aQN = jSONObject.optString("backgroundTextStyle", dVar.aQN);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.parseColor(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aQO = jSONObject.optBoolean("enablePullDownRefresh", dVar.aQO);
        dVar2.aQP = jSONObject.optString("onReachBottomDistance", dVar.aQP);
        dVar2.aQQ = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aQQ);
        dVar2.aQR = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aQR);
        dVar2.aQS = jSONObject.optString("navigationStyle", dVar.aQS);
        dVar2.aQT = jSONObject.optBoolean("navigationHomeButtonHidden", dVar.aQT);
        return dVar2;
    }

    public static d LV() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.aQQ || TextUtils.equals(dVar.aQS, "custom");
    }
}
