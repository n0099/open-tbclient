package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.zeus.WebChromeClient;
/* loaded from: classes.dex */
public class ag extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f459a;

    public ag(af afVar) {
        this.f459a = afVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.locTest.LocationServer")) {
            this.f459a.f458a.b.obtainMessage(WebChromeClient.STRING_DLG_TITLE_DATETIME).sendToTarget();
            return;
        }
        try {
            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                int intExtra = intent.getIntExtra("status", 0);
                int intExtra2 = intent.getIntExtra("plugged", 0);
                switch (intExtra) {
                    case 2:
                        this.f459a.q = "4";
                        break;
                    case 3:
                    case 4:
                        this.f459a.q = "3";
                        break;
                    default:
                        this.f459a.q = null;
                        break;
                }
                switch (intExtra2) {
                    case 1:
                        this.f459a.q = "6";
                        return;
                    case 2:
                        this.f459a.q = "5";
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            this.f459a.q = null;
        }
    }
}
