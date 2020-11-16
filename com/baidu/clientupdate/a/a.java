package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes14.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f1318a;
    public String b;
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
        this.b = str;
        this.d = str2;
        this.f1318a = str3;
        this.c = str4;
        this.e = jSONArray;
        this.f = jSONArray2;
        this.g = jSONArray3;
        this.h = jSONArray4;
        this.i = jSONArray5;
    }

    public String a() {
        return this.f1318a;
    }

    public void a(String str) {
        this.f1318a = str;
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
        return "LogModel{sessioninfo='" + this.f1318a + "', ug='" + this.b + "', nm='" + this.c + "', flag='" + this.d + "', stm=" + this.e + ", sc=" + this.f + ", etm=" + this.g + ", mg=" + this.h + ", ex=" + this.i + '}';
    }
}
