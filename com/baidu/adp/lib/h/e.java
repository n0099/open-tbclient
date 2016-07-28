package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d nb;
    private final /* synthetic */ Animation nc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Animation animation) {
        this.nb = dVar;
        this.nc = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.nb.a(this.nc);
    }
}
