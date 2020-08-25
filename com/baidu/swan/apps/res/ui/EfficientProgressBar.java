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
    private int cLg;
    private int cLh;
    private int cLi;
    private long cLj;
    private Transformation cLk;
    private AnimationSet cLl;
    private float cLm;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cLi = iI(66);
        this.cLj = -1L;
        this.cLk = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLm = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLi = iI(66);
        this.cLj = -1L;
        this.cLk = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLm = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLi = iI(66);
        this.cLj = -1L;
        this.cLk = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cLm = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iJ(this.cLg) != 100) {
            this.cLg = iI(i);
            if (i == 100) {
                if (this.cLl == null) {
                    fq(z);
                }
            } else if (this.cLj == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cLh = 0;
        this.cLg = 0;
        this.cLj = -1L;
        this.cLl = null;
        y(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void ayy() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cLh) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cLm = f;
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
            if (this.cLl != null) {
                if (this.cLl.getTransformation(getDrawingTime(), this.cLk)) {
                    y((int) (this.cLk.getAlpha() * 10000.0f), false);
                } else {
                    this.cLl = null;
                    reset();
                }
            } else if (this.cLj != -1 && this.cLh < this.cLi) {
                long currentTimeMillis = System.currentTimeMillis();
                int bE = bE(currentTimeMillis - this.cLj);
                this.cLh += bE;
                if (bE != 0) {
                    this.cLj = currentTimeMillis;
                    y(this.cLh, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cLm + getPaddingLeft(), 0.0f, getWidth(), getHeight());
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
        this.cLh = i;
        ayy();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cLh = 0;
        this.cLg = 0;
        this.cLl = null;
        this.cLj = System.currentTimeMillis();
        y(this.cLh, false);
        setVisibility(0);
    }

    private void fq(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cLl = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cLh / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cLl.addAnimation(alphaAnimation);
                this.cLk.clear();
                this.cLl.start();
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
