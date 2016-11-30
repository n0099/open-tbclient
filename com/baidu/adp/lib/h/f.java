package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ d py;
    private final /* synthetic */ Animation pz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Animation animation) {
        this.py = dVar;
        this.pz = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.py.b(this.pz);
    }
}
