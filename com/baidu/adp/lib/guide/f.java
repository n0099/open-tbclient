package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d kq;
    private final /* synthetic */ ViewGroup kr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.kq = dVar;
        this.kr = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        g.a aVar;
        g.a aVar2;
        ViewGroup viewGroup = this.kr;
        hVar = this.kq.km;
        viewGroup.removeView(hVar);
        aVar = this.kq.kp;
        if (aVar != null) {
            aVar2 = this.kq.kp;
            aVar2.onDismiss();
        }
        this.kq.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
