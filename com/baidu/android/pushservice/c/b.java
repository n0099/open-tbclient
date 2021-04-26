package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2870a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2871b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2872c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2873d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2874e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2875f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2876g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2877h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f2878i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2870a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2871b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2872c);
        jSONObject.put("push_newchannelid", this.f2873d);
        jSONObject.put("push_curpkgname", this.f2874e);
        jSONObject.put("push_webappbindinfo", this.f2875f);
        jSONObject.put("push_lightappbindinfo", this.f2876g);
        jSONObject.put("push_sdkclientbindinfo", this.f2877h);
        jSONObject.put("push_clientsbindinfo", this.f2878i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
