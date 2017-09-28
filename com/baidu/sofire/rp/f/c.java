package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class c {
    private static Lock Qv = new ReentrantLock();
    private static c Qw = null;
    private com.baidu.sofire.rp.e.a Qx;

    private c(Context context) {
        this.Qx = new com.baidu.sofire.rp.e.a(context);
    }

    public static c av(Context context) {
        if (Qw != null) {
            return Qw;
        }
        try {
            Qv.lock();
            if (Qw == null) {
                Qw = new c(context);
            }
            return Qw;
        } finally {
            Qv.unlock();
        }
    }

    public final void a() {
        this.Qx.a();
    }

    public final void b() {
        this.Qx.b();
    }

    public final void b(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.Qx.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.Qx.a(message);
    }

    public final void a(com.baidu.sofire.rp.a.b bVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = bVar;
        this.Qx.a(message);
    }

    public final void d() {
        Message message = new Message();
        message.what = 8;
        this.Qx.a(message);
    }

    public final void e() {
        Message message = new Message();
        message.what = 6;
        this.Qx.a(message);
    }

    public final void f() {
        Message message = new Message();
        message.what = 9;
        this.Qx.a(message);
    }
}
