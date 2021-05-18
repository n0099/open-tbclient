package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8640a;

    /* renamed from: b  reason: collision with root package name */
    public long f8641b;

    /* renamed from: c  reason: collision with root package name */
    public long f8642c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8643d;

    /* renamed from: e  reason: collision with root package name */
    public long f8644e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8640a = str;
        this.f8641b = j;
        this.f8642c = j2;
        this.f8644e = j3;
        this.f8643d = z;
    }

    public void a(long j) {
        this.f8642c = j;
    }

    public long b() {
        return this.f8641b;
    }

    public long c() {
        return this.f8642c;
    }

    public boolean d() {
        return this.f8643d;
    }

    public long e() {
        return this.f8644e;
    }

    public String a() {
        return this.f8640a;
    }

    public void b(long j) {
        this.f8644e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8641b);
            jSONObject.put("e", this.f8642c);
            jSONObject.put("user", this.f8643d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
