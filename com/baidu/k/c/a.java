package com.baidu.k.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cpD;
    public JSONObject crn;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cpD = callbackHandler;
        this.crn = jSONObject;
    }

    public void mk(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.crn != null && this.cpD != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cpD.handleSchemeDispatchCallback(this.crn.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
