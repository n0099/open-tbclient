package com.baidu.sapi2.shell.response;
@Deprecated
/* loaded from: classes.dex */
public class GetUserInfoResponse extends SapiResponse {
    public String displayname;
    public boolean incompleteUser;
    public String portrait;
    public String secureEmail;
    public String secureMobile;
    public String uid;
    public String username;

    public String toString() {
        return "GetUserInfoResponse{username='" + this.username + "', displayname='" + this.displayname + "', uid='" + this.uid + "', secureMobile='" + this.secureMobile + "', secureEmail='" + this.secureEmail + "', incompleteUser=" + this.incompleteUser + ", portrait='" + this.portrait + "'}";
    }
}
