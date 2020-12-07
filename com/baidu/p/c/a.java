package com.baidu.p.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cZx;
    public JSONObject dgS;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cZx = callbackHandler;
        this.dgS = jSONObject;
    }

    public void qx(String str) {
        g(str, null);
    }

    public void g(String str, JSONObject jSONObject) {
        if (this.dgS != null && this.cZx != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cZx.handleSchemeDispatchCallback(this.dgS.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
