package com.baidu.sofire.rp.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.f;
/* loaded from: classes.dex */
public class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        f.a(context).a(true);
                    } else if (action.equals("com.b.r.p")) {
                        b.a("sj-receive ACTION_REPORT_POLL");
                        a(context, intent);
                    }
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public void a(Context context, Intent intent) {
        if (intent != null) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            int R = eVar.R();
            b.a("sj-trigger report handleDailyWork " + R);
            e.a(context, R * 3600000);
            f.a(context).b();
            eVar.e(System.currentTimeMillis());
        }
    }
}
