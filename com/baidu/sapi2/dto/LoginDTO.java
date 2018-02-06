package com.baidu.sapi2.dto;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LoginDTO extends SapiDTO {
    public String account;
    public String captcha;
    public Map<String, String> extraParams = new HashMap();
    public LoginType loginType = LoginType.MERGE;
    public String password;

    /* loaded from: classes2.dex */
    public enum LoginType {
        MERGE,
        USERNAME,
        PHONE
    }
}
