package com.baidu.android.nebula.c;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.nebula.util.BDLocationManager;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f541a = null;
    private com.baidu.android.nebula.d.d b = null;
    private Context c;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f541a == null) {
                f541a = new c();
            }
            cVar = f541a;
        }
        return cVar;
    }

    public static void a(Context context, Intent intent) {
        a().a(context);
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (f541a != null) {
                f541a.d();
                f541a = null;
            }
        }
    }

    public boolean a(Context context) {
        if (e()) {
            return true;
        }
        this.b = new com.baidu.android.nebula.d.d(new com.baidu.android.nebula.b.d(), new d());
        boolean a2 = this.b.a(6259);
        if (a2) {
            this.c = context;
            com.baidu.android.nebula.c.a.a.a(this.c);
            return a2;
        }
        return a2;
    }

    public Context c() {
        return this.c;
    }

    public void d() {
        if (e()) {
            this.b.a();
        }
        BDLocationManager.a();
    }

    public boolean e() {
        return this.b != null && this.b.b();
    }
}
