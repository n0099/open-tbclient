package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    Handler f2551a;

    /* renamed from: b  reason: collision with root package name */
    private Object f2552b;
    private boolean c;

    m() {
        this.f2551a = null;
        this.f2552b = new Object();
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str) {
        super(str);
        this.f2551a = null;
        this.f2552b = new Object();
        this.c = false;
    }

    public void a() {
        if (a.f2533a) {
            a.a("Looper thread quit()");
        }
        this.f2551a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f2552b) {
            try {
                if (!this.c) {
                    this.f2552b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f2552b) {
            this.c = true;
            this.f2552b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f2551a = new Handler();
        if (a.f2533a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f2533a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
