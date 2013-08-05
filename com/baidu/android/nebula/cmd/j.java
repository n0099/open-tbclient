package com.baidu.android.nebula.cmd;

import java.util.Timer;
/* loaded from: classes.dex */
final class j implements com.baidu.android.nebula.util.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.f552a = dVar;
    }

    @Override // com.baidu.android.nebula.util.e
    public void a(com.baidu.android.nebula.util.c cVar) {
        com.baidu.android.nebula.util.c cVar2;
        Timer timer;
        Timer timer2;
        synchronized (this.f552a.f546a) {
            this.f552a.f546a.mLocInfo = cVar;
            cVar2 = this.f552a.f546a.mLocInfo;
            if (cVar2 == null) {
                this.f552a.f546a.mErrcode = 2;
            } else {
                this.f552a.f546a.mErrcode = 0;
            }
            timer = this.f552a.f546a.mTimeoutTm;
            if (timer != null) {
                timer2 = this.f552a.f546a.mTimeoutTm;
                timer2.cancel();
            }
            this.f552a.f546a.notifyAll();
        }
    }
}
