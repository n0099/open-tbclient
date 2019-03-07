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
    private int aGK;
    private int aGL;
    private int aGM;
    private long aGN;
    private Transformation aGO;
    private AnimationSet aGP;
    private Drawable aGQ;
    private float aGR;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aGM = cN(66);
        this.aGN = -1L;
        this.aGO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGR = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGM = cN(66);
        this.aGN = -1L;
        this.aGO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGR = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGM = cN(66);
        this.aGN = -1L;
        this.aGO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aGR = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aGQ = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cO(this.aGK) != 100) {
            this.aGK = cN(i);
            if (i == 100) {
                if (this.aGP == null) {
                    bA(z);
                }
            } else if (this.aGN == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aGL = 0;
        this.aGK = 0;
        this.aGN = -1L;
        this.aGP = null;
        i(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void GY() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aGL) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aGR = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aGQ == null ? 0 : this.aGQ.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aGQ != null) {
            this.aGQ.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aGQ != null) {
            if (this.aGP != null) {
                if (this.aGP.getTransformation(getDrawingTime(), this.aGO)) {
                    i((int) (this.aGO.getAlpha() * 10000.0f), false);
                } else {
                    this.aGP = null;
                    reset();
                }
            } else if (this.aGN != -1 && this.aGL < this.aGM) {
                long currentTimeMillis = System.currentTimeMillis();
                int D = D(currentTimeMillis - this.aGN);
                this.aGL += D;
                if (D != 0) {
                    this.aGN = currentTimeMillis;
                    i(this.aGL, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aGR + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aGQ.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void i(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aGL = i;
        GY();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aGL = 0;
        this.aGK = 0;
        this.aGP = null;
        this.aGN = System.currentTimeMillis();
        i(this.aGL, false);
        setVisibility(0);
    }

    private void bA(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aGP = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aGL / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aGP.addAnimation(alphaAnimation);
                this.aGO.clear();
                this.aGP.start();
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
