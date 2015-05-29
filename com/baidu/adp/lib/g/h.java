package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ e vW;
    private final /* synthetic */ Animation vX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, Animation animation) {
        this.vW = eVar;
        this.vX = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vW.c(this.vX);
    }
}
