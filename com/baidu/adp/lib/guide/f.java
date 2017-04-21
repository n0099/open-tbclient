package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d uF;
    private final /* synthetic */ ViewGroup uG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.uF = dVar;
        this.uG = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        g.a aVar;
        g.a aVar2;
        ViewGroup viewGroup = this.uG;
        hVar = this.uF.uB;
        viewGroup.removeView(hVar);
        aVar = this.uF.uE;
        if (aVar != null) {
            aVar2 = this.uF.uE;
            aVar2.onDismiss();
        }
        this.uF.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
