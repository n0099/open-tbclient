package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class e {
    private static Lock aGs = new ReentrantLock();
    private static e aGt = null;
    public com.baidu.sofire.rp.e.a aGu;

    private e(Context context) {
        this.aGu = new com.baidu.sofire.rp.e.a(context);
    }

    public static e aB(Context context) {
        if (aGt != null) {
            return aGt;
        }
        try {
            aGs.lock();
            if (aGt == null) {
                aGt = new e(context);
            }
            return aGt;
        } finally {
            aGs.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.aGu;
        if (aVar.aGV == null) {
            aVar.aGV = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.aGV, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.aGS.sendMessage(message);
    }
}
