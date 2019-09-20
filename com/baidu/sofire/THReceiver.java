package com.baidu.sofire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.b.v;
/* loaded from: classes2.dex */
public class THReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent != null) {
            try {
                new StringBuilder().append(intent.toString());
                b.a();
                v.a().a(new Runnable() { // from class: com.baidu.sofire.THReceiver.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            new StringBuilder().append(intent.toString());
                            b.a();
                            System.currentTimeMillis();
                            if ("r".equals(intent.getStringExtra("t"))) {
                                String stringExtra = intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra("t", "r");
                                intent2.putExtra("c", stringExtra);
                                a.a(context, intent2);
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a();
                        }
                    }
                });
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
        }
    }
}
