package com.baidu.ar.bean;
/* loaded from: classes3.dex */
public class e {
    private String a;
    private int b;
    private String c;
    private int e;
    private String f;
    private int d = 1000;
    private boolean g = true;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.e = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        return this.g;
    }

    public String toString() {
        return "SlamModel{id='" + this.a + "', placeType=" + this.b + ", position='" + this.c + "', distance=" + this.d + ", pitchAngle=" + this.e + ", rotation='" + this.f + "', mImmediatelyPlaceModel=" + this.g + '}';
    }
}
