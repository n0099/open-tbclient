package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mobstat.bt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    public String f8955a;

    /* renamed from: b  reason: collision with root package name */
    public String f8956b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f8957c;

    /* renamed from: d  reason: collision with root package name */
    public String f8958d;

    /* renamed from: e  reason: collision with root package name */
    public String f8959e;

    /* renamed from: f  reason: collision with root package name */
    public String f8960f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8961g;

    /* renamed from: h  reason: collision with root package name */
    public long f8962h;
    public long i;
    public long j;
    public int k;
    public String l;
    public String m;

    public aq(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z, int i, long j, long j2, long j3, String str6, String str7) {
        this.f8955a = str;
        this.f8956b = str2;
        this.f8957c = jSONArray;
        this.f8958d = str3;
        this.f8959e = str4;
        this.f8960f = str5;
        this.f8961g = z;
        this.k = i;
        this.f8962h = j;
        this.i = j2;
        this.j = j3;
        this.l = str6;
        this.m = str7;
    }

    public String a() {
        return this.f8955a;
    }

    public String b() {
        return this.f8956b;
    }

    public JSONArray c() {
        return this.f8957c;
    }

    public String d() {
        return this.f8958d;
    }

    public String e() {
        return this.f8959e;
    }

    public String f() {
        return this.f8960f;
    }

    public boolean g() {
        return this.f8961g;
    }

    public int h() {
        return this.k;
    }

    public long i() {
        return this.f8962h;
    }

    public long j() {
        return this.i;
    }

    public long k() {
        return this.j;
    }

    public String l() {
        return this.l;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(long j) {
        this.j = j;
    }

    public void a(long j) {
        this.i = j;
    }

    public void b(String str) {
        this.m = str;
    }

    public void a(String str) {
        this.l = str;
    }

    public JSONObject a(String str, String str2, String str3) {
        String a2 = a(this.f8955a, this.f8956b, this.f8957c, this.f8958d, this.f8959e, this.f8960f, this.f8961g);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f8955a);
            jSONObject.put("d", this.l);
            jSONObject.put("p", str);
            jSONObject.put("path", str3);
            jSONObject.put("title", this.f8958d);
            jSONObject.put("index", this.f8959e);
            jSONObject.put("n", str2);
            jSONObject.put("user", this.f8961g ? 1 : 0);
            jSONObject.put("c", this.k);
            jSONObject.put("t", this.f8962h);
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
