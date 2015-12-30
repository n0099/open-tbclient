package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d vY;
    private final /* synthetic */ Animation vZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.vY = dVar;
        this.vZ = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vY.b(this.vZ);
    }
}
