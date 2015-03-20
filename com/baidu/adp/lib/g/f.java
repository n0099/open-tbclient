package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e wS;
    private final /* synthetic */ Animation wT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Animation animation) {
        this.wS = eVar;
        this.wT = animation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wS.a(this.wT);
    }
}
