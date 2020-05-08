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
    private int cjP;
    private int cjQ;
    private int cjR;
    private long cjS;
    private Transformation cjT;
    private AnimationSet cjU;
    private float cjV;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cjR = fO(66);
        this.cjS = -1L;
        this.cjT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjR = fO(66);
        this.cjS = -1L;
        this.cjT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjR = fO(66);
        this.cjS = -1L;
        this.cjT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjV = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fP(this.cjP) != 100) {
            this.cjP = fO(i);
            if (i == 100) {
                if (this.cjU == null) {
                    eq(z);
                }
            } else if (this.cjS == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cjQ = 0;
        this.cjP = 0;
        this.cjS = -1L;
        this.cjU = null;
        v(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void ajQ() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cjQ) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cjV = f;
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
            if (this.cjU != null) {
                if (this.cjU.getTransformation(getDrawingTime(), this.cjT)) {
                    v((int) (this.cjT.getAlpha() * 10000.0f), false);
                } else {
                    this.cjU = null;
                    reset();
                }
            } else if (this.cjS != -1 && this.cjQ < this.cjR) {
                long currentTimeMillis = System.currentTimeMillis();
                int bc = bc(currentTimeMillis - this.cjS);
                this.cjQ += bc;
                if (bc != 0) {
                    this.cjS = currentTimeMillis;
                    v(this.cjQ, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cjV + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void v(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cjQ = i;
        ajQ();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cjQ = 0;
        this.cjP = 0;
        this.cjU = null;
        this.cjS = System.currentTimeMillis();
        v(this.cjQ, false);
        setVisibility(0);
    }

    private void eq(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cjU = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cjQ / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cjU.addAnimation(alphaAnimation);
                this.cjT.clear();
                this.cjU.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bc(long j) {
        return (int) ((fO(66) / 1500.0f) * ((float) j));
    }

    private int fO(int i) {
        return i * 100;
    }

    private int fP(int i) {
        return i / 100;
    }
}
