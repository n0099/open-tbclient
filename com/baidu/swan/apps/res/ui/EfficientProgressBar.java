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
    private int dxC;
    private int dxD;
    private int dxE;
    private long dxF;
    private Transformation dxG;
    private AnimationSet dxH;
    private Drawable dxI;
    private float dxJ;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dxE = iz(66);
        this.dxF = -1L;
        this.dxG = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dxJ = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxE = iz(66);
        this.dxF = -1L;
        this.dxG = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dxJ = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxE = iz(66);
        this.dxF = -1L;
        this.dxG = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dxJ = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.dxI = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iA(this.dxC) != 100) {
            this.dxC = iz(i);
            if (i == 100) {
                if (this.dxH == null) {
                    gG(z);
                }
            } else if (this.dxF == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dxD = 0;
        this.dxC = 0;
        this.dxF = -1L;
        this.dxH = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aGO() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dxD) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dxJ = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.dxI == null ? 0 : this.dxI.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.dxI != null) {
            this.dxI.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.dxI != null) {
            if (this.dxH != null) {
                if (this.dxH.getTransformation(getDrawingTime(), this.dxG)) {
                    A((int) (this.dxG.getAlpha() * 10000.0f), false);
                } else {
                    this.dxH = null;
                    reset();
                }
            } else if (this.dxF != -1 && this.dxD < this.dxE) {
                long currentTimeMillis = System.currentTimeMillis();
                int cR = cR(currentTimeMillis - this.dxF);
                this.dxD += cR;
                if (cR != 0) {
                    this.dxF = currentTimeMillis;
                    A(this.dxD, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dxJ + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.dxI.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dxD = i;
        aGO();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dxD = 0;
        this.dxC = 0;
        this.dxH = null;
        this.dxF = System.currentTimeMillis();
        A(this.dxD, false);
        setVisibility(0);
    }

    private void gG(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dxH = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dxD / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dxH.addAnimation(alphaAnimation);
                this.dxG.clear();
                this.dxH.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cR(long j) {
        return (int) ((iz(66) / 1500.0f) * ((float) j));
    }

    private int iz(int i) {
        return i * 100;
    }

    private int iA(int i) {
        return i / 100;
    }
}
