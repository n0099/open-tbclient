package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g implements Runnable {
    final /* synthetic */ e amH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.amH = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.amD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
