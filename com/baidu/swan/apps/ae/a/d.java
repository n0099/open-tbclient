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
    public boolean aRA;
    public boolean aRB;
    public String aRC;
    public boolean aRD;
    public int aRu;
    public String aRv;
    public String aRw;
    public String aRx;
    public boolean aRy;
    public String aRz;
    public int mBackgroundColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d X(JSONObject jSONObject) {
        if (jSONObject == null) {
            return MJ();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return MJ();
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
        dVar.aRu = c.cE(jSONObject.optString("navigationBarBackgroundColor"));
        dVar.aRv = jSONObject.optString("navigationBarTitleText");
        dVar.aRw = jSONObject.optString("navigationBarTextStyle", "black");
        dVar.aRx = jSONObject.optString("backgroundTextStyle", "black");
        dVar.mBackgroundColor = c.cE(jSONObject.optString("backgroundColor"));
        dVar.aRy = jSONObject.optBoolean("enablePullDownRefresh");
        dVar.aRz = jSONObject.optString("onReachBottomDistance");
        dVar.aRA = jSONObject.optBoolean("enableOpacityNavigationBar");
        dVar.aRB = jSONObject.optBoolean("enableOpacityNavigationBarText");
        dVar.aRC = jSONObject.optString("navigationStyle", NotifyAdapterUtil.PRIMARY_CHANNEL);
        dVar.aRD = jSONObject.optBoolean("navigationHomeButtonHidden");
        return dVar;
    }

    private static d a(JSONObject jSONObject, @NonNull d dVar) {
        d dVar2 = new d();
        dVar2.aRu = jSONObject.has("navigationBarBackgroundColor") ? c.cE(jSONObject.optString("navigationBarBackgroundColor")) : dVar.aRu;
        dVar2.aRv = jSONObject.optString("navigationBarTitleText", dVar.aRv);
        dVar2.aRw = jSONObject.optString("navigationBarTextStyle", dVar.aRw);
        dVar2.aRx = jSONObject.optString("backgroundTextStyle", dVar.aRx);
        dVar2.mBackgroundColor = jSONObject.has("backgroundColor") ? c.cE(jSONObject.optString("backgroundColor")) : dVar.mBackgroundColor;
        dVar2.aRy = jSONObject.optBoolean("enablePullDownRefresh", dVar.aRy);
        dVar2.aRz = jSONObject.optString("onReachBottomDistance", dVar.aRz);
        dVar2.aRA = jSONObject.optBoolean("enableOpacityNavigationBar", dVar.aRA);
        dVar2.aRB = jSONObject.optBoolean("enableOpacityNavigationBarText", dVar.aRB);
        dVar2.aRC = jSONObject.optString("navigationStyle", dVar.aRC);
        dVar2.aRD = jSONObject.optBoolean("navigationHomeButtonHidden", dVar.aRD);
        return dVar2;
    }

    public static d MJ() {
        if (DEBUG) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new d();
    }

    public static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.aRA || TextUtils.equals(dVar.aRC, "custom");
    }
}
