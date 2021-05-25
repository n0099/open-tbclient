package com.baidu.apollon.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.apollon.eventbus.EventBus;
/* loaded from: classes.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final e f3695a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3696b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3697c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3698d;

    public c(b bVar, Looper looper, int i2) {
        super(looper);
        this.f3697c = bVar;
        this.f3696b = i2;
        this.f3695a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        d a2 = d.a(gVar, event);
        synchronized (this) {
            this.f3695a.a(a2);
            if (!this.f3698d) {
                this.f3698d = true;
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
                d a2 = this.f3695a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3695a.a();
                        if (a2 == null) {
                            this.f3698d = false;
                            return;
                        }
                    }
                }
                this.f3697c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3696b);
            if (sendMessage(obtainMessage())) {
                this.f3698d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f3698d = false;
        }
    }
}
