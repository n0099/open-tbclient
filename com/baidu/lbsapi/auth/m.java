package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    Handler f2550a;

    /* renamed from: b  reason: collision with root package name */
    private Object f2551b;
    private boolean c;

    m() {
        this.f2550a = null;
        this.f2551b = new Object();
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str) {
        super(str);
        this.f2550a = null;
        this.f2551b = new Object();
        this.c = false;
    }

    public void a() {
        if (a.f2532a) {
            a.a("Looper thread quit()");
        }
        this.f2550a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f2551b) {
            try {
                if (!this.c) {
                    this.f2551b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f2551b) {
            this.c = true;
            this.f2551b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f2550a = new Handler();
        if (a.f2532a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f2532a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
