package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes2.dex */
public class j implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f10018a;

    public j(i iVar) {
        this.f10018a = iVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f10018a.f10017a.f10016a.ab;
        view.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
