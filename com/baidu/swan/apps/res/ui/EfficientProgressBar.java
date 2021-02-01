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
    private int dwb;
    private int dwc;
    private int dwd;
    private long dwe;
    private Transformation dwf;
    private AnimationSet dwg;
    private Drawable dwh;
    private float dwi;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dwd = iy(66);
        this.dwe = -1L;
        this.dwf = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dwi = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwd = iy(66);
        this.dwe = -1L;
        this.dwf = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dwi = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwd = iy(66);
        this.dwe = -1L;
        this.dwf = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dwi = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.dwh = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || iz(this.dwb) != 100) {
            this.dwb = iy(i);
            if (i == 100) {
                if (this.dwg == null) {
                    gG(z);
                }
            } else if (this.dwe == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dwc = 0;
        this.dwb = 0;
        this.dwe = -1L;
        this.dwg = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aGL() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dwc) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dwi = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.dwh == null ? 0 : this.dwh.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.dwh != null) {
            this.dwh.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.dwh != null) {
            if (this.dwg != null) {
                if (this.dwg.getTransformation(getDrawingTime(), this.dwf)) {
                    A((int) (this.dwf.getAlpha() * 10000.0f), false);
                } else {
                    this.dwg = null;
                    reset();
                }
            } else if (this.dwe != -1 && this.dwc < this.dwd) {
                long currentTimeMillis = System.currentTimeMillis();
                int cR = cR(currentTimeMillis - this.dwe);
                this.dwc += cR;
                if (cR != 0) {
                    this.dwe = currentTimeMillis;
                    A(this.dwc, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dwi + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.dwh.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dwc = i;
        aGL();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dwc = 0;
        this.dwb = 0;
        this.dwg = null;
        this.dwe = System.currentTimeMillis();
        A(this.dwc, false);
        setVisibility(0);
    }

    private void gG(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dwg = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dwc / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dwg.addAnimation(alphaAnimation);
                this.dwf.clear();
                this.dwg.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cR(long j) {
        return (int) ((iy(66) / 1500.0f) * ((float) j));
    }

    private int iy(int i) {
        return i * 100;
    }

    private int iz(int i) {
        return i / 100;
    }
}
