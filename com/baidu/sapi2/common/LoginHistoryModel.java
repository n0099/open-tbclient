package com.baidu.sapi2.common;

import com.baidu.mobstat.Config;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.SyncAccountUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoginHistoryModel implements NoProguard {
    public String bduss;
    public String displayname;
    public String loginType;
    public String portrait;
    public String portraitSign;
    public boolean recent;
    public String uid;
    public String username;

    public static LoginHistoryModel fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
        loginHistoryModel.uid = jSONObject.optString("uid");
        loginHistoryModel.displayname = jSONObject.optString("displayname");
        loginHistoryModel.username = jSONObject.optString("username");
        loginHistoryModel.portrait = jSONObject.optString("portrait");
        loginHistoryModel.portraitSign = jSONObject.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
        loginHistoryModel.recent = jSONObject.optBoolean(Config.TRACE_VISIT_RECENT);
        loginHistoryModel.loginType = jSONObject.optString("loginType");
        loginHistoryModel.bduss = jSONObject.optString("bduss");
        return loginHistoryModel;
    }
}
