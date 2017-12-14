package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class b {
    private static Lock QP = new ReentrantLock();
    private static b QR = null;
    public com.baidu.sofire.rp.e.a QO;

    private b(Context context) {
        this.QO = new com.baidu.sofire.rp.e.a(context);
    }

    public static b at(Context context) {
        if (QR != null) {
            return QR;
        }
        try {
            QP.lock();
            if (QR == null) {
                QR = new b(context);
            }
            return QR;
        } finally {
            QP.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.QO;
        if (aVar.QN == null) {
            aVar.QN = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.QN, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.QK.sendMessage(message);
    }
}
