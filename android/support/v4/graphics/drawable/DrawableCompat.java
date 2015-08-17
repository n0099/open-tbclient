package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes.dex */
public class DrawableCompat {
    static final b lx;

    /* loaded from: classes.dex */
    interface b {
        boolean isAutoMirrored(Drawable drawable);

        void jumpToCurrentState(Drawable drawable);

        void setAutoMirrored(Drawable drawable, boolean z);
    }

    /* loaded from: classes.dex */
    static class a implements b {
        a() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void jumpToCurrentState(Drawable drawable) {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setAutoMirrored(Drawable drawable, boolean z) {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean isAutoMirrored(Drawable drawable) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class c extends a {
        c() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void jumpToCurrentState(Drawable drawable) {
            android.support.v4.graphics.drawable.a.jumpToCurrentState(drawable);
        }
    }

    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setAutoMirrored(Drawable drawable, boolean z) {
            android.support.v4.graphics.drawable.b.setAutoMirrored(drawable, z);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean isAutoMirrored(Drawable drawable) {
            return android.support.v4.graphics.drawable.b.isAutoMirrored(drawable);
        }
    }

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
