package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.a.e;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
