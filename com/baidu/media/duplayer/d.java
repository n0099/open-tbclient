package com.baidu.media.duplayer;
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f2262a;
    private String b;
    private String c;
    private a ccv;
    private String d;

    /* loaded from: classes18.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f2262a = i;
        this.b = str;
        this.c = str2;
        this.ccv = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.ccv = aVar;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.d = str;
    }

    public a abN() {
        return this.ccv;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
