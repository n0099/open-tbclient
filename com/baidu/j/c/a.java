package com.baidu.j.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler bYg;
    public JSONObject bZP;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.bYg = callbackHandler;
        this.bZP = jSONObject;
    }

    public void ko(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.bZP != null && this.bYg != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.bYg.handleSchemeDispatchCallback(this.bZP.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
