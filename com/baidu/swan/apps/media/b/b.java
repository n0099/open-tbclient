package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String ccA;
    public static String ccB;
    public static String ccC;
    public static String ccD;
    public static String ccE;
    public static String ccF;
    public static String ccG;
    private UnitedSchemeEntity bYf;
    private CallbackHandler bYg;

    private b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.bYg = callbackHandler;
        this.bYf = unitedSchemeEntity;
        ccA = str;
        ccB = str2;
        ccC = str3;
        ccD = str4;
        ccE = str5;
        ccF = str6;
        ccG = str7;
    }

    public static b a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, b bVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(MissionEvent.MESSAGE_START);
                String optString2 = jSONObject.optString(MissionEvent.MESSAGE_PAUSE);
                String optString3 = jSONObject.optString(MissionEvent.MESSAGE_RESUME);
                String optString4 = jSONObject.optString(MissionEvent.MESSAGE_STOP);
                String optString5 = jSONObject.optString("onError");
                String optString6 = jSONObject.optString("onInterruptionBegin");
                String optString7 = jSONObject.optString("onInterruptionEnd");
                if (callbackHandler != null && unitedSchemeEntity != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    return new b(callbackHandler, unitedSchemeEntity, optString, optString2, optString3, optString4, optString5, optString6, optString7);
                }
                return bVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return bVar;
            }
        }
        return bVar;
    }

    public void ko(String str) {
        e(str, null);
    }

    public void e(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            UnitedSchemeUtility.safeCallback(this.bYg, this.bYf, wrapCallbackParams.toString(), str);
            if (DEBUG) {
                Log.d("AudioStatusCallBack", "Audio callback type is : " + str + " , data is : " + wrapCallbackParams.toString());
            }
        }
    }

    public void Q(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("errCode", Integer.valueOf(i));
                jSONObject.putOpt("errMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e(ccE, jSONObject);
        }
    }
}
