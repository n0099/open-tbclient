package com.alipay.security.mobile.module.http.model;
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final int f2096c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2097d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f2098e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final String f2099f = "APPKEY_ERROR";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2100g = "SUCCESS";

    /* renamed from: h  reason: collision with root package name */
    public String f2101h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p = "";

    public int a() {
        return this.f2094a ? com.alipay.security.mobile.module.a.a.a(this.f2101h) ? 2 : 1 : f2099f.equals(this.f2095b) ? 3 : 2;
    }

    public boolean b() {
        return "1".equals(this.j);
    }

    public String c() {
        String str = this.k;
        return str == null ? "0" : str;
    }
}
