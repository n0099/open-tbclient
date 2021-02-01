package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f1654a;

    /* renamed from: b  reason: collision with root package name */
    public String f1655b;
    public String c;
    public String d;
    public JSONArray e;
    public JSONArray f;
    public JSONArray g;
    public JSONArray h;
    public JSONArray i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.f1655b = str;
        this.d = str2;
        this.f1654a = str3;
        this.c = str4;
        this.e = jSONArray;
        this.f = jSONArray2;
        this.g = jSONArray3;
        this.h = jSONArray4;
        this.i = jSONArray5;
    }

    public String a() {
        return this.f1654a;
    }

    public void a(String str) {
        this.f1654a = str;
    }

    public String b() {
        return this.c;
    }

    public JSONArray c() {
        return this.e;
    }

    public JSONArray d() {
        return this.f;
    }

    public JSONArray e() {
        return this.g;
    }

    public JSONArray f() {
        return this.h;
    }

    public JSONArray g() {
        return this.i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.f1654a + "', ug='" + this.f1655b + "', nm='" + this.c + "', flag='" + this.d + "', stm=" + this.e + ", sc=" + this.f + ", etm=" + this.g + ", mg=" + this.h + ", ex=" + this.i + '}';
    }
}
