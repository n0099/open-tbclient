package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h implements Runnable {
    final /* synthetic */ e aob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aob = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.anX);
            com.baidu.crabsdk.c.a.dC("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
