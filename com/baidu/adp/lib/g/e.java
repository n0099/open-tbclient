package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d vQ;
    private final /* synthetic */ Animation vR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.vQ = dVar;
        this.vR = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vQ.a(this.vR);
    }
}
