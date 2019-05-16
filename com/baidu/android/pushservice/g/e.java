package com.baidu.android.pushservice.g;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends j {
    public String a;

    public e() {
    }

    public e(j jVar) {
        super(jVar);
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
