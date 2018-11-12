package com.baidu.sofire.b;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class f {
    private static Lock a = new ReentrantLock();
    private static f b = null;
    private com.baidu.sofire.rp.f.a c;

    private f(Context context) {
        this.c = new com.baidu.sofire.rp.f.a(context);
    }

    public static f a(Context context) {
        if (b != null) {
            return b;
        }
        try {
            a.lock();
            if (b == null) {
                b = new f(context);
            }
            return b;
        } finally {
            a.unlock();
        }
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void a() {
        this.c.a();
    }

    public void a(com.baidu.sofire.rp.c.a aVar) {
        Message message = new Message();
        message.what = 1;
        message.obj = aVar;
        this.c.a(message);
    }

    public void b() {
        Message message = new Message();
        message.what = 2;
        this.c.a(message);
    }

    public void a(com.baidu.sofire.rp.a.a aVar) {
        Message message = new Message();
        message.what = 3;
        message.obj = aVar;
        this.c.a(message);
    }

    public void c() {
        Message message = new Message();
        message.what = 8;
        this.c.a(message);
    }

    public void a(String str) {
        Message message = new Message();
        message.what = 11;
        message.obj = str;
        this.c.a(message);
    }

    public void d() {
        Message message = new Message();
        message.what = 6;
        this.c.a(message);
    }

    public void e() {
        Message message = new Message();
        message.what = 9;
        this.c.a(message);
    }
}
