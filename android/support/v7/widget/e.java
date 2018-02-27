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
    private boolean MC;
    private final CompoundButton Mx;
    private ColorStateList My = null;
    private PorterDuff.Mode Mz = null;
    private boolean MA = false;
    private boolean MB = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CompoundButton compoundButton) {
        this.Mx = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.Mx.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.Mx.setButtonDrawable(AppCompatResources.getDrawable(this.Mx.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.Mx, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.Mx, DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.My = colorStateList;
        this.MA = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportButtonTintList() {
        return this.My;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.Mz = mode;
        this.MB = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.Mz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fJ() {
        if (this.MC) {
            this.MC = false;
            return;
        }
        this.MC = true;
        fK();
    }

    void fK() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.Mx);
        if (buttonDrawable != null) {
            if (this.MA || this.MB) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.MA) {
                    DrawableCompat.setTintList(mutate, this.My);
                }
                if (this.MB) {
                    DrawableCompat.setTintMode(mutate, this.Mz);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.Mx.getDrawableState());
                }
                this.Mx.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bf(int i) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT < 17 && (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.Mx)) != null) {
            return i + buttonDrawable.getIntrinsicWidth();
        }
        return i;
    }
}
