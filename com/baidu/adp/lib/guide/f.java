package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.b = dVar;
        this.a = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h hVar2;
        ViewGroup viewGroup = this.a;
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
