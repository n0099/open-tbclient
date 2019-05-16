package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes3.dex */
public class f {
    public static d a;
    private static LocalServerSocket e;
    private Context h;
    private Handler i;
    private boolean j;
    private PushServiceReceiver k;
    private RegistrationReceiver l;
    private boolean m;
    private static f b = null;
    private static final Object d = new Object();
    private static Object g = new Object();
    private Boolean f = false;
    private Runnable n = new Runnable() { // from class: com.baidu.android.pushservice.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.a(new Intent());
        }
    };
    private Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.d();
        }
    };
    private Runnable p = new Runnable() { // from class: com.baidu.android.pushservice.f.4
        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.d) {
                if (f.a != null) {
                    f.a.b();
                }
            }
        }
    };
    private int c = 180000;

    private f(Context context) {
        this.i = new Handler(context.getMainLooper());
        this.h = context.getApplicationContext();
        l.g(this.h.getApplicationContext());
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(context);
            }
            fVar = b;
        }
        return fVar;
    }

    public static void b() {
        if (b != null) {
            b.i();
        }
        com.baidu.android.pushservice.h.d.a().b();
    }

    private boolean b(Context context) {
        String v = l.v(context);
        String packageName = context.getPackageName();
        if (!packageName.equals(v)) {
            if (a.d(this.h)) {
                return false;
            }
            com.baidu.android.pushservice.f.a.a("PushSDK", "Current push service : " + packageName + " should stop!!! highest priority service is: " + v, this.h);
            return true;
        }
        com.baidu.android.pushservice.f.a.a("PushSDK", "Try use current push service, package name is: " + packageName, this.h);
        if (a.d(this.h)) {
            a.c(context, false);
            return false;
        }
        return false;
    }

    private void g() {
        if (this.k == null) {
            this.k = new PushServiceReceiver();
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (this.l == null) {
            this.l = new RegistrationReceiver();
            this.h.getApplicationContext().registerReceiver(this.l, new IntentFilter("android.intent.action.PACKAGE_REMOVED"));
        }
    }

    private void h() {
        if (this.l != null) {
            this.h.getApplicationContext().unregisterReceiver(this.l);
        }
        if (this.k != null) {
            this.h.getApplicationContext().unregisterReceiver(this.k);
        }
    }

    private void i() {
        com.baidu.android.pushservice.f.a.a("PushSDK", "destroy", this.h);
        synchronized (g) {
            try {
                if (e != null) {
                    e.close();
                    e = null;
                }
            } catch (IOException e2) {
            }
            if (a != null) {
                synchronized (d) {
                    a.c();
                    a = null;
                }
            }
            try {
                com.baidu.android.pushservice.c.a.a();
            } catch (Exception e3) {
            }
            if (this.j) {
                h();
            }
            b = null;
        }
    }

    private void j() {
        synchronized (d) {
            a = d.a(this.h);
        }
    }

    private void k() {
        long currentTimeMillis;
        l();
        long currentTimeMillis2 = System.currentTimeMillis() + this.c;
        int i = ((int) (currentTimeMillis2 / 1000)) % 60;
        if (((int) ((currentTimeMillis2 / 60000) % 5)) == 0 && i < 15) {
            currentTimeMillis2 += ((long) (Math.random() * (this.c - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) {
            currentTimeMillis = System.currentTimeMillis() + 60000;
            this.c = 60000;
        } else {
            currentTimeMillis = currentTimeMillis2;
        }
        AlarmManager alarmManager = (AlarmManager) this.h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, currentTimeMillis, this.c, s());
            } catch (Exception e2) {
            }
        }
    }

    private void l() {
        try {
            ((AlarmManager) this.h.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s());
        } catch (Exception e2) {
        }
    }

    private void m() {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.f.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (f.b == null) {
                    return;
                }
                synchronized (f.b) {
                    boolean e2 = com.baidu.android.pushservice.i.g.e(f.this.h);
                    com.baidu.android.pushservice.f.a.a("PushSDK", "tryConnect networkConnected :" + e2, f.this.h);
                    if (e2) {
                        if (f.a != null && !f.a.a()) {
                            if (i.a(f.this.h).e()) {
                                f.this.q();
                            } else {
                                com.baidu.android.pushservice.f.a.d("PushSDK", "Channel token is not available, start NETWORK REGISTER SERVICE .", f.this.h);
                                f.this.p();
                            }
                        }
                    }
                }
            }
        });
    }

    private boolean n() {
        if (e == null) {
            try {
                e = new LocalServerSocket(l.q(this.h));
                r();
            } catch (Exception e2) {
                com.baidu.android.pushservice.f.a.a("PushSDK", "--- Socket Adress (" + l.q(this.h) + ") in use --- @ " + this.h.getPackageName(), this.h);
                k.b(this.h);
                return false;
            }
        }
        return true;
    }

    private boolean o() {
        com.baidu.android.pushservice.message.a.c.a(this.h);
        boolean a2 = com.baidu.android.pushservice.i.g.a(this.h);
        com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.h);
        String v = l.v(this.h);
        if (l.c(this.h) || !(TextUtils.isEmpty(v) || this.h.getPackageName().equals(v) || a.d(this.h))) {
            l();
            return false;
        } else if (!a2) {
            if (a != null) {
                a.a(true);
                return true;
            }
            return true;
        } else if (a != null) {
            if (a.a()) {
                a.d();
                if (!this.m) {
                    this.m = true;
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
                    c().a(intent);
                }
            } else if (i.a(this.h).e()) {
                q();
            } else {
                com.baidu.android.pushservice.f.a.c("PushSDK", "Channel token is not available, start NETWORK REGISTER SERVICE .", this.h);
                p();
            }
            l.b("heartbeat PushConnection isConnected " + a.a() + " at Time " + System.currentTimeMillis(), this.h.getApplicationContext());
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.i.removeCallbacks(this.o);
        this.i.postDelayed(this.o, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (e != null || n()) {
            this.i.removeCallbacks(this.p);
            this.i.postDelayed(this.p, 1000L);
        }
    }

    private void r() {
        if (l.D(this.h)) {
            com.baidu.android.pushservice.i.a.a(this.h, "com.baidu.push.cur_pkg", (String) null);
        } else {
            com.baidu.android.pushservice.i.a.a(this.h, "com.baidu.push.cur_pkg", this.h.getPackageName());
        }
    }

    private PendingIntent s() {
        Intent intent = new Intent();
        intent.putExtra("AlarmAlert", "OK");
        intent.setFlags(32);
        intent.setClass(this.h, PushService.class);
        return PendingIntent.getService(this.h.getApplicationContext(), 0, intent, 134217728);
    }

    public void a(int i) {
        com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat set : " + i + " secs", this.h);
        if (i > 0) {
            this.c = i * 1000;
        }
        k();
    }

    public boolean a() {
        com.baidu.android.pushservice.f.a.a("PushSDK", "Create PushSDK from : " + this.h.getPackageName(), this.h);
        l();
        this.f = true;
        if (l.c(this.h.getApplicationContext()) || b(this.h)) {
            com.baidu.android.pushservice.f.a.a("PushSDK", "onCreate shouldStopSelf", this.h);
            return false;
        }
        synchronized (g) {
            if (PushSocket.a) {
                if (!n()) {
                    if (!this.h.getPackageName().equals(l.v(this.h))) {
                        return false;
                    }
                }
                this.j = l.E(this.h);
                if (this.j) {
                    g();
                }
                g.b(this.h);
                Thread.setDefaultUncaughtExceptionHandler(new b(this.h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                j();
                h.a(this.h);
                if (e != null) {
                    this.i.postDelayed(this.n, 500L);
                    m();
                }
                return true;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        com.baidu.android.pushservice.f.a.a("PushSDK", "PushSDK handleOnStart go", this.h);
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.f.a.c("PushSDK", "--- handleOnStart by null intent!", this.h);
        }
        if (!com.baidu.android.pushservice.b.d.k(this.h) || com.baidu.android.pushservice.b.d.c(this.h)) {
            if (!this.f.booleanValue()) {
                a();
            }
            synchronized (g) {
                this.i.removeCallbacks(this.n);
                if (e == null) {
                    String action = intent.getAction();
                    if (PushConstants.ACTION_METHOD.equals(action) || "com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        return c().a(intent);
                    }
                    return true;
                } else if (intent.getStringExtra("AlarmAlert") != null) {
                    return o();
                } else {
                    if (("pushservice_restart_v2".equals(intent.getStringExtra("method")) || "pushservice_restart_v3".equals(intent.getStringExtra("method"))) && e != null) {
                        long longExtra = l.D(this.h) ? intent.getLongExtra("priority3", 0L) : intent.getLongExtra("priority2", 0L);
                        com.baidu.android.pushservice.b.d.a(this.h).e();
                        boolean z = longExtra > l.h(this.h) && com.baidu.android.pushservice.b.d.a(this.h).b() != 3;
                        boolean z2 = com.baidu.android.pushservice.b.d.a(this.h).b() == 4;
                        if (z && a.d(this.h) && !l.c(this.h)) {
                            return true;
                        }
                        if (z || z2) {
                            return false;
                        }
                    } else if (c().a(intent)) {
                        com.baidu.android.pushservice.f.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.h);
                        return true;
                    }
                    m();
                    return true;
                }
            }
        }
        return false;
    }

    public h c() {
        return h.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        com.baidu.android.pushservice.f.a.a("PushSDK", ">> sendRequestTokenIntent", this.h);
        k.b(this.h, new Intent("com.baidu.pushservice.action.TOKEN"));
    }
}
