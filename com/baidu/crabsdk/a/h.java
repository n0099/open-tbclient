package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Runnable {
    final /* synthetic */ e Sb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Sb = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().removeFrameCallback(e.RX);
        com.baidu.crabsdk.c.a.ce("stop FrameMonitor !!");
    }
}
