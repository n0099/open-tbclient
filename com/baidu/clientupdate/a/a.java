package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4555a;

    /* renamed from: b  reason: collision with root package name */
    public String f4556b;

    /* renamed from: c  reason: collision with root package name */
    public String f4557c;

    /* renamed from: d  reason: collision with root package name */
    public String f4558d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4559e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4560f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4561g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4562h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f4563i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4556b = str;
        this.f4558d = str2;
        this.f4555a = str3;
        this.f4557c = str4;
        this.f4559e = jSONArray;
        this.f4560f = jSONArray2;
        this.f4561g = jSONArray3;
        this.f4562h = jSONArray4;
        this.f4563i = jSONArray5;
    }

    public String a() {
        return this.f4555a;
    }

    public void a(String str) {
        this.f4555a = str;
    }

    public String b() {
        return this.f4557c;
    }

    public JSONArray c() {
        return this.f4559e;
    }

    public JSONArray d() {
        return this.f4560f;
    }

    public JSONArray e() {
        return this.f4561g;
    }

    public JSONArray f() {
        return this.f4562h;
    }

    public JSONArray g() {
        return this.f4563i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4555a + "', ug='" + this.f4556b + "', nm='" + this.f4557c + "', flag='" + this.f4558d + "', stm=" + this.f4559e + ", sc=" + this.f4560f + ", etm=" + this.f4561g + ", mg=" + this.f4562h + ", ex=" + this.f4563i + '}';
    }
}
