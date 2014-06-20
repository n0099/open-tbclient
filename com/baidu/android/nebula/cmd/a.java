package com.baidu.android.nebula.cmd;
/* loaded from: classes.dex */
public class a {
    private String a = "";
    private long b = 0;
    private String c = "";
    private String d = "";
    private int e = -1;
    private String f = "web";
    private String g = "";

    public void a() {
        this.a = "";
        this.c = "";
        this.d = "";
        this.e = -1;
        this.b = 0L;
        this.f = "";
        this.g = "";
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public String toString() {
        return "{cmd:" + this.a + ",time:" + this.b + ",cmdpackage:" + this.c + ",execpackage:" + this.d + ",status:" + this.e + ",from:" + this.f + ",mSearchId:" + this.g + "}";
    }
}
