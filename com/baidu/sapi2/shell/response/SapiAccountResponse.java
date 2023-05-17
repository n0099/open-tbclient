package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SapiAccountResponse extends SapiResponse {
    public String actionType;
    public String app;
    public String authSid;
    public String extra;
    public String livingUname;
    public boolean newReg;
    public String portraitSign;
    public String socialNickname;
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
    public FromType fromType = FromType.LOGIN;
    public Map<String, String> tplStokenMap = new HashMap();
    public String isGuestAccount = "";

    public String toString() {
        return "SapiAccountResponse{bduss='" + this.bduss + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', uid='" + this.uid + "', portraitSign='" + this.portraitSign + "', newReg=" + this.newReg + ", authSid='" + this.authSid + "', socialPortraitUrl='" + this.socialPortraitUrl + "', socialNickname='" + this.socialNickname + "', socialType=" + this.socialType + ", actionType='" + this.actionType + "', isGuestAccount='" + this.isGuestAccount + "', livingUname='" + this.livingUname + "', app='" + this.app + "', extra='" + this.extra + "', accountType=" + this.accountType + ", fromType=" + this.fromType + ", tplStokenMap=" + this.tplStokenMap + '}';
    }
}
