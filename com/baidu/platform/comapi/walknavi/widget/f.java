package com.baidu.platform.comapi.walknavi.widget;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes2.dex */
public class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f10234a;

    public f(d dVar) {
        this.f10234a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f10234a.f10231e;
        view.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
