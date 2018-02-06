package com.baidu.fsg.biometrics.base.c;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes2.dex */
public class a {
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络不给力，请稍后重试";
    public static final String ERROR_MSG_NO_LOGIN = "用户未登录";
    public static final String ERROR_MSG_PARAM = "参数错误，请检测参数是否合法";
    public static final String ERROR_MSG_SERVER_ERROR = "服务异常，请稍后重试";
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String ERROR_MSG_UNKNOWN = "操作失败，请稍后重试";
    public static final String ERROR_MSG_USER_CANCEL = "用户取消操作";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String RESULT_MSG_SUCCESS = "成功";
    protected SparseArray<String> msgMap = new SparseArray<>();
    protected int resultCode = -202;
    protected String resultMsg;

    public a() {
        this.msgMap.put(0, "成功");
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
        this.msgMap.put(-201, "网络不给力，请稍后重试");
        this.msgMap.put(-203, "网站安全证书已过期或不可信，系统时间错误可能导致此问题");
        this.msgMap.put(-204, ERROR_MSG_USER_CANCEL);
        this.msgMap.put(-205, ERROR_MSG_PARAM);
        this.msgMap.put(-206, ERROR_MSG_SERVER_ERROR);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public String getResultMsg() {
        if (TextUtils.isEmpty(this.resultMsg)) {
            return this.msgMap.get(this.resultCode) != null ? this.msgMap.get(this.resultCode) : this.msgMap.get(-202);
        }
        return this.resultMsg;
    }
}
