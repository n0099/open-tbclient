package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes.dex */
public class DrawableCompat {
    static final b lx;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            lx = new d();
        } else if (i >= 11) {
            lx = new c();
        } else {
            lx = new a();
        }
    }

    public static void jumpToCurrentState(Drawable drawable) {
        lx.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        lx.setAutoMirrored(drawable, z);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return lx.isAutoMirrored(drawable);
    }
}
