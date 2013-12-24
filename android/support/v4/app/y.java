package android.support.v4.app;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Animation.AnimationListener {
    final /* synthetic */ Fragment a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, Fragment fragment) {
        this.b = vVar;
        this.a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.a.k != null) {
            this.a.k = null;
            this.b.a(this.a, this.a.l, 0, 0, false);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
