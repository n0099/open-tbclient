package com.baidu.android.nebula.cmd;

import java.util.Timer;
/* loaded from: classes.dex */
class k implements com.baidu.android.nebula.util.e {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.android.nebula.util.e
    public void a(com.baidu.android.nebula.util.c cVar) {
        com.baidu.android.nebula.util.c cVar2;
        Timer timer;
        Timer timer2;
        synchronized (this.a.a) {
            this.a.a.mLocInfo = cVar;
            cVar2 = this.a.a.mLocInfo;
            if (cVar2 == null) {
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
