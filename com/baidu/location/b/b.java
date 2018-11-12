package com.baidu.location.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import com.baidu.location.a.j;
import com.baidu.location.g.g;
/* loaded from: classes6.dex */
public class b {
    private static b a = null;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager aen = null;
    private a aeo = null;
    private PendingIntent aep = null;
    private long g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (b.this.b && intent.getAction().equals("com.baidu.location.autonotifyloc_7.8.0") && b.this.c != null) {
                b.this.aep = null;
                b.this.c.sendEmptyMessage(1);
            }
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (System.currentTimeMillis() - this.g < 1000) {
            return;
        }
        if (this.aep != null) {
            this.aen.cancel(this.aep);
            this.aep = null;
        }
        if (this.aep == null) {
            this.aep = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.8.0"), 134217728);
            this.aen.set(0, System.currentTimeMillis() + g.W, this.aep);
        }
        Message message = new Message();
        message.what = 22;
        if (System.currentTimeMillis() - this.g >= g.X) {
            this.g = System.currentTimeMillis();
            if (com.baidu.location.e.d.tP().i()) {
                return;
            }
            j.tj().b(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.b) {
            try {
                if (this.aep != null) {
                    this.aen.cancel(this.aep);
                    this.aep = null;
                }
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.aeo);
            } catch (Exception e) {
            }
            this.aen = null;
            this.aeo = null;
            this.c = null;
            this.b = false;
        }
    }

    public static synchronized b tv() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public void b() {
        if (!this.b && g.W >= 10000) {
            if (this.c == null) {
                this.c = new Handler() { // from class: com.baidu.location.b.b.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        switch (message.what) {
                            case 1:
                                try {
                                    b.this.f();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            case 2:
                                try {
                                    b.this.g();
                                    return;
                                } catch (Exception e2) {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                };
            }
            this.aen = (AlarmManager) com.baidu.location.f.getServiceContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.aeo = new a();
            com.baidu.location.f.getServiceContext().registerReceiver(this.aeo, new IntentFilter("com.baidu.location.autonotifyloc_7.8.0"), "android.permission.ACCESS_FINE_LOCATION", null);
            this.aep = PendingIntent.getBroadcast(com.baidu.location.f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.8.0"), 134217728);
            this.aen.set(0, System.currentTimeMillis() + g.W, this.aep);
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
