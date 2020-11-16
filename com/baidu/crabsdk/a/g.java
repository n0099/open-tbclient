package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g implements Runnable {
    final /* synthetic */ e aob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aob = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.anX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
