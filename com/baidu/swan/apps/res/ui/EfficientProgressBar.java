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
/* loaded from: classes2.dex */
public class EfficientProgressBar extends View {
    private int aJq;
    private int aJr;
    private int aJs;
    private long aJt;
    private Transformation aJu;
    private AnimationSet aJv;
    private Drawable aJw;
    private float aJx;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.aJs = cU(66);
        this.aJt = -1L;
        this.aJu = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJx = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJs = cU(66);
        this.aJt = -1L;
        this.aJu = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJx = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJs = cU(66);
        this.aJt = -1L;
        this.aJu = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.aJx = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aJw = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || cV(this.aJq) != 100) {
            this.aJq = cU(i);
            if (i == 100) {
                if (this.aJv == null) {
                    bM(z);
                }
            } else if (this.aJt == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.aJr = 0;
        this.aJq = 0;
        this.aJt = -1L;
        this.aJv = null;
        m(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void JZ() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.aJr) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.aJx = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.aJw == null ? 0 : this.aJw.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.aJw != null) {
            this.aJw.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aJw != null) {
            if (this.aJv != null) {
                if (this.aJv.getTransformation(getDrawingTime(), this.aJu)) {
                    m((int) (this.aJu.getAlpha() * 10000.0f), false);
                } else {
                    this.aJv = null;
                    reset();
                }
            } else if (this.aJt != -1 && this.aJr < this.aJs) {
                long currentTimeMillis = System.currentTimeMillis();
                int P = P(currentTimeMillis - this.aJt);
                this.aJr += P;
                if (P != 0) {
                    this.aJt = currentTimeMillis;
                    m(this.aJr, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.aJx + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.aJw.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void m(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.aJr = i;
        JZ();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.aJr = 0;
        this.aJq = 0;
        this.aJv = null;
        this.aJt = System.currentTimeMillis();
        m(this.aJr, false);
        setVisibility(0);
    }

    private void bM(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.aJv = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.aJr / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.aJv.addAnimation(alphaAnimation);
                this.aJu.clear();
                this.aJv.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int P(long j) {
        return (int) ((cU(66) / 1500.0f) * ((float) j));
    }

    private int cU(int i) {
        return i * 100;
    }

    private int cV(int i) {
        return i / 100;
    }
}
