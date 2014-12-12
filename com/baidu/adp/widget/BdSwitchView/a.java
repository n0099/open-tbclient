package com.baidu.adp.widget.BdSwitchView;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Animation.AnimationListener {
    final /* synthetic */ BdSwitchView ui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSwitchView bdSwitchView) {
        this.ui = bdSwitchView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ui.uc = true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.ui.uc = false;
    }
}
