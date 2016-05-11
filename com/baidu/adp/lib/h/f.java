package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d mt;
    private final /* synthetic */ Animation mu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.mt = dVar;
        this.mu = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mt.b(this.mu);
    }
}
