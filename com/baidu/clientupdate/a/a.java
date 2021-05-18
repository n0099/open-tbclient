package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4552a;

    /* renamed from: b  reason: collision with root package name */
    public String f4553b;

    /* renamed from: c  reason: collision with root package name */
    public String f4554c;

    /* renamed from: d  reason: collision with root package name */
    public String f4555d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4556e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4557f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4558g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4559h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f4560i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4553b = str;
        this.f4555d = str2;
        this.f4552a = str3;
        this.f4554c = str4;
        this.f4556e = jSONArray;
        this.f4557f = jSONArray2;
        this.f4558g = jSONArray3;
        this.f4559h = jSONArray4;
        this.f4560i = jSONArray5;
    }

    public String a() {
        return this.f4552a;
    }

    public void a(String str) {
        this.f4552a = str;
    }

    public String b() {
        return this.f4554c;
    }

    public JSONArray c() {
        return this.f4556e;
    }

    public JSONArray d() {
        return this.f4557f;
    }

    public JSONArray e() {
        return this.f4558g;
    }

    public JSONArray f() {
        return this.f4559h;
    }

    public JSONArray g() {
        return this.f4560i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4552a + "', ug='" + this.f4553b + "', nm='" + this.f4554c + "', flag='" + this.f4555d + "', stm=" + this.f4556e + ", sc=" + this.f4557f + ", etm=" + this.f4558g + ", mg=" + this.f4559h + ", ex=" + this.f4560i + '}';
    }
}
