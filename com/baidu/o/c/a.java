package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cUn;
    public JSONObject dbC;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cUn = callbackHandler;
        this.dbC = jSONObject;
    }

    public void pW(String str) {
        g(str, null);
    }

    public void g(String str, JSONObject jSONObject) {
        if (this.dbC != null && this.cUn != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cUn.handleSchemeDispatchCallback(this.dbC.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
