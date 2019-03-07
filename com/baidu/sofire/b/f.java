package com.baidu.sofire.b;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class f {
    private static Lock b = new ReentrantLock();
    private static f c = null;
    public com.baidu.sofire.rp.f.a a;

    private f(Context context) {
        this.a = new com.baidu.sofire.rp.f.a(context);
    }

    public static f a(Context context) {
        if (c != null) {
            return c;
        }
        try {
            b.lock();
            if (c == null) {
                c = new f(context);
            }
            return c;
        } finally {
            b.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.rp.f.a aVar = this.a;
        if (aVar.d == null) {
            aVar.d = new com.baidu.sofire.rp.e.a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        aVar.b.getApplicationContext().registerReceiver(aVar.d, intentFilter);
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }

    public final void b() {
        com.baidu.sofire.rp.f.a aVar = this.a;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.a.a(message);
    }
}
