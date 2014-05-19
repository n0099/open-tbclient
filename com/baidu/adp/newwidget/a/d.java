package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable a;
    public com.baidu.adp.widget.a.a b;
    public volatile boolean c = true;

    public boolean a() {
        return (this.a == null || this.a.getBitmap() == null) ? false : true;
    }

    public boolean b() {
        return this.b != null && this.b.i();
    }

    public boolean c() {
        return a() || b();
    }

    public int d() {
        if (a()) {
            return this.a.getIntrinsicWidth();
        }
        if (b()) {
            return this.b.c();
        }
        return 0;
    }

    public int e() {
        if (a()) {
            return this.a.getIntrinsicHeight();
        }
        if (b()) {
            return this.b.d();
        }
        return 0;
    }

    public void f() {
        this.b = null;
        this.a = null;
    }

    public boolean g() {
        if (b()) {
            return this.b.e();
        }
        return false;
    }
}
