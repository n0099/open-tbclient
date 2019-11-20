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
    private int bcK;
    private int bcL;
    private int bcM;
    private long bcN;
    private Transformation bcO;
    private AnimationSet bcP;
    private Drawable bcQ;
    private float bcR;
    private Interpolator mInterpolator;

    public EfficientProgressBar(Context context) {
        super(context);
        this.bcM = dQ(66);
        this.bcN = -1L;
        this.bcO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bcR = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcM = dQ(66);
        this.bcN = -1L;
        this.bcO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bcR = -1.0f;
        init();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcM = dQ(66);
        this.bcN = -1L;
        this.bcO = new Transformation();
        this.mInterpolator = new DecelerateInterpolator(2.0f);
        this.bcR = -1.0f;
        init();
    }

    private void init() {
    }

    public void setProgressDrawable(Drawable drawable) {
        this.bcQ = drawable;
    }

    public void setProgress(int i, boolean z) {
        if (i != 100 || dR(this.bcK) != 100) {
            this.bcK = dQ(i);
            if (i == 100) {
                if (this.bcP == null) {
                    cd(z);
                }
            } else if (this.bcN == -1) {
                start();
            }
        }
    }

    public void reset() {
        this.bcL = 0;
        this.bcK = 0;
        this.bcN = -1L;
        this.bcP = null;
        o(0, false);
        setVisibility(4);
    }

    @TargetApi(11)
    private void OX() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = -1.0f;
        if (width > 0) {
            f = ((10000 - this.bcL) / 10000.0f) * width;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.bcR = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.bcQ == null ? 0 : this.bcQ.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && this.bcQ != null) {
            this.bcQ.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.bcQ != null) {
            if (this.bcP != null) {
                if (this.bcP.getTransformation(getDrawingTime(), this.bcO)) {
                    o((int) (this.bcO.getAlpha() * 10000.0f), false);
                } else {
                    this.bcP = null;
                    reset();
                }
            } else if (this.bcN != -1 && this.bcL < this.bcM) {
                long currentTimeMillis = System.currentTimeMillis();
                int ah = ah(currentTimeMillis - this.bcN);
                this.bcL += ah;
                if (ah != 0) {
                    this.bcN = currentTimeMillis;
                    o(this.bcL, true);
                }
            }
            int i = -1;
            if (getPaddingLeft() > 0) {
                i = canvas.save();
                canvas.clipRect(this.bcR + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.bcQ.draw(canvas);
            if (i >= 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void o(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.bcL = i;
        OX();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    private void start() {
        this.bcL = 0;
        this.bcK = 0;
        this.bcP = null;
        this.bcN = System.currentTimeMillis();
        o(this.bcL, false);
        setVisibility(0);
    }

    private void cd(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.bcP = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.bcL / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.mInterpolator);
                this.bcP.addAnimation(alphaAnimation);
                this.bcO.clear();
                this.bcP.start();
                invalidate();
                return;
            }
            reset();
        }
    }

    private int ah(long j) {
        return (int) ((dQ(66) / 1500.0f) * ((float) j));
    }

    private int dQ(int i) {
        return i * 100;
    }

    private int dR(int i) {
        return i / 100;
    }
}
