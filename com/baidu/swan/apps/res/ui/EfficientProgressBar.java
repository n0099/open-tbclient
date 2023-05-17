package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
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
/* loaded from: classes4.dex */
public class EfficientProgressBar extends View {
    public int a;
    public int b;
    public int c;
    public long d;
    public Transformation e;
    public Interpolator f;
    public AnimationSet g;
    public Drawable h;
    public float i;

    public final void d() {
    }

    public final int g(int i) {
        return i * 100;
    }

    public EfficientProgressBar(Context context) {
        super(context);
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public final int a(long j) {
        return (int) ((g(66) / 1500.0f) * ((float) j));
    }

    public final int b(int i) {
        return i / 100;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.h = drawable;
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public final void h(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.b = i;
        e();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicHeight;
        int size = View.MeasureSpec.getSize(i);
        Drawable drawable = this.h;
        if (drawable == null) {
            intrinsicHeight = 0;
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        setMeasuredDimension(size, intrinsicHeight + getPaddingBottom() + getPaddingTop());
    }

    public void setProgress(int i, boolean z) {
        if (i == 100 && b(this.a) == 100) {
            return;
        }
        this.a = g(i);
        if (i == 100) {
            if (this.g == null) {
                c(z);
            }
        } else if (this.d == -1) {
            i();
        }
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public final void c(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.g = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.b / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.f);
                this.g.addAnimation(alphaAnimation);
                this.e.clear();
                this.g.start();
                invalidate();
                return;
            }
            f();
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public final void e() {
        float f;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (width > 0) {
            f = ((10000 - this.b) / 10000.0f) * width;
        } else {
            f = -1.0f;
        }
        if (f > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f);
            }
            this.i = f;
        }
    }

    public void f() {
        this.b = 0;
        this.a = 0;
        this.d = -1L;
        this.g = null;
        h(0, false);
        setVisibility(4);
    }

    public final void i() {
        this.b = 0;
        this.a = 0;
        this.g = null;
        this.d = System.currentTimeMillis();
        h(this.b, false);
        setVisibility(0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.h != null) {
            AnimationSet animationSet = this.g;
            if (animationSet != null) {
                if (animationSet.getTransformation(getDrawingTime(), this.e)) {
                    h((int) (this.e.getAlpha() * 10000.0f), false);
                } else {
                    this.g = null;
                    f();
                }
            } else if (this.d != -1 && this.b < this.c) {
                long currentTimeMillis = System.currentTimeMillis();
                int a = a(currentTimeMillis - this.d);
                int i = this.b + a;
                this.b = i;
                if (a != 0) {
                    this.d = currentTimeMillis;
                    h(i, true);
                }
            }
            int i2 = -1;
            if (getPaddingLeft() > 0) {
                i2 = canvas.save();
                canvas.clipRect(this.i + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.h.draw(canvas);
            if (i2 >= 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        if (z && (drawable = this.h) != null) {
            drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }
}
