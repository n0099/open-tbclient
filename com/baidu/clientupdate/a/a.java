package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4574a;

    /* renamed from: b  reason: collision with root package name */
    public String f4575b;

    /* renamed from: c  reason: collision with root package name */
    public String f4576c;

    /* renamed from: d  reason: collision with root package name */
    public String f4577d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4578e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4579f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4580g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4581h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f4582i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f4575b = str;
        this.f4577d = str2;
        this.f4574a = str3;
        this.f4576c = str4;
        this.f4578e = jSONArray;
        this.f4579f = jSONArray2;
        this.f4580g = jSONArray3;
        this.f4581h = jSONArray4;
        this.f4582i = jSONArray5;
    }

    public String a() {
        return this.f4574a;
    }

    public void a(String str) {
        this.f4574a = str;
    }

    public String b() {
        return this.f4576c;
    }

    public JSONArray c() {
        return this.f4578e;
    }

    public JSONArray d() {
        return this.f4579f;
    }

    public JSONArray e() {
        return this.f4580g;
    }

    public JSONArray f() {
        return this.f4581h;
    }

    public JSONArray g() {
        return this.f4582i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f4574a + "', ug='" + this.f4575b + "', nm='" + this.f4576c + "', flag='" + this.f4577d + "', stm=" + this.f4578e + ", sc=" + this.f4579f + ", etm=" + this.f4580g + ", mg=" + this.f4581h + ", ex=" + this.f4582i + '}';
    }
}
