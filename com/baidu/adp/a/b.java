package com.baidu.adp.a;

import android.app.Application;
/* loaded from: classes.dex */
public class b extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static b f117a = null;
    private boolean b = false;

    @Override // android.app.Application
    public void onCreate() {
        f117a = this;
        super.onCreate();
        e();
        f();
        d();
    }

    private void d() {
        com.baidu.adp.lib.network.b.a().a(this, false);
    }

    public static b a() {
        return f117a;
    }

    private void e() {
        if ((getApplicationInfo().flags & 2) == 0) {
            this.b = false;
        } else {
            this.b = true;
        }
    }

    public boolean b() {
        return this.b;
    }

    private void f() {
        com.baidu.adp.lib.c.a.a().a(this);
    }

    public void c() {
    }
}
