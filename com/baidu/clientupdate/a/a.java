package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4593a;

    /* renamed from: b  reason: collision with root package name */
    public String f4594b;

    /* renamed from: c  reason: collision with root package name */
    public String f4595c;

    /* renamed from: d  reason: collision with root package name */
    public String f4596d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4597e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4598f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4599g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4600h;
    public JSONArray i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4594b = str;
        this.f4596d = str2;
        this.f4593a = str3;
        this.f4595c = str4;
        this.f4597e = jSONArray;
        this.f4598f = jSONArray2;
        this.f4599g = jSONArray3;
        this.f4600h = jSONArray4;
        this.i = jSONArray5;
    }

    public String a() {
        return this.f4593a;
    }

    public void a(String str) {
        this.f4593a = str;
    }

    public String b() {
        return this.f4595c;
    }

    public JSONArray c() {
        return this.f4597e;
    }

    public JSONArray d() {
        return this.f4598f;
    }

    public JSONArray e() {
        return this.f4599g;
    }

    public JSONArray f() {
        return this.f4600h;
    }

    public JSONArray g() {
        return this.i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4593a + "', ug='" + this.f4594b + "', nm='" + this.f4595c + "', flag='" + this.f4596d + "', stm=" + this.f4597e + ", sc=" + this.f4598f + ", etm=" + this.f4599g + ", mg=" + this.f4600h + ", ex=" + this.i + '}';
    }
}
