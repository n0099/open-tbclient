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
    private int aII;
    private int aIJ;
    private int aIK;
    private long aIL;
    private Transformation aIM;
    private AnimationSet aIN;
    private Drawable aIO;
    private float aIP;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aIK = cR(66);
        this.aIL = -1L;
        this.aIM = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aIP = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIK = cR(66);
        this.aIL = -1L;
        this.aIM = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aIP = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIK = cR(66);
        this.aIL = -1L;
        this.aIM = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aIP = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aIO = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cS(this.aII) != 100) {
            this.aII = cR(i);
            if (i == 100) {
                if (this.aIN == null) {
                    bJ(z);
                }
            } else if (this.aIL == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aIJ = 0;
        this.aII = 0;
        this.aIL = -1L;
        this.aIN = null;
        m(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void Jm() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aIJ) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aIP = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aIO == null ? 0 : this.aIO.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aIO != null) {
            this.aIO.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aIO != null) {
            if (this.aIN != null) {
                if (this.aIN.getTransformation(getDrawingTime(), this.aIM)) {
                    m((int) (this.aIM.getAlpha() * 10000.0f), false);
                } else {
                    this.aIN = null;
                    reset();
                }
            } else if (this.aIL != -1 && this.aIJ < this.aIK) {
                long currentTimeMillis = System.currentTimeMillis();
                int P = P(currentTimeMillis - this.aIL);
                this.aIJ += P;
                if (P != 0) {
                    this.aIL = currentTimeMillis;
                    m(this.aIJ, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aIP + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aIO.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void m(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aIJ = i;
        Jm();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aIJ = 0;
        this.aII = 0;
        this.aIN = null;
        this.aIL = System.currentTimeMillis();
        m(this.aIJ, false);
        setVisibility(0);
    }

    private void bJ(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aIN = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aIJ / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aIN.addAnimation(alphaAnimation);
                this.aIM.clear();
                this.aIN.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int P(long j) {
        return (int) ((cR(66) / 1500.0f) * ((float) j));
    }

    private int cR(int i) {
        return i * 100;
    }

    private int cS(int i) {
        return i / 100;
    }
}
