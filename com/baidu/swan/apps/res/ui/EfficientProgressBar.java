package com.baidu.swan.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* loaded from: classes11.dex */
public class EfficientProgressBar extends View {
    private int bKZ;
    private int bLa;
    private int bLb;
    private long bLc;
    private Transformation bLd;
    private AnimationSet bLe;
    private float bLf;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bLb = fH(66);
        this.bLc = -1L;
        this.bLd = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bLf = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLb = fH(66);
        this.bLc = -1L;
        this.bLd = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bLf = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bLb = fH(66);
        this.bLc = -1L;
        this.bLd = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bLf = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fI(this.bKZ) != 100) {
            this.bKZ = fH(i);
            if (i == 100) {
                if (this.bLe == null) {
                    du(z);
                }
            } else if (this.bLc == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bLa = 0;
        this.bKZ = 0;
        this.bLc = -1L;
        this.bLe = null;
        r(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void abM() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bLa) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bLf = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.mThumb == null ? 0 : this.mThumb.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.mThumb != null) {
            this.mThumb.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mThumb != null) {
            if (this.bLe != null) {
                if (this.bLe.getTransformation(getDrawingTime(), this.bLd)) {
                    r((int) (this.bLd.getAlpha() * 10000.0f), false);
                } else {
                    this.bLe = null;
                    reset();
                }
            } else if (this.bLc != -1 && this.bLa < this.bLb) {
                long currentTimeMillis = System.currentTimeMillis();
                int ax = ax(currentTimeMillis - this.bLc);
                this.bLa += ax;
                if (ax != 0) {
                    this.bLc = currentTimeMillis;
                    r(this.bLa, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bLf + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void r(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.bLa = i;
        abM();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bLa = 0;
        this.bKZ = 0;
        this.bLe = null;
        this.bLc = System.currentTimeMillis();
        r(this.bLa, false);
        setVisibility(0);
    }

    private void du(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bLe = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bLa / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bLe.addAnimation(alphaAnimation);
                this.bLd.clear();
                this.bLe.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int ax(long j) {
        return (int) ((fH(66) / 1500.0f) * ((float) j));
    }

    private int fH(int i) {
        return i * 100;
    }

    private int fI(int i) {
        return i / 100;
    }
}
