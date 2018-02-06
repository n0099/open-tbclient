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
    private final SeekBar Nj;
    private Drawable Nk;
    private ColorStateList Nl;
    private PorterDuff.Mode Nm;
    private boolean Nn;
    private boolean No;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SeekBar seekBar) {
        super(seekBar);
        this.Nl = null;
        this.Nm = null;
        this.Nn = false;
        this.No = false;
        this.Nj = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.g
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.Nj.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.Nj.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.Nm = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.Nm);
            this.No = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.Nl = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.Nn = true;
        }
        obtainStyledAttributes.recycle();
        fN();
    }

    void setTickMark(Drawable drawable) {
        if (this.Nk != null) {
            this.Nk.setCallback(null);
        }
        this.Nk = drawable;
        if (drawable != null) {
            drawable.setCallback(this.Nj);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.Nj));
            if (drawable.isStateful()) {
                drawable.setState(this.Nj.getDrawableState());
            }
            fN();
        }
        this.Nj.invalidate();
    }

    private void fN() {
        if (this.Nk != null) {
            if (this.Nn || this.No) {
                this.Nk = DrawableCompat.wrap(this.Nk.mutate());
                if (this.Nn) {
                    DrawableCompat.setTintList(this.Nk, this.Nl);
                }
                if (this.No) {
                    DrawableCompat.setTintMode(this.Nk, this.Nm);
                }
                if (this.Nk.isStateful()) {
                    this.Nk.setState(this.Nj.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jumpDrawablesToCurrentState() {
        if (this.Nk != null) {
            this.Nk.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawableStateChanged() {
        Drawable drawable = this.Nk;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.Nj.getDrawableState())) {
            this.Nj.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Canvas canvas) {
        int max;
        if (this.Nk != null && (max = this.Nj.getMax()) > 1) {
            int intrinsicWidth = this.Nk.getIntrinsicWidth();
            int intrinsicHeight = this.Nk.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.Nk.setBounds(-i, -i2, i, i2);
            float width = ((this.Nj.getWidth() - this.Nj.getPaddingLeft()) - this.Nj.getPaddingRight()) / max;
            int save = canvas.save();
            canvas.translate(this.Nj.getPaddingLeft(), this.Nj.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.Nk.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }
}
