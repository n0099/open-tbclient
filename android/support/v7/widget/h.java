package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* loaded from: classes2.dex */
class h extends g {
    private final SeekBar Nk;
    private Drawable Nl;
    private ColorStateList Nm;
    private PorterDuff.Mode Nn;
    private boolean No;
    private boolean Np;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SeekBar seekBar) {
        super(seekBar);
        this.Nm = null;
        this.Nn = null;
        this.No = false;
        this.Np = false;
        this.Nk = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.g
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.Nk.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.Nk.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.Nn = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.Nn);
            this.Np = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.Nm = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.No = true;
        }
        obtainStyledAttributes.recycle();
        fN();
    }

    void setTickMark(Drawable drawable) {
        if (this.Nl != null) {
            this.Nl.setCallback(null);
        }
        this.Nl = drawable;
        if (drawable != null) {
            drawable.setCallback(this.Nk);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.Nk));
            if (drawable.isStateful()) {
                drawable.setState(this.Nk.getDrawableState());
            }
            fN();
        }
        this.Nk.invalidate();
    }

    private void fN() {
        if (this.Nl != null) {
            if (this.No || this.Np) {
                this.Nl = DrawableCompat.wrap(this.Nl.mutate());
                if (this.No) {
                    DrawableCompat.setTintList(this.Nl, this.Nm);
                }
                if (this.Np) {
                    DrawableCompat.setTintMode(this.Nl, this.Nn);
                }
                if (this.Nl.isStateful()) {
                    this.Nl.setState(this.Nk.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jumpDrawablesToCurrentState() {
        if (this.Nl != null) {
            this.Nl.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawableStateChanged() {
        Drawable drawable = this.Nl;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.Nk.getDrawableState())) {
            this.Nk.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Canvas canvas) {
        int max;
        if (this.Nl != null && (max = this.Nk.getMax()) > 1) {
            int intrinsicWidth = this.Nl.getIntrinsicWidth();
            int intrinsicHeight = this.Nl.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.Nl.setBounds(-i, -i2, i, i2);
            float width = ((this.Nk.getWidth() - this.Nk.getPaddingLeft()) - this.Nk.getPaddingRight()) / max;
            int save = canvas.save();
            canvas.translate(this.Nk.getPaddingLeft(), this.Nk.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.Nl.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }
}
