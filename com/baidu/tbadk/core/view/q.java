package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class q implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView agp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NoNetworkView noNetworkView) {
        this.agp = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.agp.setVisibility(8);
    }
}
