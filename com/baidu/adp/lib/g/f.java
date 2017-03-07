package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d wX;
    private final /* synthetic */ Animation wY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.wX = dVar;
        this.wY = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wX.b(this.wY);
    }
}
