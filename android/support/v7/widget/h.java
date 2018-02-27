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
    private final SeekBar Ne;
    private Drawable Nf;
    private ColorStateList Ng;
    private PorterDuff.Mode Nh;
    private boolean Ni;
    private boolean Nj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SeekBar seekBar) {
        super(seekBar);
        this.Ng = null;
        this.Nh = null;
        this.Ni = false;
        this.Nj = false;
        this.Ne = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.g
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.Ne.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.Ne.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.Nh = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.Nh);
            this.Nj = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.Ng = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.Ni = true;
        }
        obtainStyledAttributes.recycle();
        fN();
    }

    void setTickMark(Drawable drawable) {
        if (this.Nf != null) {
            this.Nf.setCallback(null);
        }
        this.Nf = drawable;
        if (drawable != null) {
            drawable.setCallback(this.Ne);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.Ne));
            if (drawable.isStateful()) {
                drawable.setState(this.Ne.getDrawableState());
            }
            fN();
        }
        this.Ne.invalidate();
    }

    private void fN() {
        if (this.Nf != null) {
            if (this.Ni || this.Nj) {
                this.Nf = DrawableCompat.wrap(this.Nf.mutate());
                if (this.Ni) {
                    DrawableCompat.setTintList(this.Nf, this.Ng);
                }
                if (this.Nj) {
                    DrawableCompat.setTintMode(this.Nf, this.Nh);
                }
                if (this.Nf.isStateful()) {
                    this.Nf.setState(this.Ne.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jumpDrawablesToCurrentState() {
        if (this.Nf != null) {
            this.Nf.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawableStateChanged() {
        Drawable drawable = this.Nf;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.Ne.getDrawableState())) {
            this.Ne.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Canvas canvas) {
        int max;
        if (this.Nf != null && (max = this.Ne.getMax()) > 1) {
            int intrinsicWidth = this.Nf.getIntrinsicWidth();
            int intrinsicHeight = this.Nf.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.Nf.setBounds(-i, -i2, i, i2);
            float width = ((this.Ne.getWidth() - this.Ne.getPaddingLeft()) - this.Ne.getPaddingRight()) / max;
            int save = canvas.save();
            canvas.translate(this.Ne.getPaddingLeft(), this.Ne.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.Nf.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }
}
