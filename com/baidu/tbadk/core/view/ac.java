package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView Nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NoNetworkView noNetworkView) {
        this.Nl = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.Nl.setVisibility(8);
    }
}
