package com.baidu.swan.apps.media.audio.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    public JSONObject cBh;
    private CallbackHandler ctP;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.ctP = callbackHandler;
        this.cBh = jSONObject;
    }

    public void oC(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.cBh = new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }

    public void oD(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (this.cBh != null) {
            JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
            this.ctP.handleSchemeDispatchCallback(this.cBh.optString(str), wrapCallbackParamsWithEncode.toString());
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
            }
        }
    }

    public boolean atr() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.ctP);
    }
}
