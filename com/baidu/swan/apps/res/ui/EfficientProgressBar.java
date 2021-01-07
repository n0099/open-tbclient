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
/* loaded from: classes9.dex */
public class EfficientProgressBar extends View {
    private int dyD;
    private int dyE;
    private int dyF;
    private long dyG;
    private Transformation dyH;
    private AnimationSet dyI;
    private Drawable dyJ;
    private float dyK;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dyF = kb(66);
        this.dyG = -1L;
        this.dyH = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dyK = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyF = kb(66);
        this.dyG = -1L;
        this.dyH = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dyK = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyF = kb(66);
        this.dyG = -1L;
        this.dyH = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dyK = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.dyJ = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || kc(this.dyD) != 100) {
            this.dyD = kb(i);
            if (i == 100) {
                if (this.dyI == null) {
                    gI(z);
                }
            } else if (this.dyG == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dyE = 0;
        this.dyD = 0;
        this.dyG = -1L;
        this.dyI = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aKk() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dyE) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dyK = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.dyJ == null ? 0 : this.dyJ.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.dyJ != null) {
            this.dyJ.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.dyJ != null) {
            if (this.dyI != null) {
                if (this.dyI.getTransformation(getDrawingTime(), this.dyH)) {
                    A((int) (this.dyH.getAlpha() * 10000.0f), false);
                } else {
                    this.dyI = null;
                    reset();
                }
            } else if (this.dyG != -1 && this.dyE < this.dyF) {
                long currentTimeMillis = System.currentTimeMillis();
                int cL = cL(currentTimeMillis - this.dyG);
                this.dyE += cL;
                if (cL != 0) {
                    this.dyG = currentTimeMillis;
                    A(this.dyE, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dyK + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.dyJ.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dyE = i;
        aKk();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dyE = 0;
        this.dyD = 0;
        this.dyI = null;
        this.dyG = System.currentTimeMillis();
        A(this.dyE, false);
        setVisibility(0);
    }

    private void gI(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dyI = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dyE / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dyI.addAnimation(alphaAnimation);
                this.dyH.clear();
                this.dyI.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cL(long j) {
        return (int) ((kb(66) / 1500.0f) * ((float) j));
    }

    private int kb(int i) {
        return i * 100;
    }

    private int kc(int i) {
        return i / 100;
    }
}
