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
    private final CompoundButton MC;
    private ColorStateList MD = null;
    private PorterDuff.Mode ME = null;
    private boolean MF = false;
    private boolean MG = false;
    private boolean MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CompoundButton compoundButton) {
        this.MC = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.MC.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.MC.setButtonDrawable(AppCompatResources.getDrawable(this.MC.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.MC, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.MC, DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.MD = colorStateList;
        this.MF = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportButtonTintList() {
        return this.MD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.ME = mode;
        this.MG = true;
        fK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.ME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fJ() {
        if (this.MH) {
            this.MH = false;
            return;
        }
        this.MH = true;
        fK();
    }

    void fK() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.MC);
        if (buttonDrawable != null) {
            if (this.MF || this.MG) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.MF) {
                    DrawableCompat.setTintList(mutate, this.MD);
                }
                if (this.MG) {
                    DrawableCompat.setTintMode(mutate, this.ME);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.MC.getDrawableState());
                }
                this.MC.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bf(int i) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT < 17 && (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.MC)) != null) {
            return i + buttonDrawable.getIntrinsicWidth();
        }
        return i;
    }
}
