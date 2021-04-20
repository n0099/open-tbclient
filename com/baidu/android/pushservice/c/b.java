package com.baidu.android.pushservice.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f2864a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f2865b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f2866c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2867d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f2868e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f2869f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f2870g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f2871h = "";
    public String i = "";
    public String j = "";

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j = this.f2864a;
        if (j > -1) {
            jSONObject.put("push_priority", j);
        }
        long j2 = this.f2865b;
        if (j2 > -1) {
            jSONObject.put("push_version", j2);
        }
        jSONObject.put("push_channelid", this.f2866c);
        jSONObject.put("push_newchannelid", this.f2867d);
        jSONObject.put("push_curpkgname", this.f2868e);
        jSONObject.put("push_webappbindinfo", this.f2869f);
        jSONObject.put("push_lightappbindinfo", this.f2870g);
        jSONObject.put("push_sdkclientbindinfo", this.f2871h);
        jSONObject.put("push_clientsbindinfo", this.i);
        jSONObject.put("push_selfbindinfo", this.j);
        return jSONObject;
    }
}
