package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class h implements Runnable {
    final /* synthetic */ e anV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.anV = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.anR);
            com.baidu.crabsdk.c.a.dA("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
