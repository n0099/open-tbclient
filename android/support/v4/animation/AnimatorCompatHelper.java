package android.support.v4.animation;

import android.os.Build;
import android.support.annotation.RestrictTo;
import android.view.View;
@RestrictTo
/* loaded from: classes2.dex */
public final class AnimatorCompatHelper {
    private static final a wb;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            wb = new c();
        } else {
            wb = new b();
        }
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return wb.emptyValueAnimator();
    }

    private AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        wb.clearInterpolator(view);
    }
}
