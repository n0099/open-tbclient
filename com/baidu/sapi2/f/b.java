package com.baidu.sapi2.f;

import com.baidu.sapi2.result.SapiResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends SapiResult {

    /* renamed from: a  reason: collision with root package name */
    public static final int f11228a = -603;

    /* renamed from: b  reason: collision with root package name */
    public static final int f11229b = -604;

    /* renamed from: c  reason: collision with root package name */
    public static final String f11230c = "系统错误，请稍后再试";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11231d = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";

    public b() {
        this.msgMap.put(f11228a, f11230c);
        this.msgMap.put(f11229b, f11231d);
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
