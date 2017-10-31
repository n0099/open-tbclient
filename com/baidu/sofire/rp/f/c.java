package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class c {
    private static Lock Qy = new ReentrantLock();
    private static c Qz = null;
    private com.baidu.sofire.rp.e.a QA;

    private c(Context context) {
        this.QA = new com.baidu.sofire.rp.e.a(context);
    }

    public static c au(Context context) {
        if (Qz != null) {
            return Qz;
        }
        try {
            Qy.lock();
            if (Qz == null) {
                Qz = new c(context);
            }
            return Qz;
        } finally {
            Qy.unlock();
        }
    }

    public final void a() {
        this.QA.a();
    }

    public final void b() {
        this.QA.b();
    }

    public final void b(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.QA.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.QA.a(message);
    }

    public final void a(com.baidu.sofire.rp.a.b bVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = bVar;
        this.QA.a(message);
    }

    public final void d() {
        Message message = new Message();
        message.what = 8;
        this.QA.a(message);
    }

    public final void e() {
        Message message = new Message();
        message.what = 6;
        this.QA.a(message);
    }

    public final void f() {
        Message message = new Message();
        message.what = 9;
        this.QA.a(message);
    }
}
