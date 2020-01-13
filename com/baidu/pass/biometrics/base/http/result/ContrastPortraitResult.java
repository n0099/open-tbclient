package com.baidu.pass.biometrics.base.http.result;

import com.baidu.pass.biometrics.base.result.PassBiometricResult;
/* loaded from: classes5.dex */
public class ContrastPortraitResult extends PassBiometricResult {
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_GET_USERINFO_FAILURE = 1;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_UPLOAD_FAILURE = 2;
    public static final String ERROR_MSG_CONTRAST_FAIL = "人脸对比失败，请确保本人操作";
    public static final String ERROR_MSG_GET_USERINFO_FAILURE = "获取用户信息失败";
    public static final String ERROR_MSG_IMAGE_FILE_EMPTY = "获取人脸图像失败";
    public static final String ERROR_MSG_UPLOAD_FAILURE = "系统繁忙，请稍候重试";
    public String authsid;
    public String callbackkey;
    public int contrastres;
    public int finalres;
    public int finish;
    public String imgdigests;
    public int recordvideo;

    public boolean isProcessPass() {
        return 1 == this.finalres;
    }

    public boolean isFinish() {
        return this.finish == 1;
    }

    public ContrastPortraitResult() {
        this.msgMap.put(1, ERROR_MSG_GET_USERINFO_FAILURE);
        this.msgMap.put(2, ERROR_MSG_UPLOAD_FAILURE);
        this.msgMap.put(-306, ERROR_MSG_IMAGE_FILE_EMPTY);
        this.msgMap.put(-302, ERROR_MSG_CONTRAST_FAIL);
    }
}
