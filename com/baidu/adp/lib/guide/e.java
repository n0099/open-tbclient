package com.baidu.adp.lib.guide;

import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ d ko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ko = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        g.a aVar;
        g.a aVar2;
        aVar = this.ko.kn;
        if (aVar != null) {
            aVar2 = this.ko.kn;
            aVar2.cX();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
