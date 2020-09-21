package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class g implements Runnable {
    final /* synthetic */ e anl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.anl = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.anh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
