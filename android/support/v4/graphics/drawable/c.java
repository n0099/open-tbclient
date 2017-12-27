package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class c {
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (!(drawable instanceof TintAwareDrawable)) {
            return new g(drawable);
        }
        return drawable;
    }
}
