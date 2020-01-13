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
    private int bGH;
    private int bGI;
    private int bGJ;
    private long bGK;
    private Transformation bGL;
    private AnimationSet bGM;
    private float bGN;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bGJ = fr(66);
        this.bGK = -1L;
        this.bGL = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGN = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGJ = fr(66);
        this.bGK = -1L;
        this.bGL = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGN = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGJ = fr(66);
        this.bGK = -1L;
        this.bGL = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bGN = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || fs(this.bGH) != 100) {
            this.bGH = fr(i);
            if (i == 100) {
                if (this.bGM == null) {
                    dm(z);
                }
            } else if (this.bGK == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bGI = 0;
        this.bGH = 0;
        this.bGK = -1L;
        this.bGM = null;
        r(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void Zt() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bGI) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bGN = f;
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
            if (this.bGM != null) {
                if (this.bGM.getTransformation(getDrawingTime(), this.bGL)) {
                    r((int) (this.bGL.getAlpha() * 10000.0f), false);
                } else {
                    this.bGM = null;
                    reset();
                }
            } else if (this.bGK != -1 && this.bGI < this.bGJ) {
                long currentTimeMillis = System.currentTimeMillis();
                int at = at(currentTimeMillis - this.bGK);
                this.bGI += at;
                if (at != 0) {
                    this.bGK = currentTimeMillis;
                    r(this.bGI, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bGN + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.mThumb.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void r(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.bGI = i;
        Zt();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bGI = 0;
        this.bGH = 0;
        this.bGM = null;
        this.bGK = System.currentTimeMillis();
        r(this.bGI, false);
        setVisibility(0);
    }

    private void dm(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bGM = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bGI / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bGM.addAnimation(alphaAnimation);
                this.bGL.clear();
                this.bGM.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int at(long j) {
        return (int) ((fr(66) / 1500.0f) * ((float) j));
    }

    private int fr(int i) {
        return i * 100;
    }

    private int fs(int i) {
        return i / 100;
    }
}
