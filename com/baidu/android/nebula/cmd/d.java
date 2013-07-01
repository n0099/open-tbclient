package com.baidu.android.nebula.cmd;

import java.util.Timer;
/* loaded from: classes.dex */
final class d implements com.baidu.android.nebula.util.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f282a = aVar;
    }

    @Override // com.baidu.android.nebula.util.e
    public void a(com.baidu.android.nebula.util.c cVar) {
        com.baidu.android.nebula.util.c cVar2;
        Timer timer;
        Timer timer2;
        synchronized (this.f282a.f279a) {
            this.f282a.f279a.mLocInfo = cVar;
            cVar2 = this.f282a.f279a.mLocInfo;
            if (cVar2 == null) {
                this.f282a.f279a.mErrcode = 2;
            } else {
                this.f282a.f279a.mErrcode = 0;
            }
            timer = this.f282a.f279a.mTimeoutTm;
            if (timer != null) {
                timer2 = this.f282a.f279a.mTimeoutTm;
                timer2.cancel();
            }
            this.f282a.f279a.notifyAll();
        }
    }
}
