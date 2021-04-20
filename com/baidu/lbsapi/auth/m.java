package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6383a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6384b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6385c;

    public m() {
        this.f6383a = null;
        this.f6384b = new Object();
        this.f6385c = false;
    }

    public m(String str) {
        super(str);
        this.f6383a = null;
        this.f6384b = new Object();
        this.f6385c = false;
    }

    public void a() {
        if (a.f6357a) {
            a.a("Looper thread quit()");
        }
        this.f6383a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6384b) {
            try {
                if (!this.f6385c) {
                    this.f6384b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6384b) {
            this.f6385c = true;
            this.f6384b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6383a = new Handler();
        if (a.f6357a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6357a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
