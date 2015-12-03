package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d vW;
    private final /* synthetic */ Animation vX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.vW = dVar;
        this.vX = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vW.a(this.vX);
    }
}
