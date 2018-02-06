package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CheckBox;
/* loaded from: classes2.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {
    private e MB;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.MB = new e(this);
        this.MB.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.MB != null) {
            this.MB.fJ();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.MB != null ? this.MB.bf(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.MB != null) {
            this.MB.setSupportButtonTintList(colorStateList);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public ColorStateList getSupportButtonTintList() {
        if (this.MB != null) {
            return this.MB.getSupportButtonTintList();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.MB != null) {
            this.MB.setSupportButtonTintMode(mode);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.MB != null) {
            return this.MB.getSupportButtonTintMode();
        }
        return null;
    }
}
