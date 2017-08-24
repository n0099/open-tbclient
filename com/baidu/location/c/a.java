package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager Os = null;
    private C0026a Ot = null;
    private PendingIntent Ou = null;
    private long g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0026a extends BroadcastReceiver {
        private C0026a() {
        }

        /* synthetic */ C0026a(a aVar, i iVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.b && intent.getAction().equals("com.baidu.location.autonotifyloc_6.2.3") && a.this.c != null) {
                a.this.Ou = null;
                a.this.c.sendEmptyMessage(1);
            }
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (System.currentTimeMillis() - this.g < 1000) {
            return;
        }
        if (this.Ou != null) {
            this.Os.cancel(this.Ou);
            this.Ou = null;
        }
        if (this.Ou == null) {
            this.Ou = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Os.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Ou);
        }
        Message message = new Message();
        message.what = 22;
        if (System.currentTimeMillis() - this.g >= com.baidu.location.h.i.U) {
            this.g = System.currentTimeMillis();
            if (com.baidu.location.f.f.nl().i()) {
                return;
            }
            com.baidu.location.a.e.mv().b(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b) {
            try {
                if (this.Ou != null) {
                    this.Os.cancel(this.Ou);
                    this.Ou = null;
                }
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Ot);
            } catch (Exception e) {
            }
            this.Os = null;
            this.Ot = null;
            this.c = null;
            this.b = false;
        }
    }

    public static synchronized a mI() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void b() {
        if (!this.b && com.baidu.location.h.i.T >= 10000) {
            if (this.c == null) {
                this.c = new i(this);
            }
            this.Os = (AlarmManager) com.baidu.location.f.getServiceContext().getSystemService("alarm");
            this.Ot = new C0026a(this, null);
            com.baidu.location.f.getServiceContext().registerReceiver(this.Ot, new IntentFilter("com.baidu.location.autonotifyloc_6.2.3"));
            this.Ou = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Os.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Ou);
            this.b = true;
            this.g = System.currentTimeMillis();
        }
    }

    public void c() {
        if (this.b && this.c != null) {
            this.c.sendEmptyMessage(2);
        }
    }

    public void d() {
        if (this.b && this.c != null) {
            this.c.sendEmptyMessage(1);
        }
    }

    public void e() {
        if (this.b && this.c != null) {
            this.c.sendEmptyMessage(1);
        }
    }
}
