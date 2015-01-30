package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e lE;
    private final /* synthetic */ Animation lF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Animation animation) {
        this.lE = eVar;
        this.lF = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lE.a(this.lF);
    }
}
