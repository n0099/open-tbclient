package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    public static Interpolator create(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(path);
        }
        return new PathInterpolatorApi14(path);
    }

    public static Interpolator create(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f2, f3);
        }
        return new PathInterpolatorApi14(f2, f3);
    }

    public static Interpolator create(float f2, float f3, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f2, f3, f4, f5);
        }
        return new PathInterpolatorApi14(f2, f3, f4, f5);
    }
}
