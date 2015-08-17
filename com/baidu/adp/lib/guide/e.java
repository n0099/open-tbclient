package com.baidu.adp.lib.guide;

import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ d uc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.uc = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        g.a aVar;
        g.a aVar2;
        aVar = this.uc.ub;
        if (aVar != null) {
            aVar2 = this.uc.ub;
            aVar2.gC();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
