package com.baidu.searchbox.account.result;
/* loaded from: classes3.dex */
public class BoxOauthResult extends BoxSapiResult {
    public static final int ERROR_CODE_BDUSS_NOT_EXIST = -301;
    public static final String ERROR_MSG_BDUSS_NOT_EXIST = "bduss 本地不存在";
    public String accessToken;

    public String toString() {
        return "OAuthResult: accessToken=" + this.accessToken + ",errorCode = " + getResultCode() + ",errorMsg = " + getResultMsg();
    }
}
