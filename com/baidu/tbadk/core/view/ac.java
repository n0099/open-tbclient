package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView ZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NoNetworkView noNetworkView) {
        this.ZQ = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.ZQ.setVisibility(8);
    }
}
