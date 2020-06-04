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
    private int cvt;
    private int cvu;
    private int cvv;
    private long cvw;
    private Transformation cvx;
    private AnimationSet cvy;
    private float cvz;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.cvv = gh(66);
        this.cvw = -1L;
        this.cvx = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cvz = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvv = gh(66);
        this.cvw = -1L;
        this.cvx = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cvz = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvv = gh(66);
        this.cvw = -1L;
        this.cvx = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.cvz = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || gi(this.cvt) != 100) {
            this.cvt = gh(i);
            if (i == 100) {
                if (this.cvy == null) {
                    eJ(z);
                }
            } else if (this.cvw == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.cvu = 0;
        this.cvt = 0;
        this.cvw = -1L;
        this.cvy = null;
        w(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void anE() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.cvu) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.cvz = f;
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
            if (this.cvy != null) {
                if (this.cvy.getTransformation(getDrawingTime(), this.cvx)) {
                    w((int) (this.cvx.getAlpha() * 10000.0f), false);
                } else {
                    this.cvy = null;
                    reset();
                }
            } else if (this.cvw != -1 && this.cvu < this.cvv) {
                long currentTimeMillis = System.currentTimeMillis();
                int bm = bm(currentTimeMillis - this.cvw);
                this.cvu += bm;
                if (bm != 0) {
                    this.cvw = currentTimeMillis;
                    w(this.cvu, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.cvz + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void w(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.cvu = i;
        anE();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.cvu = 0;
        this.cvt = 0;
        this.cvy = null;
        this.cvw = System.currentTimeMillis();
        w(this.cvu, false);
        setVisibility(0);
    }

    private void eJ(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.cvy = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.cvu / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.cvy.addAnimation(alphaAnimation);
                this.cvx.clear();
                this.cvy.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int bm(long j) {
        return (int) ((gh(66) / 1500.0f) * ((float) j));
    }

    private int gh(int i) {
        return i * 100;
    }

    private int gi(int i) {
        return i / 100;
    }
}
