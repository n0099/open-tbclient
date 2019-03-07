package com.baidu.sofire.rp.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.f;
import com.baidu.sofire.e;
/* loaded from: classes.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        f.a(context).a();
                    } else if (action.equals("com.b.r.p")) {
                        b.a();
                        if (intent != null) {
                            e eVar = new e(context);
                            int w = eVar.w();
                            b.a();
                            com.baidu.sofire.b.e.a(context, w * 3600000);
                            f.a(context).c();
                            eVar.c(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
        }
    }
}
