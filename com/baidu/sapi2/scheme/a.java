package com.baidu.sapi2.scheme;

import com.baidu.sapi2.result.SapiResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends SapiResult {
    public static final int a = -603;
    public static final int b = -604;
    public static final String c = "系统错误，请稍后再试";
    public static final String d = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";

    public a() {
        this.msgMap.put(a, c);
        this.msgMap.put(b, d);
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", getResultCode());
            jSONObject.put("errmsg", getResultMsg());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
