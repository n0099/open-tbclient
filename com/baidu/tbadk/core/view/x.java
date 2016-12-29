package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class x implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView aga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NoNetworkView noNetworkView) {
        this.aga = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aga.setVisibility(8);
    }
}
