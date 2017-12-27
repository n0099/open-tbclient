package android.support.v4.animation;

import android.os.Build;
import android.support.annotation.RestrictTo;
import android.view.View;
@RestrictTo
/* loaded from: classes2.dex */
public final class AnimatorCompatHelper {
    private static final a wc;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            wc = new c();
        } else {
            wc = new b();
        }
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return wc.emptyValueAnimator();
    }

    private AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        wc.clearInterpolator(view);
    }
}
