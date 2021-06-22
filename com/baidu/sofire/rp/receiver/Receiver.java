package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.h.a;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
/* loaded from: classes2.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !action.equals("com.b.r.p") || intent == null) {
                return;
            }
            a a2 = a.a(context);
            c.a(context, a2.u() * 3600000);
            d.a(context).c();
            a2.b(System.currentTimeMillis());
        } catch (Throwable unused) {
            c.a();
        }
    }
}
