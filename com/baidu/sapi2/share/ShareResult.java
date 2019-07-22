package com.baidu.sapi2.share;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes.dex */
public class ShareResult extends SapiResult {
    public static final int ERROR_CODE_REASON_BDUSS_EXPIRED = -3004;
    public static final int ERROR_CODE_REASON_CANCLE = -3001;
    public static final int ERROR_CODE_REASON_NETWORK_ERROR = -3003;
    public static final int ERROR_CODE_REASON_SDK_NOT_INIT = -3005;
    public static final int ERROR_CODE_REASON_SIGN_ERROR = -3002;
    public static final int ERROR_CODE_SYS_ERROR = -3006;
    public static final String ERROR_MSG_REASON_BDUSS_EXPIRED = "互通登录失败，请换种登录方式";
    public static final String ERROR_MSG_REASON_CANCLE = "您已取消%s授权登录";
    public static final String ERROR_MSG_REASON_NETWORK_ERROR = "网络请求失败，请稍后再试";
    public static final String ERROR_MSG_REASON_SDK_NOT_INIT = "互通请求失败，请换种登录方式";
    public static final String ERROR_MSG_REASON_SIGN_ERROR = "互通登录失败，该应用暂未授权";
    public static final String ERROR_MSG_SYS_ERROR = "系统错误，请换种登录方式";

    public ShareResult() {
        this.msgMap.put(ERROR_CODE_REASON_CANCLE, ERROR_MSG_REASON_CANCLE);
        this.msgMap.put(ERROR_CODE_REASON_SIGN_ERROR, ERROR_MSG_REASON_SIGN_ERROR);
        this.msgMap.put(ERROR_CODE_REASON_NETWORK_ERROR, ERROR_MSG_REASON_NETWORK_ERROR);
        this.msgMap.put(ERROR_CODE_REASON_BDUSS_EXPIRED, ERROR_MSG_REASON_BDUSS_EXPIRED);
        this.msgMap.put(ERROR_CODE_REASON_SDK_NOT_INIT, ERROR_MSG_REASON_SDK_NOT_INIT);
        this.msgMap.put(ERROR_CODE_SYS_ERROR, ERROR_MSG_SYS_ERROR);
    }
}
