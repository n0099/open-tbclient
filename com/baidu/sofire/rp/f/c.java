package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class c {
    private static Lock QR = new ReentrantLock();
    private static c QS = null;
    private com.baidu.sofire.rp.e.a QT;

    private c(Context context) {
        this.QT = new com.baidu.sofire.rp.e.a(context);
    }

    public static c au(Context context) {
        if (QS != null) {
            return QS;
        }
        try {
            QR.lock();
            if (QS == null) {
                QS = new c(context);
            }
            return QS;
        } finally {
            QR.unlock();
        }
    }

    public final void a() {
        this.QT.a();
    }

    public final void b() {
        this.QT.b();
    }

    public final void b(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.QT.a(message);
    }

    public final void c() {
        Message message = new Message();
        message.what = 2;
        this.QT.a(message);
    }

    public final void a(com.baidu.sofire.rp.a.b bVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = bVar;
        this.QT.a(message);
    }

    public final void d() {
        Message message = new Message();
        message.what = 8;
        this.QT.a(message);
    }

    public final void e() {
        Message message = new Message();
        message.what = 6;
        this.QT.a(message);
    }

    public final void f() {
        Message message = new Message();
        message.what = 9;
        this.QT.a(message);
    }
}
