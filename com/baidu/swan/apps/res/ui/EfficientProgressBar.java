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
    private int aGO;
    private int aGP;
    private int aGQ;
    private long aGR;
    private Transformation aGS;
    private AnimationSet aGT;
    private Drawable aGU;
    private float aGV;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aGQ = cM(66);
        this.aGR = -1L;
        this.aGS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGQ = cM(66);
        this.aGR = -1L;
        this.aGS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGQ = cM(66);
        this.aGR = -1L;
        this.aGS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGV = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aGU = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cN(this.aGO) != 100) {
            this.aGO = cM(i);
            if (i == 100) {
                if (this.aGT == null) {
                    bA(z);
                }
            } else if (this.aGR == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aGP = 0;
        this.aGO = 0;
        this.aGR = -1L;
        this.aGT = null;
        i(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void GW() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aGP) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aGV = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aGU == null ? 0 : this.aGU.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aGU != null) {
            this.aGU.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aGU != null) {
            if (this.aGT != null) {
                if (this.aGT.getTransformation(getDrawingTime(), this.aGS)) {
                    i((int) (this.aGS.getAlpha() * 10000.0f), false);
                } else {
                    this.aGT = null;
                    reset();
                }
            } else if (this.aGR != -1 && this.aGP < this.aGQ) {
                long currentTimeMillis = System.currentTimeMillis();
                int D = D(currentTimeMillis - this.aGR);
                this.aGP += D;
                if (D != 0) {
                    this.aGR = currentTimeMillis;
                    i(this.aGP, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aGV + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aGU.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void i(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aGP = i;
        GW();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aGP = 0;
        this.aGO = 0;
        this.aGT = null;
        this.aGR = System.currentTimeMillis();
        i(this.aGP, false);
        setVisibility(0);
    }

    private void bA(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aGT = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aGP / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aGT.addAnimation(alphaAnimation);
                this.aGS.clear();
                this.aGT.start();
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
