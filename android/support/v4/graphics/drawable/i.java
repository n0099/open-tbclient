package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableWrapperGingerbread;
/* loaded from: classes2.dex */
class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Drawable drawable) {
        super(drawable);
    }

    i(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.wy.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.wy.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.wy.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.wy.getDirtyBounds();
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (dh()) {
            super.setTintList(colorStateList);
        } else {
            this.wy.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (dh()) {
            super.setTint(i);
        } else {
            this.wy.setTint(i);
        }
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (dh()) {
            super.setTintMode(mode);
        } else {
            this.wy.setTintMode(mode);
        }
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread
    protected boolean dh() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.wy;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.h, android.support.v4.graphics.drawable.g, android.support.v4.graphics.drawable.DrawableWrapperGingerbread
    DrawableWrapperGingerbread.DrawableWrapperState dg() {
        return new a(this.wx, null);
    }

    /* loaded from: classes2.dex */
    private static class a extends DrawableWrapperGingerbread.DrawableWrapperState {
        a(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this, resources);
        }
    }
}
