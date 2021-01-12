package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes14.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private String f3682a;

    /* renamed from: b  reason: collision with root package name */
    private long f3683b;
    private long c;
    private boolean d;
    private long e;

    public ap(String str, long j, long j2, long j3, boolean z) {
        this.f3682a = str;
        this.f3683b = j;
        this.c = j2;
        this.e = j3;
        this.d = z;
    }

    public void a(long j) {
        this.c = j;
    }

    public String a() {
        return this.f3682a;
    }

    public long b() {
        return this.f3683b;
    }

    public long c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.f3683b);
            jSONObject.put("e", this.c);
            jSONObject.put("user", this.d ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
