package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class e {
    private static Lock b = new ReentrantLock();
    private static e c = null;
    public com.baidu.sofire.rp.e.a a;

    private e(Context context) {
        this.a = new com.baidu.sofire.rp.e.a(context);
    }

    public static e a(Context context) {
        if (c != null) {
            return c;
        }
        try {
            b.lock();
            if (c == null) {
                c = new e(context);
            }
            return c;
        } finally {
            b.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.e.a aVar = this.a;
        if (aVar.e == null) {
            aVar.e = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.c.getApplicationContext().registerReceiver(aVar.e, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.a.sendMessage(message);
    }
}
