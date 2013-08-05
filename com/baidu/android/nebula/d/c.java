package com.baidu.android.nebula.d;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.nebula.util.BDLocationManager;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f556a = null;
    private com.baidu.android.nebula.c.b b = null;
    private Context c;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f556a == null) {
                f556a = new c();
            }
            cVar = f556a;
        }
        return cVar;
    }

    public static void a(Context context, Intent intent) {
        a().a(context);
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (f556a != null) {
                f556a.d();
                f556a = null;
            }
        }
    }

    public boolean a(Context context) {
        if (e()) {
            return true;
        }
        this.b = new com.baidu.android.nebula.c.b(new com.baidu.android.nebula.a.c(), new b());
        boolean a2 = this.b.a(6259);
        if (a2) {
            this.c = context;
            com.baidu.android.nebula.d.a.a.a(this.c);
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
