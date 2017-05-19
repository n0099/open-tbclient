package com.baidu.android.pushservice.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {
    public long a = 0;
    public long b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.a > -1) {
            jSONObject.put("push_priority", this.a);
        }
        if (this.b > -1) {
            jSONObject.put("push_version", this.b);
        }
        jSONObject.put("push_channelid", this.c);
        jSONObject.put("push_curpkgname", this.d);
        jSONObject.put("push_webappbindinfo", this.e);
        jSONObject.put("push_lightappbindinfo", this.f);
        jSONObject.put("push_sdkclientbindinfo", this.g);
        jSONObject.put("push_clientsbindinfo", this.h);
        jSONObject.put("push_selfbindinfo", this.i);
        return jSONObject;
    }
}
