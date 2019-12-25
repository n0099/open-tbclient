package com.baidu.sapi2.shell.response;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SocialResponse extends SapiAccountResponse {
    public boolean bindConflict;
    public String nextUrl;
    public String userInfoXmlContent;
    public boolean accountCenterFlag = false;
    public boolean isBinded = false;
    public String baiduUname = "";
    public String socialUname = "";
    public boolean bindGuide = false;
    public boolean offlineNotice = false;

    public static SocialResponse fromJSONObject(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        SocialResponse socialResponse = new SocialResponse();
        socialResponse.errorCode = jSONObject.optInt("errno");
        socialResponse.errorMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
        socialResponse.livingUname = jSONObject.optString("livinguname");
        socialResponse.socialType = SocialType.getSocialType(jSONObject.optInt("os_type"));
        socialResponse.bduss = jSONObject.optString("bduss");
        socialResponse.socialPortraitUrl = jSONObject.optString("os_headurl");
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
        socialResponse.ptoken = jSONObject.optString("ptoken");
        socialResponse.stoken = jSONObject.optString("stoken");
        JSONObject optJSONObject = jSONObject.optJSONObject("stoken_list");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("stoken")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String[] split = optJSONArray.optString(i).split("#");
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
}
