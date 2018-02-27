package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public final class DrawableCompat {
    static final b wq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void applyTheme(Drawable drawable, Resources.Theme theme);

        boolean canApplyTheme(Drawable drawable);

        void clearColorFilter(Drawable drawable);

        int getAlpha(Drawable drawable);

        ColorFilter getColorFilter(Drawable drawable);

        int getLayoutDirection(Drawable drawable);

        void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException;

        boolean isAutoMirrored(Drawable drawable);

        void jumpToCurrentState(Drawable drawable);

        void setAutoMirrored(Drawable drawable, boolean z);

        void setHotspot(Drawable drawable, float f, float f2);

        void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4);

        boolean setLayoutDirection(Drawable drawable, int i);

        void setTint(Drawable drawable, int i);

        void setTintList(Drawable drawable, ColorStateList colorStateList);

        void setTintMode(Drawable drawable, PorterDuff.Mode mode);

        Drawable wrap(Drawable drawable);
    }

    /* loaded from: classes2.dex */
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

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setHotspot(Drawable drawable, float f, float f2) {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTint(Drawable drawable, int i) {
            android.support.v4.graphics.drawable.b.setTint(drawable, i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.graphics.drawable.b.setTintList(drawable, colorStateList);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.graphics.drawable.b.setTintMode(drawable, mode);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public Drawable wrap(Drawable drawable) {
            return android.support.v4.graphics.drawable.b.b(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean setLayoutDirection(Drawable drawable, int i) {
            return false;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public int getLayoutDirection(Drawable drawable) {
            return 0;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public int getAlpha(Drawable drawable) {
            return 0;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void applyTheme(Drawable drawable, Resources.Theme theme) {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean canApplyTheme(Drawable drawable) {
            return false;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public ColorFilter getColorFilter(Drawable drawable) {
            return null;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.b
        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            android.support.v4.graphics.drawable.b.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* loaded from: classes2.dex */
    static class c extends a {
        c() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void jumpToCurrentState(Drawable drawable) {
            android.support.v4.graphics.drawable.c.jumpToCurrentState(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public Drawable wrap(Drawable drawable) {
            return android.support.v4.graphics.drawable.c.b(drawable);
        }
    }

    /* loaded from: classes2.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean setLayoutDirection(Drawable drawable, int i) {
            return android.support.v4.graphics.drawable.d.setLayoutDirection(drawable, i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public int getLayoutDirection(Drawable drawable) {
            int layoutDirection = android.support.v4.graphics.drawable.d.getLayoutDirection(drawable);
            if (layoutDirection >= 0) {
                return layoutDirection;
            }
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    static class e extends d {
        e() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setAutoMirrored(Drawable drawable, boolean z) {
            android.support.v4.graphics.drawable.e.setAutoMirrored(drawable, z);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean isAutoMirrored(Drawable drawable) {
            return android.support.v4.graphics.drawable.e.isAutoMirrored(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.c, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public Drawable wrap(Drawable drawable) {
            return android.support.v4.graphics.drawable.e.b(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public int getAlpha(Drawable drawable) {
            return android.support.v4.graphics.drawable.e.getAlpha(drawable);
        }
    }

    /* loaded from: classes2.dex */
    static class f extends e {
        f() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setHotspot(Drawable drawable, float f, float f2) {
            android.support.v4.graphics.drawable.f.setHotspot(drawable, f, f2);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            android.support.v4.graphics.drawable.f.setHotspotBounds(drawable, i, i2, i3, i4);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTint(Drawable drawable, int i) {
            android.support.v4.graphics.drawable.f.setTint(drawable, i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            android.support.v4.graphics.drawable.f.setTintList(drawable, colorStateList);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            android.support.v4.graphics.drawable.f.setTintMode(drawable, mode);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.e, android.support.v4.graphics.drawable.DrawableCompat.c, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public Drawable wrap(Drawable drawable) {
            return android.support.v4.graphics.drawable.f.b(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void applyTheme(Drawable drawable, Resources.Theme theme) {
            android.support.v4.graphics.drawable.f.applyTheme(drawable, theme);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean canApplyTheme(Drawable drawable) {
            return android.support.v4.graphics.drawable.f.canApplyTheme(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public ColorFilter getColorFilter(Drawable drawable) {
            return android.support.v4.graphics.drawable.f.getColorFilter(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void clearColorFilter(Drawable drawable) {
            android.support.v4.graphics.drawable.f.clearColorFilter(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            android.support.v4.graphics.drawable.f.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* loaded from: classes2.dex */
    static class g extends f {
        g() {
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.d, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public boolean setLayoutDirection(Drawable drawable, int i) {
            return android.support.v4.graphics.drawable.a.setLayoutDirection(drawable, i);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.d, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public int getLayoutDirection(Drawable drawable) {
            return android.support.v4.graphics.drawable.a.getLayoutDirection(drawable);
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.f, android.support.v4.graphics.drawable.DrawableCompat.e, android.support.v4.graphics.drawable.DrawableCompat.c, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public Drawable wrap(Drawable drawable) {
            return drawable;
        }

        @Override // android.support.v4.graphics.drawable.DrawableCompat.f, android.support.v4.graphics.drawable.DrawableCompat.a, android.support.v4.graphics.drawable.DrawableCompat.b
        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            wq = new g();
        } else if (i >= 21) {
            wq = new f();
        } else if (i >= 19) {
            wq = new e();
        } else if (i >= 17) {
            wq = new d();
        } else if (i >= 11) {
            wq = new c();
        } else {
            wq = new a();
        }
    }

    public static void jumpToCurrentState(Drawable drawable) {
        wq.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        wq.setAutoMirrored(drawable, z);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return wq.isAutoMirrored(drawable);
    }

    public static void setHotspot(Drawable drawable, float f2, float f3) {
        wq.setHotspot(drawable, f2, f3);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        wq.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static void setTint(Drawable drawable, int i) {
        wq.setTint(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        wq.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        wq.setTintMode(drawable, mode);
    }

    public static int getAlpha(Drawable drawable) {
        return wq.getAlpha(drawable);
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        wq.applyTheme(drawable, theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return wq.canApplyTheme(drawable);
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return wq.getColorFilter(drawable);
    }

    public static void clearColorFilter(Drawable drawable) {
        wq.clearColorFilter(drawable);
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        wq.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable wrap(Drawable drawable) {
        return wq.wrap(drawable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable drawable) {
        if (drawable instanceof DrawableWrapper) {
            return (T) ((DrawableWrapper) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        return wq.setLayoutDirection(drawable, i);
    }

    public static int getLayoutDirection(Drawable drawable) {
        return wq.getLayoutDirection(drawable);
    }

    private DrawableCompat() {
    }
}
