package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2829a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2830b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2831c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2832d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2833e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2834f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2835g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2836h = "";
    public String i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2829a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2830b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2831c);
        jSONObject.put("push_newchannelid", this.f2832d);
        jSONObject.put("push_curpkgname", this.f2833e);
        jSONObject.put("push_webappbindinfo", this.f2834f);
        jSONObject.put("push_lightappbindinfo", this.f2835g);
        jSONObject.put("push_sdkclientbindinfo", this.f2836h);
        jSONObject.put("push_clientsbindinfo", this.i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
