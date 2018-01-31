package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class b {
    private static Lock aFA = new ReentrantLock();
    private static b aFB = null;
    public com.baidu.sofire.rp.e.a aFz;

    private b(Context context) {
        this.aFz = new com.baidu.sofire.rp.e.a(context);
    }

    public static b aF(Context context) {
        if (aFB != null) {
            return aFB;
        }
        try {
            aFA.lock();
            if (aFB == null) {
                aFB = new b(context);
            }
            return aFB;
        } finally {
            aFA.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aFz;
        if (aVar.aFy == null) {
            aVar.aFy = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aFy, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aFv.sendMessage(message);
    }
}
