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
/* loaded from: classes7.dex */
public class EfficientProgressBar extends View {
    private int cCR;
    private int cCS;
    private int cCT;
    private long cCU;
    private Transformation cCV;
    private AnimationSet cCW;
    private float cCX;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cCT = gC(66);
        this.cCU = -1L;
        this.cCV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cCX = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCT = gC(66);
        this.cCU = -1L;
        this.cCV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cCX = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCT = gC(66);
        this.cCU = -1L;
        this.cCV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cCX = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || gD(this.cCR) != 100) {
            this.cCR = gC(i);
            if (i == 100) {
                if (this.cCW == null) {
                    eX(z);
                }
            } else if (this.cCU == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cCS = 0;
        this.cCR = 0;
        this.cCU = -1L;
        this.cCW = null;
        w(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aqu() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cCS) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cCX = f;
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
            if (this.cCW != null) {
                if (this.cCW.getTransformation(getDrawingTime(), this.cCV)) {
                    w((int) (this.cCV.getAlpha() * 10000.0f), false);
                } else {
                    this.cCW = null;
                    reset();
                }
            } else if (this.cCU != -1 && this.cCS < this.cCT) {
                long currentTimeMillis = System.currentTimeMillis();
                int bx = bx(currentTimeMillis - this.cCU);
                this.cCS += bx;
                if (bx != 0) {
                    this.cCU = currentTimeMillis;
                    w(this.cCS, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cCX + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void w(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cCS = i;
        aqu();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cCS = 0;
        this.cCR = 0;
        this.cCW = null;
        this.cCU = System.currentTimeMillis();
        w(this.cCS, false);
        setVisibility(0);
    }

    private void eX(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cCW = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cCS / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cCW.addAnimation(alphaAnimation);
                this.cCV.clear();
                this.cCW.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bx(long j) {
        return (int) ((gC(66) / 1500.0f) * ((float) j));
    }

    private int gC(int i) {
        return i * 100;
    }

    private int gD(int i) {
        return i / 100;
    }
}
