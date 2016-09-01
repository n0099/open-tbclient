package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class r implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView afI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NoNetworkView noNetworkView) {
        this.afI = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.afI.setVisibility(8);
    }
}
