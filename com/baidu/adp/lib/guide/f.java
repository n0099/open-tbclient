package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    private final /* synthetic */ ViewGroup jA;
    final /* synthetic */ d jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.jz = dVar;
        this.jA = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h hVar2;
        ViewGroup viewGroup = this.jA;
        iVar = this.jz.jv;
        viewGroup.removeView(iVar);
        hVar = this.jz.jy;
        if (hVar != null) {
            hVar2 = this.jz.jy;
            hVar2.onDismiss();
        }
        this.jz.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
