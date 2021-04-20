package com.baidu.apollon.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.apollon.eventbus.EventBus;
/* loaded from: classes.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final e f3647a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3648b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3649c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3650d;

    public c(b bVar, Looper looper, int i) {
        super(looper);
        this.f3649c = bVar;
        this.f3648b = i;
        this.f3647a = new e();
    }

    public void a(g gVar, EventBus.Event event) {
        d a2 = d.a(gVar, event);
        synchronized (this) {
            this.f3647a.a(a2);
            if (!this.f3650d) {
                this.f3650d = true;
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
                d a2 = this.f3647a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f3647a.a();
                        if (a2 == null) {
                            this.f3650d = false;
                            return;
                        }
                    }
                }
                this.f3649c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f3648b);
            if (sendMessage(obtainMessage())) {
                this.f3650d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f3650d = false;
        }
    }
}
