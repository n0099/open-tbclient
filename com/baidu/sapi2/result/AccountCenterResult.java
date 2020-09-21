package com.baidu.sapi2.result;
/* loaded from: classes25.dex */
public class AccountCenterResult extends SapiResult {
    public static final int ERROR_CODE_HANDLE_LOGIN = -10001;
    public static final int ERROR_CODE_LOGIN_SUCCESS = -10002;
    public static final String ERROR_MSG_HANDLE_LOGIN = "请登录";
    public static final String ERROR_MSG_LOGIN_SUCCESS = "获取登录态成功";
    public String encryptedId;
    public boolean isAccountDestory = false;
    public boolean isAccountFreeze = false;
    public String preSetUserName;

    public AccountCenterResult() {
        this.msgMap.put(-10001, "请登录");
        this.msgMap.put(ERROR_CODE_LOGIN_SUCCESS, ERROR_MSG_LOGIN_SUCCESS);
    }

    public void loginSuc() {
    }
}
