package com.baidu.adp.lib.guide;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ d uS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.uS = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        h hVar2;
        hVar = this.uS.uR;
        if (hVar != null) {
            hVar2 = this.uS.uR;
            hVar2.gW();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
