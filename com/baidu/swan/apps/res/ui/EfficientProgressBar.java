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
    private int cLk;
    private int cLl;
    private int cLm;
    private long cLn;
    private Transformation cLo;
    private AnimationSet cLp;
    private float cLq;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cLm = iI(66);
        this.cLn = -1L;
        this.cLo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLq = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLm = iI(66);
        this.cLn = -1L;
        this.cLo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLq = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLm = iI(66);
        this.cLn = -1L;
        this.cLo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLq = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iJ(this.cLk) != 100) {
            this.cLk = iI(i);
            if (i == 100) {
                if (this.cLp == null) {
                    fr(z);
                }
            } else if (this.cLn == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cLl = 0;
        this.cLk = 0;
        this.cLn = -1L;
        this.cLp = null;
        y(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void ayy() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cLl) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cLq = f;
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
            if (this.cLp != null) {
                if (this.cLp.getTransformation(getDrawingTime(), this.cLo)) {
                    y((int) (this.cLo.getAlpha() * 10000.0f), false);
                } else {
                    this.cLp = null;
                    reset();
                }
            } else if (this.cLn != -1 && this.cLl < this.cLm) {
                long currentTimeMillis = System.currentTimeMillis();
                int bE = bE(currentTimeMillis - this.cLn);
                this.cLl += bE;
                if (bE != 0) {
                    this.cLn = currentTimeMillis;
                    y(this.cLl, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cLq + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void y(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cLl = i;
        ayy();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cLl = 0;
        this.cLk = 0;
        this.cLp = null;
        this.cLn = System.currentTimeMillis();
        y(this.cLl, false);
        setVisibility(0);
    }

    private void fr(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cLp = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cLl / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cLp.addAnimation(alphaAnimation);
                this.cLo.clear();
                this.cLp.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bE(long j) {
        return (int) ((iI(66) / 1500.0f) * ((float) j));
    }

    private int iI(int i) {
        return i * 100;
    }

    private int iJ(int i) {
        return i / 100;
    }
}
