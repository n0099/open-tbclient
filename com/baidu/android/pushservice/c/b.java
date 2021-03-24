package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2828a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2829b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2830c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2831d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2832e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2833f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2834g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2835h = "";
    public String i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2828a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2829b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2830c);
        jSONObject.put("push_newchannelid", this.f2831d);
        jSONObject.put("push_curpkgname", this.f2832e);
        jSONObject.put("push_webappbindinfo", this.f2833f);
        jSONObject.put("push_lightappbindinfo", this.f2834g);
        jSONObject.put("push_sdkclientbindinfo", this.f2835h);
        jSONObject.put("push_clientsbindinfo", this.i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
