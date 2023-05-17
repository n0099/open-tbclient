package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mobstat.bs;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    public String a;
    public String b;
    public JSONArray c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    public int k;
    public String l;
    public String m;
    public String n;
    public JSONArray o;

    public ap(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, String str6, boolean z, int i, long j, long j2, long j3, String str7, String str8, JSONArray jSONArray2) {
        this.a = str;
        this.b = str2;
        this.c = jSONArray;
        this.d = str3;
        this.e = str5;
        this.f = str6;
        this.g = z;
        this.k = i;
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.l = str7;
        this.m = str8;
        this.n = str4;
        this.o = jSONArray2;
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        String str6;
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("p", str2);
            jSONObject.put("path", jSONArray);
            jSONObject.put("title", str3);
            jSONObject.put("index", str4);
            jSONObject.put("n", str5);
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put("user", i);
            str6 = jSONObject.toString();
        } catch (Exception unused) {
            str6 = "";
        }
        if (TextUtils.isEmpty(str6)) {
            return "";
        }
        return bs.a.a(str6.getBytes());
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public JSONArray c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public int h() {
        return this.k;
    }

    public long i() {
        return this.h;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(String str, String str2, String str3) {
        Object obj;
        int i;
        String a = a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.a);
            jSONObject.put("d", this.l);
            jSONObject.put("p", str);
            jSONObject.put("path", str3);
            if (this.o != null && this.o.length() != 0) {
                obj = this.o;
                jSONObject.put("v5", obj);
                jSONObject.put("title", this.d);
                jSONObject.put("content", this.n);
                jSONObject.put("index", this.e);
                jSONObject.put("n", str2);
                if (!this.g) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("user", i);
                jSONObject.put("c", this.k);
                jSONObject.put("t", this.h);
                jSONObject.put("ps", this.m);
                jSONObject.put("sign", a);
                return jSONObject;
            }
            obj = "";
            jSONObject.put("v5", obj);
            jSONObject.put("title", this.d);
            jSONObject.put("content", this.n);
            jSONObject.put("index", this.e);
            jSONObject.put("n", str2);
            if (!this.g) {
            }
            jSONObject.put("user", i);
            jSONObject.put("c", this.k);
            jSONObject.put("t", this.h);
            jSONObject.put("ps", this.m);
            jSONObject.put("sign", a);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
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
}
