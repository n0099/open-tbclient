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
/* loaded from: classes3.dex */
public class EfficientProgressBar extends View {
    private int cNk;
    private int cNl;
    private int cNm;
    private long cNn;
    private Transformation cNo;
    private AnimationSet cNp;
    private float cNq;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cNm = iS(66);
        this.cNn = -1L;
        this.cNo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cNq = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNm = iS(66);
        this.cNn = -1L;
        this.cNo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cNq = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNm = iS(66);
        this.cNn = -1L;
        this.cNo = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cNq = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iT(this.cNk) != 100) {
            this.cNk = iS(i);
            if (i == 100) {
                if (this.cNp == null) {
                    fp(z);
                }
            } else if (this.cNn == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cNl = 0;
        this.cNk = 0;
        this.cNn = -1L;
        this.cNp = null;
        y(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void azh() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cNl) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cNq = f;
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
            if (this.cNp != null) {
                if (this.cNp.getTransformation(getDrawingTime(), this.cNo)) {
                    y((int) (this.cNo.getAlpha() * 10000.0f), false);
                } else {
                    this.cNp = null;
                    reset();
                }
            } else if (this.cNn != -1 && this.cNl < this.cNm) {
                long currentTimeMillis = System.currentTimeMillis();
                int bF = bF(currentTimeMillis - this.cNn);
                this.cNl += bF;
                if (bF != 0) {
                    this.cNn = currentTimeMillis;
                    y(this.cNl, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cNq + getPaddingLeft(), 0.0f, getWidth(), getHeight());
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
        this.cNl = i;
        azh();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cNl = 0;
        this.cNk = 0;
        this.cNp = null;
        this.cNn = System.currentTimeMillis();
        y(this.cNl, false);
        setVisibility(0);
    }

    private void fp(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cNp = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cNl / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cNp.addAnimation(alphaAnimation);
                this.cNo.clear();
                this.cNp.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bF(long j) {
        return (int) ((iS(66) / 1500.0f) * ((float) j));
    }

    private int iS(int i) {
        return i * 100;
    }

    private int iT(int i) {
        return i / 100;
    }
}
