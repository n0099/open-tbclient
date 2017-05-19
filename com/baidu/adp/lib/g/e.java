package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d wF;
    private final /* synthetic */ Animation wG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.wF = dVar;
        this.wG = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wF.a(this.wG);
    }
}
