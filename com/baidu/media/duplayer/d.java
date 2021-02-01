package com.baidu.media.duplayer;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f3201a;

    /* renamed from: b  reason: collision with root package name */
    private String f3202b;
    private String c;
    private a ciw;
    private String d;

    /* loaded from: classes5.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f3201a = i;
        this.f3202b = str;
        this.c = str2;
        this.ciw = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.ciw = aVar;
    }

    public String a() {
        return this.f3202b;
    }

    public void a(String str) {
        this.d = str;
    }

    public a abw() {
        return this.ciw;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
