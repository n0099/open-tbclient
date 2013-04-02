package com.baidu.android.nebula.cmd;

import java.util.Timer;
/* loaded from: classes.dex */
class d implements com.baidu.android.nebula.localserver.util.c {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.android.nebula.localserver.util.c
    public void a(com.baidu.android.nebula.localserver.util.b bVar) {
        com.baidu.android.nebula.localserver.util.b bVar2;
        Timer timer;
        Timer timer2;
        synchronized (this.a.a) {
            this.a.a.mLocInfo = bVar;
            bVar2 = this.a.a.mLocInfo;
            if (bVar2 == null) {
                this.a.a.mErrcode = 2;
            } else {
                this.a.a.mErrcode = 0;
            }
            timer = this.a.a.mTimeoutTm;
            if (timer != null) {
                timer2 = this.a.a.mTimeoutTm;
                timer2.cancel();
            }
            this.a.a.notifyAll();
        }
    }
}
