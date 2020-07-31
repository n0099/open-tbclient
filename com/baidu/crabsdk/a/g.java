package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class g implements Runnable {
    final /* synthetic */ e alE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.alE = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.alA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
