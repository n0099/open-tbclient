package com.baidu.j.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CallbackHandler cnx;
    public JSONObject cph;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cnx = callbackHandler;
        this.cph = jSONObject;
    }

    public void lJ(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cph != null && this.cnx != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.cnx.handleSchemeDispatchCallback(this.cph.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
