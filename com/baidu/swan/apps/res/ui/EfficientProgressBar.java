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
    private int bFW;
    private int bFX;
    private int bFY;
    private long bFZ;
    private Transformation bGa;
    private AnimationSet bGb;
    private Drawable bGc;
    private float bGd;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bFY = fq(66);
        this.bFZ = -1L;
        this.bGa = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGd = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFY = fq(66);
        this.bFZ = -1L;
        this.bGa = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGd = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFY = fq(66);
        this.bFZ = -1L;
        this.bGa = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGd = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.bGc = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fr(this.bFW) != 100) {
            this.bFW = fq(i);
            if (i == 100) {
                if (this.bGb == null) {
                    dh(z);
                }
            } else if (this.bFZ == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bFX = 0;
        this.bFW = 0;
        this.bFZ = -1L;
        this.bGb = null;
        r(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void YW() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bFX) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bGd = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.bGc == null ? 0 : this.bGc.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.bGc != null) {
            this.bGc.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.bGc != null) {
            if (this.bGb != null) {
                if (this.bGb.getTransformation(getDrawingTime(), this.bGa)) {
                    r((int) (this.bGa.getAlpha() * 10000.0f), false);
                } else {
                    this.bGb = null;
                    reset();
                }
            } else if (this.bFZ != -1 && this.bFX < this.bFY) {
                long currentTimeMillis = System.currentTimeMillis();
                int aq = aq(currentTimeMillis - this.bFZ);
                this.bFX += aq;
                if (aq != 0) {
                    this.bFZ = currentTimeMillis;
                    r(this.bFX, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bGd + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.bGc.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void r(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.bFX = i;
        YW();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bFX = 0;
        this.bFW = 0;
        this.bGb = null;
        this.bFZ = System.currentTimeMillis();
        r(this.bFX, false);
        setVisibility(0);
    }

    private void dh(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bGb = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bFX / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bGb.addAnimation(alphaAnimation);
                this.bGa.clear();
                this.bGb.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int aq(long j) {
        return (int) ((fq(66) / 1500.0f) * ((float) j));
    }

    private int fq(int i) {
        return i * 100;
    }

    private int fr(int i) {
        return i / 100;
    }
}
