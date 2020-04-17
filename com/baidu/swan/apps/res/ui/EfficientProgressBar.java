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
    private int cjJ;
    private int cjK;
    private int cjL;
    private long cjM;
    private Transformation cjN;
    private AnimationSet cjO;
    private float cjP;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cjL = fO(66);
        this.cjM = -1L;
        this.cjN = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjP = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjL = fO(66);
        this.cjM = -1L;
        this.cjN = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjP = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjL = fO(66);
        this.cjM = -1L;
        this.cjN = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cjP = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fP(this.cjJ) != 100) {
            this.cjJ = fO(i);
            if (i == 100) {
                if (this.cjO == null) {
                    eq(z);
                }
            } else if (this.cjM == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cjK = 0;
        this.cjJ = 0;
        this.cjM = -1L;
        this.cjO = null;
        v(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void ajR() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cjK) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cjP = f;
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
            if (this.cjO != null) {
                if (this.cjO.getTransformation(getDrawingTime(), this.cjN)) {
                    v((int) (this.cjN.getAlpha() * 10000.0f), false);
                } else {
                    this.cjO = null;
                    reset();
                }
            } else if (this.cjM != -1 && this.cjK < this.cjL) {
                long currentTimeMillis = System.currentTimeMillis();
                int bc = bc(currentTimeMillis - this.cjM);
                this.cjK += bc;
                if (bc != 0) {
                    this.cjM = currentTimeMillis;
                    v(this.cjK, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cjP + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void v(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cjK = i;
        ajR();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cjK = 0;
        this.cjJ = 0;
        this.cjO = null;
        this.cjM = System.currentTimeMillis();
        v(this.cjK, false);
        setVisibility(0);
    }

    private void eq(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cjO = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cjK / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cjO.addAnimation(alphaAnimation);
                this.cjN.clear();
                this.cjO.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bc(long j) {
        return (int) ((fO(66) / 1500.0f) * ((float) j));
    }

    private int fO(int i) {
        return i * 100;
    }

    private int fP(int i) {
        return i / 100;
    }
}
