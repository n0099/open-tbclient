package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class g implements Runnable {
    final /* synthetic */ e Pp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.Pp = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.Pk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
