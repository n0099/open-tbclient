package com.baidu.android.pushservice.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends l {
    public String a;

    public f() {
    }

    public f(l lVar) {
        super(lVar);
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
