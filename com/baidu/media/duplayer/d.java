package com.baidu.media.duplayer;
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f3203a;

    /* renamed from: b  reason: collision with root package name */
    private String f3204b;
    private String c;
    private a cen;
    private String d;

    /* loaded from: classes14.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.f3203a = i;
        this.f3204b = str;
        this.c = str2;
        this.cen = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.cen = aVar;
    }

    public a ZH() {
        return this.cen;
    }

    public String a() {
        return this.f3204b;
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
