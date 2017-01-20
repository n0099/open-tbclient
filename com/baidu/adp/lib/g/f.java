package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d pr;
    private final /* synthetic */ Animation pt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.pr = dVar;
        this.pt = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pr.b(this.pt);
    }
}
