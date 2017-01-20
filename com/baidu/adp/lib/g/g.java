package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ d pr;
    private final /* synthetic */ Animation pt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, Animation animation) {
        this.pr = dVar;
        this.pt = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pr.c(this.pt);
    }
}
