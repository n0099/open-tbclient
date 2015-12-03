package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class o implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView afp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NoNetworkView noNetworkView) {
        this.afp = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.afp.setVisibility(8);
    }
}
