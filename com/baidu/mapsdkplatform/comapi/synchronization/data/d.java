package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7810a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static int f7811b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static g f7812c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Thread f7813d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f7814e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f7815g = 5000;

    /* renamed from: h  reason: collision with root package name */
    public static long f7816h = 5000;
    public static volatile boolean i = false;
    public static int j = 1000;

    /* renamed from: f  reason: collision with root package name */
    public c f7817f;
    public boolean k;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f7818a = new d();
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f7819a;

        public b(String str) {
            this.f7819a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!d.f7814e) {
                if (d.f7812c != null) {
                    d.f7812c.a(d.f7811b, d.i);
                    boolean unused = d.i = false;
                }
                try {
                    Thread.sleep(d.f7815g);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
                int d2 = d.f7812c != null ? d.f7812c.d() : 0;
                if (d2 >= 3) {
                    long j = (d2 / 3) + 1;
                    long unused3 = d.f7815g = d.f7816h * j < 60000 ? d.f7816h * j : 60000L;
                } else {
                    long unused4 = d.f7815g = d.f7816h;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Handler {
        private void a(int i) {
            if (d.j == i) {
                boolean unused = d.i = false;
                return;
            }
            boolean unused2 = d.i = true;
            int unused3 = d.j = i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = d.f7810a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The order state is: " + message.what);
            a(message.what);
            int i = message.what;
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3 || i == 4) {
                    d.q();
                    return;
                } else if (i != 5) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.f7810a, "The order state is undefined");
                    return;
                }
            }
            d.p();
        }
    }

    public d() {
        this.k = true;
    }

    public static d a() {
        return a.f7818a;
    }

    private void o() {
        f7814e = true;
        Thread thread = f7813d;
        if (thread != null) {
            thread.interrupt();
            f7813d = null;
        }
    }

    public static synchronized void p() {
        synchronized (d.class) {
            f7814e = true;
        }
    }

    public static synchronized void q() {
        synchronized (d.class) {
            if (f7813d == null) {
                return;
            }
            f7814e = false;
            if (Thread.State.NEW == f7813d.getState()) {
                f7813d.start();
            }
            if (Thread.State.TERMINATED == f7813d.getState()) {
                f7813d = null;
                Thread thread = new Thread(new b(Thread.currentThread().getName()));
                f7813d = thread;
                thread.start();
            }
        }
    }

    public synchronized void a(int i2) {
        String str = f7810a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
        f7811b = i2;
        if (this.f7817f == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7810a, "SyncDataRequestHandler is null");
            return;
        }
        Message obtainMessage = this.f7817f.obtainMessage();
        obtainMessage.what = i2;
        this.f7817f.sendMessage(obtainMessage);
    }

    public void a(View view) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.a(displayOptions);
        }
    }

    public void a(RoleOptions roleOptions) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.a(roleOptions);
        }
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        g a2 = g.a();
        f7812c = a2;
        if (a2 != null) {
            a2.b();
            f7812c.a(roleOptions);
            f7812c.a(displayOptions);
        }
        f7813d = new Thread(new b(Thread.currentThread().getName()));
        this.f7817f = new c();
    }

    public void a(k kVar) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.a(kVar);
        }
    }

    public void b() {
        if (this.k) {
            this.k = false;
        } else {
            q();
        }
    }

    public void b(int i2) {
        long j2 = i2 * 1000;
        f7816h = j2;
        f7815g = j2;
    }

    public void b(View view) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.b(view);
        }
    }

    public void c() {
        p();
    }

    public void c(View view) {
        g gVar = f7812c;
        if (gVar != null) {
            gVar.c(view);
        }
    }

    public void d() {
        o();
        this.f7817f.removeCallbacksAndMessages(null);
        f7811b = 0;
        f7816h = 5000L;
        i = false;
        j = 1000;
        this.k = true;
        g gVar = f7812c;
        if (gVar != null) {
            gVar.h();
        }
    }
}
