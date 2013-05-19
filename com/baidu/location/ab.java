package com.baidu.location;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ w a;

    private ab(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Handler handler2;
        z = this.a.q;
        if (!z || !ap.k) {
            this.a.s = false;
            return;
        }
        handler = this.a.f;
        handler.obtainMessage(91).sendToTarget();
        handler2 = this.a.f;
        handler2.postDelayed(this, ap.L);
        this.a.s = true;
    }
}
