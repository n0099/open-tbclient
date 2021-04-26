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
    public static final String f8092a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static int f8093b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static g f8094c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Thread f8095d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f8096e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f8097g = 5000;

    /* renamed from: h  reason: collision with root package name */
    public static long f8098h = 5000;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f8099i = false;
    public static int j = 1000;

    /* renamed from: f  reason: collision with root package name */
    public c f8100f;
    public boolean k;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f8101a = new d();
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f8102a;

        public b(String str) {
            this.f8102a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!d.f8096e) {
                if (d.f8094c != null) {
                    d.f8094c.a(d.f8093b, d.f8099i);
                    boolean unused = d.f8099i = false;
                }
                try {
                    Thread.sleep(d.f8097g);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
                int d2 = d.f8094c != null ? d.f8094c.d() : 0;
                if (d2 >= 3) {
                    long j = (d2 / 3) + 1;
                    long unused3 = d.f8097g = d.f8098h * j < 60000 ? d.f8098h * j : 60000L;
                } else {
                    long unused4 = d.f8097g = d.f8098h;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Handler {
        private void a(int i2) {
            if (d.j == i2) {
                boolean unused = d.f8099i = false;
                return;
            }
            boolean unused2 = d.f8099i = true;
            int unused3 = d.j = i2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = d.f8092a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The order state is: " + message.what);
            a(message.what);
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                    d.q();
                    return;
                } else if (i2 != 5) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.f8092a, "The order state is undefined");
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
        return a.f8101a;
    }

    private void o() {
        f8096e = true;
        Thread thread = f8095d;
        if (thread != null) {
            thread.interrupt();
            f8095d = null;
        }
    }

    public static synchronized void p() {
        synchronized (d.class) {
            f8096e = true;
        }
    }

    public static synchronized void q() {
        synchronized (d.class) {
            if (f8095d == null) {
                return;
            }
            f8096e = false;
            if (Thread.State.NEW == f8095d.getState()) {
                f8095d.start();
            }
            if (Thread.State.TERMINATED == f8095d.getState()) {
                f8095d = null;
                Thread thread = new Thread(new b(Thread.currentThread().getName()));
                f8095d = thread;
                thread.start();
            }
        }
    }

    public synchronized void a(int i2) {
        String str = f8092a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
        f8093b = i2;
        if (this.f8100f == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f8092a, "SyncDataRequestHandler is null");
            return;
        }
        Message obtainMessage = this.f8100f.obtainMessage();
        obtainMessage.what = i2;
        this.f8100f.sendMessage(obtainMessage);
    }

    public void a(View view) {
        g gVar = f8094c;
        if (gVar != null) {
            gVar.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        g gVar = f8094c;
        if (gVar != null) {
            gVar.a(displayOptions);
        }
    }

    public void a(RoleOptions roleOptions) {
        g gVar = f8094c;
        if (gVar != null) {
            gVar.a(roleOptions);
        }
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        g a2 = g.a();
        f8094c = a2;
        if (a2 != null) {
            a2.b();
            f8094c.a(roleOptions);
            f8094c.a(displayOptions);
        }
        f8095d = new Thread(new b(Thread.currentThread().getName()));
        this.f8100f = new c();
    }

    public void a(k kVar) {
        g gVar = f8094c;
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
        f8098h = j2;
        f8097g = j2;
    }

    public void b(View view) {
        g gVar = f8094c;
        if (gVar != null) {
            gVar.b(view);
        }
    }

    public void c() {
        p();
    }

    public void c(View view) {
        g gVar = f8094c;
        if (gVar != null) {
            gVar.c(view);
        }
    }

    public void d() {
        o();
        this.f8100f.removeCallbacksAndMessages(null);
        f8093b = 0;
        f8098h = 5000L;
        f8099i = false;
        j = 1000;
        this.k = true;
        g gVar = f8094c;
        if (gVar != null) {
            gVar.h();
        }
    }
}
