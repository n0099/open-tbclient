package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Runnable {
    final /* synthetic */ e Zs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Zs = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.Zo);
            com.baidu.crabsdk.c.a.ch("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
