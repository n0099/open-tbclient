package com.baidu.sofire;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.sofire.i.u;
/* loaded from: classes2.dex */
public class THService extends Service {
    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        u.a().a(new Runnable() { // from class: com.baidu.sofire.THService.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    new StringBuilder().append(intent.getAction());
                    b.a();
                    if ("s".equals(intent.getStringExtra("t"))) {
                        String stringExtra = intent.getStringExtra("c");
                        Intent intent2 = new Intent();
                        intent2.putExtra("t", "s");
                        intent2.putExtra("c", stringExtra);
                        a.a(THService.this.getApplicationContext(), intent2);
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.i.d.a();
                }
            }
        });
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
