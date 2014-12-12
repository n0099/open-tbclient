package com.baidu.adp.lib.guide;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ d jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.jz = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        h hVar2;
        hVar = this.jz.jy;
        if (hVar != null) {
            hVar2 = this.jz.jy;
            hVar2.dA();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
