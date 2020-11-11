package com.baidu.swan.apps.media.audio.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private CallbackHandler cUn;
    public JSONObject dbC;

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.cUn = callbackHandler;
        this.dbC = jSONObject;
    }

    public void pV(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is Null");
                return;
            }
            return;
        }
        try {
            this.dbC = new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio Callback is not jsonObject");
            }
        }
    }

    public void pW(String str) {
        g(str, null);
    }

    public void g(String str, JSONObject jSONObject) {
        if (this.dbC != null) {
            JSONObject wrapCallbackParamsWithEncode = UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0);
            this.cUn.handleSchemeDispatchCallback(this.dbC.optString(str), wrapCallbackParamsWithEncode.toString());
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString());
            }
        }
    }

    public boolean aAw() {
        return UnitedSchemeUtility.isInvokedFromSwanGame(this.cUn);
    }
}
