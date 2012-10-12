package com.baidu.android.pushservice;

import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class d {
    private static volatile d q;
    com.baidu.android.pushservice.message.a b;
    private Socket i;
    private InputStream j;
    private OutputStream k;
    private i m;
    private h n;
    private PushService p;
    private final String c = w.b;
    private final int d = w.c;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private LinkedList l = new LinkedList();
    private int o = 0;
    Handler a = new Handler();
    private Runnable r = new f(this);
    private Runnable s = new g(this);
    private long t = 0;

    private d(PushService pushService) {
        this.p = pushService;
    }

    public static d a(PushService pushService) {
        if (q == null) {
            q = new d(pushService);
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.e || this.f) {
            return;
        }
        if (!y.a().d()) {
            this.p.a();
            return;
        }
        this.f = true;
        this.g = false;
        Thread thread = new Thread(new e(this));
        thread.setName("PushService-PushService-connect");
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.g = true;
        g();
        if (this.h) {
            return;
        }
        this.o++;
        if (this.o < 5) {
            this.a.postDelayed(this.r, (1 << (this.o - 1)) * 5 * 1000);
            return;
        }
        y.a().a((String) null, (String) null);
        com.baidu.android.pushservice.util.d.c(this.p);
    }

    private void g() {
        this.a.removeCallbacks(this.s);
        this.g = true;
        this.e = false;
        synchronized (this.l) {
            this.l.notifyAll();
        }
        try {
            if (this.i != null) {
                this.i.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (this.j != null) {
                this.j.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            if (this.k != null) {
                this.k.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        if (this.b != null) {
            this.b.c();
        }
    }

    public void a(com.baidu.android.pushservice.message.b bVar) {
        this.l.add(bVar);
        synchronized (this.l) {
            this.l.notify();
        }
    }

    public boolean a() {
        return this.e;
    }

    public void b() {
        this.o = 0;
        this.h = false;
        e();
    }

    public void c() {
        this.g = true;
        this.h = true;
        this.a.removeCallbacks(this.r);
        g();
    }

    public void d() {
        if (this.b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.t > 60000) {
                this.b.d();
                this.t = currentTimeMillis;
            }
        }
    }
}
