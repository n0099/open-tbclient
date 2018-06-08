package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager Wv = null;
    private C0066a Ww = null;
    private PendingIntent Wx = null;
    private long g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0066a extends BroadcastReceiver {
        private C0066a() {
        }

        /* synthetic */ C0066a(a aVar, i iVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.b && intent.getAction().equals("com.baidu.location.autonotifyloc_6.2.3") && a.this.c != null) {
                a.this.Wx = null;
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
        if (this.Wx != null) {
            this.Wv.cancel(this.Wx);
            this.Wx = null;
        }
        if (this.Wx == null) {
            this.Wx = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Wv.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Wx);
        }
        Message message = new Message();
        message.what = 22;
        if (System.currentTimeMillis() - this.g >= com.baidu.location.h.i.U) {
            this.g = System.currentTimeMillis();
            if (com.baidu.location.f.f.qY().i()) {
                return;
            }
            com.baidu.location.a.e.qi().b(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b) {
            try {
                if (this.Wx != null) {
                    this.Wv.cancel(this.Wx);
                    this.Wx = null;
                }
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Ww);
            } catch (Exception e) {
            }
            this.Wv = null;
            this.Ww = null;
            this.c = null;
            this.b = false;
        }
    }

    public static synchronized a qu() {
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
            this.Wv = (AlarmManager) com.baidu.location.f.getServiceContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.Ww = new C0066a(this, null);
            com.baidu.location.f.getServiceContext().registerReceiver(this.Ww, new IntentFilter("com.baidu.location.autonotifyloc_6.2.3"));
            this.Wx = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Wv.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Wx);
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
