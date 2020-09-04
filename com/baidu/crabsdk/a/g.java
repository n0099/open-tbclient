package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g implements Runnable {
    final /* synthetic */ e amJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.amJ = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.amF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
