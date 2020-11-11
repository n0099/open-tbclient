package com.baidu.platform.comapi.walknavi.g.c;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f3033a = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        RelativeLayout relativeLayout5;
        relativeLayout = this.f3033a.y;
        relativeLayout.clearAnimation();
        relativeLayout2 = this.f3033a.y;
        relativeLayout2.setVisibility(8);
        relativeLayout3 = this.f3033a.I;
        relativeLayout3.clearAnimation();
        relativeLayout4 = this.f3033a.I;
        relativeLayout4.setVisibility(8);
        relativeLayout5 = this.f3033a.J;
        relativeLayout5.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
