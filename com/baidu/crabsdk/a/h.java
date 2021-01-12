package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class h implements Runnable {
    final /* synthetic */ e aoB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aoB = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.aoy);
            com.baidu.crabsdk.c.a.ds("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
