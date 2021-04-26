package com.baidu.platform.comapi.walknavi.g.b;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class g implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10015a;

    public g(c cVar) {
        this.f10015a = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        RelativeLayout relativeLayout5;
        relativeLayout = this.f10015a.y;
        relativeLayout.clearAnimation();
        relativeLayout2 = this.f10015a.y;
        relativeLayout2.setVisibility(8);
        relativeLayout3 = this.f10015a.H;
        relativeLayout3.clearAnimation();
        relativeLayout4 = this.f10015a.H;
        relativeLayout4.setVisibility(8);
        relativeLayout5 = this.f10015a.I;
        relativeLayout5.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
