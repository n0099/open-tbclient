package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class c {
    public static Interpolator create(Path path) {
        return new d(path);
    }

    public static Interpolator create(float f, float f2) {
        return new d(f, f2);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        return new d(f, f2, f3, f4);
    }
}
