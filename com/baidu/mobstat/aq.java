package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mobstat.bt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private String f2596a;
    private String b;
    private JSONArray c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private long h;
    private long i;
    private long j;
    private int k;
    private String l;
    private String m;

    public aq(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z, int i, long j, long j2, long j3, String str6, String str7) {
        this.f2596a = str;
        this.b = str2;
        this.c = jSONArray;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = z;
        this.k = i;
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.l = str6;
        this.m = str7;
    }

    public String a() {
        return this.f2596a;
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

    public void a(int i) {
        this.k = i;
    }

    public long j() {
        return this.i;
    }

    public long k() {
        return this.j;
    }

    public void a(long j) {
        this.i = j;
    }

    public void b(long j) {
        this.j = j;
    }

    public String l() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }

    public void b(String str) {
        this.m = str;
    }

    public JSONObject a(String str, String str2, String str3) {
        String a2 = a(this.f2596a, this.b, this.c, this.d, this.e, this.f, this.g);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f2596a);
            jSONObject.put("d", this.l);
            jSONObject.put("p", str);
            jSONObject.put("path", str3);
            jSONObject.put("title", this.d);
            jSONObject.put("index", this.e);
            jSONObject.put("n", str2);
            jSONObject.put("user", this.g ? 1 : 0);
            jSONObject.put("c", this.k);
            jSONObject.put("t", this.h);
            jSONObject.put("ps", this.m);
            jSONObject.put("sign", a2);
        } catch (Exception e) {
            jSONObject = null;
        }
        return jSONObject;
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        String str6 = "";
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
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(str6)) {
            return "";
        }
        return bt.a.a(str6.getBytes());
    }
}
