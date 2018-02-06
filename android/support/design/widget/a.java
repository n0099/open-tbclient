package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes2.dex */
class a {
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator kB = new FastOutSlowInInterpolator();
    static final Interpolator kC = new FastOutLinearInInterpolator();
    static final Interpolator kD = new LinearOutSlowInInterpolator();
    static final Interpolator kE = new DecelerateInterpolator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }

    /* renamed from: android.support.design.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class animation.Animation$AnimationListenerC0002a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
