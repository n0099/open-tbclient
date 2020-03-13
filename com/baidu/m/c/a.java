package com.baidu.m.c;

import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public JSONObject bBr;
    private CallbackHandler bzJ;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.bzJ = callbackHandler;
        this.bBr = jSONObject;
    }

    public void jc(String str) {
        d(str, null);
    }

    public void d(String str, JSONObject jSONObject) {
        if (this.bBr != null && this.bzJ != null) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            this.bzJ.handleSchemeDispatchCallback(this.bBr.optString(str), wrapCallbackParams.toString());
            if (DEBUG) {
                Log.d("AudioRTCEventCallback", "AudioRTC callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }
}
