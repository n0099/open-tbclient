package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.g.t;
/* loaded from: classes2.dex */
public class THReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            new StringBuilder().append(intent.toString());
            b.a();
            t.a(context).a(new Runnable() { // from class: com.baidu.sofire.THReceiver.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        new StringBuilder().append(intent.toString());
                        b.a();
                        System.currentTimeMillis();
                        if (r.f7672a.equals(intent.getStringExtra("t"))) {
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent2 = new Intent();
                            intent2.putExtra("t", r.f7672a);
                            intent2.putExtra("c", stringExtra);
                            a.a(context, intent2);
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.g.d.a();
                    }
                }
            });
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }
}
