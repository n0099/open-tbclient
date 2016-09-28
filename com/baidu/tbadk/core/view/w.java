package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NoNetworkView noNetworkView) {
        this.agi = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.agi.setVisibility(8);
    }
}
