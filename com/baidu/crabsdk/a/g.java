package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g implements Runnable {
    final /* synthetic */ e anU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.anU = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.anQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
