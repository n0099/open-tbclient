package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Handler f6319a;

    /* renamed from: b  reason: collision with root package name */
    public Object f6320b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6321c;

    public m() {
        this.f6319a = null;
        this.f6320b = new Object();
        this.f6321c = false;
    }

    public m(String str) {
        super(str);
        this.f6319a = null;
        this.f6320b = new Object();
        this.f6321c = false;
    }

    public void a() {
        if (a.f6293a) {
            a.a("Looper thread quit()");
        }
        this.f6319a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f6320b) {
            try {
                if (!this.f6321c) {
                    this.f6320b.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.f6320b) {
            this.f6321c = true;
            this.f6320b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6319a = new Handler();
        if (a.f6293a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.f6293a) {
            a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
