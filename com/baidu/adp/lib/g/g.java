package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ e lB;
    private final /* synthetic */ Animation lC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Animation animation) {
        this.lB = eVar;
        this.lC = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lB.b(this.lC);
    }
}
