package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.g.d;
/* loaded from: classes3.dex */
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
            e eVar = new e(context);
            int w = eVar.w();
            new StringBuilder().append(w);
            b.a();
            d.a(context, w * 3600000);
            com.baidu.sofire.g.e.a(context).c();
            eVar.b(System.currentTimeMillis());
        } catch (Throwable unused) {
            d.a();
        }
    }
}
