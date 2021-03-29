package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4558a;

    /* renamed from: b  reason: collision with root package name */
    public String f4559b;

    /* renamed from: c  reason: collision with root package name */
    public String f4560c;

    /* renamed from: d  reason: collision with root package name */
    public String f4561d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4562e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4563f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4564g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4565h;
    public JSONArray i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4559b = str;
        this.f4561d = str2;
        this.f4558a = str3;
        this.f4560c = str4;
        this.f4562e = jSONArray;
        this.f4563f = jSONArray2;
        this.f4564g = jSONArray3;
        this.f4565h = jSONArray4;
        this.i = jSONArray5;
    }

    public String a() {
        return this.f4558a;
    }

    public void a(String str) {
        this.f4558a = str;
    }

    public String b() {
        return this.f4560c;
    }

    public JSONArray c() {
        return this.f4562e;
    }

    public JSONArray d() {
        return this.f4563f;
    }

    public JSONArray e() {
        return this.f4564g;
    }

    public JSONArray f() {
        return this.f4565h;
    }

    public JSONArray g() {
        return this.i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4558a + "', ug='" + this.f4559b + "', nm='" + this.f4560c + "', flag='" + this.f4561d + "', stm=" + this.f4562e + ", sc=" + this.f4563f + ", etm=" + this.f4564g + ", mg=" + this.f4565h + ", ex=" + this.i + '}';
    }
}
