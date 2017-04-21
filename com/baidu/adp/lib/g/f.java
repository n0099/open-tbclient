package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d wE;
    private final /* synthetic */ Animation wF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.wE = dVar;
        this.wF = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wE.b(this.wF);
    }
}
