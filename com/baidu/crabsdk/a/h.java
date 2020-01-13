package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Runnable {
    final /* synthetic */ e Pt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Pt = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(e.Po);
            com.baidu.crabsdk.c.a.cb("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
