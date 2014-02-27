package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {
    final /* synthetic */ d a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.a = dVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h unused;
        ViewGroup viewGroup = this.b;
        iVar = this.a.c;
        viewGroup.removeView(iVar);
        hVar = this.a.e;
        if (hVar != null) {
            unused = this.a.e;
        }
        this.a.b();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
