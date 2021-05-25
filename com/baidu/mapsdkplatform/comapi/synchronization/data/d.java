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
    public static final String f7789a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static int f7790b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static g f7791c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Thread f7792d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f7793e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f7794g = 5000;

    /* renamed from: h  reason: collision with root package name */
    public static long f7795h = 5000;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f7796i = false;
    public static int j = 1000;

    /* renamed from: f  reason: collision with root package name */
    public c f7797f;
    public boolean k;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f7798a = new d();
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f7799a;

        public b(String str) {
            this.f7799a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!d.f7793e) {
                if (d.f7791c != null) {
                    d.f7791c.a(d.f7790b, d.f7796i);
                    boolean unused = d.f7796i = false;
                }
                try {
                    Thread.sleep(d.f7794g);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
                int d2 = d.f7791c != null ? d.f7791c.d() : 0;
                if (d2 >= 3) {
                    long j = (d2 / 3) + 1;
                    long unused3 = d.f7794g = d.f7795h * j < 60000 ? d.f7795h * j : 60000L;
                } else {
                    long unused4 = d.f7794g = d.f7795h;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Handler {
        private void a(int i2) {
            if (d.j == i2) {
                boolean unused = d.f7796i = false;
                return;
            }
            boolean unused2 = d.f7796i = true;
            int unused3 = d.j = i2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = d.f7789a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The order state is: " + message.what);
            a(message.what);
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                    d.q();
                    return;
                } else if (i2 != 5) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.f7789a, "The order state is undefined");
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
        return a.f7798a;
    }

    private void o() {
        f7793e = true;
        Thread thread = f7792d;
        if (thread != null) {
            thread.interrupt();
            f7792d = null;
        }
    }

    public static synchronized void p() {
        synchronized (d.class) {
            f7793e = true;
        }
    }

    public static synchronized void q() {
        synchronized (d.class) {
            if (f7792d == null) {
                return;
            }
            f7793e = false;
            if (Thread.State.NEW == f7792d.getState()) {
                f7792d.start();
            }
            if (Thread.State.TERMINATED == f7792d.getState()) {
                f7792d = null;
                Thread thread = new Thread(new b(Thread.currentThread().getName()));
                f7792d = thread;
                thread.start();
            }
        }
    }

    public synchronized void a(int i2) {
        String str = f7789a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
        f7790b = i2;
        if (this.f7797f == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7789a, "SyncDataRequestHandler is null");
            return;
        }
        Message obtainMessage = this.f7797f.obtainMessage();
        obtainMessage.what = i2;
        this.f7797f.sendMessage(obtainMessage);
    }

    public void a(View view) {
        g gVar = f7791c;
        if (gVar != null) {
            gVar.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        g gVar = f7791c;
        if (gVar != null) {
            gVar.a(displayOptions);
        }
    }

    public void a(RoleOptions roleOptions) {
        g gVar = f7791c;
        if (gVar != null) {
            gVar.a(roleOptions);
        }
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        g a2 = g.a();
        f7791c = a2;
        if (a2 != null) {
            a2.b();
            f7791c.a(roleOptions);
            f7791c.a(displayOptions);
        }
        f7792d = new Thread(new b(Thread.currentThread().getName()));
        this.f7797f = new c();
    }

    public void a(k kVar) {
        g gVar = f7791c;
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
        f7795h = j2;
        f7794g = j2;
    }

    public void b(View view) {
        g gVar = f7791c;
        if (gVar != null) {
            gVar.b(view);
        }
    }

    public void c() {
        p();
    }

    public void c(View view) {
        g gVar = f7791c;
        if (gVar != null) {
            gVar.c(view);
        }
    }

    public void d() {
        o();
        this.f7797f.removeCallbacksAndMessages(null);
        f7790b = 0;
        f7795h = 5000L;
        f7796i = false;
        j = 1000;
        this.k = true;
        g gVar = f7791c;
        if (gVar != null) {
            gVar.h();
        }
    }
}
