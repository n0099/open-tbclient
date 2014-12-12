package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes.dex */
public class DrawableCompat {
    static final b au;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            au = new d();
        } else if (i >= 11) {
            au = new c();
        } else {
            au = new a();
        }
    }

    public static void jumpToCurrentState(Drawable drawable) {
        au.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        au.setAutoMirrored(drawable, z);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return au.isAutoMirrored(drawable);
    }
}
