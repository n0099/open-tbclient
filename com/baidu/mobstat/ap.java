package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8949a;

    /* renamed from: b  reason: collision with root package name */
    public long f8950b;

    /* renamed from: c  reason: collision with root package name */
    public long f8951c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8952d;

    /* renamed from: e  reason: collision with root package name */
    public long f8953e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8949a = str;
        this.f8950b = j;
        this.f8951c = j2;
        this.f8953e = j3;
        this.f8952d = z;
    }

    public void a(long j) {
        this.f8951c = j;
    }

    public long b() {
        return this.f8950b;
    }

    public long c() {
        return this.f8951c;
    }

    public boolean d() {
        return this.f8952d;
    }

    public long e() {
        return this.f8953e;
    }

    public String a() {
        return this.f8949a;
    }

    public void b(long j) {
        this.f8953e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8950b);
            jSONObject.put("e", this.f8951c);
            jSONObject.put("user", this.f8952d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
