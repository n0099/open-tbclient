package com.baidu.sapi2.result;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetCertStatusResult extends SapiResult {
    public static final int CODE_BUSINESS_RESULT_OK = 110000;
    public static final int CODE_BUSINESS_RESULT_RISK_CONTROL = 50000;
    public static final int CODE_BUSINESS_RESULT_USER_OFFLINE = 400021;
    public static final int CODE_NET_RESULT_OK = 200;
    public static final String KEY_CERT_CODE = "cert_code";
    public static final String KEY_CERT_TYPE = "cert_type";
    public static final String KEY_CODE = "code";
    public static final String KEY_DATA = "data";
    public static final String KEY_GUARDER_INFO = "guarderInfo";
    public static final String KEY_ID_NAME = "idName";
    public static final String KEY_ID_NUM = "idNum";
    public static final String KEY_IS_CHILD = "isChild";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TRUE_NAME = "true_name";
    public static final String MESSAGE_BUSINESS_RESULT_OK = "成功";
    public static final String MESSAGE_BUSINESS_RESULT_RISK_CONTROL = "您的操作存在风险";
    public static final String MESSAGE_BUSINESS_RESULT_USER_OFFLINE = "当前用户不在线";
    public static final String VALUE_ADVANCED_REAL_NAME = "advanced";
    public static final String VALUE_NO_REAL_NAME = "no";
    public static final String VALUE_PRIMARY_REAL_NAME = "primary";
    public GuarderInfo guarderInfo;
    public String idName;
    public String idNum;
    public boolean isChild;
    public String status;

    /* loaded from: classes3.dex */
    public static class GuarderInfo {
        public String certCode;
        public String certType;
        public int status;
        public String trueName;
    }

    public GetCertStatusResult() {
        this.msgMap.put(110000, "成功");
        this.msgMap.put(400021, "当前用户不在线");
        this.msgMap.put(50000, MESSAGE_BUSINESS_RESULT_RISK_CONTROL);
    }

    public static GetCertStatusResult parseFromJSONObject(JSONObject jSONObject) {
        GetCertStatusResult getCertStatusResult = new GetCertStatusResult();
        if (jSONObject == null) {
            getCertStatusResult.setResultCode(-205);
            getCertStatusResult.setResultMsg("服务端数据异常，请稍后再试");
            return getCertStatusResult;
        }
        getCertStatusResult.status = jSONObject.optString("status");
        getCertStatusResult.idName = jSONObject.optString(KEY_ID_NAME);
        getCertStatusResult.idNum = jSONObject.optString(KEY_ID_NUM);
        getCertStatusResult.isChild = jSONObject.optBoolean(KEY_IS_CHILD, false);
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_GUARDER_INFO);
        if (optJSONObject != null) {
            GuarderInfo guarderInfo = new GuarderInfo();
            guarderInfo.status = optJSONObject.optInt("status");
            guarderInfo.trueName = optJSONObject.optString(KEY_TRUE_NAME);
            guarderInfo.certCode = optJSONObject.optString(KEY_CERT_CODE);
            guarderInfo.certType = optJSONObject.optString(KEY_CERT_TYPE);
            getCertStatusResult.guarderInfo = guarderInfo;
        }
        getCertStatusResult.setResultCode(110000);
        getCertStatusResult.setResultMsg("成功");
        return getCertStatusResult;
    }
}
