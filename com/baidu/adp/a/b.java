package com.baidu.adp.a;

import android.app.Application;
/* loaded from: classes.dex */
public class b extends Application {
    private static b a = null;
    private boolean b = false;

    @Override // android.app.Application
    public void onCreate() {
        a = this;
        super.onCreate();
        com.baidu.adp.lib.g.g.a(this);
        e();
        f();
        d();
    }

    private void d() {
        com.baidu.adp.lib.network.e.a().a(this, false);
    }

    public static b a() {
        return a;
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
        com.baidu.adp.lib.g.a.a().a(this);
    }

    public void c() {
    }
}
