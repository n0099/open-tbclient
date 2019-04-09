package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String aAW;
    public static String aAX;
    public static String aAY;
    public static String aAZ;
    private UnitedSchemeEntity ayI;
    private CallbackHandler ayJ;

    private b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2, String str3, String str4) {
        this.ayJ = callbackHandler;
        this.ayI = unitedSchemeEntity;
        aAW = str;
        aAY = str4;
        aAX = str2;
        aAZ = str3;
    }

    public static b a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, b bVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("onStart");
                String optString2 = jSONObject.optString("onPause");
                String optString3 = jSONObject.optString("onStop");
                String optString4 = jSONObject.optString("onError");
                if (callbackHandler != null && unitedSchemeEntity != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    return new b(callbackHandler, unitedSchemeEntity, optString, optString2, optString4, optString3);
                }
                return bVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return bVar;
            }
        }
        return bVar;
    }

    public void eZ(String str) {
        f(str, null);
    }

    public void f(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            UnitedSchemeUtility.safeCallback(this.ayJ, this.ayI, wrapCallbackParams.toString(), str);
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }

    public void k(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", Integer.valueOf(i));
                jSONObject.putOpt("errMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f(aAZ, jSONObject);
        }
    }
}
