package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SocialResponse extends SapiAccountResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean accountCenterFlag;
    public String baiduUname;
    public boolean bindConflict;
    public boolean bindGuide;
    public boolean isBinded;
    public String nextUrl;
    public boolean offlineNotice;
    public String socialUname;
    public String userInfoXmlContent;

    public SocialResponse() {
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
        this.accountCenterFlag = false;
        this.isBinded = false;
        this.baiduUname = "";
        this.socialUname = "";
        this.bindGuide = false;
        this.offlineNotice = false;
    }

    public static SocialResponse fromJSONObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            SocialResponse socialResponse = new SocialResponse();
            socialResponse.errorCode = jSONObject.optInt("errno");
            socialResponse.errorMsg = jSONObject.optString("errmsg");
            socialResponse.livingUname = jSONObject.optString("livinguname");
            socialResponse.socialType = SocialType.getSocialType(jSONObject.optInt("os_type"));
            socialResponse.bduss = jSONObject.optString("bduss");
            socialResponse.socialPortraitUrl = jSONObject.optString("os_headurl");
            socialResponse.socialNickname = jSONObject.optString("os_name");
            String optString = jSONObject.optString("incomplete_user");
            if ("0".equals(optString)) {
                socialResponse.accountType = AccountType.NORMAL;
            } else if ("1".equals(optString)) {
                socialResponse.accountType = AccountType.INCOMPLETE_USER;
            } else {
                socialResponse.accountType = AccountType.UNKNOWN;
            }
            socialResponse.uid = jSONObject.optString("bduid");
            socialResponse.isBinded = jSONObject.optBoolean("is_binded");
            socialResponse.displayname = jSONObject.optString("display_name");
            socialResponse.username = jSONObject.optString("passport_uname");
            socialResponse.ptoken = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
            socialResponse.stoken = jSONObject.optString("stoken");
            JSONObject optJSONObject = jSONObject.optJSONObject("stoken_list");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("stoken")) != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String[] split = optJSONArray.optString(i2).split("#");
                    if (split != null && split.length > 1) {
                        socialResponse.tplStokenMap.put(split[0], split[1]);
                    }
                }
            }
            socialResponse.isGuestAccount = jSONObject.optString("guest_account");
            socialResponse.nextUrl = jSONObject.optString("next_url");
            socialResponse.userInfoXmlContent = jSONObject.optString("userInfoXmlContent");
            return socialResponse;
        }
        return (SocialResponse) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.shell.response.SapiAccountResponse
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SocialResponse{isBinded=" + this.isBinded + ", baiduUname='" + this.baiduUname + "', socialUname='" + this.socialUname + "', bindGuide=" + this.bindGuide + ", offlineNotice=" + this.offlineNotice + ", bindConflict=" + this.bindConflict + ", accountCenterFlag=" + this.accountCenterFlag + ", nextUrl='" + this.nextUrl + "', userInfoXmlContent='" + this.userInfoXmlContent + "', bduss='" + this.bduss + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', uid='" + this.uid + "', portraitSign='" + this.portraitSign + "', newReg=" + this.newReg + ", authSid='" + this.authSid + "', socialPortraitUrl='" + this.socialPortraitUrl + "', socialType=" + this.socialType + ", actionType='" + this.actionType + "', isGuestAccount='" + this.isGuestAccount + "', livingUname='" + this.livingUname + "', app='" + this.app + "', extra='" + this.extra + "', accountType=" + this.accountType + ", fromType=" + this.fromType + ", tplStokenMap=" + this.tplStokenMap + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
        }
        return (String) invokeV.objValue;
    }
}
