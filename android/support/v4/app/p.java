package android.support.v4.app;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    final /* synthetic */ Fragment a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, Fragment fragment) {
        this.b = mVar;
        this.a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.a.j != null) {
            this.a.j = null;
            this.b.a(this.a, this.a.k, 0, 0);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
