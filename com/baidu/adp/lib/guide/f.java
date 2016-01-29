package com.baidu.adp.lib.guide;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d us;
    private final /* synthetic */ ViewGroup ut;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, ViewGroup viewGroup) {
        this.us = dVar;
        this.ut = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        g.a aVar;
        g.a aVar2;
        ViewGroup viewGroup = this.ut;
        hVar = this.us.uo;
        viewGroup.removeView(hVar);
        aVar = this.us.ur;
        if (aVar != null) {
            aVar2 = this.us.ur;
            aVar2.onDismiss();
        }
        this.us.onDestroy();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
