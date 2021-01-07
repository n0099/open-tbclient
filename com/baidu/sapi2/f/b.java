package com.baidu.sapi2.f;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.result.SapiResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends SapiResult {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5240a = -603;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5241b = -604;
    public static final String c = "系统错误，请稍后再试";
    public static final String d = "验证失败，检测到当前百度安全中心App存在风险，请于官方渠道下载后重试";

    public b() {
        this.msgMap.put(f5240a, c);
        this.msgMap.put(f5241b, d);
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseJsonData.TAG_ERRNO, getResultCode());
            jSONObject.put(BaseJsonData.TAG_ERRMSG, getResultMsg());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
