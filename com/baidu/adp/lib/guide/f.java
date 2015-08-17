package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d uc;
    private final /* synthetic */ ViewGroup ud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.uc = dVar;
        this.ud = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        g.a aVar;
        g.a aVar2;
        ViewGroup viewGroup = this.ud;
        hVar = this.uc.tY;
        viewGroup.removeView(hVar);
        aVar = this.uc.ub;
        if (aVar != null) {
            aVar2 = this.uc.ub;
            aVar2.onDismiss();
        }
        this.uc.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
