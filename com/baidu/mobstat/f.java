package com.baidu.mobstat;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static f f579a = new f();
    private Context b;
    private boolean c = false;
    private boolean d = false;

    private f() {
    }

    public static f a() {
        return f579a;
    }

    private void d() {
        this.c = true;
    }

    private synchronized void e() {
        this.d = true;
    }

    public void a(Context context) {
        if (context == null || b()) {
            return;
        }
        this.b = context;
        d();
        start();
    }

    public boolean b() {
        return this.c;
    }

    public synchronized boolean c() {
        return this.d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        g.a().b(this.b);
        b.a().d(this.b);
        b.a().c(this.b);
        e();
        synchronized (f579a) {
            try {
                notifyAll();
            } catch (IllegalMonitorStateException e) {
                com.baidu.mobstat.a.b.a("stat", e);
            }
        }
        b.a().a(this.b);
        b.a().b();
        g.a().c(this.b);
    }
}
