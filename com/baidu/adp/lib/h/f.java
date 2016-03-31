package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    private final /* synthetic */ Animation wA;
    final /* synthetic */ d wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.wz = dVar;
        this.wA = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wz.b(this.wA);
    }
}
