package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LoginWithUCAuthResult extends SapiResult implements NoProguard {
    public static final int CODE_JSON_EXCEPTION = -101;
    public static final int CODE_NOT_INIT = -102;
    public static final int CODE_PARAMS_ERROR = -103;
    public static final int CODE_SERVER_ERROR_BIND = 3;
    public static final int CODE_SERVER_ERROR_LOGIN_STATE = 2;
    public static final int CODE_SERVER_ERROR_PARAMS = 1;
    public static final int CODE_SERVER_ERROR_SERVER_ERROR = 4;
    public static final String KEY_DATA = "data";
    public static final String KEY_DATA_BDUSS = "bduss";
    public static final String KEY_DATA_DISPLAYNAME = "displayname";
    public static final String KEY_DATA_PTOKEN = "ptoken";
    public static final String KEY_DATA_STOKEN = "stoken";
    public static final String KEY_DATA_UID = "uid";
    public static final String KEY_ERRMSG = "errmsg";
    public static final String KEY_ERRNO = "errno";
    public static final String MSG_JSON_EXCEPTION = "JSON解析失败";
    public static final String MSG_NOT_INIT = "请您先初始化SDK";
    public static final String MSG_PARAMS_ERROR = "请核对入参";
    public static final String MSG_SERVER_ERROR_BIND = "无uc-pass绑定关系";
    public static final String MSG_SERVER_ERROR_LOGIN_STATE = "uc登录态校验失败";
    public static final String MSG_SERVER_ERROR_PARAMS = "参数错误";
    public static final String MSG_SERVER_ERROR_SERVER_ERROR = "调用uc下游异常";
    public String bduss;
    public String displayname;
    public String ptoken;
    public String stoken;
    public String uid;

    public LoginWithUCAuthResult() {
        this.msgMap.put(1, "参数错误");
        this.msgMap.put(2, MSG_SERVER_ERROR_LOGIN_STATE);
        this.msgMap.put(3, MSG_SERVER_ERROR_BIND);
        this.msgMap.put(4, MSG_SERVER_ERROR_SERVER_ERROR);
        this.msgMap.put(-101, "JSON解析失败");
        this.msgMap.put(-102, MSG_NOT_INIT);
        this.msgMap.put(-103, "请核对入参");
    }

    public static LoginWithUCAuthResult parseFromJSONObject(String str) {
        JSONObject optJSONObject;
        LoginWithUCAuthResult loginWithUCAuthResult = new LoginWithUCAuthResult();
        if (TextUtils.isEmpty(str)) {
            return loginWithUCAuthResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            loginWithUCAuthResult.setResultCode(jSONObject.optInt("errno"));
            loginWithUCAuthResult.setResultMsg(jSONObject.optString("errmsg"));
            optJSONObject = jSONObject.optJSONObject("data");
        } catch (JSONException e) {
            e.printStackTrace();
            loginWithUCAuthResult.setResultCode(-101);
            loginWithUCAuthResult.setResultMsg("JSON解析失败");
        }
        if (optJSONObject == null) {
            return loginWithUCAuthResult;
        }
        loginWithUCAuthResult.bduss = optJSONObject.optString("bduss");
        loginWithUCAuthResult.stoken = optJSONObject.optString("stoken");
        loginWithUCAuthResult.ptoken = optJSONObject.optString("ptoken");
        loginWithUCAuthResult.uid = optJSONObject.optString("uid");
        loginWithUCAuthResult.displayname = optJSONObject.optString("displayname");
        return loginWithUCAuthResult;
    }

    public String toJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", this.resultCode);
            jSONObject.put("errmsg", this.resultMsg);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bduss", this.bduss);
            jSONObject2.put("ptoken", this.ptoken);
            jSONObject2.put("stoken", this.stoken);
            jSONObject2.put("uid", this.uid);
            jSONObject2.put("displayname", this.displayname);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
