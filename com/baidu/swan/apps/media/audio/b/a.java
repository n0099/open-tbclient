package com.baidu.swan.apps.media.audio.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    public JSONObject aBj;
    private CallbackHandler azH;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.azH = callbackHandler;
        this.aBj = jSONObject;
    }

    public void fi(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.aBj = new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }

    public void fj(String str) {
        f(str, null);
    }

    public void f(String str, JSONObject jSONObject) {
        if (this.aBj != null) {
            JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
            this.azH.handleSchemeDispatchCallback(this.aBj.optString(str), wrapCallbackParamsWithEncode.toString());
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
            }
        }
    }

    public boolean Gt() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.azH);
    }
}
