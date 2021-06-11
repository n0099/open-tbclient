package com.alipay.security.mobile.module.http.model;
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final int f2095c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2096d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f2097e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final String f2098f = "APPKEY_ERROR";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2099g = "SUCCESS";

    /* renamed from: h  reason: collision with root package name */
    public String f2100h;

    /* renamed from: i  reason: collision with root package name */
    public String f2101i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p = "";

    public int a() {
        return this.f2093a ? com.alipay.security.mobile.module.a.a.a(this.f2100h) ? 2 : 1 : f2098f.equals(this.f2094b) ? 3 : 2;
    }

    public boolean b() {
        return "1".equals(this.j);
    }

    public String c() {
        String str = this.k;
        return str == null ? "0" : str;
    }
}
