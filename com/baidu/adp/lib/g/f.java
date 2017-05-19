package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d wF;
    private final /* synthetic */ Animation wG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.wF = dVar;
        this.wG = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wF.b(this.wG);
    }
}
