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
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f3106a;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f3108e;
    public static boolean m;

    /* renamed from: c  reason: collision with root package name */
    public e f3111c;

    /* renamed from: h  reason: collision with root package name */
    public Context f3113h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3114i;
    public boolean j;
    public PushServiceReceiver k;
    public boolean l;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3107d = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3109g = new Object();

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3112f = Boolean.FALSE;
    public Runnable n = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    public Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.f3107d) {
                if (g.this.f3111c != null) {
                    g.this.f3111c.b();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public int f3110b = TiebaStatic.MAX_COST_VALUE;

    public g(Context context) {
        this.f3114i = new Handler(context.getMainLooper());
        this.f3113h = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (f3106a == null) {
            synchronized (g.class) {
                if (f3106a == null) {
                    f3106a = new g(context);
                }
            }
        }
        return f3106a;
    }

    public static void b() {
        if (f3106a != null) {
            f3106a.l();
        }
        com.baidu.android.pushservice.h.d.a().b();
    }

    private void j() {
        if (this.k == null) {
            this.k = new PushServiceReceiver();
            this.f3113h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f3113h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f3113h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f3113h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        if (this.k != null) {
            this.f3113h.getApplicationContext().unregisterReceiver(this.k);
        }
    }

    private void l() {
        com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f3113h);
        synchronized (f3109g) {
            try {
                if (f3108e != null) {
                    f3108e.close();
                    f3108e = null;
                }
            } catch (IOException unused) {
            }
            if (this.f3111c != null) {
                synchronized (f3107d) {
                    if (this.f3111c != null) {
                        this.f3111c.c();
                        this.f3111c = null;
                    }
                }
            }
            try {
                com.baidu.android.pushservice.c.a.a();
            } catch (Exception unused2) {
            }
            if (this.j) {
                k();
            }
            f3106a = null;
        }
    }

    private void m() {
        synchronized (f3107d) {
            this.f3111c = e.a(this.f3113h);
        }
    }

    private void n() {
        long currentTimeMillis = System.currentTimeMillis() + this.f3110b;
        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.f3110b - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            currentTimeMillis = System.currentTimeMillis() + 60000;
            this.f3110b = 60000;
        }
        long j = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.f3113h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.f3110b, s());
                m = false;
            } catch (Exception unused) {
            }
        }
    }

    private void o() {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (g.f3106a == null) {
                    return;
                }
                boolean a2 = com.baidu.android.pushservice.j.g.a(g.this.f3113h);
                com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, g.this.f3113h);
                if (a2) {
                    if (g.this.f3111c != null && !g.this.f3111c.a()) {
                        if (k.a(g.this.f3113h).e()) {
                            g.this.r();
                        }
                    } else if (g.this.f3111c == null || !g.this.f3111c.a()) {
                    } else {
                        com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", g.this.f3113h);
                        g.this.q();
                    }
                }
            }
        });
    }

    private boolean p() {
        if (f3108e == null) {
            try {
                f3108e = new LocalServerSocket(m.h(this.f3113h));
                return true;
            } catch (Exception unused) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f3113h) + ") in use --- @ " + this.f3113h.getPackageName(), this.f3113h);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3113h);
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f3113h);
        if (m.b(this.f3113h)) {
            d();
            return false;
        } else if (!a2) {
            e eVar = this.f3111c;
            if (eVar != null) {
                eVar.a(true);
            }
            return true;
        } else {
            e eVar2 = this.f3111c;
            if (eVar2 != null) {
                if (eVar2.a()) {
                    this.f3111c.d();
                    if (!this.l) {
                        this.l = true;
                        m.k(f());
                    }
                } else if (k.a(this.f3113h).e()) {
                    r();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (f3108e != null || p()) {
            this.f3114i.removeCallbacks(this.o);
            this.f3114i.post(this.o);
        }
    }

    private PendingIntent s() {
        return PendingIntent.getBroadcast(this.f3113h.getApplicationContext(), 0, f.a(this.f3113h), 134217728);
    }

    public void a(int i2) {
        if (m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f3113h);
        if (i2 > 0) {
            this.f3110b = i2;
        }
        n();
    }

    public boolean a() {
        d();
        this.f3112f = Boolean.TRUE;
        com.baidu.android.pushservice.j.i.c(this.f3113h, "key_push_has_start", "push_service_has_start");
        if (m.b(this.f3113h.getApplicationContext())) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f3113h);
            return false;
        }
        synchronized (f3109g) {
            if (PushSocket.f3472a) {
                if (p()) {
                    boolean p = m.p(this.f3113h);
                    this.j = p;
                    if (p) {
                        j();
                    }
                    h.b(this.f3113h);
                    Thread.setDefaultUncaughtExceptionHandler(new b(this.f3113h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                    m();
                    i.a(this.f3113h);
                    if (f3108e != null) {
                        this.f3114i.postDelayed(this.n, 500L);
                        o();
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f3113h);
        }
        if (!com.baidu.android.pushservice.b.d.q(this.f3113h) || com.baidu.android.pushservice.b.d.c(this.f3113h)) {
            if (!this.f3112f.booleanValue()) {
                a();
            }
            m = intent.getBooleanExtra("disable_alarm", false);
            synchronized (f3109g) {
                this.f3114i.removeCallbacks(this.n);
                if (f3108e == null) {
                    String action = intent.getAction();
                    if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        return true;
                    }
                    return c().a(intent);
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    return q();
                } else if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f3108e == null) {
                    if ("com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) && f3108e != null) {
                        return b(intent);
                    } else if (c().a(intent)) {
                        com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f3113h);
                        return true;
                    } else {
                        o();
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean b(Intent intent) {
        e eVar = this.f3111c;
        if (eVar == null || !eVar.a()) {
            return true;
        }
        int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
        String stringExtra = intent.getStringExtra("message_id");
        String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
        this.f3111c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
        return true;
    }

    public i c() {
        return i.a(this.f3113h);
    }

    public void d() {
        AlarmManager alarmManager = (AlarmManager) this.f3113h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.cancel(s());
                m = true;
            } catch (Exception unused) {
            }
        }
    }

    public boolean e() {
        return m;
    }

    public Context f() {
        return this.f3113h;
    }

    public boolean g() {
        return this.f3112f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f3113h, "key_push_has_start"));
    }
}
