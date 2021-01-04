package com.baidu.media.duplayer;
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f3240a;

    /* renamed from: b  reason: collision with root package name */
    private String f3241b;
    private String c;
    private a cja;
    private String d;

    /* loaded from: classes15.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f3240a = i;
        this.f3241b = str;
        this.c = str2;
        this.cja = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.cja = aVar;
    }

    public String a() {
        return this.f3241b;
    }

    public void a(String str) {
        this.d = str;
    }

    public a adz() {
        return this.cja;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
