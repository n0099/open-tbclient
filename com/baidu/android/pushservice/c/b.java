package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public long a = 0;
    public long b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.a > -1) {
            jSONObject.put("push_priority", this.a);
        }
        if (this.b > -1) {
            jSONObject.put("push_version", this.b);
        }
        jSONObject.put("push_channelid", this.c);
        jSONObject.put("push_newchannelid", this.d);
        jSONObject.put("push_curpkgname", this.e);
        jSONObject.put("push_webappbindinfo", this.f);
        jSONObject.put("push_lightappbindinfo", this.g);
        jSONObject.put("push_sdkclientbindinfo", this.h);
        jSONObject.put("push_clientsbindinfo", this.i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
