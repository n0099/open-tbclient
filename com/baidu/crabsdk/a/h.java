package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Runnable {
    final /* synthetic */ e XD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.XD = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.Xz);
            com.baidu.crabsdk.c.a.cH("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
