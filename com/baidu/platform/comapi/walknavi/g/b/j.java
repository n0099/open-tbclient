package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes6.dex */
class j implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f4305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f4305a = iVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f4305a.f4304a.f4303a.ab;
        view.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
