package com.baidu.platform.comapi.walknavi.g.c;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.a = cVar;
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
        relativeLayout = this.a.y;
        relativeLayout.clearAnimation();
        relativeLayout2 = this.a.y;
        relativeLayout2.setVisibility(8);
        relativeLayout3 = this.a.I;
        relativeLayout3.clearAnimation();
        relativeLayout4 = this.a.I;
        relativeLayout4.setVisibility(8);
        relativeLayout5 = this.a.J;
        relativeLayout5.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
