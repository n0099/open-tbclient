package com.baidu.m.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public JSONObject bBC;
    private CallbackHandler bzU;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.bzU = callbackHandler;
        this.bBC = jSONObject;
    }

    public void jb(String str) {
        d(str, null);
    }

    public void d(String str, JSONObject jSONObject) {
        if (this.bBC != null && this.bzU != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.bzU.handleSchemeDispatchCallback(this.bBC.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
