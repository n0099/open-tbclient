package com.baidu.adp.a;

import android.app.Application;
import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public class b extends Application {
    private static b a = null;
    private boolean b = false;
    private Application c = null;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a(this);
    }

    public void a(Application application) {
        a = this;
        this.c = application;
        BdUtilHelper.a(application);
        g();
        h();
        f();
    }

    private void f() {
        com.baidu.adp.lib.network.e.a().a(this.c, false);
    }

    public static b a() {
        return a;
    }

    public Application b() {
        return this.c;
    }

    public Context c() {
        return this.c;
    }

    private void g() {
        if ((this.c.getApplicationInfo().flags & 2) == 0) {
            this.b = false;
        } else {
            this.b = true;
        }
    }

    public boolean d() {
        return this.b;
    }

    private void h() {
        com.baidu.adp.lib.util.b.a().a(this.c);
    }

    public void e() {
    }
}
