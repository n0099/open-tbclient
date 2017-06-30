package com.baidu.android.pushservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.p;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.tbadk.TbConfig;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g {
    public static e a;
    private static LocalServerSocket h;
    private i i;
    private Context m;
    private Handler n;
    private static String b = "PushSDK";
    private static g c = null;
    private static int d = 180000;
    private static int e = 1800000;
    private static Object g = new Object();
    private static Object l = new Object();
    private Boolean j = false;
    private Boolean k = false;
    private Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    private Runnable p = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            g.this.d();
        }
    };
    private Runnable q = new Runnable() { // from class: com.baidu.android.pushservice.g.4
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.g) {
                if (g.a != null) {
                    g.a.b();
                }
            }
        }
    };
    private int f = d;

    private g(Context context) {
        this.n = new Handler(context.getMainLooper());
        this.m = context.getApplicationContext();
        q.g(this.m.getApplicationContext());
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (c == null) {
                c = new g(context);
            }
            gVar = c;
        }
        return gVar;
    }

    public static void b() {
        if (c != null) {
            c.h();
        }
        com.baidu.android.pushservice.i.d.a().b();
    }

    private boolean b(Context context) {
        String u = q.u(context);
        String packageName = context.getPackageName();
        if (packageName.equals(u)) {
            com.baidu.android.pushservice.g.b.a(b, "Try use current push service, package name is: " + packageName, this.m);
            return false;
        }
        com.baidu.android.pushservice.g.b.a(b, "Current push service : " + packageName + " should stop!!! highest priority service is: " + u, this.m);
        return true;
    }

    private void h() {
        com.baidu.android.pushservice.g.b.a(b, "destroy", this.m);
        synchronized (l) {
            try {
                if (h != null) {
                    h.close();
                    h = null;
                }
            } catch (IOException e2) {
                com.baidu.android.pushservice.g.a.a(b, e2);
            }
            if (a != null) {
                synchronized (g) {
                    a.c();
                    a = null;
                }
            }
            try {
                com.baidu.android.pushservice.d.a.a();
            } catch (Exception e3) {
                com.baidu.android.pushservice.g.a.e(b, "error " + e3.getMessage());
            }
            c = null;
        }
    }

    private void i() {
        synchronized (g) {
            a = e.a(this.m);
        }
    }

    private void j() {
        k();
        long currentTimeMillis = this.f + System.currentTimeMillis();
        int i = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / TbConfig.USE_TIME_INTERVAL) % 5)) == 0 && i < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.f - 20000))) + 15000;
        }
        try {
            ((AlarmManager) this.m.getSystemService("alarm")).setRepeating(0, currentTimeMillis, this.f, r());
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a(b, e2);
        }
    }

    private void k() {
        try {
            ((AlarmManager) this.m.getSystemService("alarm")).cancel(r());
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a(b, e2);
        }
    }

    private void l() {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                if (g.c == null) {
                    return;
                }
                synchronized (g.c) {
                    boolean e2 = l.e(g.this.m);
                    com.baidu.android.pushservice.g.b.a(g.b, "tryConnect networkConnected :" + e2, g.this.m);
                    if (!e2) {
                        if (a.b() > 0) {
                            p.a(g.this.m, "039912");
                        }
                        return;
                    }
                    if (a.b() > 0) {
                        p.a(g.this.m, "039914");
                    }
                    if (g.a != null && !g.a.a()) {
                        if (j.a(g.this.m).c()) {
                            g.this.p();
                        } else {
                            com.baidu.android.pushservice.g.b.d(g.b, "Channel token is not available, start NETWORK REGISTER SERVICE .", g.this.m);
                            g.this.o();
                        }
                    }
                }
            }
        });
    }

    private boolean m() {
        if (h == null) {
            try {
                com.baidu.android.pushservice.d.c.b(this.m, (String) null);
                h = new LocalServerSocket(q.o(this.m));
                q();
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.a(b, e2);
                com.baidu.android.pushservice.g.b.a(b, "--- Socket Adress (" + q.o(this.m) + ") in use --- @ " + this.m.getPackageName(), this.m);
                com.baidu.android.pushservice.j.p.b(this.m);
                return false;
            }
        }
        com.baidu.android.pushservice.d.c.b(this.m, this.m.getPackageName());
        return true;
    }

    private boolean n() {
        com.baidu.android.pushservice.message.a.d.a(this.m);
        boolean a2 = l.a(this.m);
        com.baidu.android.pushservice.g.b.a(b, "heartbeat networkConnected :" + a2, this.m);
        q.t(this.m);
        String u = q.u(this.m);
        if (q.c(this.m) || !(TextUtils.isEmpty(u) || this.m.getPackageName().equals(u))) {
            k();
            return false;
        } else if (!a2) {
            if (a != null) {
                a.a(true);
            }
            if (a.b() > 0) {
                p.a(this.m, "039912");
                return true;
            }
            return true;
        } else {
            if (a.b() > 0) {
                p.a(this.m, "039914");
            }
            if (a != null) {
                if (a.a()) {
                    a.d();
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.SEND_APPSTAT");
                    intent.setClass(this.m, PushService.class);
                    this.i.a(intent);
                } else if (j.a(this.m).c()) {
                    p();
                } else {
                    com.baidu.android.pushservice.g.b.c(b, "Channel token is not available, start NETWORK REGISTER SERVICE .", this.m);
                    o();
                }
                q.b("heartbeat PushConnection isConnected " + a.a() + " at Time " + System.currentTimeMillis(), this.m.getApplicationContext());
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.n.removeCallbacks(this.p);
        this.n.postDelayed(this.p, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (h != null || m()) {
            this.n.removeCallbacks(this.q);
            this.n.postDelayed(this.q, 1000L);
        }
    }

    private void q() {
        if (!q.E(this.m)) {
            com.baidu.android.pushservice.j.b.a(this.m, "com.baidu.push.cur_prio", a.a());
            com.baidu.android.pushservice.j.b.a(this.m, "com.baidu.push.cur_pkg", this.m.getPackageName());
            return;
        }
        String a2 = com.baidu.android.pushservice.j.b.a(this.m, "com.baidu.push.cur_pkg");
        if (TextUtils.isEmpty(a2) || !a2.equals(this.m.getPackageName())) {
            return;
        }
        com.baidu.android.pushservice.j.b.a(this.m, "com.baidu.push.cur_pkg", (String) null);
    }

    private PendingIntent r() {
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setFlags(32);
        intent.setClass(this.m, PushService.class);
        return PendingIntent.getService(this.m.getApplicationContext(), 0, intent, 134217728);
    }

    public void a(int i) {
        com.baidu.android.pushservice.g.b.a(b, "heartbeat set : " + i + " secs", this.m);
        if (i > 0) {
            this.f = i * 1000;
        }
        j();
    }

    public boolean a() {
        com.baidu.android.pushservice.g.b.a(b, "Create PushSDK from : " + this.m.getPackageName(), this.m);
        k();
        this.k = true;
        if (q.c(this.m.getApplicationContext()) || b(this.m)) {
            com.baidu.android.pushservice.g.b.a(b, "onCreate shouldStopSelf", this.m);
            return false;
        }
        synchronized (l) {
            if (PushSocket.a) {
                if (!m()) {
                    q.t(this.m);
                    if (!this.m.getPackageName().equals(q.u(this.m))) {
                        return false;
                    }
                }
                h.b(this.m);
                Thread.setDefaultUncaughtExceptionHandler(new b(this.m.getApplicationContext()));
                i();
                this.i = i.a(this.m);
                PushSettings.l(this.m);
                if (h != null) {
                    this.n.postDelayed(this.o, 500L);
                    l();
                }
                this.j = true;
                return true;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        com.baidu.android.pushservice.g.b.a(b, "PushSDK handleOnStart go", this.m);
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.b.c(b, "--- handleOnStart by null intent!", this.m);
        }
        if ((this.k.booleanValue() || a()) && (!this.k.booleanValue() || this.j.booleanValue())) {
            synchronized (l) {
                this.n.removeCallbacks(this.o);
                com.baidu.android.pushservice.g.a.b(b, "-- handleOnStart -- " + intent);
                if (h == null) {
                    if (PushConstants.ACTION_METHOD.equals(intent.getAction())) {
                        return this.i.a(intent);
                    }
                    return true;
                } else if (intent.getStringExtra("AlarmAlert") != null) {
                    return n();
                } else {
                    if (intent != null) {
                        if (("pushservice_restart_v2".equals(intent.getStringExtra(PushConstants.EXTRA_METHOD)) || "pushservice_restart_v3".equals(intent.getStringExtra(PushConstants.EXTRA_METHOD))) && h != null) {
                            long longExtra = q.E(this.m) ? intent.getLongExtra("priority3", 0L) : intent.getLongExtra("priority2", 0L);
                            com.baidu.android.pushservice.c.d.a(this.m).e();
                            boolean z = longExtra > q.h(this.m) && com.baidu.android.pushservice.c.d.a(this.m).b() != com.baidu.android.pushservice.c.d.g;
                            boolean z2 = com.baidu.android.pushservice.c.d.a(this.m).b() == com.baidu.android.pushservice.c.d.h;
                            if (z || z2) {
                                return false;
                            }
                        } else if (this.i.a(intent)) {
                            com.baidu.android.pushservice.g.b.c(b, "-- handleOnStart -- intent handled  by mRegistrationService ", this.m);
                            return true;
                        }
                    }
                    l();
                    return true;
                }
            }
        }
        return false;
    }

    public i c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        com.baidu.android.pushservice.g.b.a(b, ">> sendRequestTokenIntent", this.m);
        com.baidu.android.pushservice.j.p.b(this.m, new Intent("com.baidu.pushservice.action.TOKEN"));
    }
}
