package com.baidu.media.duplayer;
/* loaded from: classes12.dex */
public class d {
    private int a;
    private String b;
    private a bAH;
    private String c;
    private String d;

    /* loaded from: classes12.dex */
    public enum a {
        LIB_TYPE_JAR,
        LIB_TYPE_SO
    }

    public d(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.bAH = a.LIB_TYPE_SO;
    }

    public d(int i, String str, String str2, a aVar) {
        this(i, str, str2);
        this.bAH = aVar;
    }

    public a SQ() {
        return this.bAH;
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
