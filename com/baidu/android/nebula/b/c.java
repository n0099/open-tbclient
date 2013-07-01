package com.baidu.android.nebula.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.android.common.net.ConnectManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public final class c {
    private static c f = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f259a;
    private Handler g;
    private j b = new j();
    private j c = new j();
    private volatile j d = new j();
    private j e = new j();
    private q h = null;
    private Runnable i = new t(this);

    private c(Context context) {
        this.f259a = null;
        this.g = null;
        this.f259a = context.getApplicationContext();
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
        if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && ConnectManager.isNetworkConnected(context)) {
            c(context);
        }
    }

    public static boolean b(Context context) {
        return m.a(context) != 0 || System.currentTimeMillis() - m.a(context, System.currentTimeMillis()) >= 172800000;
    }

    public static void c(Context context) {
        if (b(context)) {
            a(context).i();
        }
    }

    private void f() {
        this.c = d.a(this.f259a).a();
        this.b = f.a(this.f259a);
        g();
    }

    private j g() {
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            u a2 = this.c.a(uVar.b());
            if (a2 == null) {
                uVar.a(r.INSERT);
                this.e.a(uVar.b(), uVar);
            } else if (uVar.compareTo(a2) != 0 && uVar.compareTo(a2) == 1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if ((r2 - com.baidu.android.nebula.b.m.a(r8.f259a, r2)) > (com.baidu.android.nebula.b.m.a(r8.f259a) * 1000)) goto L7;
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
            new g(this.f259a).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.i, 5000L);
    }

    private void j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.h = new q(this, null);
        this.f259a.registerReceiver(this.h, intentFilter);
    }

    private void k() {
        if (this.h == null) {
            return;
        }
        this.f259a.unregisterReceiver(this.h);
    }

    public j a(int i) {
        this.d.a();
        if (i >= this.e.c()) {
            this.d = this.e.a(0, this.e.c());
        } else {
            this.d = this.e.a(0, i);
        }
        return this.d;
    }

    public boolean a(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() > this.d.c()) {
            return false;
        }
        int c = this.d.c();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < c) {
                u a2 = this.d.a(num.intValue());
                if (a2.a() == r.DELETE) {
                    this.c.b(a2.b());
                } else if (a2.a() == r.UPDATE || a2.a() == r.INSERT) {
                    this.c.a(a2);
                }
            }
        }
        d.a(this.f259a).a(this.c.b());
        return true;
    }

    public j b(int i) {
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

    public void b() {
        d.a(this.f259a).b();
    }

    public void b(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.e.a(this.d.a(((Integer) it.next()).intValue()));
        }
    }

    public boolean c() {
        return this.e.c() > 0;
    }

    public void d() {
        this.e.a();
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            uVar.a(r.INSERT);
            this.e.a(uVar.b(), uVar);
        }
    }

    public boolean e() {
        return this.e.c() > 0;
    }
}
