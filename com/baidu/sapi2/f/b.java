package com.baidu.sapi2.f;

import com.baidu.sapi2.result.SapiResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends SapiResult {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10813a = -603;

    /* renamed from: b  reason: collision with root package name */
    public static final int f10814b = -604;

    /* renamed from: c  reason: collision with root package name */
    public static final String f10815c = "系统错误，请稍后再试";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10816d = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";

    public b() {
        this.msgMap.put(f10813a, f10815c);
        this.msgMap.put(f10814b, f10816d);
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", getResultCode());
            jSONObject.put("errmsg", getResultMsg());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
