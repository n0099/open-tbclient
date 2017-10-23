package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class c {
    private static Lock Qj = new ReentrantLock();
    private static c Qk = null;
    private com.baidu.sofire.rp.e.a Ql;

    private c(Context context) {
        this.Ql = new com.baidu.sofire.rp.e.a(context);
    }

    public static c au(Context context) {
        if (Qk != null) {
            return Qk;
        }
        try {
            Qj.lock();
            if (Qk == null) {
                Qk = new c(context);
            }
            return Qk;
        } finally {
            Qj.unlock();
        }
    }

    public final void a() {
        this.Ql.a();
    }

    public final void b() {
        this.Ql.b();
    }

    public final void b(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.Ql.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.Ql.a(message);
    }

    public final void a(com.baidu.sofire.rp.a.b bVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = bVar;
        this.Ql.a(message);
    }

    public final void d() {
        Message message = new Message();
        message.what = 8;
        this.Ql.a(message);
    }

    public final void e() {
        Message message = new Message();
        message.what = 6;
        this.Ql.a(message);
    }

    public final void f() {
        Message message = new Message();
        message.what = 9;
        this.Ql.a(message);
    }
}
