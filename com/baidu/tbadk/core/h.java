package com.baidu.tbadk.core;

import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class h {
    private static h a;
    private int b = 1;
    private int c = 1;
    private int d = 0;
    private boolean e = true;
    private int f = 0;

    public static h a() {
        h hVar;
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
                hVar = a;
            }
            return hVar;
        }
        return a;
    }

    private h() {
    }

    public void b() {
        this.d = com.baidu.tbadk.core.sharedPref.b.a().a("image_quality", 0);
        this.b = com.baidu.tbadk.core.sharedPref.b.a().a("new_display_photo", 1);
        this.c = com.baidu.tbadk.core.sharedPref.b.a().a("new_abstract_state", 0);
        this.f = com.baidu.tbadk.core.sharedPref.b.a().a("view_image_quality", 0);
        this.e = com.baidu.tbadk.core.sharedPref.b.a().a("show_images", true);
    }

    public void a(int i) {
        this.b = i;
        com.baidu.tbadk.core.sharedPref.b.a().b("new_display_photo", i);
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        if (this.b == 0) {
            if (bb.a().c()) {
                return true;
            }
        } else if (this.b == 1) {
            return true;
        }
        return false;
    }

    public void b(int i) {
        if (this.d != i) {
            this.d = i;
            com.baidu.tbadk.core.sharedPref.b.a().b("image_quality", i);
        }
    }

    public int e() {
        this.d = com.baidu.tbadk.core.sharedPref.b.a().a("image_quality", 0);
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public void a(boolean z) {
        if (this.e != z) {
            this.e = z;
            com.baidu.tbadk.core.sharedPref.b.a().b("show_images", z);
        }
    }

    public void c(int i) {
        if (this.f != i) {
            this.f = i;
            com.baidu.tbadk.core.sharedPref.b.a().b("view_image_quality", i);
            bb.a().f();
            bb.a().g();
        }
    }

    public int g() {
        return this.f;
    }

    public void b(boolean z) {
        if (z) {
            a(0);
            b(0);
            a(true);
            c(0);
            return;
        }
        a(1);
        b(1);
        a(true);
        c(1);
    }

    public boolean h() {
        return this.b == 0 || this.d == 0 || this.f == 0;
    }
}
