package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public JSONObject cBh;
    private CallbackHandler ctP;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.ctP = callbackHandler;
        this.cBh = jSONObject;
    }

    public void oD(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cBh != null && this.ctP != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.ctP.handleSchemeDispatchCallback(this.cBh.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
