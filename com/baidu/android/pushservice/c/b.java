package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f1225a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f1226b = 0;
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
        if (this.f1225a > -1) {
            jSONObject.put("push_priority", this.f1225a);
        }
        if (this.f1226b > -1) {
            jSONObject.put("push_version", this.f1226b);
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
