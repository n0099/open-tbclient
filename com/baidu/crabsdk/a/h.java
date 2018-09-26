package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Runnable {
    final /* synthetic */ e UG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.UG = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().removeFrameCallback(e.UC);
        com.baidu.crabsdk.c.a.cv("stop FrameMonitor !!");
    }
}
