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
    public JSONObject aAi;
    private CallbackHandler ayF;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.ayF = callbackHandler;
        this.aAi = jSONObject;
    }

    public void eX(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.aAi = new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }

    public void eY(String str) {
        f(str, null);
    }

    public void f(String str, JSONObject jSONObject) {
        if (this.aAi != null) {
            JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
            this.ayF.handleSchemeDispatchCallback(this.aAi.optString(str), wrapCallbackParamsWithEncode.toString());
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
            }
        }
    }

    public boolean Ez() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.ayF);
    }
}
