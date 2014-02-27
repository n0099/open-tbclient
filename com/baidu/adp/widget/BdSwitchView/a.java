package com.baidu.adp.widget.BdSwitchView;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Animation.AnimationListener {
    final /* synthetic */ BdSwitchView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSwitchView bdSwitchView) {
        this.a = bdSwitchView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        this.a.f = true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.a.f = false;
    }
}
