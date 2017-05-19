package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b {
    private static b Nj = null;
    private boolean a = false;
    private String b = null;
    private a Ni = null;
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
                            b.this.b = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
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

    public static synchronized b mL() {
        b bVar;
        synchronized (b.class) {
            if (Nj == null) {
                Nj = new b();
            }
            bVar = Nj;
        }
        return bVar;
    }

    public void b() {
        this.Ni = new a();
        com.baidu.location.f.getServiceContext().registerReceiver(this.Ni, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public void c() {
        if (this.Ni != null) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.Ni);
            } catch (Exception e) {
            }
        }
        this.Ni = null;
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
