package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d wA;
    private final /* synthetic */ Animation wB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.wA = dVar;
        this.wB = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wA.a(this.wB);
    }
}
