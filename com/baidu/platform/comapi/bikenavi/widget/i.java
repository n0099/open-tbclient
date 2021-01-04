package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f4229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f4229a = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f4229a.g;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
