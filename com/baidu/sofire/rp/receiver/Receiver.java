package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.i.d;
import com.baidu.sofire.i.f;
/* loaded from: classes2.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || !action.equals("com.b.r.p") || intent == null) {
                    return;
                }
                e eVar = new e(context);
                int y = eVar.y();
                new StringBuilder().append(y);
                b.a();
                d.a(context, y * 3600000);
                f.a(context).c();
                eVar.b(System.currentTimeMillis());
            } catch (Throwable th) {
                d.a();
            }
        }
    }
}
