package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cOu;
    public JSONObject cVI;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cOu = callbackHandler;
        this.cVI = jSONObject;
    }

    public void pI(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cVI != null && this.cOu != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cOu.handleSchemeDispatchCallback(this.cVI.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
