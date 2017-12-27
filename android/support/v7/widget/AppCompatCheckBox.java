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
    private e MC;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.MC = new e(this);
        this.MC.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.MC != null) {
            this.MC.fJ();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.MC != null ? this.MC.bf(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.MC != null) {
            this.MC.setSupportButtonTintList(colorStateList);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public ColorStateList getSupportButtonTintList() {
        if (this.MC != null) {
            return this.MC.getSupportButtonTintList();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.MC != null) {
            this.MC.setSupportButtonTintMode(mode);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    @RestrictTo
    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.MC != null) {
            return this.MC.getSupportButtonTintMode();
        }
        return null;
    }
}
