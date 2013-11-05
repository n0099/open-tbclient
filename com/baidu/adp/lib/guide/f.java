package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f497a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.b = dVar;
        this.f497a = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h hVar2;
        ViewGroup viewGroup = this.f497a;
        iVar = this.b.c;
        viewGroup.removeView(iVar);
        hVar = this.b.e;
        if (hVar != null) {
            hVar2 = this.b.e;
            hVar2.b();
        }
        this.b.b();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
