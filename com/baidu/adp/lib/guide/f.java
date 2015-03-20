package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d uS;
    private final /* synthetic */ ViewGroup uT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.uS = dVar;
        this.uT = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        h hVar;
        h hVar2;
        ViewGroup viewGroup = this.uT;
        iVar = this.uS.uO;
        viewGroup.removeView(iVar);
        hVar = this.uS.uR;
        if (hVar != null) {
            hVar2 = this.uS.uR;
            hVar2.onDismiss();
        }
        this.uS.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
