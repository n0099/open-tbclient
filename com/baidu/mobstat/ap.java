package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8828a;

    /* renamed from: b  reason: collision with root package name */
    public long f8829b;

    /* renamed from: c  reason: collision with root package name */
    public long f8830c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8831d;

    /* renamed from: e  reason: collision with root package name */
    public long f8832e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8828a = str;
        this.f8829b = j;
        this.f8830c = j2;
        this.f8832e = j3;
        this.f8831d = z;
    }

    public void a(long j) {
        this.f8830c = j;
    }

    public long b() {
        return this.f8829b;
    }

    public long c() {
        return this.f8830c;
    }

    public boolean d() {
        return this.f8831d;
    }

    public long e() {
        return this.f8832e;
    }

    public String a() {
        return this.f8828a;
    }

    public void b(long j) {
        this.f8832e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8829b);
            jSONObject.put("e", this.f8830c);
            jSONObject.put("user", this.f8831d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
