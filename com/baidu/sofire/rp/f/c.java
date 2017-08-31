package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class c {
    private static Lock Qg = new ReentrantLock();
    private static c Qh = null;
    private com.baidu.sofire.rp.e.a Qi;

    private c(Context context) {
        this.Qi = new com.baidu.sofire.rp.e.a(context);
    }

    public static c au(Context context) {
        if (Qh != null) {
            return Qh;
        }
        try {
            Qg.lock();
            if (Qh == null) {
                Qh = new c(context);
            }
            return Qh;
        } finally {
            Qg.unlock();
        }
    }

    public final void a() {
        this.Qi.a();
    }

    public final void b() {
        this.Qi.b();
    }

    public final void b(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.Qi.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.Qi.a(message);
    }

    public final void a(com.baidu.sofire.rp.a.b bVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = bVar;
        this.Qi.a(message);
    }

    public final void d() {
        Message message = new Message();
        message.what = 8;
        this.Qi.a(message);
    }

    public final void e() {
        Message message = new Message();
        message.what = 6;
        this.Qi.a(message);
    }

    public final void f() {
        Message message = new Message();
        message.what = 9;
        this.Qi.a(message);
    }
}
