package com.baidu.adp.lib.guide;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f434a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f434a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        h hVar2;
        hVar = this.f434a.e;
        if (hVar != null) {
            hVar2 = this.f434a.e;
            hVar2.a();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
