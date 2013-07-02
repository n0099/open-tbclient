package com.baidu.android.nebula.localserver;

import android.content.Context;
import com.baidu.android.nebula.localserver.util.BDLocationManager;
import com.baidu.android.nebula.localserver.util.e;
/* loaded from: classes.dex */
public class c {
    private static c a = null;
    private com.baidu.android.nebula.c.d b = null;
    private Context c;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public boolean a(Context context) {
        if (d()) {
            return true;
        }
        this.b = new com.baidu.android.nebula.c.d(new com.baidu.android.nebula.b.d(), new d());
        boolean a2 = this.b.a(6259);
        if (a2) {
            this.c = context;
            e.a(this.c);
            return a2;
        }
        return a2;
    }

    public Context b() {
        return this.c;
    }

    public void c() {
        if (d()) {
            this.b.a();
        }
        BDLocationManager.a();
    }

    public boolean d() {
        return this.b != null && this.b.b();
    }
}
