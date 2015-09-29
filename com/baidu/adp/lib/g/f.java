package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d vQ;
    private final /* synthetic */ Animation vR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.vQ = dVar;
        this.vR = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vQ.b(this.vR);
    }
}
