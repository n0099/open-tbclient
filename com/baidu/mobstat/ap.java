package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8602a;

    /* renamed from: b  reason: collision with root package name */
    public long f8603b;

    /* renamed from: c  reason: collision with root package name */
    public long f8604c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8605d;

    /* renamed from: e  reason: collision with root package name */
    public long f8606e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8602a = str;
        this.f8603b = j;
        this.f8604c = j2;
        this.f8606e = j3;
        this.f8605d = z;
    }

    public void a(long j) {
        this.f8604c = j;
    }

    public long b() {
        return this.f8603b;
    }

    public long c() {
        return this.f8604c;
    }

    public boolean d() {
        return this.f8605d;
    }

    public long e() {
        return this.f8606e;
    }

    public String a() {
        return this.f8602a;
    }

    public void b(long j) {
        this.f8606e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8603b);
            jSONObject.put("e", this.f8604c);
            jSONObject.put("user", this.f8605d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
