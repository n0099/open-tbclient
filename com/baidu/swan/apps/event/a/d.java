package com.baidu.swan.apps.event.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String clA;
    public final String mData;

    public d(String str, String str2) {
        this.clA = str;
        this.mData = str2;
    }

    public static d mR(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e));
            }
            return null;
        }
    }
}
