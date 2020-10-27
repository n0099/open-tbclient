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
/* loaded from: classes10.dex */
public class EfficientProgressBar extends View {
    private int dhO;
    private int dhP;
    private int dhQ;
    private long dhR;
    private Transformation dhS;
    private AnimationSet dhT;
    private float dhU;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dhQ = jA(66);
        this.dhR = -1L;
        this.dhS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dhU = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhQ = jA(66);
        this.dhR = -1L;
        this.dhS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dhU = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhQ = jA(66);
        this.dhR = -1L;
        this.dhS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dhU = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || jB(this.dhO) != 100) {
            this.dhO = jA(i);
            if (i == 100) {
                if (this.dhT == null) {
                    fY(z);
                }
            } else if (this.dhR == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dhP = 0;
        this.dhO = 0;
        this.dhR = -1L;
        this.dhT = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aDK() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dhP) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dhU = f;
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
            if (this.dhT != null) {
                if (this.dhT.getTransformation(getDrawingTime(), this.dhS)) {
                    A((int) (this.dhS.getAlpha() * 10000.0f), false);
                } else {
                    this.dhT = null;
                    reset();
                }
            } else if (this.dhR != -1 && this.dhP < this.dhQ) {
                long currentTimeMillis = System.currentTimeMillis();
                int bP = bP(currentTimeMillis - this.dhR);
                this.dhP += bP;
                if (bP != 0) {
                    this.dhR = currentTimeMillis;
                    A(this.dhP, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dhU + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dhP = i;
        aDK();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dhP = 0;
        this.dhO = 0;
        this.dhT = null;
        this.dhR = System.currentTimeMillis();
        A(this.dhP, false);
        setVisibility(0);
    }

    private void fY(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dhT = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dhP / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dhT.addAnimation(alphaAnimation);
                this.dhS.clear();
                this.dhT.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bP(long j) {
        return (int) ((jA(66) / 1500.0f) * ((float) j));
    }

    private int jA(int i) {
        return i * 100;
    }

    private int jB(int i) {
        return i / 100;
    }
}
