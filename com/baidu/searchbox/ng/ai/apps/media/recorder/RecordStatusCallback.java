package com.baidu.searchbox.ng.ai.apps.media.recorder;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RecordStatusCallback {
    private static final boolean DEBUG = false;
    public static final String KEY_ERROR_CODE = "errCode";
    public static final String KEY_ERROR_MSG = "errMsg";
    public static final String KEY_TEMP_FILE_PATH = "tempFilePath";
    private static final String ON_ERROR = "onError";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_START = "onStart";
    private static final String ON_STOP = "onStop";
    private static final String TAG = "AudioStatusCallBack";
    public static String errorCallback;
    public static String pauseCallback;
    public static String startCallback;
    public static String stopCallback;
    private UnitedSchemeEntity mEntity;
    private CallbackHandler mHandler;

    private RecordStatusCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2, String str3, String str4) {
        this.mHandler = callbackHandler;
        this.mEntity = unitedSchemeEntity;
        startCallback = str;
        stopCallback = str4;
        pauseCallback = str2;
        errorCallback = str3;
    }

    public static RecordStatusCallback createFromJSON(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, RecordStatusCallback recordStatusCallback) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(ON_START);
                String optString2 = jSONObject.optString("onPause");
                String optString3 = jSONObject.optString("onStop");
                String optString4 = jSONObject.optString("onError");
                if (callbackHandler != null && unitedSchemeEntity != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    return new RecordStatusCallback(callbackHandler, unitedSchemeEntity, optString, optString2, optString4, optString3);
                }
                return recordStatusCallback;
            } catch (JSONException e) {
                e.printStackTrace();
                return recordStatusCallback;
            }
        }
        return recordStatusCallback;
    }

    public void dispatchCallback(String str) {
        dispatchCallback(str, null);
    }

    public void dispatchCallback(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.safeCallback(this.mHandler, this.mEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public void dispatchErrorCallback(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(KEY_ERROR_CODE, Integer.valueOf(i));
                jSONObject.putOpt("errMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dispatchCallback(errorCallback, jSONObject);
        }
    }
}
