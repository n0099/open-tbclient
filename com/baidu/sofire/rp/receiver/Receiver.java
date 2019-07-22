package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.f;
import com.baidu.sofire.e;
/* loaded from: classes2.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        f.a(context).a();
                    } else if (action.equals("com.b.r.p") && intent != null) {
                        e eVar = new e(context);
                        int v = eVar.v();
                        new StringBuilder().append(v);
                        b.a();
                        com.baidu.sofire.b.e.a(context, v * 3600000);
                        f.a(context).c();
                        eVar.c(System.currentTimeMillis());
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
        }
    }
}
