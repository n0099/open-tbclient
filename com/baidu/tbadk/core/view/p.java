package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class p implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView agO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NoNetworkView noNetworkView) {
        this.agO = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.agO.setVisibility(8);
    }
}
