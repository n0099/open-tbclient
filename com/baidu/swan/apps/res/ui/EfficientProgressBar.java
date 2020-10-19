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
    private int cZn;
    private int cZo;
    private int cZp;
    private long cZq;
    private Transformation cZr;
    private AnimationSet cZs;
    private float cZt;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cZp = jp(66);
        this.cZq = -1L;
        this.cZr = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cZt = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZp = jp(66);
        this.cZq = -1L;
        this.cZr = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cZt = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZp = jp(66);
        this.cZq = -1L;
        this.cZr = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cZt = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || jq(this.cZn) != 100) {
            this.cZn = jp(i);
            if (i == 100) {
                if (this.cZs == null) {
                    fL(z);
                }
            } else if (this.cZq == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cZo = 0;
        this.cZn = 0;
        this.cZq = -1L;
        this.cZs = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aBQ() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cZo) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cZt = f;
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
            if (this.cZs != null) {
                if (this.cZs.getTransformation(getDrawingTime(), this.cZr)) {
                    A((int) (this.cZr.getAlpha() * 10000.0f), false);
                } else {
                    this.cZs = null;
                    reset();
                }
            } else if (this.cZq != -1 && this.cZo < this.cZp) {
                long currentTimeMillis = System.currentTimeMillis();
                int bN = bN(currentTimeMillis - this.cZq);
                this.cZo += bN;
                if (bN != 0) {
                    this.cZq = currentTimeMillis;
                    A(this.cZo, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cZt + getPaddingLeft(), 0.0f, getWidth(), getHeight());
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
        this.cZo = i;
        aBQ();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cZo = 0;
        this.cZn = 0;
        this.cZs = null;
        this.cZq = System.currentTimeMillis();
        A(this.cZo, false);
        setVisibility(0);
    }

    private void fL(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cZs = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cZo / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cZs.addAnimation(alphaAnimation);
                this.cZr.clear();
                this.cZs.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bN(long j) {
        return (int) ((jp(66) / 1500.0f) * ((float) j));
    }

    private int jp(int i) {
        return i * 100;
    }

    private int jq(int i) {
        return i / 100;
    }
}
