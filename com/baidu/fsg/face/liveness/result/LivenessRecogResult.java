package com.baidu.fsg.face.liveness.result;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class LivenessRecogResult extends a {
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_LIVENESS_VIDEO_TIMEOUT = -401;
    public static final int ERROR_CODE_LIVENESS_VIDEO_TOOLARGE = -402;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION = -308;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final int ERROR_CODE_RECORD_AUDIO_FAILED = -304;
    public static final int ERROR_CODE_VIDEO_IS_REVIEWING = -309;
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public String imgdigests;
    public String originalImage;
    public String video;
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE = ResUtils.string("error_msg_open_camera_failure");
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = ResUtils.string("error_msg_liveness_recognize_time_out");
    public static final String ERROR_MSG_CONTRAST_FAIL = ResUtils.string("error_msg_contrast_fail");
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL = ResUtils.string("error_msg_face_sdk_init_fail");
    public static final String ERROR_MSG_NO_PERMISSION = ResUtils.string("error_msg_no_permission");
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = ResUtils.string("error_msg_may_be_no_camera_permission");
    public static final String ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION = ResUtils.string("error_msg_may_be_no_record_audio_permission");
    public static final String ERROR_MSG_VIDEO_IS_REVIEWING = ResUtils.string("error_msg_video_is_reviewing");
    public static final String ERROR_MSG_LIVENESS_VIDEO_TIMEOUT = ResUtils.string("error_msg_liveness_video_timeout");
    public static final String ERROR_MSG_LIVENESS_VIDEO_TOOLARGE = ResUtils.string("error_msg_liveness_video_toolarge");

    public LivenessRecogResult() {
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
        this.msgMap.put(-303, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(-304, ERROR_MSG_NO_PERMISSION);
        this.msgMap.put(-307, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION, ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
        this.msgMap.put(ERROR_CODE_VIDEO_IS_REVIEWING, ERROR_MSG_VIDEO_IS_REVIEWING);
        this.msgMap.put(ERROR_CODE_LIVENESS_VIDEO_TIMEOUT, ERROR_MSG_LIVENESS_VIDEO_TIMEOUT);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseJsonData.TAG_ERRNO, getResultCode());
            jSONObject.put(BaseJsonData.TAG_ERRMSG, getResultMsg());
            if (this.resultCode == 0) {
                if (!TextUtils.isEmpty(this.callbackkey)) {
                    jSONObject.put("credentialKey", this.callbackkey);
                }
                if (!TextUtils.isEmpty(this.authSid)) {
                    jSONObject.put("authsid", this.authSid);
                }
            }
        } catch (JSONException e) {
            d.a(e);
        }
        return jSONObject;
    }
}
