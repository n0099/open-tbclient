package com.baidu.apollon.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.apollon.eventbus.EventBus;
/* loaded from: classes.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final e f3612a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3613b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3614c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3615d;

    public c(b bVar, Looper looper, int i) {
        super(looper);
        this.f3614c = bVar;
        this.f3613b = i;
        this.f3612a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        d a2 = d.a(gVar, event);
        synchronized (this) {
            this.f3612a.a(a2);
            if (!this.f3615d) {
                this.f3615d = true;
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
                d a2 = this.f3612a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3612a.a();
                        if (a2 == null) {
                            this.f3615d = false;
                            return;
                        }
                    }
                }
                this.f3614c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3613b);
            if (sendMessage(obtainMessage())) {
                this.f3615d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f3615d = false;
        }
    }
}
