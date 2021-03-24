package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6347a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6348b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6349c;

    public m() {
        this.f6347a = null;
        this.f6348b = new Object();
        this.f6349c = false;
    }

    public m(String str) {
        super(str);
        this.f6347a = null;
        this.f6348b = new Object();
        this.f6349c = false;
    }

    public void a() {
        if (a.f6321a) {
            a.a("Looper thread quit()");
        }
        this.f6347a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6348b) {
            try {
                if (!this.f6349c) {
                    this.f6348b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6348b) {
            this.f6349c = true;
            this.f6348b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6347a = new Handler();
        if (a.f6321a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6321a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
