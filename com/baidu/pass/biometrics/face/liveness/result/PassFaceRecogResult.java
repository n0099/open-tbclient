package com.baidu.pass.biometrics.face.liveness.result;

import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PassFaceRecogResult extends PassBiometricResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final String ERROR_MSG_CONTRAST_FAIL;
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL;
    public static final String ERROR_MSG_IMAGE_FILE_EMPTY;
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT;
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION;
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE;
    public transient /* synthetic */ FieldHolder $fh;
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public String imgdigests;
    public String originalImage;
    public List<String> originalImageList;
    public String video;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1188783240, "Lcom/baidu/pass/biometrics/face/liveness/result/PassFaceRecogResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1188783240, "Lcom/baidu/pass/biometrics/face/liveness/result/PassFaceRecogResult;");
                return;
            }
        }
        ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d15);
        ERROR_MSG_CONTRAST_FAIL = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d10);
        ERROR_MSG_FACE_SDK_INIT_FAIL = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d12);
        ERROR_MSG_OPEN_CAMERA_FAILURE = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d19);
        ERROR_MSG_IMAGE_FILE_EMPTY = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d13);
        ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = ResUtils.getString(R.string.obfuscated_res_0x7f0f0d16);
    }

    public PassFaceRecogResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.imgdigests = "";
        this.faceimage = "";
        this.originalImage = "";
        this.originalImageList = new ArrayList();
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
        this.msgMap.put(ERROR_CODE_FACE_SDK_INIT_FAIL, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
        this.msgMap.put(-306, ERROR_MSG_IMAGE_FILE_EMPTY);
        this.msgMap.put(-2, "活体验证数据异常");
        this.msgMap.put(-3, "当前设备存在风险");
        this.msgMap.put(-4, "当前设备存在风险");
        this.msgMap.put(-5, "设备相机存在风险");
        this.msgMap.put(-7, "活体验证失败");
        this.msgMap.put(-8, "活体验证失败");
        this.msgMap.put(-9, "活体验证失败");
        this.msgMap.put(-10, "活体验证失败");
        this.msgMap.put(-11, "活体验证失败");
        this.msgMap.put(-12, "活体验证失败");
        this.msgMap.put(-13, "人脸SDK初始化失败");
        this.msgMap.put(-14, "请先同意隐私协议");
        this.msgMap.put(-15, "安全模块未成功加载，请稍后重试");
        this.msgMap.put(-18, "未检测到人脸");
    }
}
