package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d mt;
    private final /* synthetic */ Animation mu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.mt = dVar;
        this.mu = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mt.a(this.mu);
    }
}
