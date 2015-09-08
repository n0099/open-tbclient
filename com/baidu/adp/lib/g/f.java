package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d vP;
    private final /* synthetic */ Animation vQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.vP = dVar;
        this.vQ = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vP.b(this.vQ);
    }
}
