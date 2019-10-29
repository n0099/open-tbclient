package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Runnable {
    final /* synthetic */ e Jt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Jt = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.Jo);
            com.baidu.crabsdk.c.a.bu("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
