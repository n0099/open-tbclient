package android.support.v4.app;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f303a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, Fragment fragment) {
        this.b = vVar;
        this.f303a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f303a.k != null) {
            this.f303a.k = null;
            this.b.a(this.f303a, this.f303a.l, 0, 0, false);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
