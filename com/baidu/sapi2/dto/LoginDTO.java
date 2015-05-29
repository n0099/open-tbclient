package com.baidu.sapi2.dto;
/* loaded from: classes.dex */
public class LoginDTO extends SapiDTO {
    public String account;
    public String captcha;
    public LoginType loginType = LoginType.MERGE;
    public String password;

    /* loaded from: classes.dex */
    public enum LoginType {
        MERGE,
        USERNAME,
        PHONE
    }
}
