package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public String f8524a;

    /* renamed from: b  reason: collision with root package name */
    public long f8525b;

    /* renamed from: c  reason: collision with root package name */
    public long f8526c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8527d;

    /* renamed from: e  reason: collision with root package name */
    public long f8528e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f8524a = str;
        this.f8525b = j;
        this.f8526c = j2;
        this.f8528e = j3;
        this.f8527d = z;
    }

    public void a(long j) {
        this.f8526c = j;
    }

    public long b() {
        return this.f8525b;
    }

    public long c() {
        return this.f8526c;
    }

    public boolean d() {
        return this.f8527d;
    }

    public long e() {
        return this.f8528e;
    }

    public String a() {
        return this.f8524a;
    }

    public void b(long j) {
        this.f8528e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f8525b);
            jSONObject.put("e", this.f8526c);
            jSONObject.put("user", this.f8527d ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
