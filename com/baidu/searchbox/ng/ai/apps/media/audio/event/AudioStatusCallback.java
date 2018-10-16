package com.baidu.searchbox.ng.ai.apps.media.audio.event;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioStatusCallback {
    private static final boolean DEBUG = false;
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ERROR = "onError";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_POSITION = "currentTime";
    public static final String ON_CAN_PLAY = "onCanplay";
    public static final String ON_END = "onEnded";
    public static final String ON_PAUSE = "onPause";
    public static final String ON_PLAY = "onPlay";
    public static final String ON_SEEKING = "onSeeking";
    public static final String ON_SEEK_COMPLETION = "onSeeked";
    public static final String ON_STOP = "onStop";
    public static final String ON_UPDATE_PROGRESS = "onTimeUpdate";
    public static final String ON_WAIT = "onWaiting";
    private static final String TAG = "AudioStatusCallBack";
    private JSONObject mCallbacks;
    private CallbackHandler mHandler;

    public AudioStatusCallback(CallbackHandler callbackHandler, JSONObject jSONObject) {
        this.mHandler = callbackHandler;
        this.mCallbacks = jSONObject;
    }

    public void setCallbacks(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mCallbacks = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
    }

    public void dispatchCallback(String str) {
        dispatchCallback(str, null);
    }

    public void dispatchCallback(String str, JSONObject jSONObject) {
        if (this.mCallbacks != null) {
            this.mHandler.handleSchemeDispatchCallback(this.mCallbacks.optString(str), UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
    }
}
