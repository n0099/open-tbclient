package com.baidu.d.a;

import android.os.Handler;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i extends Thread {
    Handler a;
    private Object b;
    private boolean c;

    i() {
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str) {
        super(str);
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    public void a() {
        if (b.a) {
            b.a("Looper thread quit()");
        }
        this.a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (b.a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
