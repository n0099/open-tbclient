package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class h implements Runnable {
    final /* synthetic */ e alE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.alE = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.alA);
            com.baidu.crabsdk.c.a.dh("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
