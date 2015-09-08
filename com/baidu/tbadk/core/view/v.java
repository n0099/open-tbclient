package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class v implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView afa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NoNetworkView noNetworkView) {
        this.afa = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.afa.setVisibility(8);
    }
}
