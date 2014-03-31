package com.baidu.tbadk.core.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class l implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NoNetworkView noNetworkView) {
        this.a = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
    }
}
