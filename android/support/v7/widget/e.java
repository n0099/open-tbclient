package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;
/* loaded from: classes2.dex */
class e {
    private final CompoundButton MD;
    private ColorStateList ME = null;
    private PorterDuff.Mode MF = null;
    private boolean MG = false;
    private boolean MH = false;
    private boolean MI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CompoundButton compoundButton) {
        this.MD = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.MD.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.MD.setButtonDrawable(AppCompatResources.getDrawable(this.MD.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.MD, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.MD, DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.ME = colorStateList;
        this.MG = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportButtonTintList() {
        return this.ME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.MF = mode;
        this.MH = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.MF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fJ() {
        if (this.MI) {
            this.MI = false;
            return;
        }
        this.MI = true;
        fK();
    }

    void fK() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.MD);
        if (buttonDrawable != null) {
            if (this.MG || this.MH) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.MG) {
                    DrawableCompat.setTintList(mutate, this.ME);
                }
                if (this.MH) {
                    DrawableCompat.setTintMode(mutate, this.MF);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.MD.getDrawableState());
                }
                this.MD.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bf(int i) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT < 17 && (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.MD)) != null) {
            return i + buttonDrawable.getIntrinsicWidth();
        }
        return i;
    }
}
