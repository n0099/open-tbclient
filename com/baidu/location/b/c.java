package com.baidu.location.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes3.dex */
public class c {
    private static c d = null;
    private boolean a = false;
    private String b = null;
    private a c = null;
    private int e = -1;

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    c.this.a = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        c.this.e = -1;
                    } else {
                        c.this.e = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            c.this.b = "4";
                            break;
                        case 3:
                        case 4:
                            c.this.b = "3";
                            break;
                        default:
                            c.this.b = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            c.this.b = "6";
                            c.this.a = true;
                            return;
                        case 2:
                            c.this.b = "5";
                            c.this.a = true;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                c.this.b = null;
            }
        }
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c();
            }
            cVar = d;
        }
        return cVar;
    }

    public void b() {
        this.c = new a();
        try {
            com.baidu.location.f.getServiceContext().registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
        }
    }

    public void c() {
        if (this.c != null) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.c);
            } catch (Exception e) {
            }
        }
        this.c = null;
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
