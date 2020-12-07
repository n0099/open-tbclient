package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Runnable {
    final /* synthetic */ e aoP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aoP = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.aoL);
            com.baidu.crabsdk.c.a.dE("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
