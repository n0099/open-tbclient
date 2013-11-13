package com.baidu.android.nebula.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.android.common.net.ConnectManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public final class e {
    private static e f = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f642a;
    private Handler g;
    private s b = new s();
    private s c = new s();
    private volatile s d = new s();
    private s e = new s();
    private h h = null;
    private Runnable i = new f(this);

    private e(Context context) {
        this.f642a = null;
        this.g = null;
        this.f642a = context.getApplicationContext();
        this.g = new Handler(context.getMainLooper());
        j();
        f();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f == null) {
                f = new e(context);
            }
            eVar = f;
        }
        return eVar;
    }

    public static synchronized void a() {
        synchronized (e.class) {
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
        return c.a(context) != 0 || System.currentTimeMillis() - c.a(context, System.currentTimeMillis()) >= 172800000;
    }

    public static void c(Context context) {
        if (b(context)) {
            a(context).i();
        }
    }

    private void f() {
        this.c = l.a(this.f642a).a();
        this.b = k.a(this.f642a);
        g();
    }

    private s g() {
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            a a2 = this.c.a(aVar.b());
            if (a2 == null) {
                aVar.a(b.INSERT);
                this.e.a(aVar.b(), aVar);
            } else if (aVar.compareTo(a2) != 0 && aVar.compareTo(a2) == 1) {
                aVar.a(b.UPDATE);
                this.e.a(aVar.b(), aVar);
            }
        }
        Iterator it2 = this.c.b().iterator();
        while (it2.hasNext()) {
            a aVar2 = (a) it2.next();
            if (this.b.a(aVar2.b()) == null) {
                aVar2.a(b.DELETE);
                this.e.a(aVar2.b(), aVar2);
            }
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if ((r2 - com.baidu.android.nebula.a.c.a(r8.f642a, r2)) > (com.baidu.android.nebula.a.c.a(r8.f642a) * 1000)) goto L7;
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
            new u(this.f642a).a();
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
        this.h = new h(this, null);
        this.f642a.registerReceiver(this.h, intentFilter);
    }

    private void k() {
        if (this.h == null) {
            return;
        }
        this.f642a.unregisterReceiver(this.h);
    }

    public s a(int i) {
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
                a a2 = this.d.a(num.intValue());
                if (a2.a() == b.DELETE) {
                    this.c.b(a2.b());
                } else if (a2.a() == b.UPDATE || a2.a() == b.INSERT) {
                    this.c.a(a2);
                }
            }
        }
        l.a(this.f642a).a(this.c.b());
        return true;
    }

    public s b(int i) {
        if (i >= this.b.c()) {
            return this.b;
        }
        s sVar = new s();
        Random random = new Random();
        while (sVar.c() < i) {
            sVar.a(this.b.a(random.nextInt(this.b.c())));
        }
        return sVar;
    }

    public void b() {
        l.a(this.f642a).b();
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
            a aVar = (a) it.next();
            aVar.a(b.INSERT);
            this.e.a(aVar.b(), aVar);
        }
    }

    public boolean e() {
        return this.e.c() > 0;
    }
}
