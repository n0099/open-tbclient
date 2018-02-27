package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class DrawableWrapperGingerbread extends Drawable implements Drawable.Callback, DrawableWrapper, TintAwareDrawable {
    static final PorterDuff.Mode tq = PorterDuff.Mode.SRC_IN;
    private int mCurrentColor;
    private boolean tu;
    private PorterDuff.Mode wv;
    private boolean ww;
    DrawableWrapperState wx;
    Drawable wy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWrapperGingerbread(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.wx = drawableWrapperState;
        a(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWrapperGingerbread(Drawable drawable) {
        this.wx = dg();
        setWrappedDrawable(drawable);
    }

    private void a(Resources resources) {
        if (this.wx != null && this.wx.wz != null) {
            setWrappedDrawable(a(this.wx.wz, resources));
        }
    }

    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.wy.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.wy != null) {
            this.wy.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.wy.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return (this.wx != null ? this.wx.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.wy.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.wy.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.wy.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.wy.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.wy.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!dh() || this.wx == null) ? null : this.wx.um;
        return (colorStateList != null && colorStateList.isStateful()) || this.wy.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.wy.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.wy.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wy.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.wy.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wy.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.wy.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.wy.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.wy.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wy.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wy.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.wy.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.wx == null || !this.wx.canConstantState()) {
            return null;
        }
        this.wx.tf = getChangingConfigurations();
        return this.wx;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.tu && super.mutate() == this) {
            this.wx = dg();
            if (this.wy != null) {
                this.wy.mutate();
            }
            if (this.wx != null) {
                this.wx.wz = this.wy != null ? this.wy.getConstantState() : null;
            }
            this.tu = true;
        }
        return this;
    }

    DrawableWrapperState dg() {
        return new a(this.wx, null);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.wy.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.wx.um = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.wx.uo = mode;
        f(getState());
    }

    private boolean f(int[] iArr) {
        if (dh()) {
            ColorStateList colorStateList = this.wx.um;
            PorterDuff.Mode mode = this.wx.uo;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (this.ww && colorForState == this.mCurrentColor && mode == this.wv) {
                    return false;
                }
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.wv = mode;
                this.ww = true;
                return true;
            }
            this.ww = false;
            clearColorFilter();
            return false;
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapper
    public final Drawable getWrappedDrawable() {
        return this.wy;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapper
    public final void setWrappedDrawable(Drawable drawable) {
        if (this.wy != null) {
            this.wy.setCallback(null);
        }
        this.wy = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.wx != null) {
                this.wx.wz = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean dh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static abstract class DrawableWrapperState extends Drawable.ConstantState {
        int tf;
        ColorStateList um;
        PorterDuff.Mode uo;
        Drawable.ConstantState wz;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            this.um = null;
            this.uo = DrawableWrapperGingerbread.tq;
            if (drawableWrapperState != null) {
                this.tf = drawableWrapperState.tf;
                this.wz = drawableWrapperState.wz;
                this.um = drawableWrapperState.um;
                this.uo = drawableWrapperState.uo;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return (this.wz != null ? this.wz.getChangingConfigurations() : 0) | this.tf;
        }

        boolean canConstantState() {
            return this.wz != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends DrawableWrapperState {
        a(DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new DrawableWrapperGingerbread(this, resources);
        }
    }
}
