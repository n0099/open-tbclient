package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6362a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6363b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6364c;

    public m() {
        this.f6362a = null;
        this.f6363b = new Object();
        this.f6364c = false;
    }

    public m(String str) {
        super(str);
        this.f6362a = null;
        this.f6363b = new Object();
        this.f6364c = false;
    }

    public void a() {
        if (a.f6336a) {
            a.a("Looper thread quit()");
        }
        this.f6362a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6363b) {
            try {
                if (!this.f6364c) {
                    this.f6363b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6363b) {
            this.f6364c = true;
            this.f6363b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6362a = new Handler();
        if (a.f6336a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6336a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
