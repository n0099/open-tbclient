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
/* loaded from: classes2.dex */
public class a {
    private static a a = null;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager Wx = null;
    private C0067a Wy = null;
    private PendingIntent Wz = null;
    private long g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0067a extends BroadcastReceiver {
        private C0067a() {
        }

        /* synthetic */ C0067a(a aVar, i iVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (a.this.b && intent.getAction().equals("com.baidu.location.autonotifyloc_6.2.3") && a.this.c != null) {
                a.this.Wz = null;
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
        if (this.Wz != null) {
            this.Wx.cancel(this.Wz);
            this.Wz = null;
        }
        if (this.Wz == null) {
            this.Wz = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Wx.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Wz);
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
                if (this.Wz != null) {
                    this.Wx.cancel(this.Wz);
                    this.Wz = null;
                }
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Wy);
            } catch (Exception e) {
            }
            this.Wx = null;
            this.Wy = null;
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
            this.Wx = (AlarmManager) com.baidu.location.f.getServiceContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.Wy = new C0067a(this, null);
            com.baidu.location.f.getServiceContext().registerReceiver(this.Wy, new IntentFilter("com.baidu.location.autonotifyloc_6.2.3"));
            this.Wz = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_6.2.3"), 134217728);
            this.Wx.set(0, System.currentTimeMillis() + com.baidu.location.h.i.T, this.Wz);
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
