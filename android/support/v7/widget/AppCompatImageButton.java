package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: classes2.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView {
    private d Mt;
    private AppCompatImageHelper oB;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.Mt = new d(this);
        this.Mt.loadFromAttributes(attributeSet, i);
        this.oB = new AppCompatImageHelper(this);
        this.oB.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.oB.setImageResource(i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Mt != null) {
            this.Mt.be(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Mt != null) {
            this.Mt.c(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mt != null) {
            this.Mt.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        if (this.Mt != null) {
            return this.Mt.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.Mt != null) {
            this.Mt.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.Mt != null) {
            return this.Mt.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mt != null) {
            this.Mt.fI();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.oB.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}
