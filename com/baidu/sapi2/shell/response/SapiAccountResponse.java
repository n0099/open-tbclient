package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SapiAccountResponse extends SapiResponse {
    public String actionType;
    public String authSid;
    public boolean newReg;
    public String bduss = "";
    public String ptoken = "";
    public String stoken = "";
    public String displayname = "";
    public String username = "";
    public String email = "";
    public String uid = "";
    public String socialPortraitUrl = "";
    public SocialType socialType = SocialType.UNKNOWN;
    public SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
    public AccountType accountType = AccountType.UNKNOWN;
    public Map<String, String> tplStokenMap = new HashMap();
}
