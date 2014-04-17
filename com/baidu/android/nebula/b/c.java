package com.baidu.android.nebula.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public final class c {
    private static c f = null;
    private Context a;
    private Handler g;
    private j b = new j();
    private j c = new j();
    private volatile j d = new j();
    private j e = new j();
    private q h = null;
    private Runnable i = new t(this);

    private c(Context context) {
        this.a = null;
        this.g = null;
        this.a = context.getApplicationContext();
        this.g = new Handler(context.getMainLooper());
        j();
        f();
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f == null) {
                f = new c(context);
            }
            cVar = f;
        }
        return cVar;
    }

    public static synchronized void a() {
        synchronized (c.class) {
            if (f != null) {
                f.k();
                f = null;
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
        }
    }

    public static boolean b(Context context) {
        return m.a(context) != 0 || System.currentTimeMillis() - m.a(context, System.currentTimeMillis()) >= 172800000;
    }

    public static void c(Context context) {
        if (com.baidu.android.a.j.a(context).f() && b(context)) {
            a(context).i();
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.android.nebula.b.b.run():void] */
    public static /* synthetic */ void d(c cVar) {
        cVar.h();
    }

    private void f() {
        this.c = d.a(this.a).a();
        this.b = f.a(this.a);
        g();
    }

    private j g() {
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            u a = this.c.a(uVar.b());
            if (a == null) {
                uVar.a(r.INSERT);
                this.e.a(uVar.b(), uVar);
            } else if (uVar.compareTo(a) != 0 && uVar.compareTo(a) == 1) {
                uVar.a(r.UPDATE);
                this.e.a(uVar.b(), uVar);
            }
        }
        Iterator it2 = this.c.b().iterator();
        while (it2.hasNext()) {
            u uVar2 = (u) it2.next();
            if (this.b.a(uVar2.b()) == null) {
                uVar2.a(r.DELETE);
                this.e.a(uVar2.b(), uVar2);
            }
        }
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
        if ((r2 - com.baidu.android.nebula.b.m.a(r8.a, r2)) > (com.baidu.android.nebula.b.m.a(r8.a) * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        boolean z = true;
        boolean z2 = c();
        if (!z2) {
            long currentTimeMillis = System.currentTimeMillis();
        }
        z = z2;
        if (z) {
            new g(this.a).a();
        }
    }

    public void i() {
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.i, 60000L);
    }

    private void j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.h = new q(this, null);
        this.a.registerReceiver(this.h, intentFilter);
    }

    private void k() {
        if (this.h == null) {
            return;
        }
        this.a.unregisterReceiver(this.h);
    }

    public final j a(int i) {
        this.d.a();
        if (i >= this.e.c()) {
            this.d = this.e.a(0, this.e.c());
        } else {
            this.d = this.e.a(0, i);
        }
        return this.d;
    }

    public final boolean a(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() > this.d.c()) {
            return false;
        }
        int c = this.d.c();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < c) {
                u a = this.d.a(num.intValue());
                if (a.a() == r.DELETE) {
                    this.c.b(a.b());
                } else if (a.a() == r.UPDATE || a.a() == r.INSERT) {
                    this.c.a(a);
                }
            }
        }
        d.a(this.a).a(this.c.b());
        return true;
    }

    public final j b(int i) {
        if (i >= this.b.c()) {
            return this.b;
        }
        j jVar = new j();
        Random random = new Random();
        while (jVar.c() < i) {
            jVar.a(this.b.a(random.nextInt(this.b.c())));
        }
        return jVar;
    }

    public final void b() {
        d.a(this.a).b();
    }

    public final void b(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.e.a(this.d.a(((Integer) it.next()).intValue()));
        }
    }

    public final boolean c() {
        return this.e.c() > 0;
    }

    public final void d() {
        this.e.a();
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            uVar.a(r.INSERT);
            this.e.a(uVar.b(), uVar);
        }
    }

    public final boolean e() {
        return this.e.c() > 0;
    }
}
