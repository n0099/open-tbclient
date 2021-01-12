package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class g implements Runnable {
    final /* synthetic */ e aoB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aoB = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.aoy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
