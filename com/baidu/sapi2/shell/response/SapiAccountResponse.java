package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class SapiAccountResponse extends SapiResponse {
    public String actionType;
    public String app;
    public String authSid;
    public String extra;
    public String livingUname;
    public boolean newReg;
    public String portraitSign;
    public String bduss = "";
    public String ptoken = "";
    public String stoken = "";
    public String displayname = "";
    public String username = "";
    public String email = "";
    public String uid = "";
    public String socialPortraitUrl = "";
    public SocialType socialType = SocialType.UNKNOWN;
    public AccountType accountType = AccountType.UNKNOWN;
    public Map<String, String> tplStokenMap = new HashMap();
    public String isGuestAccount = "";
}
