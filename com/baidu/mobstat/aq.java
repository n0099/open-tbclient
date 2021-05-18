package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mobstat.bt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    public String f8645a;

    /* renamed from: b  reason: collision with root package name */
    public String f8646b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f8647c;

    /* renamed from: d  reason: collision with root package name */
    public String f8648d;

    /* renamed from: e  reason: collision with root package name */
    public String f8649e;

    /* renamed from: f  reason: collision with root package name */
    public String f8650f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8651g;

    /* renamed from: h  reason: collision with root package name */
    public long f8652h;

    /* renamed from: i  reason: collision with root package name */
    public long f8653i;
    public long j;
    public int k;
    public String l;
    public String m;

    public aq(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z, int i2, long j, long j2, long j3, String str6, String str7) {
        this.f8645a = str;
        this.f8646b = str2;
        this.f8647c = jSONArray;
        this.f8648d = str3;
        this.f8649e = str4;
        this.f8650f = str5;
        this.f8651g = z;
        this.k = i2;
        this.f8652h = j;
        this.f8653i = j2;
        this.j = j3;
        this.l = str6;
        this.m = str7;
    }

    public String a() {
        return this.f8645a;
    }

    public String b() {
        return this.f8646b;
    }

    public JSONArray c() {
        return this.f8647c;
    }

    public String d() {
        return this.f8648d;
    }

    public String e() {
        return this.f8649e;
    }

    public String f() {
        return this.f8650f;
    }

    public boolean g() {
        return this.f8651g;
    }

    public int h() {
        return this.k;
    }

    public long i() {
        return this.f8652h;
    }

    public long j() {
        return this.f8653i;
    }

    public long k() {
        return this.j;
    }

    public String l() {
        return this.l;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void b(long j) {
        this.j = j;
    }

    public void a(long j) {
        this.f8653i = j;
    }

    public void b(String str) {
        this.m = str;
    }

    public void a(String str) {
        this.l = str;
    }

    public JSONObject a(String str, String str2, String str3) {
        String a2 = a(this.f8645a, this.f8646b, this.f8647c, this.f8648d, this.f8649e, this.f8650f, this.f8651g);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f8645a);
            jSONObject.put("d", this.l);
            jSONObject.put("p", str);
            jSONObject.put("path", str3);
            jSONObject.put("title", this.f8648d);
            jSONObject.put("index", this.f8649e);
            jSONObject.put("n", str2);
            jSONObject.put("user", this.f8651g ? 1 : 0);
            jSONObject.put("c", this.k);
            jSONObject.put("t", this.f8652h);
            jSONObject.put("ps", this.m);
            jSONObject.put("sign", a2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        String str6;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("p", str2);
            jSONObject.put("path", jSONArray);
            jSONObject.put("title", str3);
            jSONObject.put("index", str4);
            jSONObject.put("n", str5);
            jSONObject.put("user", z ? 1 : 0);
            str6 = jSONObject.toString();
        } catch (Exception unused) {
            str6 = "";
        }
        return !TextUtils.isEmpty(str6) ? bt.a.a(str6.getBytes()) : "";
    }
}
