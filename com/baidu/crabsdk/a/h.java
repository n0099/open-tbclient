package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Runnable {
    final /* synthetic */ e Sc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Sc = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().removeFrameCallback(e.RY);
        com.baidu.crabsdk.c.a.cb("stop FrameMonitor !!");
    }
}
