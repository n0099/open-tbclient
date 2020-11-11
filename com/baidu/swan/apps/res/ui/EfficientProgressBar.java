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
/* loaded from: classes10.dex */
public class EfficientProgressBar extends View {
    private int dnK;
    private int dnL;
    private int dnM;
    private long dnN;
    private Transformation dnO;
    private AnimationSet dnP;
    private float dnQ;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dnM = jK(66);
        this.dnN = -1L;
        this.dnO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dnQ = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dnM = jK(66);
        this.dnN = -1L;
        this.dnO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dnQ = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dnM = jK(66);
        this.dnN = -1L;
        this.dnO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dnQ = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || jL(this.dnK) != 100) {
            this.dnK = jK(i);
            if (i == 100) {
                if (this.dnP == null) {
                    gh(z);
                }
            } else if (this.dnN == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dnL = 0;
        this.dnK = 0;
        this.dnN = -1L;
        this.dnP = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aGk() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dnL) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dnQ = f;
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
            if (this.dnP != null) {
                if (this.dnP.getTransformation(getDrawingTime(), this.dnO)) {
                    A((int) (this.dnO.getAlpha() * 10000.0f), false);
                } else {
                    this.dnP = null;
                    reset();
                }
            } else if (this.dnN != -1 && this.dnL < this.dnM) {
                long currentTimeMillis = System.currentTimeMillis();
                int cl = cl(currentTimeMillis - this.dnN);
                this.dnL += cl;
                if (cl != 0) {
                    this.dnN = currentTimeMillis;
                    A(this.dnL, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dnQ + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void A(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.dnL = i;
        aGk();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dnL = 0;
        this.dnK = 0;
        this.dnP = null;
        this.dnN = System.currentTimeMillis();
        A(this.dnL, false);
        setVisibility(0);
    }

    private void gh(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dnP = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dnL / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dnP.addAnimation(alphaAnimation);
                this.dnO.clear();
                this.dnP.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cl(long j) {
        return (int) ((jK(66) / 1500.0f) * ((float) j));
    }

    private int jK(int i) {
        return i * 100;
    }

    private int jL(int i) {
        return i / 100;
    }
}
