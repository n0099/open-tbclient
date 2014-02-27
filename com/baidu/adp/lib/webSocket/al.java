package com.baidu.adp.lib.webSocket;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
/* loaded from: classes.dex */
public final class al {
    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;

    public al() {
        this.i = null;
        this.a = AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        this.b = AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        this.c = false;
        this.d = true;
        this.e = 30000;
        this.f = 30000;
        this.g = true;
        this.h = true;
        this.i = null;
    }

    public al(al alVar) {
        this.i = null;
        this.a = alVar.a;
        this.b = alVar.b;
        this.c = alVar.c;
        this.d = alVar.d;
        this.e = alVar.e;
        this.f = alVar.f;
        this.g = alVar.g;
        this.h = alVar.h;
        this.i = alVar.i;
    }

    public final boolean a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final void a(String str) {
        this.i = str;
    }
}
