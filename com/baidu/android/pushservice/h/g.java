package com.baidu.android.pushservice.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends l {
    public String a;
    public int b;
    public int c;

    public g() {
    }

    public g(l lVar) {
        super(lVar);
    }

    public g(String str, int i, String str2, int i2) {
        this.j = str;
        this.b = i;
        this.a = str2;
        this.c = i2;
        this.d = "050101";
        this.e = System.currentTimeMillis();
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("msg_type", this.c);
        return jSONObject;
    }
}
