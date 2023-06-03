package com.baidu.sapi2.scheme;

import com.baidu.sapi2.result.SapiResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SchemeResult extends SapiResult {
    public static final int ERROR_CODE_SC_PACKAGE_SIGN_ERROR = -604;
    public static final int ERROR_CODE_SYSTEM_ERROR = -603;
    public static final String ERROR_MSG_SC_PACKAGE_SIGN_ERROR = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";
    public static final String ERROR_MSG_SYSTEM_ERROR = "系统错误，请稍后再试";

    public SchemeResult() {
        this.msgMap.put(-603, ERROR_MSG_SYSTEM_ERROR);
        this.msgMap.put(-604, ERROR_MSG_SC_PACKAGE_SIGN_ERROR);
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", getResultCode());
            jSONObject.put("errmsg", getResultMsg());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
