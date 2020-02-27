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
    private int bKM;
    private int bKN;
    private int bKO;
    private long bKP;
    private Transformation bKQ;
    private AnimationSet bKR;
    private float bKS;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bKO = fH(66);
        this.bKP = -1L;
        this.bKQ = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bKS = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKO = fH(66);
        this.bKP = -1L;
        this.bKQ = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bKS = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKO = fH(66);
        this.bKP = -1L;
        this.bKQ = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bKS = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fI(this.bKM) != 100) {
            this.bKM = fH(i);
            if (i == 100) {
                if (this.bKR == null) {
                    dt(z);
                }
            } else if (this.bKP == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bKN = 0;
        this.bKM = 0;
        this.bKP = -1L;
        this.bKR = null;
        r(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void abH() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bKN) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bKS = f;
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
            if (this.bKR != null) {
                if (this.bKR.getTransformation(getDrawingTime(), this.bKQ)) {
                    r((int) (this.bKQ.getAlpha() * 10000.0f), false);
                } else {
                    this.bKR = null;
                    reset();
                }
            } else if (this.bKP != -1 && this.bKN < this.bKO) {
                long currentTimeMillis = System.currentTimeMillis();
                int ax = ax(currentTimeMillis - this.bKP);
                this.bKN += ax;
                if (ax != 0) {
                    this.bKP = currentTimeMillis;
                    r(this.bKN, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bKS + getPaddingLeft(), 0.0f, getWidth(), getHeight());
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
        this.bKN = i;
        abH();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bKN = 0;
        this.bKM = 0;
        this.bKR = null;
        this.bKP = System.currentTimeMillis();
        r(this.bKN, false);
        setVisibility(0);
    }

    private void dt(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bKR = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bKN / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bKR.addAnimation(alphaAnimation);
                this.bKQ.clear();
                this.bKR.start();
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
