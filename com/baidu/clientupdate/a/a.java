package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4557a;

    /* renamed from: b  reason: collision with root package name */
    public String f4558b;

    /* renamed from: c  reason: collision with root package name */
    public String f4559c;

    /* renamed from: d  reason: collision with root package name */
    public String f4560d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4561e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4562f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4563g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4564h;
    public JSONArray i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4558b = str;
        this.f4560d = str2;
        this.f4557a = str3;
        this.f4559c = str4;
        this.f4561e = jSONArray;
        this.f4562f = jSONArray2;
        this.f4563g = jSONArray3;
        this.f4564h = jSONArray4;
        this.i = jSONArray5;
    }

    public String a() {
        return this.f4557a;
    }

    public void a(String str) {
        this.f4557a = str;
    }

    public String b() {
        return this.f4559c;
    }

    public JSONArray c() {
        return this.f4561e;
    }

    public JSONArray d() {
        return this.f4562f;
    }

    public JSONArray e() {
        return this.f4563g;
    }

    public JSONArray f() {
        return this.f4564h;
    }

    public JSONArray g() {
        return this.i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4557a + "', ug='" + this.f4558b + "', nm='" + this.f4559c + "', flag='" + this.f4560d + "', stm=" + this.f4561e + ", sc=" + this.f4562f + ", etm=" + this.f4563g + ", mg=" + this.f4564h + ", ex=" + this.i + '}';
    }
}
