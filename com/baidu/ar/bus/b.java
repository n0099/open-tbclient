package com.baidu.ar.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class b extends Handler {
    private boolean kA;
    private boolean kB;
    private final d kx;
    private final int ky;
    private final a kz;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar, Looper looper, int i) {
        super(looper);
        this.kB = false;
        this.kz = aVar;
        this.ky = i;
        this.kx = new d();
    }

    public void c(g gVar, Object obj) {
        c d = c.d(gVar, obj);
        synchronized (this) {
            this.kx.c(d);
            if (!this.kA) {
                this.kA = true;
                if (!sendMessage(obtainMessage())) {
                    com.baidu.ar.h.b.aS("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (!this.kB) {
                c cH = this.kx.cH();
                if (cH == null) {
                    synchronized (this) {
                        cH = this.kx.cH();
                        if (cH == null) {
                            this.kA = false;
                            return;
                        }
                    }
                }
                this.kz.a(cH);
                if (SystemClock.uptimeMillis() - uptimeMillis >= this.ky) {
                    if (!sendMessage(obtainMessage())) {
                        com.baidu.ar.h.b.aS("Could not send handler message");
                    }
                    this.kA = true;
                    return;
                }
            }
        } finally {
            this.kA = false;
        }
    }

    public void release() {
        this.kB = true;
    }
}
