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
        d();
        e();
        c();
    }

    private void c() {
        com.baidu.adp.lib.b.b.a().a(this, false);
    }

    public static b a() {
        return a;
    }

    private void d() {
        if ((getApplicationInfo().flags & 2) == 0) {
            this.b = false;
        } else {
            this.b = true;
        }
    }

    public boolean b() {
        return this.b;
    }

    private void e() {
        com.baidu.adp.lib.e.a.a().a(this);
    }
}
