package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2893a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2894b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2895c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2896d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2897e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2898f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2899g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2900h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f2901i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2893a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2894b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2895c);
        jSONObject.put("push_newchannelid", this.f2896d);
        jSONObject.put("push_curpkgname", this.f2897e);
        jSONObject.put("push_webappbindinfo", this.f2898f);
        jSONObject.put("push_lightappbindinfo", this.f2899g);
        jSONObject.put("push_sdkclientbindinfo", this.f2900h);
        jSONObject.put("push_clientsbindinfo", this.f2901i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
