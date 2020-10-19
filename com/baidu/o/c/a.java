package com.baidu.o.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cFY;
    public JSONObject cNm;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cFY = callbackHandler;
        this.cNm = jSONObject;
    }

    public void pp(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cNm != null && this.cFY != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cFY.handleSchemeDispatchCallback(this.cNm.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
