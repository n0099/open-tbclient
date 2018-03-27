package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class e {
    private static Lock aGi = new ReentrantLock();
    private static e aGj = null;
    public com.baidu.sofire.rp.e.a aGk;

    private e(Context context) {
        this.aGk = new com.baidu.sofire.rp.e.a(context);
    }

    public static e aB(Context context) {
        if (aGj != null) {
            return aGj;
        }
        try {
            aGi.lock();
            if (aGj == null) {
                aGj = new e(context);
            }
            return aGj;
        } finally {
            aGi.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aGk;
        if (aVar.aGL == null) {
            aVar.aGL = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aGL, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aGI.sendMessage(message);
    }
}
