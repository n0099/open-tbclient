package com.baidu.media.duplayer;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f2307a;
    private String b;
    private String c;
    private a cjW;
    private String d;

    /* loaded from: classes5.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f2307a = i;
        this.b = str;
        this.c = str2;
        this.cjW = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.cjW = aVar;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.d = str;
    }

    public a abz() {
        return this.cjW;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
