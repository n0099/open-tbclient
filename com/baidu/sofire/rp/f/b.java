package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class b {
    private static Lock aFy = new ReentrantLock();
    private static b aFz = null;
    public com.baidu.sofire.rp.e.a aFx;

    private b(Context context) {
        this.aFx = new com.baidu.sofire.rp.e.a(context);
    }

    public static b aF(Context context) {
        if (aFz != null) {
            return aFz;
        }
        try {
            aFy.lock();
            if (aFz == null) {
                aFz = new b(context);
            }
            return aFz;
        } finally {
            aFy.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aFx;
        if (aVar.aFw == null) {
            aVar.aFw = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aFw, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aFt.sendMessage(message);
    }
}
