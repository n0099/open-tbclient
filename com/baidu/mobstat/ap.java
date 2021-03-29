package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8950a;

    /* renamed from: b  reason: collision with root package name */
    public long f8951b;

    /* renamed from: c  reason: collision with root package name */
    public long f8952c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8953d;

    /* renamed from: e  reason: collision with root package name */
    public long f8954e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8950a = str;
        this.f8951b = j;
        this.f8952c = j2;
        this.f8954e = j3;
        this.f8953d = z;
    }

    public void a(long j) {
        this.f8952c = j;
    }

    public long b() {
        return this.f8951b;
    }

    public long c() {
        return this.f8952c;
    }

    public boolean d() {
        return this.f8953d;
    }

    public long e() {
        return this.f8954e;
    }

    public String a() {
        return this.f8950a;
    }

    public void b(long j) {
        this.f8954e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8951b);
            jSONObject.put("e", this.f8952c);
            jSONObject.put("user", this.f8953d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
