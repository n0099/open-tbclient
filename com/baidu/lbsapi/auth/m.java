package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6568a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6569b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6570c;

    public m() {
        this.f6568a = null;
        this.f6569b = new Object();
        this.f6570c = false;
    }

    public m(String str) {
        super(str);
        this.f6568a = null;
        this.f6569b = new Object();
        this.f6570c = false;
    }

    public void a() {
        if (a.f6542a) {
            a.a("Looper thread quit()");
        }
        this.f6568a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6569b) {
            try {
                if (!this.f6570c) {
                    this.f6569b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6569b) {
            this.f6570c = true;
            this.f6569b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6568a = new Handler();
        if (a.f6542a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6542a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
