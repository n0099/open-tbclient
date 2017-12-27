package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView {
    private d Mu;
    private i Mv;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.Mu = new d(this);
        this.Mu.loadFromAttributes(attributeSet, i);
        this.Mv = i.d(this);
        this.Mv.loadFromAttributes(attributeSet, i);
        this.Mv.fQ();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Mu != null) {
            this.Mu.be(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Mu != null) {
            this.Mu.c(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mu != null) {
            this.Mu.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        if (this.Mu != null) {
            return this.Mu.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.Mu != null) {
            this.Mu.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.Mu != null) {
            return this.Mu.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Mu != null) {
            this.Mu.fI();
        }
        if (this.Mv != null) {
            this.Mv.fQ();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Mv != null) {
            this.Mv.l(context, i);
        }
    }
}
