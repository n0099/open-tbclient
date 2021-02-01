package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.kwad.sdk.collector.AppStatusRules;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class d {
    private static g c;
    private static Thread d;
    private c f;
    private boolean k;

    /* renamed from: a  reason: collision with root package name */
    private static final String f3114a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static int f3115b = 0;
    private static volatile boolean e = true;
    private static volatile long g = 5000;
    private static long h = 5000;
    private static volatile boolean i = false;
    private static int j = 1000;

    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f3116a = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f3117a;

        b(String str) {
            this.f3117a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!d.e) {
                if (d.c != null) {
                    d.c.a(d.f3115b, d.i);
                    boolean unused = d.i = false;
                }
                try {
                    Thread.sleep(d.g);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int d = d.c != null ? d.c.d() : 0;
                if (d >= 3) {
                    int i = (d / 3) + 1;
                    long unused2 = d.g = d.h * ((long) i) >= AppStatusRules.DEFAULT_GRANULARITY ? 60000L : i * d.h;
                } else {
                    long unused3 = d.g = d.h;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class c extends Handler {
        c() {
        }

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
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(d.f3114a, "The order state is: " + message.what);
            a(message.what);
            switch (message.what) {
                case 0:
                case 5:
                    d.p();
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                    d.q();
                    return;
                default:
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.f3114a, "The order state is undefined");
                    return;
            }
        }
    }

    private d() {
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return a.f3116a;
    }

    private void o() {
        e = true;
        if (d != null) {
            d.interrupt();
            d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void p() {
        synchronized (d.class) {
            e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void q() {
        synchronized (d.class) {
            if (d != null) {
                e = false;
                if (Thread.State.NEW == d.getState()) {
                    d.start();
                }
                if (Thread.State.TERMINATED == d.getState()) {
                    d = null;
                    d = new Thread(new b(Thread.currentThread().getName()));
                    d.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(int i2) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(f3114a, "The order state = " + i2);
        f3115b = i2;
        if (this.f == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f3114a, "SyncDataRequestHandler is null");
        } else {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = i2;
            this.f.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (c != null) {
            c.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DisplayOptions displayOptions) {
        if (c != null) {
            c.a(displayOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RoleOptions roleOptions) {
        if (c != null) {
            c.a(roleOptions);
        }
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        c = g.a();
        if (c != null) {
            c.b();
            c.a(roleOptions);
            c.a(displayOptions);
        }
        d = new Thread(new b(Thread.currentThread().getName()));
        this.f = new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        if (c != null) {
            c.a(kVar);
        }
    }

    public void b() {
        if (this.k) {
            this.k = false;
        } else {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        h = i2 * 1000;
        g = i2 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        if (c != null) {
            c.b(view);
        }
    }

    public void c() {
        p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view) {
        if (c != null) {
            c.c(view);
        }
    }

    public void d() {
        o();
        this.f.removeCallbacksAndMessages(null);
        f3115b = 0;
        h = 5000L;
        i = false;
        j = 1000;
        this.k = true;
        if (c != null) {
            c.h();
        }
    }
}
