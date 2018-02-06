package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes2.dex */
public class g {
    public static e a;
    private static LocalServerSocket h;
    private Context k;
    private Handler l;
    private boolean m;
    private PushServiceReceiver n;
    private RegistrationReceiver o;
    private boolean p;
    private static String b = "PushSDK";
    private static g c = null;
    private static int d = 180000;
    private static int e = 1800000;
    private static final Object g = new Object();
    private static Object j = new Object();
    private Boolean i = false;
    private Runnable q = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    private Runnable r = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            g.this.d();
        }
    };
    private Runnable s = new Runnable() { // from class: com.baidu.android.pushservice.g.4
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
        this.l = new Handler(context.getMainLooper());
        this.k = context.getApplicationContext();
        p.g(this.k.getApplicationContext());
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
            c.j();
        }
        com.baidu.android.pushservice.i.d.a().b();
    }

    private boolean b(Context context) {
        String v = p.v(context);
        String packageName = context.getPackageName();
        if (packageName.equals(v)) {
            com.baidu.android.pushservice.g.a.a(b, "Try use current push service, package name is: " + packageName, this.k);
            return false;
        }
        com.baidu.android.pushservice.g.a.a(b, "Current push service : " + packageName + " should stop!!! highest priority service is: " + v, this.k);
        return true;
    }

    private void h() {
        if (this.n == null) {
            this.n = new PushServiceReceiver();
            this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (this.o == null) {
            this.o = new RegistrationReceiver();
            this.k.getApplicationContext().registerReceiver(this.o, new IntentFilter("android.intent.action.PACKAGE_REMOVED"));
        }
    }

    private void i() {
        if (this.o != null) {
            this.k.getApplicationContext().unregisterReceiver(this.o);
        }
        if (this.n != null) {
            this.k.getApplicationContext().unregisterReceiver(this.n);
        }
    }

    private void j() {
        com.baidu.android.pushservice.g.a.a(b, "destroy", this.k);
        synchronized (j) {
            try {
                if (h != null) {
                    h.close();
                    h = null;
                }
            } catch (IOException e2) {
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
            }
            if (this.m) {
                i();
            }
            c = null;
        }
    }

    private void k() {
        synchronized (g) {
            a = e.a(this.k);
        }
    }

    private void l() {
        m();
        long currentTimeMillis = this.f + System.currentTimeMillis();
        int i = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.f - 20000))) + 15000;
        }
        try {
            ((AlarmManager) this.k.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, currentTimeMillis, this.f, t());
        } catch (Exception e2) {
        }
    }

    private void m() {
        try {
            ((AlarmManager) this.k.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(t());
        } catch (Exception e2) {
        }
    }

    private void n() {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                if (g.c == null) {
                    return;
                }
                synchronized (g.c) {
                    boolean e2 = k.e(g.this.k);
                    com.baidu.android.pushservice.g.a.a(g.b, "tryConnect networkConnected :" + e2, g.this.k);
                    if (!e2) {
                        if (a.b() > 0) {
                            q.a(g.this.k, "039912");
                        }
                        return;
                    }
                    if (a.b() > 0) {
                        q.a(g.this.k, "039914");
                    }
                    if (g.a != null && !g.a.a()) {
                        if (j.a(g.this.k).c()) {
                            g.this.r();
                        } else {
                            com.baidu.android.pushservice.g.a.d(g.b, "Channel token is not available, start NETWORK REGISTER SERVICE .", g.this.k);
                            g.this.q();
                        }
                    }
                }
            }
        });
    }

    private boolean o() {
        if (h == null) {
            try {
                com.baidu.android.pushservice.d.c.b(this.k, (String) null);
                h = new LocalServerSocket(p.p(this.k));
                s();
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.a(b, "--- Socket Adress (" + p.p(this.k) + ") in use --- @ " + this.k.getPackageName(), this.k);
                o.b(this.k);
                return false;
            }
        }
        com.baidu.android.pushservice.d.c.b(this.k, this.k.getPackageName());
        return true;
    }

    private boolean p() {
        com.baidu.android.pushservice.message.a.d.a(this.k);
        boolean a2 = k.a(this.k);
        com.baidu.android.pushservice.g.a.a(b, "heartbeat networkConnected :" + a2, this.k);
        String v = p.v(this.k);
        if (p.c(this.k) || !(TextUtils.isEmpty(v) || this.k.getPackageName().equals(v))) {
            m();
            return false;
        } else if (!a2) {
            if (a != null) {
                a.a(true);
            }
            if (a.b() > 0) {
                q.a(this.k, "039912");
                return true;
            }
            return true;
        } else {
            if (a.b() > 0) {
                q.a(this.k, "039914");
            }
            if (a != null) {
                if (a.a()) {
                    a.d();
                    if (!this.p) {
                        this.p = true;
                        Intent intent = new Intent(PushConstants.ACTION_METHOD);
                        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
                        c().a(intent);
                    }
                } else if (j.a(this.k).c()) {
                    r();
                } else {
                    com.baidu.android.pushservice.g.a.c(b, "Channel token is not available, start NETWORK REGISTER SERVICE .", this.k);
                    q();
                }
                p.b("heartbeat PushConnection isConnected " + a.a() + " at Time " + System.currentTimeMillis(), this.k.getApplicationContext());
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.l.removeCallbacks(this.r);
        this.l.postDelayed(this.r, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (h != null || o()) {
            this.l.removeCallbacks(this.s);
            this.l.postDelayed(this.s, 1000L);
        }
    }

    private void s() {
        if (!p.F(this.k)) {
            com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_prio", a.a());
            com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg", this.k.getPackageName());
            return;
        }
        String a2 = com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg");
        if (TextUtils.isEmpty(a2) || !a2.equals(this.k.getPackageName())) {
            return;
        }
        com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg", (String) null);
    }

    private PendingIntent t() {
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setFlags(32);
        intent.setClass(this.k, PushService.class);
        return PendingIntent.getService(this.k.getApplicationContext(), 0, intent, 134217728);
    }

    public void a(int i) {
        com.baidu.android.pushservice.g.a.a(b, "heartbeat set : " + i + " secs", this.k);
        if (i > 0) {
            this.f = i * 1000;
        }
        l();
    }

    public boolean a() {
        com.baidu.android.pushservice.g.a.a(b, "Create PushSDK from : " + this.k.getPackageName(), this.k);
        m();
        this.i = true;
        if (p.c(this.k.getApplicationContext()) || b(this.k)) {
            com.baidu.android.pushservice.g.a.a(b, "onCreate shouldStopSelf", this.k);
            return false;
        }
        synchronized (j) {
            if (PushSocket.a) {
                if (!o()) {
                    p.u(this.k);
                    if (!this.k.getPackageName().equals(p.v(this.k))) {
                        return false;
                    }
                }
                this.m = p.G(this.k);
                if (this.m) {
                    h();
                }
                h.b(this.k);
                Thread.setDefaultUncaughtExceptionHandler(new b(this.k.getApplicationContext()));
                k();
                i.a(this.k);
                PushSettings.l(this.k);
                if (h != null) {
                    this.l.postDelayed(this.q, 500L);
                    n();
                }
                return true;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        com.baidu.android.pushservice.g.a.a(b, "PushSDK handleOnStart go", this.k);
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.a.c(b, "--- handleOnStart by null intent!", this.k);
        }
        if (!this.i.booleanValue()) {
            a();
        }
        synchronized (j) {
            this.l.removeCallbacks(this.q);
            if (h == null) {
                if (PushConstants.ACTION_METHOD.equals(intent.getAction())) {
                    return c().a(intent);
                }
                return true;
            } else if (intent.getStringExtra("AlarmAlert") != null) {
                return p();
            } else {
                if (("pushservice_restart_v2".equals(intent.getStringExtra("method")) || "pushservice_restart_v3".equals(intent.getStringExtra("method"))) && h != null) {
                    long longExtra = p.F(this.k) ? intent.getLongExtra("priority3", 0L) : intent.getLongExtra("priority2", 0L);
                    com.baidu.android.pushservice.c.d.a(this.k).e();
                    boolean z = longExtra > p.h(this.k) && com.baidu.android.pushservice.c.d.a(this.k).b() != 3;
                    boolean z2 = com.baidu.android.pushservice.c.d.a(this.k).b() == 4;
                    if (z || z2) {
                        return false;
                    }
                } else if (c().a(intent)) {
                    com.baidu.android.pushservice.g.a.c(b, "-- handleOnStart -- intent handled  by mRegistrationService ", this.k);
                    return true;
                }
                n();
                return true;
            }
        }
    }

    public i c() {
        return i.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        com.baidu.android.pushservice.g.a.a(b, ">> sendRequestTokenIntent", this.k);
        o.b(this.k, new Intent("com.baidu.pushservice.action.TOKEN"));
    }
}
