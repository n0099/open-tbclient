package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2874a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2875b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2876c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2877d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2878e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2879f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2880g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2881h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f2882i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2874a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2875b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2876c);
        jSONObject.put("push_newchannelid", this.f2877d);
        jSONObject.put("push_curpkgname", this.f2878e);
        jSONObject.put("push_webappbindinfo", this.f2879f);
        jSONObject.put("push_lightappbindinfo", this.f2880g);
        jSONObject.put("push_sdkclientbindinfo", this.f2881h);
        jSONObject.put("push_clientsbindinfo", this.f2882i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
