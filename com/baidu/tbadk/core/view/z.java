package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class z implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView akF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NoNetworkView noNetworkView) {
        this.akF = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.akF.setVisibility(8);
    }
}
