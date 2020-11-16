package com.baidu.media.duplayer;
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f2260a;
    private String b;
    private a bXe;
    private String c;
    private String d;

    /* loaded from: classes18.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f2260a = i;
        this.b = str;
        this.c = str2;
        this.bXe = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.bXe = aVar;
    }

    public a Zk() {
        return this.bXe;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
