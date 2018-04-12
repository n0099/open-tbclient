package android.support.v4.animation;

import android.os.Build;
import android.support.annotation.RestrictTo;
import android.view.View;
@RestrictTo({RestrictTo.Scope.GROUP_ID})
/* loaded from: classes2.dex */
public final class AnimatorCompatHelper {
    private static final AnimatorProvider IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            IMPL = new HoneycombMr1AnimatorCompatProvider();
        } else {
            IMPL = new GingerbreadAnimatorCompatProvider();
        }
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }

    private AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view2) {
        IMPL.clearInterpolator(view2);
    }
}
