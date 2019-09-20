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
    private int aJO;
    private int aJP;
    private int aJQ;
    private long aJR;
    private Transformation aJS;
    private AnimationSet aJT;
    private Drawable aJU;
    private float aJV;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aJQ = cV(66);
        this.aJR = -1L;
        this.aJS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJQ = cV(66);
        this.aJR = -1L;
        this.aJS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJV = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJQ = cV(66);
        this.aJR = -1L;
        this.aJS = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJV = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aJU = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cW(this.aJO) != 100) {
            this.aJO = cV(i);
            if (i == 100) {
                if (this.aJT == null) {
                    bM(z);
                }
            } else if (this.aJR == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aJP = 0;
        this.aJO = 0;
        this.aJR = -1L;
        this.aJT = null;
        m(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void Kd() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aJP) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aJV = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aJU == null ? 0 : this.aJU.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aJU != null) {
            this.aJU.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aJU != null) {
            if (this.aJT != null) {
                if (this.aJT.getTransformation(getDrawingTime(), this.aJS)) {
                    m((int) (this.aJS.getAlpha() * 10000.0f), false);
                } else {
                    this.aJT = null;
                    reset();
                }
            } else if (this.aJR != -1 && this.aJP < this.aJQ) {
                long currentTimeMillis = System.currentTimeMillis();
                int P = P(currentTimeMillis - this.aJR);
                this.aJP += P;
                if (P != 0) {
                    this.aJR = currentTimeMillis;
                    m(this.aJP, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aJV + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aJU.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void m(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aJP = i;
        Kd();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aJP = 0;
        this.aJO = 0;
        this.aJT = null;
        this.aJR = System.currentTimeMillis();
        m(this.aJP, false);
        setVisibility(0);
    }

    private void bM(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aJT = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aJP / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aJT.addAnimation(alphaAnimation);
                this.aJS.clear();
                this.aJT.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int P(long j) {
        return (int) ((cV(66) / 1500.0f) * ((float) j));
    }

    private int cV(int i) {
        return i * 100;
    }

    private int cW(int i) {
        return i / 100;
    }
}
