package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class b {
    private static Lock aFx = new ReentrantLock();
    private static b aFy = null;
    public com.baidu.sofire.rp.e.a aFw;

    private b(Context context) {
        this.aFw = new com.baidu.sofire.rp.e.a(context);
    }

    public static b aF(Context context) {
        if (aFy != null) {
            return aFy;
        }
        try {
            aFx.lock();
            if (aFy == null) {
                aFy = new b(context);
            }
            return aFy;
        } finally {
            aFx.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aFw;
        if (aVar.aFv == null) {
            aVar.aFv = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aFv, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aFs.sendMessage(message);
    }
}
