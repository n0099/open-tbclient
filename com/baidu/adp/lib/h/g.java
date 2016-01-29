package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ d wi;
    private final /* synthetic */ Animation wj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, Animation animation) {
        this.wi = dVar;
        this.wj = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wi.c(this.wj);
    }
}
