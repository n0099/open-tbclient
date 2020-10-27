package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g implements Runnable {
    final /* synthetic */ e anV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.anV = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.anR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
