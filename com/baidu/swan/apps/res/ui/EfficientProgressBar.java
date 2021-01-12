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
/* loaded from: classes8.dex */
public class EfficientProgressBar extends View {
    private int dtR;
    private int dtS;
    private int dtT;
    private long dtU;
    private Transformation dtV;
    private AnimationSet dtW;
    private Drawable dtX;
    private float dtY;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dtT = iv(66);
        this.dtU = -1L;
        this.dtV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtY = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtT = iv(66);
        this.dtU = -1L;
        this.dtV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtY = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtT = iv(66);
        this.dtU = -1L;
        this.dtV = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtY = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.dtX = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iw(this.dtR) != 100) {
            this.dtR = iv(i);
            if (i == 100) {
                if (this.dtW == null) {
                    gE(z);
                }
            } else if (this.dtU == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dtS = 0;
        this.dtR = 0;
        this.dtU = -1L;
        this.dtW = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aGq() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dtS) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dtY = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.dtX == null ? 0 : this.dtX.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.dtX != null) {
            this.dtX.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.dtX != null) {
            if (this.dtW != null) {
                if (this.dtW.getTransformation(getDrawingTime(), this.dtV)) {
                    A((int) (this.dtV.getAlpha() * 10000.0f), false);
                } else {
                    this.dtW = null;
                    reset();
                }
            } else if (this.dtU != -1 && this.dtS < this.dtT) {
                long currentTimeMillis = System.currentTimeMillis();
                int cL = cL(currentTimeMillis - this.dtU);
                this.dtS += cL;
                if (cL != 0) {
                    this.dtU = currentTimeMillis;
                    A(this.dtS, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dtY + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.dtX.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dtS = i;
        aGq();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dtS = 0;
        this.dtR = 0;
        this.dtW = null;
        this.dtU = System.currentTimeMillis();
        A(this.dtS, false);
        setVisibility(0);
    }

    private void gE(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dtW = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dtS / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dtW.addAnimation(alphaAnimation);
                this.dtV.clear();
                this.dtW.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cL(long j) {
        return (int) ((iv(66) / 1500.0f) * ((float) j));
    }

    private int iv(int i) {
        return i * 100;
    }

    private int iw(int i) {
        return i / 100;
    }
}
