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
/* loaded from: classes7.dex */
public class EfficientProgressBar extends View {
    private int dmc;
    private int dmd;
    private int dme;
    private long dmf;
    private Transformation dmg;
    private AnimationSet dmh;
    private float dmi;
    private Interpolator mInterpolator;
    private Drawable mThumb;

    public EfficientProgressBar(Context context) {
        super(context);
        this.dme = jG(66);
        this.dmf = -1L;
        this.dmg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dmi = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dme = jG(66);
        this.dmf = -1L;
        this.dmg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dmi = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dme = jG(66);
        this.dmf = -1L;
        this.dmg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.dmi = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mThumb = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || jH(this.dmc) != 100) {
            this.dmc = jG(i);
            if (i == 100) {
                if (this.dmh == null) {
                    gk(z);
                }
            } else if (this.dmf == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.dmd = 0;
        this.dmc = 0;
        this.dmf = -1L;
        this.dmh = null;
        A(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void aFC() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.dmd) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.dmi = f;
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
            if (this.dmh != null) {
                if (this.dmh.getTransformation(getDrawingTime(), this.dmg)) {
                    A((int) (this.dmg.getAlpha() * 10000.0f), false);
                } else {
                    this.dmh = null;
                    reset();
                }
            } else if (this.dmf != -1 && this.dmd < this.dme) {
                long currentTimeMillis = System.currentTimeMillis();
                int cl = cl(currentTimeMillis - this.dmf);
                this.dmd += cl;
                if (cl != 0) {
                    this.dmf = currentTimeMillis;
                    A(this.dmd, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.dmi + getPaddingLeft(), 0.0f, getWidth(), getHeight());
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
        this.dmd = i;
        aFC();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.dmd = 0;
        this.dmc = 0;
        this.dmh = null;
        this.dmf = System.currentTimeMillis();
        A(this.dmd, false);
        setVisibility(0);
    }

    private void gk(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.dmh = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.dmd / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.dmh.addAnimation(alphaAnimation);
                this.dmg.clear();
                this.dmh.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int cl(long j) {
        return (int) ((jG(66) / 1500.0f) * ((float) j));
    }

    private int jG(int i) {
        return i * 100;
    }

    private int jH(int i) {
        return i / 100;
    }
}
