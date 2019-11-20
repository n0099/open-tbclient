package com.baidu.crabsdk.a;

import android.view.Choreographer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements Runnable {
    final /* synthetic */ e IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.IS = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(e.IL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
