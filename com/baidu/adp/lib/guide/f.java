package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d nn;
    private final /* synthetic */ ViewGroup np;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.nn = dVar;
        this.np = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        g.a aVar;
        g.a aVar2;
        ViewGroup viewGroup = this.np;
        hVar = this.nn.nj;
        viewGroup.removeView(hVar);
        aVar = this.nn.nm;
        if (aVar != null) {
            aVar2 = this.nn.nm;
            aVar2.onDismiss();
        }
        this.nn.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
