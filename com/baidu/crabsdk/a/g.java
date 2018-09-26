package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Runnable {
    final /* synthetic */ e UG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.UG = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(e.UC);
    }
}
