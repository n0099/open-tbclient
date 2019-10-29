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
    private int bdc;
    private int bdd;
    private int bde;
    private long bdf;
    private Transformation bdg;
    private AnimationSet bdh;
    private Drawable bdi;
    private float bdj;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bde = dQ(66);
        this.bdf = -1L;
        this.bdg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bdj = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bde = dQ(66);
        this.bdf = -1L;
        this.bdg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bdj = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bde = dQ(66);
        this.bdf = -1L;
        this.bdg = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bdj = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.bdi = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || dR(this.bdc) != 100) {
            this.bdc = dQ(i);
            if (i == 100) {
                if (this.bdh == null) {
                    cd(z);
                }
            } else if (this.bdf == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bdd = 0;
        this.bdc = 0;
        this.bdf = -1L;
        this.bdh = null;
        o(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void OW() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bdd) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bdj = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.bdi == null ? 0 : this.bdi.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.bdi != null) {
            this.bdi.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.bdi != null) {
            if (this.bdh != null) {
                if (this.bdh.getTransformation(getDrawingTime(), this.bdg)) {
                    o((int) (this.bdg.getAlpha() * 10000.0f), false);
                } else {
                    this.bdh = null;
                    reset();
                }
            } else if (this.bdf != -1 && this.bdd < this.bde) {
                long currentTimeMillis = System.currentTimeMillis();
                int ai = ai(currentTimeMillis - this.bdf);
                this.bdd += ai;
                if (ai != 0) {
                    this.bdf = currentTimeMillis;
                    o(this.bdd, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bdj + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.bdi.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void o(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.bdd = i;
        OW();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bdd = 0;
        this.bdc = 0;
        this.bdh = null;
        this.bdf = System.currentTimeMillis();
        o(this.bdd, false);
        setVisibility(0);
    }

    private void cd(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bdh = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bdd / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bdh.addAnimation(alphaAnimation);
                this.bdg.clear();
                this.bdh.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int ai(long j) {
        return (int) ((dQ(66) / 1500.0f) * ((float) j));
    }

    private int dQ(int i) {
        return i * 100;
    }

    private int dR(int i) {
        return i / 100;
    }
}
