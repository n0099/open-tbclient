package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? b.create(path) : c.create(path);
    }

    public static Interpolator create(float f, float f2) {
        return Build.VERSION.SDK_INT >= 21 ? b.create(f, f2) : c.create(f, f2);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        return Build.VERSION.SDK_INT >= 21 ? b.create(f, f2, f3, f4) : c.create(f, f2, f3, f4);
    }
}
