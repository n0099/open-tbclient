package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class z implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView akT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NoNetworkView noNetworkView) {
        this.akT = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.akT.setVisibility(8);
    }
}
