package com.baidu.ar.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes12.dex */
public class b extends Handler {
    private final d ki;
    private final int kj;
    private final a kk;
    private boolean kl;
    private boolean km;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar, Looper looper, int i) {
        super(looper);
        this.km = false;
        this.kk = aVar;
        this.kj = i;
        this.ki = new d();
    }

    public void c(g gVar, Object obj) {
        c d = c.d(gVar, obj);
        synchronized (this) {
            this.ki.c(d);
            if (!this.kl) {
                this.kl = true;
                if (!sendMessage(obtainMessage())) {
                    com.baidu.ar.g.b.aP("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (!this.km) {
                c cI = this.ki.cI();
                if (cI == null) {
                    synchronized (this) {
                        cI = this.ki.cI();
                        if (cI == null) {
                            this.kl = false;
                            return;
                        }
                    }
                }
                this.kk.a(cI);
                if (SystemClock.uptimeMillis() - uptimeMillis >= this.kj) {
                    if (!sendMessage(obtainMessage())) {
                        com.baidu.ar.g.b.aP("Could not send handler message");
                    }
                    this.kl = true;
                    return;
                }
            }
        } finally {
            this.kl = false;
        }
    }

    public void release() {
        this.km = true;
    }
}
