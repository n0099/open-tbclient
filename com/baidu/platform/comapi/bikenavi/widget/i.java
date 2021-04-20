package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes2.dex */
public class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f9441a;

    public i(g gVar) {
        this.f9441a = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f9441a.f9439e;
        view.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
