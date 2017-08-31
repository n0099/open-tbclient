package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.rp.a.a;
import com.baidu.sofire.rp.f.b;
import com.baidu.sofire.rp.f.c;
/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        c.au(context).a();
                    } else if (action.equals("com.b.r.p")) {
                        if (intent != null) {
                            a aVar = new a(context);
                            int i = aVar.a.getInt("re_net_hr", 3);
                            if (com.baidu.sofire.rp.e.a.a == 1) {
                                r0 = " 1" + Integer.toString(i);
                                com.baidu.sofire.rp.e.a.b = false;
                            } else if (com.baidu.sofire.rp.e.a.a == 2) {
                                com.baidu.sofire.rp.e.a.b = true;
                                i = aVar.a.getInt("re_net_hr_bc", 8);
                                str = " 2" + Integer.toString(i);
                            }
                            com.baidu.sofire.rp.f.a.a(context, i * 3600000);
                            c.au(context).c();
                        }
                    } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                        com.baidu.sofire.rp.e.a.a = 2;
                    } else if (action.equals("android.intent.action.SCREEN_ON")) {
                        com.baidu.sofire.rp.e.a.a = 1;
                        if (com.baidu.sofire.rp.e.a.b) {
                            a aVar2 = new a(context);
                            com.baidu.sofire.rp.e.a.b = false;
                            com.baidu.sofire.rp.f.a.a(context, aVar2.a.getInt("re_net_hr", 3) * 3600000);
                        }
                    }
                }
            } catch (Throwable th) {
                b.a();
            }
        }
    }
}
