package com.baidu.sapi2.biometrics.liveness.result;

import android.text.TextUtils;
import com.baidu.fsg.biometrics.base.c.a;
import com.baidu.fsg.biometrics.base.d.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessRecogResult extends a {
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION = -308;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final int ERROR_CODE_RECORD_AUDIO_FAILED = -304;
    public static final int ERROR_CODE_VIDEO_IS_REVIEWING = -309;
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL = "人脸 SDK 初始化失败";
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = "人脸识别失败，请保证光线充足或者更换设备后尝试";
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = "打开相机失败，请检查是否有相机权限";
    public static final String ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION = "录制视频失败，请检查是否有麦克风权限";
    public static final String ERROR_MSG_NO_PERMISSION = "录制视频失败，请检查是否有相机权限";
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE = "请在设置中开启相机权限，以正常使用人脸识别功能";
    public static final String ERROR_MSG_VIDEO_IS_REVIEWING = "您已上传视频，正在审核中，请耐心等候";
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public String imgdigests;
    public String originalImage;
    public String video;

    public LivenessRecogResult() {
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(ERROR_CODE_FACE_SDK_INIT_FAIL, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(-304, ERROR_MSG_NO_PERMISSION);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION, ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
        this.msgMap.put(ERROR_CODE_VIDEO_IS_REVIEWING, ERROR_MSG_VIDEO_IS_REVIEWING);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", getResultCode());
            jSONObject.put("errmsg", getResultMsg());
            if (this.resultCode == 0) {
                if (!TextUtils.isEmpty(this.callbackkey)) {
                    jSONObject.put("credentialKey", this.callbackkey);
                }
                if (!TextUtils.isEmpty(this.authSid)) {
                    jSONObject.put("authsid", this.authSid);
                }
            }
        } catch (JSONException e) {
            c.a(e);
        }
        return jSONObject;
    }
}
