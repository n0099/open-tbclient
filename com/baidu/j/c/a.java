package com.baidu.j.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler ciI;
    public JSONObject cks;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.ciI = callbackHandler;
        this.cks = jSONObject;
    }

    public void lB(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cks != null && this.ciI != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.ciI.handleSchemeDispatchCallback(this.cks.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
