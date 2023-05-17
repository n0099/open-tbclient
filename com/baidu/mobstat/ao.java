package com.baidu.mobstat;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ao {
    public String a;
    public long b;
    public long c;
    public boolean d;
    public long e;

    public ao(String str, long j, long j2, long j3, boolean z) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.e = j3;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
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

    public JSONObject a(String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("s", this.b);
            jSONObject.put("e", this.c);
            if (this.d) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put("user", i);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(long j) {
        this.e = j;
    }

    public void a(long j) {
        this.c = j;
    }
}
