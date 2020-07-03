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
/* loaded from: classes11.dex */
public class EfficientProgressBar extends View {
    private int cAe;
    private int cAf;
    private int cAg;
    private long cAh;
    private Transformation cAi;
    private AnimationSet cAj;
    private float cAk;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cAg = gt(66);
        this.cAh = -1L;
        this.cAi = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cAk = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAg = gt(66);
        this.cAh = -1L;
        this.cAi = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cAk = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAg = gt(66);
        this.cAh = -1L;
        this.cAi = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cAk = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || gu(this.cAe) != 100) {
            this.cAe = gt(i);
            if (i == 100) {
                if (this.cAj == null) {
                    eO(z);
                }
            } else if (this.cAh == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cAf = 0;
        this.cAe = 0;
        this.cAh = -1L;
        this.cAj = null;
        x(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aoK() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cAf) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cAk = f;
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
            if (this.cAj != null) {
                if (this.cAj.getTransformation(getDrawingTime(), this.cAi)) {
                    x((int) (this.cAi.getAlpha() * 10000.0f), false);
                } else {
                    this.cAj = null;
                    reset();
                }
            } else if (this.cAh != -1 && this.cAf < this.cAg) {
                long currentTimeMillis = System.currentTimeMillis();
                int bm = bm(currentTimeMillis - this.cAh);
                this.cAf += bm;
                if (bm != 0) {
                    this.cAh = currentTimeMillis;
                    x(this.cAf, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cAk + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void x(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cAf = i;
        aoK();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cAf = 0;
        this.cAe = 0;
        this.cAj = null;
        this.cAh = System.currentTimeMillis();
        x(this.cAf, false);
        setVisibility(0);
    }

    private void eO(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cAj = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cAf / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cAj.addAnimation(alphaAnimation);
                this.cAi.clear();
                this.cAj.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bm(long j) {
        return (int) ((gt(66) / 1500.0f) * ((float) j));
    }

    private int gt(int i) {
        return i * 100;
    }

    private int gu(int i) {
        return i / 100;
    }
}
