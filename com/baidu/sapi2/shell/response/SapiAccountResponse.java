package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class SapiAccountResponse extends SapiResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountType accountType;
    public String actionType;
    public String app;
    public String authSid;
    public String bduss;
    public String displayname;
    public String email;
    public String extra;
    public FromType fromType;
    public String isGuestAccount;
    public String livingUname;
    public boolean newReg;
    public String portraitSign;
    public String ptoken;
    public String socialNickname;
    public String socialPortraitUrl;
    public SocialType socialType;
    public String stoken;
    public Map<String, String> tplStokenMap;
    public String uid;
    public String username;

    public SapiAccountResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bduss = "";
        this.ptoken = "";
        this.stoken = "";
        this.displayname = "";
        this.username = "";
        this.email = "";
        this.uid = "";
        this.socialPortraitUrl = "";
        this.socialType = SocialType.UNKNOWN;
        this.accountType = AccountType.UNKNOWN;
        this.fromType = FromType.LOGIN;
        this.tplStokenMap = new HashMap();
        this.isGuestAccount = "";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SapiAccountResponse{bduss='" + this.bduss + ExtendedMessageFormat.QUOTE + ", ptoken='" + this.ptoken + ExtendedMessageFormat.QUOTE + ", stoken='" + this.stoken + ExtendedMessageFormat.QUOTE + ", displayname='" + this.displayname + ExtendedMessageFormat.QUOTE + ", username='" + this.username + ExtendedMessageFormat.QUOTE + ", email='" + this.email + ExtendedMessageFormat.QUOTE + ", uid='" + this.uid + ExtendedMessageFormat.QUOTE + ", portraitSign='" + this.portraitSign + ExtendedMessageFormat.QUOTE + ", newReg=" + this.newReg + ", authSid='" + this.authSid + ExtendedMessageFormat.QUOTE + ", socialPortraitUrl='" + this.socialPortraitUrl + ExtendedMessageFormat.QUOTE + ", socialNickname='" + this.socialNickname + ExtendedMessageFormat.QUOTE + ", socialType=" + this.socialType + ", actionType='" + this.actionType + ExtendedMessageFormat.QUOTE + ", isGuestAccount='" + this.isGuestAccount + ExtendedMessageFormat.QUOTE + ", livingUname='" + this.livingUname + ExtendedMessageFormat.QUOTE + ", app='" + this.app + ExtendedMessageFormat.QUOTE + ", extra='" + this.extra + ExtendedMessageFormat.QUOTE + ", accountType=" + this.accountType + ", fromType=" + this.fromType + ", tplStokenMap=" + this.tplStokenMap + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
