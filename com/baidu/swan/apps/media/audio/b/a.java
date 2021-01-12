package com.baidu.swan.apps.media.audio.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private CallbackHandler cZC;
    public JSONObject dgX;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cZC = callbackHandler;
        this.dgX = jSONObject;
    }

    public void pe(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.dgX = new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }

    public void pf(String str) {
        h(str, null);
    }

    public void h(String str, JSONObject jSONObject) {
        if (this.dgX != null) {
            JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
            this.cZC.handleSchemeDispatchCallback(this.dgX.optString(str), wrapCallbackParamsWithEncode.toString());
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
            }
        }
    }

    public boolean aAw() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.cZC);
    }
}
