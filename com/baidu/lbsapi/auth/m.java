package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6348a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6349b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6350c;

    public m() {
        this.f6348a = null;
        this.f6349b = new Object();
        this.f6350c = false;
    }

    public m(String str) {
        super(str);
        this.f6348a = null;
        this.f6349b = new Object();
        this.f6350c = false;
    }

    public void a() {
        if (a.f6322a) {
            a.a("Looper thread quit()");
        }
        this.f6348a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6349b) {
            try {
                if (!this.f6350c) {
                    this.f6349b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6349b) {
            this.f6350c = true;
            this.f6349b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6348a = new Handler();
        if (a.f6322a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6322a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
