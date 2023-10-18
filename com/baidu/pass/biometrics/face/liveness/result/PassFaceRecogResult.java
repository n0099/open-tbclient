package com.baidu.pass.biometrics.face.liveness.result;

import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PassFaceRecogResult extends PassBiometricResult {
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String video;
    public static final String ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f69);
    public static final String ERROR_MSG_CONTRAST_FAIL = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f64);
    public static final String ERROR_MSG_FACE_SDK_INIT_FAIL = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f66);
    public static final String ERROR_MSG_OPEN_CAMERA_FAILURE = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f6e);
    public static final String ERROR_MSG_IMAGE_FILE_EMPTY = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f67);
    public static final String ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f6a);
    public String imgdigests = "";
    public String faceimage = "";
    public String originalImage = "";
    public List<String> originalImageList = new ArrayList();

    public PassFaceRecogResult() {
        this.msgMap.put(-305, ERROR_MSG_OPEN_CAMERA_FAILURE);
        this.msgMap.put(-301, ERROR_MSG_LIVENESS_RECOGNIZE_TIME_OUT);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
        this.msgMap.put(-303, ERROR_MSG_FACE_SDK_INIT_FAIL);
        this.msgMap.put(-307, ERROR_MSG_MAY_BE_NO_CAMERA_PERMISSION);
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
