package com.baidu.android.pushservice.f;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends m {
    public String a;

    public f() {
    }

    public f(m mVar) {
        super(mVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("crash_stack", this.a);
        return jSONObject;
    }
}
