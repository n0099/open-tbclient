package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.SapiAccount;
/* loaded from: classes.dex */
public class SapiAccountResponse extends SapiResponse {
    public String authSid;
    public boolean newReg;
    public String bduss = "";
    public String ptoken = "";
    public String stoken = "";
    public String displayname = "";
    public String username = "";
    public String email = "";
    public String uid = "";
    public SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
}
