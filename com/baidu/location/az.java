package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az {
    private static az a = null;

    /* renamed from: do  reason: not valid java name */
    private a f88do;

    /* renamed from: for  reason: not valid java name */
    private boolean f89for = false;

    /* renamed from: if  reason: not valid java name */
    private String f90if = null;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    az.this.f89for = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    switch (intExtra) {
                        case 2:
                            az.this.f90if = "4";
                            break;
                        case 3:
                        case 4:
                            az.this.f90if = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                            break;
                        default:
                            az.this.f90if = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            az.this.f90if = "6";
                            az.this.f89for = true;
                            break;
                        case 2:
                            az.this.f90if = "5";
                            az.this.f89for = true;
                            break;
                    }
                    if (az.this.f89for) {
                        al.bP().bO();
                    } else {
                        al.bP().bQ();
                    }
                }
            } catch (Exception e) {
                az.this.f90if = null;
            }
        }
    }

    private az() {
        this.f88do = null;
        this.f88do = new a();
    }

    /* renamed from: do  reason: not valid java name */
    public static az m252do() {
        if (a == null) {
            a = new az();
        }
        return a;
    }

    public String a() {
        return this.f90if;
    }

    /* renamed from: for  reason: not valid java name */
    public void m253for() {
        f.getServiceContext().registerReceiver(this.f88do, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* renamed from: if  reason: not valid java name */
    public void m254if() {
        if (this.f88do != null) {
            try {
                f.getServiceContext().unregisterReceiver(this.f88do);
            } catch (Exception e) {
            }
        }
        this.f88do = null;
    }

    /* renamed from: int  reason: not valid java name */
    public boolean m255int() {
        return this.f89for;
    }
}
