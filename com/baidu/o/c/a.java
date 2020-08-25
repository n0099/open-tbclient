package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler crH;
    public JSONObject czc;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.crH = callbackHandler;
        this.czc = jSONObject;
    }

    public void oi(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.czc != null && this.crH != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.crH.handleSchemeDispatchCallback(this.czc.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
