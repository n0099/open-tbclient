package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d wi;
    private final /* synthetic */ Animation wj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.wi = dVar;
        this.wj = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wi.b(this.wj);
    }
}
