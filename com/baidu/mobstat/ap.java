package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8540a;

    /* renamed from: b  reason: collision with root package name */
    public long f8541b;

    /* renamed from: c  reason: collision with root package name */
    public long f8542c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8543d;

    /* renamed from: e  reason: collision with root package name */
    public long f8544e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8540a = str;
        this.f8541b = j;
        this.f8542c = j2;
        this.f8544e = j3;
        this.f8543d = z;
    }

    public void a(long j) {
        this.f8542c = j;
    }

    public long b() {
        return this.f8541b;
    }

    public long c() {
        return this.f8542c;
    }

    public boolean d() {
        return this.f8543d;
    }

    public long e() {
        return this.f8544e;
    }

    public String a() {
        return this.f8540a;
    }

    public void b(long j) {
        this.f8544e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8541b);
            jSONObject.put("e", this.f8542c);
            jSONObject.put("user", this.f8543d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
