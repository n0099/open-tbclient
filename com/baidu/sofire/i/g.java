package com.baidu.sofire.i;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    private static Lock f5258b = new ReentrantLock();
    private static g c = null;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.h.a f5259a;

    private g(Context context) {
        this.f5259a = new com.baidu.sofire.h.a(context);
    }

    public static g a(Context context) {
        if (c != null) {
            return c;
        }
        try {
            f5258b.lock();
            if (c == null) {
                c = new g(context);
            }
            return c;
        } finally {
            f5258b.unlock();
        }
    }

    public final void a() {
        com.baidu.sofire.h.a aVar = this.f5259a;
        if (!"tvshield".equals("sofire")) {
            if (aVar.c == null) {
                aVar.c = new Receiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            aVar.f5253b.getApplicationContext().registerReceiver(aVar.c, intentFilter, aVar.f5253b.getPackageName() + ".permission.sofire.RECEIVE", null);
        }
        Message message = new Message();
        message.what = 5;
        aVar.a(message);
    }

    public final void b() {
        com.baidu.sofire.h.a aVar = this.f5259a;
        Message message = new Message();
        message.what = 7;
        aVar.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.f5259a.a(message);
    }
}
