package com.baidu.m.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler buK;
    public JSONObject bwu;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.buK = callbackHandler;
        this.bwu = jSONObject;
    }

    public void iK(String str) {
        d(str, null);
    }

    public void d(String str, JSONObject jSONObject) {
        if (this.bwu != null && this.buK != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.buK.handleSchemeDispatchCallback(this.bwu.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
