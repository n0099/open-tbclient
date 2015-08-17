package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d vR;
    private final /* synthetic */ Animation vS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.vR = dVar;
        this.vS = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vR.b(this.vS);
    }
}
