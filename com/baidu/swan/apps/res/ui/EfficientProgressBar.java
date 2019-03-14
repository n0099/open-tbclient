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
    private int aGL;
    private int aGM;
    private int aGN;
    private long aGO;
    private Transformation aGP;
    private AnimationSet aGQ;
    private Drawable aGR;
    private float aGS;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aGN = cN(66);
        this.aGO = -1L;
        this.aGP = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGS = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGN = cN(66);
        this.aGO = -1L;
        this.aGP = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGS = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGN = cN(66);
        this.aGO = -1L;
        this.aGP = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGS = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aGR = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cO(this.aGL) != 100) {
            this.aGL = cN(i);
            if (i == 100) {
                if (this.aGQ == null) {
                    bA(z);
                }
            } else if (this.aGO == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aGM = 0;
        this.aGL = 0;
        this.aGO = -1L;
        this.aGQ = null;
        i(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void GY() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aGM) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aGS = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aGR == null ? 0 : this.aGR.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aGR != null) {
            this.aGR.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aGR != null) {
            if (this.aGQ != null) {
                if (this.aGQ.getTransformation(getDrawingTime(), this.aGP)) {
                    i((int) (this.aGP.getAlpha() * 10000.0f), false);
                } else {
                    this.aGQ = null;
                    reset();
                }
            } else if (this.aGO != -1 && this.aGM < this.aGN) {
                long currentTimeMillis = System.currentTimeMillis();
                int D = D(currentTimeMillis - this.aGO);
                this.aGM += D;
                if (D != 0) {
                    this.aGO = currentTimeMillis;
                    i(this.aGM, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aGS + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aGR.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void i(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aGM = i;
        GY();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aGM = 0;
        this.aGL = 0;
        this.aGQ = null;
        this.aGO = System.currentTimeMillis();
        i(this.aGM, false);
        setVisibility(0);
    }

    private void bA(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aGQ = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aGM / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aGQ.addAnimation(alphaAnimation);
                this.aGP.clear();
                this.aGQ.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int D(long j) {
        return (int) ((cN(66) / 1500.0f) * ((float) j));
    }

    private int cN(int i) {
        return i * 100;
    }

    private int cO(int i) {
        return i / 100;
    }
}
