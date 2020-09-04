package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler crL;
    public JSONObject czg;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.crL = callbackHandler;
        this.czg = jSONObject;
    }

    public void oj(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.czg != null && this.crL != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.crL.handleSchemeDispatchCallback(this.czg.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
