package com.baidu.sapi2.shell.response;
/* loaded from: classes.dex */
public class SapiAccountResponse extends SapiResponse {
    public String bduss;
    public String displayname;
    public String email;
    public String portrait;
    public String ptoken;
    public String stoken;
    public String uid;
    public String username;

    public SapiAccountResponse() {
        this.bduss = "";
        this.ptoken = "";
        this.stoken = "";
        this.displayname = "";
        this.username = "";
        this.email = "";
        this.uid = "";
        this.portrait = "";
    }

    public SapiAccountResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        super(i, str);
        this.displayname = str2;
        this.username = str3;
        this.email = str4;
        this.bduss = str5;
        this.ptoken = str6;
        this.stoken = str7;
        this.uid = str8;
        this.portrait = str9;
    }
}
