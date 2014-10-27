package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ e lB;
    private final /* synthetic */ Animation lC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, Animation animation) {
        this.lB = eVar;
        this.lC = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lB.c(this.lC);
    }
}
