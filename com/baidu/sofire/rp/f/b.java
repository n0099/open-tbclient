package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class b {
    private static Lock QR = new ReentrantLock();
    private static b QS = null;
    public com.baidu.sofire.rp.e.a QP;

    private b(Context context) {
        this.QP = new com.baidu.sofire.rp.e.a(context);
    }

    public static b at(Context context) {
        if (QS != null) {
            return QS;
        }
        try {
            QR.lock();
            if (QS == null) {
                QS = new b(context);
            }
            return QS;
        } finally {
            QR.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.QP;
        if (aVar.QO == null) {
            aVar.QO = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.QO, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.QL.sendMessage(message);
    }
}
