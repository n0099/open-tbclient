package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ d px;
    private final /* synthetic */ Animation py;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, Animation animation) {
        this.px = dVar;
        this.py = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.px.c(this.py);
    }
}
