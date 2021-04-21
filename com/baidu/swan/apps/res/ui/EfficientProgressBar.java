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
/* loaded from: classes3.dex */
public class EfficientProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f12129e;

    /* renamed from: f  reason: collision with root package name */
    public int f12130f;

    /* renamed from: g  reason: collision with root package name */
    public int f12131g;

    /* renamed from: h  reason: collision with root package name */
    public long f12132h;
    public Transformation i;
    public Interpolator j;
    public AnimationSet k;
    public Drawable l;
    public float m;

    public EfficientProgressBar(Context context) {
        super(context);
        this.f12131g = g(66);
        this.f12132h = -1L;
        this.i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    public final int a(long j) {
        return (int) ((g(66) / 1500.0f) * ((float) j));
    }

    public final int b(int i) {
        return i / 100;
    }

    public final void c(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.k = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.f12130f / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.j);
                this.k.addAnimation(alphaAnimation);
                this.i.clear();
                this.k.start();
                invalidate();
                return;
            }
            f();
        }
    }

    public final void d() {
    }

    @TargetApi(11)
    public final void e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f2 = width > 0 ? ((10000 - this.f12130f) / 10000.0f) * width : -1.0f;
        if (f2 > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f2);
            }
            this.m = f2;
        }
    }

    public void f() {
        this.f12130f = 0;
        this.f12129e = 0;
        this.f12132h = -1L;
        this.k = null;
        h(0, false);
        setVisibility(4);
    }

    public final int g(int i) {
        return i * 100;
    }

    public final void h(int i, boolean z) {
        if (i > 10000) {
            i = 10000;
        }
        this.f12130f = i;
        e();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    public final void i() {
        this.f12130f = 0;
        this.f12129e = 0;
        this.k = null;
        this.f12132h = System.currentTimeMillis();
        h(this.f12130f, false);
        setVisibility(0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.l != null) {
            AnimationSet animationSet = this.k;
            if (animationSet != null) {
                if (animationSet.getTransformation(getDrawingTime(), this.i)) {
                    h((int) (this.i.getAlpha() * 10000.0f), false);
                } else {
                    this.k = null;
                    f();
                }
            } else if (this.f12132h != -1 && this.f12130f < this.f12131g) {
                long currentTimeMillis = System.currentTimeMillis();
                int a2 = a(currentTimeMillis - this.f12132h);
                int i = this.f12130f + a2;
                this.f12130f = i;
                if (a2 != 0) {
                    this.f12132h = currentTimeMillis;
                    h(i, true);
                }
            }
            int i2 = -1;
            if (getPaddingLeft() > 0) {
                i2 = canvas.save();
                canvas.clipRect(this.m + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.l.draw(canvas);
            if (i2 >= 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        if (!z || (drawable = this.l) == null) {
            return;
        }
        drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        Drawable drawable = this.l;
        setMeasuredDimension(size, (drawable == null ? 0 : drawable.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    public void setProgress(int i, boolean z) {
        if (i == 100 && b(this.f12129e) == 100) {
            return;
        }
        this.f12129e = g(i);
        if (i == 100) {
            if (this.k == null) {
                c(z);
            }
        } else if (this.f12132h == -1) {
            i();
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        this.l = drawable;
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12131g = g(66);
        this.f12132h = -1L;
        this.i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12131g = g(66);
        this.f12132h = -1L;
        this.i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }
}
