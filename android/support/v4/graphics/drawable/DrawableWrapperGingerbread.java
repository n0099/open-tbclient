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
    static final PorterDuff.Mode tr = PorterDuff.Mode.SRC_IN;
    private int mCurrentColor;

    /* renamed from: tv  reason: collision with root package name */
    private boolean f1tv;
    private PorterDuff.Mode ww;
    private boolean wx;
    DrawableWrapperState wy;
    Drawable wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWrapperGingerbread(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.wy = drawableWrapperState;
        a(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWrapperGingerbread(Drawable drawable) {
        this.wy = dg();
        setWrappedDrawable(drawable);
    }

    private void a(Resources resources) {
        if (this.wy != null && this.wy.wA != null) {
            setWrappedDrawable(a(this.wy.wA, resources));
        }
    }

    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.wz.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.wz != null) {
            this.wz.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.wz.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return (this.wy != null ? this.wy.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.wz.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.wz.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.wz.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.wz.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.wz.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!dh() || this.wy == null) ? null : this.wy.uo;
        return (colorStateList != null && colorStateList.isStateful()) || this.wz.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.wz.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.wz.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wz.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.wz.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wz.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.wz.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.wz.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.wz.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wz.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wz.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.wz.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.wy == null || !this.wy.canConstantState()) {
            return null;
        }
        this.wy.tg = getChangingConfigurations();
        return this.wy;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1tv && super.mutate() == this) {
            this.wy = dg();
            if (this.wz != null) {
                this.wz.mutate();
            }
            if (this.wy != null) {
                this.wy.wA = this.wz != null ? this.wz.getConstantState() : null;
            }
            this.f1tv = true;
        }
        return this;
    }

    DrawableWrapperState dg() {
        return new a(this.wy, null);
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
        return this.wz.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.wy.uo = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.wy.uq = mode;
        f(getState());
    }

    private boolean f(int[] iArr) {
        if (dh()) {
            ColorStateList colorStateList = this.wy.uo;
            PorterDuff.Mode mode = this.wy.uq;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (this.wx && colorForState == this.mCurrentColor && mode == this.ww) {
                    return false;
                }
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.ww = mode;
                this.wx = true;
                return true;
            }
            this.wx = false;
            clearColorFilter();
            return false;
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapper
    public final Drawable getWrappedDrawable() {
        return this.wz;
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapper
    public final void setWrappedDrawable(Drawable drawable) {
        if (this.wz != null) {
            this.wz.setCallback(null);
        }
        this.wz = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.wy != null) {
                this.wy.wA = drawable.getConstantState();
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
        int tg;
        ColorStateList uo;
        PorterDuff.Mode uq;
        Drawable.ConstantState wA;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            this.uo = null;
            this.uq = DrawableWrapperGingerbread.tr;
            if (drawableWrapperState != null) {
                this.tg = drawableWrapperState.tg;
                this.wA = drawableWrapperState.wA;
                this.uo = drawableWrapperState.uo;
                this.uq = drawableWrapperState.uq;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return (this.wA != null ? this.wA.getChangingConfigurations() : 0) | this.tg;
        }

        boolean canConstantState() {
            return this.wA != null;
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
