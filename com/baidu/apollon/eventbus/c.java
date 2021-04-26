package com.baidu.apollon.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.apollon.eventbus.EventBus;
/* loaded from: classes.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final e f3691a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3692b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3693c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3694d;

    public c(b bVar, Looper looper, int i2) {
        super(looper);
        this.f3693c = bVar;
        this.f3692b = i2;
        this.f3691a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        d a2 = d.a(gVar, event);
        synchronized (this) {
            this.f3691a.a(a2);
            if (!this.f3694d) {
                this.f3694d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                d a2 = this.f3691a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3691a.a();
                        if (a2 == null) {
                            this.f3694d = false;
                            return;
                        }
                    }
                }
                this.f3693c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3692b);
            if (sendMessage(obtainMessage())) {
                this.f3694d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f3694d = false;
        }
    }
}
