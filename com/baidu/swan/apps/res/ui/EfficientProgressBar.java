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
/* loaded from: classes25.dex */
public class EfficientProgressBar extends View {
    private int dtd;
    private int dte;
    private int dtf;
    private long dtg;
    private Transformation dth;
    private AnimationSet dti;
    private Drawable dtj;
    private float dtk;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dtf = ke(66);
        this.dtg = -1L;
        this.dth = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtk = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtf = ke(66);
        this.dtg = -1L;
        this.dth = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtk = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtf = ke(66);
        this.dtg = -1L;
        this.dth = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dtk = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.dtj = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || kf(this.dtd) != 100) {
            this.dtd = ke(i);
            if (i == 100) {
                if (this.dti == null) {
                    gz(z);
                }
            } else if (this.dtg == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dte = 0;
        this.dtd = 0;
        this.dtg = -1L;
        this.dti = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aIK() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dte) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dtk = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.dtj == null ? 0 : this.dtj.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.dtj != null) {
            this.dtj.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.dtj != null) {
            if (this.dti != null) {
                if (this.dti.getTransformation(getDrawingTime(), this.dth)) {
                    A((int) (this.dth.getAlpha() * 10000.0f), false);
                } else {
                    this.dti = null;
                    reset();
                }
            } else if (this.dtg != -1 && this.dte < this.dtf) {
                long currentTimeMillis = System.currentTimeMillis();
                int cK = cK(currentTimeMillis - this.dtg);
                this.dte += cK;
                if (cK != 0) {
                    this.dtg = currentTimeMillis;
                    A(this.dte, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dtk + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.dtj.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dte = i;
        aIK();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dte = 0;
        this.dtd = 0;
        this.dti = null;
        this.dtg = System.currentTimeMillis();
        A(this.dte, false);
        setVisibility(0);
    }

    private void gz(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dti = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dte / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dti.addAnimation(alphaAnimation);
                this.dth.clear();
                this.dti.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cK(long j) {
        return (int) ((ke(66) / 1500.0f) * ((float) j));
    }

    private int ke(int i) {
        return i * 100;
    }

    private int kf(int i) {
        return i / 100;
    }
}
