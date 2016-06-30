package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView aci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NoNetworkView noNetworkView) {
        this.aci = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aci.setVisibility(8);
    }
}
