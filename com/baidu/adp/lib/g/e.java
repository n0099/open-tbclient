package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d wX;
    private final /* synthetic */ Animation wY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.wX = dVar;
        this.wY = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wX.a(this.wY);
    }
}
