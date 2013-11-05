package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private int f527a;
    private int b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;

    public ai() {
        this.i = null;
        this.f527a = 131072;
        this.b = 131072;
        this.c = false;
        this.d = true;
        this.e = 30000;
        this.f = 30000;
        this.g = true;
        this.h = true;
        this.i = null;
    }

    public ai(ai aiVar) {
        this.i = null;
        this.f527a = aiVar.f527a;
        this.b = aiVar.b;
        this.c = aiVar.c;
        this.d = aiVar.d;
        this.e = aiVar.e;
        this.f = aiVar.f;
        this.g = aiVar.g;
        this.h = aiVar.h;
        this.i = aiVar.i;
    }

    public boolean a() {
        return this.c;
    }

    public int b() {
        return this.f527a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }
}
