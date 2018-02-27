package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class e {
    private static Lock aGh = new ReentrantLock();
    private static e aGi = null;
    public com.baidu.sofire.rp.e.a aGj;

    private e(Context context) {
        this.aGj = new com.baidu.sofire.rp.e.a(context);
    }

    public static e aB(Context context) {
        if (aGi != null) {
            return aGi;
        }
        try {
            aGh.lock();
            if (aGi == null) {
                aGi = new e(context);
            }
            return aGi;
        } finally {
            aGh.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aGj;
        if (aVar.aGK == null) {
            aVar.aGK = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aGK, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aGH.sendMessage(message);
    }
}
