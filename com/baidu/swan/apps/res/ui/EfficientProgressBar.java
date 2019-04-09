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
/* loaded from: classes2.dex */
public class EfficientProgressBar extends View {
    private int aGP;
    private int aGQ;
    private int aGR;
    private long aGS;
    private Transformation aGT;
    private AnimationSet aGU;
    private Drawable aGV;
    private float aGW;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aGR = cM(66);
        this.aGS = -1L;
        this.aGT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGW = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGR = cM(66);
        this.aGS = -1L;
        this.aGT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGW = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGR = cM(66);
        this.aGS = -1L;
        this.aGT = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGW = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aGV = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cN(this.aGP) != 100) {
            this.aGP = cM(i);
            if (i == 100) {
                if (this.aGU == null) {
                    bA(z);
                }
            } else if (this.aGS == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aGQ = 0;
        this.aGP = 0;
        this.aGS = -1L;
        this.aGU = null;
        i(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void GW() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aGQ) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aGW = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aGV == null ? 0 : this.aGV.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aGV != null) {
            this.aGV.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aGV != null) {
            if (this.aGU != null) {
                if (this.aGU.getTransformation(getDrawingTime(), this.aGT)) {
                    i((int) (this.aGT.getAlpha() * 10000.0f), false);
                } else {
                    this.aGU = null;
                    reset();
                }
            } else if (this.aGS != -1 && this.aGQ < this.aGR) {
                long currentTimeMillis = System.currentTimeMillis();
                int D = D(currentTimeMillis - this.aGS);
                this.aGQ += D;
                if (D != 0) {
                    this.aGS = currentTimeMillis;
                    i(this.aGQ, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aGW + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aGV.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void i(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aGQ = i;
        GW();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aGQ = 0;
        this.aGP = 0;
        this.aGU = null;
        this.aGS = System.currentTimeMillis();
        i(this.aGQ, false);
        setVisibility(0);
    }

    private void bA(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aGU = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aGQ / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aGU.addAnimation(alphaAnimation);
                this.aGT.clear();
                this.aGU.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int D(long j) {
        return (int) ((cM(66) / 1500.0f) * ((float) j));
    }

    private int cM(int i) {
        return i * 100;
    }

    private int cN(int i) {
        return i / 100;
    }
}
