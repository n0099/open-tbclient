package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class y implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView afn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(NoNetworkView noNetworkView) {
        this.afn = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.afn.setVisibility(8);
    }
}
