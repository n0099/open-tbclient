package com.baidu.android.nebula.cmd;

import java.util.Timer;
/* loaded from: classes.dex */
class d implements com.baidu.android.nebula.util.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f545a = cVar;
    }

    @Override // com.baidu.android.nebula.util.d
    public void a(com.baidu.android.nebula.util.c cVar) {
        com.baidu.android.nebula.util.c cVar2;
        Timer timer;
        Timer timer2;
        synchronized (this.f545a.f544a) {
            this.f545a.f544a.mLocInfo = cVar;
            cVar2 = this.f545a.f544a.mLocInfo;
            if (cVar2 == null) {
                this.f545a.f544a.mErrcode = 2;
            } else {
                this.f545a.f544a.mErrcode = 0;
            }
            timer = this.f545a.f544a.mTimeoutTm;
            if (timer != null) {
                timer2 = this.f545a.f544a.mTimeoutTm;
                timer2.cancel();
            }
            this.f545a.f544a.notifyAll();
        }
    }
}
