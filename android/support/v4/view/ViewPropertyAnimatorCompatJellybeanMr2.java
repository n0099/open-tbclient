package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class ViewPropertyAnimatorCompatJellybeanMr2 {
    ViewPropertyAnimatorCompatJellybeanMr2() {
    }

    public static Interpolator getInterpolator(View view2) {
        return (Interpolator) view2.animate().getInterpolator();
    }
}
