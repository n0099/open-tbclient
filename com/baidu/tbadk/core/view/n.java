package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class n implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView aem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NoNetworkView noNetworkView) {
        this.aem = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aem.setVisibility(8);
    }
}
