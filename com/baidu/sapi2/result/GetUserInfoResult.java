package com.baidu.sapi2.result;
/* loaded from: classes25.dex */
public class GetUserInfoResult extends SapiResult {
    public static final String ERROR_MSG_UNKNOWN = "用户信息获取失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public int carSdkFace;
    public String displayname;
    public int faceLoginSwitch;
    public boolean incompleteUser;
    public String portrait;
    public String portraitHttps;
    public String portraitSign;
    public String secureEmail;
    public String secureMobile;
    public String uid;
    public String username;
    public boolean isInitialPortrait = false;
    public boolean havePwd = true;

    public GetUserInfoResult() {
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }

    public String toString() {
        return "GetUserInfoResult{username='" + this.username + "', displayname='" + this.displayname + "', uid='" + this.uid + "', secureMobile='" + this.secureMobile + "', secureEmail='" + this.secureEmail + "', incompleteUser=" + this.incompleteUser + ", portrait='" + this.portrait + "', portraitSign='" + this.portraitSign + "', isInitialPortrait=" + this.isInitialPortrait + ", havePwd=" + this.havePwd + '}';
    }
}
