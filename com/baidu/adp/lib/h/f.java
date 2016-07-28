package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d nb;
    private final /* synthetic */ Animation nc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.nb = dVar;
        this.nc = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.nb.b(this.nc);
    }
}
