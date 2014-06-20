package com.baidu.android.nebula.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public final class i {
    private static i f = null;
    private Context a;
    private Handler g;
    private n b = new n();
    private n c = new n();
    private volatile n d = new n();
    private n e = new n();
    private s h = null;
    private Runnable i = new t(this);

    private i(Context context) {
        this.a = null;
        this.g = null;
        this.a = context.getApplicationContext();
        this.g = new Handler(context.getMainLooper());
        j();
        f();
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f == null) {
                f = new i(context);
            }
            iVar = f;
        }
        return iVar;
    }

    public static synchronized void a() {
        synchronized (i.class) {
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
        return e.a(context) != 0 || System.currentTimeMillis() - e.a(context, System.currentTimeMillis()) >= 172800000;
    }

    public static void c(Context context) {
        if (com.baidu.android.a.s.a(context).f() && b(context)) {
            a(context).i();
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.android.nebula.c.h.run():void] */
    public static /* synthetic */ void d(i iVar) {
        iVar.h();
    }

    private void f() {
        this.c = b.a(this.a).a();
        this.b = j.a(this.a);
        g();
    }

    private n g() {
        Iterator it = this.b.b().iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            u a = this.c.a(uVar.b());
            if (a == null) {
                uVar.a(f.INSERT);
                this.e.a(uVar.b(), uVar);
            } else if (uVar.compareTo(a) != 0 && uVar.compareTo(a) == 1) {
                uVar.a(f.UPDATE);
                this.e.a(uVar.b(), uVar);
            }
        }
        Iterator it2 = this.c.b().iterator();
        while (it2.hasNext()) {
            u uVar2 = (u) it2.next();
            if (this.b.a(uVar2.b()) == null) {
                uVar2.a(f.DELETE);
                this.e.a(uVar2.b(), uVar2);
            }
        }
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
        if ((r2 - com.baidu.android.nebula.c.e.a(r8.a, r2)) > (com.baidu.android.nebula.c.e.a(r8.a) * 1000)) goto L7;
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
            new k(this.a).a();
        }
    }

    public void i() {
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.i, TbConfig.USE_TIME_INTERVAL);
    }

    private void j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.h = new s(this, null);
        this.a.registerReceiver(this.h, intentFilter);
    }

    private void k() {
        if (this.h == null) {
            return;
        }
        this.a.unregisterReceiver(this.h);
    }

    public n a(int i) {
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
                u a = this.d.a(num.intValue());
                if (a.a() == f.DELETE) {
                    this.c.b(a.b());
                } else if (a.a() == f.UPDATE || a.a() == f.INSERT) {
                    this.c.a(a);
                }
            }
        }
        b.a(this.a).a(this.c.b());
        return true;
    }

    public n b(int i) {
        if (i >= this.b.c()) {
            return this.b;
        }
        n nVar = new n();
        Random random = new Random();
        while (nVar.c() < i) {
            nVar.a(this.b.a(random.nextInt(this.b.c())));
        }
        return nVar;
    }

    public void b() {
        b.a(this.a).b();
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
            uVar.a(f.INSERT);
            this.e.a(uVar.b(), uVar);
        }
    }

    public boolean e() {
        return this.e.c() > 0;
    }
}
