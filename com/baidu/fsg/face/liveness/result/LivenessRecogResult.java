package com.baidu.fsg.face.liveness.result;

import android.text.TextUtils;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.face.base.c.a;
import com.baidu.fsg.face.base.d.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LivenessRecogResult extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_LIVENESS_VIDEO_TIMEOUT = -401;
    public static final int ERROR_CODE_LIVENESS_VIDEO_TOOLARGE = -402;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION = -308;
    public static final int ERROR_CODE_MML_FRAMEWORK_NOT_FIND = -403;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final int ERROR_CODE_RECORD_AUDIO_FAILED = -304;
    public static final int ERROR_CODE_SAFE_MODULE_LOAD_FAIL = -404;
    public static final int ERROR_CODE_VIDEO_IS_REVIEWING = -309;
    public static final String ERROR_MSG_CONTRAST_FAIL;
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL;
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT;
    public static final String ERROR_MSG_LIVENESS_VIDEO_TIMEOUT;
    public static final String ERROR_MSG_LIVENESS_VIDEO_TOOLARGE;
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION;
    public static final String ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final String ERROR_MSG_MML_FRAMEWORK_NOT_FIND = "人脸模块未下发成功";
    public static final String ERROR_MSG_NO_PERMISSION;
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE;
    public static final String ERROR_MSG_SAFE_MODULE_LOAD_FAIL = "安全模块未下发成功";
    public static final String ERROR_MSG_VIDEO_IS_REVIEWING;
    public transient /* synthetic */ FieldHolder $fh;
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public String imgdigests;
    public String originalImage;
    public String video;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074087762, "Lcom/baidu/fsg/face/liveness/result/LivenessRecogResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074087762, "Lcom/baidu/fsg/face/liveness/result/LivenessRecogResult;");
                return;
            }
        }
        ERROR_MSG_OPEN_CAMERA_FAILURE = ResUtils.string("error_msg_open_camera_failure");
        ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = ResUtils.string("error_msg_liveness_recognize_time_out");
        ERROR_MSG_CONTRAST_FAIL = ResUtils.string("error_msg_contrast_fail");
        ERROR_MSG_FACE_SDK_INIT_FAIL = ResUtils.string("error_msg_face_sdk_init_fail");
        ERROR_MSG_NO_PERMISSION = ResUtils.string("error_msg_no_permission");
        ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = ResUtils.string("error_msg_may_be_no_camera_permission");
        ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION = ResUtils.string("error_msg_may_be_no_record_audio_permission");
        ERROR_MSG_VIDEO_IS_REVIEWING = ResUtils.string("error_msg_video_is_reviewing");
        ERROR_MSG_LIVENESS_VIDEO_TIMEOUT = ResUtils.string("error_msg_liveness_video_timeout");
        ERROR_MSG_LIVENESS_VIDEO_TOOLARGE = ResUtils.string("error_msg_liveness_video_toolarge");
    }

    public LivenessRecogResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
        this.msgMap.put(-303, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(-304, ERROR_MSG_NO_PERMISSION);
        this.msgMap.put(-307, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION, ERROR_MSG_MAY_BE_NO_RECORD_AUDIO_PERMISSION);
        this.msgMap.put(ERROR_CODE_VIDEO_IS_REVIEWING, ERROR_MSG_VIDEO_IS_REVIEWING);
        this.msgMap.put(-401, ERROR_MSG_LIVENESS_VIDEO_TIMEOUT);
        this.msgMap.put(-403, ERROR_MSG_MML_FRAMEWORK_NOT_FIND);
        this.msgMap.put(-404, ERROR_MSG_SAFE_MODULE_LOAD_FAIL);
    }

    public JSONObject toJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            } catch (JSONException e2) {
                d.a(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
