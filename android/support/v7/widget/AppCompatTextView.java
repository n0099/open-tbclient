package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView {
    private d Mt;
    private i Mu;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.Mt = new d(this);
        this.Mt.loadFromAttributes(attributeSet, i);
        this.Mu = i.d(this);
        this.Mu.loadFromAttributes(attributeSet, i);
        this.Mu.fQ();
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Mu != null) {
            this.Mu.m(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mt != null) {
            this.Mt.fI();
        }
        if (this.Mu != null) {
            this.Mu.fQ();
        }
    }
}
