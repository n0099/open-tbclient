package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f435a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.f435a = dVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h hVar2;
        ViewGroup viewGroup = this.b;
        iVar = this.f435a.c;
        viewGroup.removeView(iVar);
        hVar = this.f435a.e;
        if (hVar != null) {
            hVar2 = this.f435a.e;
            hVar2.b();
        }
        this.f435a.b();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
