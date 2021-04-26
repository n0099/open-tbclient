package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4698a;

    /* renamed from: b  reason: collision with root package name */
    public String f4699b;

    /* renamed from: c  reason: collision with root package name */
    public String f4700c;

    /* renamed from: d  reason: collision with root package name */
    public String f4701d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4702e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4703f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4704g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4705h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f4706i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4699b = str;
        this.f4701d = str2;
        this.f4698a = str3;
        this.f4700c = str4;
        this.f4702e = jSONArray;
        this.f4703f = jSONArray2;
        this.f4704g = jSONArray3;
        this.f4705h = jSONArray4;
        this.f4706i = jSONArray5;
    }

    public String a() {
        return this.f4698a;
    }

    public void a(String str) {
        this.f4698a = str;
    }

    public String b() {
        return this.f4700c;
    }

    public JSONArray c() {
        return this.f4702e;
    }

    public JSONArray d() {
        return this.f4703f;
    }

    public JSONArray e() {
        return this.f4704g;
    }

    public JSONArray f() {
        return this.f4705h;
    }

    public JSONArray g() {
        return this.f4706i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4698a + "', ug='" + this.f4699b + "', nm='" + this.f4700c + "', flag='" + this.f4701d + "', stm=" + this.f4702e + ", sc=" + this.f4703f + ", etm=" + this.f4704g + ", mg=" + this.f4705h + ", ex=" + this.f4706i + '}';
    }
}
