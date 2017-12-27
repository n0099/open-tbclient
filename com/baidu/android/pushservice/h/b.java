package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends n {
    public String a;
    public String b;
    public String c;

    public b() {
    }

    public b(n nVar) {
        super(nVar);
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
            jSONObject.put("channel", this.c);
        }
        return jSONObject;
    }
}
