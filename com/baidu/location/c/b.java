package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public class b {
    private static b Os = null;
    private boolean a = false;
    private String b = null;
    private a Or = null;
    private int e = -1;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    b.this.a = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        b.this.e = -1;
                    } else {
                        b.this.e = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            b.this.b = "4";
                            break;
                        case 3:
                        case 4:
                            b.this.b = "3";
                            break;
                        default:
                            b.this.b = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            b.this.b = "6";
                            b.this.a = true;
                            return;
                        case 2:
                            b.this.b = "5";
                            b.this.a = true;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                b.this.b = null;
            }
        }
    }

    private b() {
    }

    public static synchronized b ni() {
        b bVar;
        synchronized (b.class) {
            if (Os == null) {
                Os = new b();
            }
            bVar = Os;
        }
        return bVar;
    }

    public void b() {
        this.Or = new a();
        com.baidu.location.f.getServiceContext().registerReceiver(this.Or, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void c() {
        if (this.Or != null) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Or);
            } catch (Exception e) {
            }
        }
        this.Or = null;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public int f() {
        return this.e;
    }
}
