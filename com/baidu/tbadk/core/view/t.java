package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class t implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView Is;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NoNetworkView noNetworkView) {
        this.Is = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.Is.setVisibility(8);
    }
}
