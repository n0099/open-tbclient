package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView YN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NoNetworkView noNetworkView) {
        this.YN = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.YN.setVisibility(8);
    }
}
