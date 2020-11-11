package com.baidu.sofire.i;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes15.dex */
public final class g {
    private static Lock b = new ReentrantLock();
    private static g c = null;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.h.a f3632a;

    private g(Context context) {
        this.f3632a = new com.baidu.sofire.h.a(context);
    }

    public static g a(Context context) {
        if (c != null) {
            return c;
        }
        try {
            b.lock();
            if (c == null) {
                c = new g(context);
            }
            return c;
        } finally {
            b.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.h.a aVar = this.f3632a;
        if (!"tvshield".equals("sofire")) {
            if (aVar.c == null) {
                aVar.c = new Receiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            aVar.b.getApplicationContext().registerReceiver(aVar.c, intentFilter, aVar.b.getPackageName() + ".permission.sofire.RECEIVE", null);
        }
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }

    public final void b() {
        com.baidu.sofire.h.a aVar = this.f3632a;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f3632a.a(message);
    }
}
