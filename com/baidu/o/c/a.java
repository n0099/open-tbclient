package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cSD;
    public JSONObject cZS;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cSD = callbackHandler;
        this.cZS = jSONObject;
    }

    public void pQ(String str) {
        g(str, null);
    }

    public void g(String str, JSONObject jSONObject) {
        if (this.cZS != null && this.cSD != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cSD.handleSchemeDispatchCallback(this.cZS.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
