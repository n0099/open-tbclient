package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2871a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2872b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2873c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2874d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2875e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2876f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2877g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2878h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f2879i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2871a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2872b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2873c);
        jSONObject.put("push_newchannelid", this.f2874d);
        jSONObject.put("push_curpkgname", this.f2875e);
        jSONObject.put("push_webappbindinfo", this.f2876f);
        jSONObject.put("push_lightappbindinfo", this.f2877g);
        jSONObject.put("push_sdkclientbindinfo", this.f2878h);
        jSONObject.put("push_clientsbindinfo", this.f2879i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
