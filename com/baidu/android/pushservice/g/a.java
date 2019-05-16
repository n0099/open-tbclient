package com.baidu.android.pushservice.g;

import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.LogBuilder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends j {
    public String a;
    public String b;
    public String c;

    public a() {
    }

    public a(j jVar) {
        super(jVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("msg_result", this.a);
        jSONObject.put("request_id", this.b);
        jSONObject.put("err_code", this.g);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put(LogBuilder.KEY_CHANNEL, this.c);
        }
        return jSONObject;
    }
}
