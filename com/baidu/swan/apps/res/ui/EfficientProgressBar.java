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
/* loaded from: classes3.dex */
public class EfficientProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f11095e;

    /* renamed from: f  reason: collision with root package name */
    public int f11096f;

    /* renamed from: g  reason: collision with root package name */
    public int f11097g;

    /* renamed from: h  reason: collision with root package name */
    public long f11098h;

    /* renamed from: i  reason: collision with root package name */
    public Transformation f11099i;
    public Interpolator j;
    public AnimationSet k;
    public Drawable l;
    public float m;

    public EfficientProgressBar(Context context) {
        super(context);
        this.f11097g = g(66);
        this.f11098h = -1L;
        this.f11099i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    public final int a(long j) {
        return (int) ((g(66) / 1500.0f) * ((float) j));
    }

    public final int b(int i2) {
        return i2 / 100;
    }

    public final void c(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                this.k = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.f11096f / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.j);
                this.k.addAnimation(alphaAnimation);
                this.f11099i.clear();
                this.k.start();
                invalidate();
                return;
            }
            f();
        }
    }

    public final void d() {
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public final void e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f2 = width > 0 ? ((10000 - this.f11096f) / 10000.0f) * width : -1.0f;
        if (f2 > 0.0f) {
            if (Build.VERSION.SDK_INT >= 11) {
                setTranslationX(-f2);
            }
            this.m = f2;
        }
    }

    public void f() {
        this.f11096f = 0;
        this.f11095e = 0;
        this.f11098h = -1L;
        this.k = null;
        h(0, false);
        setVisibility(4);
    }

    public final int g(int i2) {
        return i2 * 100;
    }

    public final void h(int i2, boolean z) {
        if (i2 > 10000) {
            i2 = 10000;
        }
        this.f11096f = i2;
        e();
        if (z) {
            postInvalidateDelayed(50L);
        } else {
            invalidate();
        }
    }

    public final void i() {
        this.f11096f = 0;
        this.f11095e = 0;
        this.k = null;
        this.f11098h = System.currentTimeMillis();
        h(this.f11096f, false);
        setVisibility(0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.l != null) {
            AnimationSet animationSet = this.k;
            if (animationSet != null) {
                if (animationSet.getTransformation(getDrawingTime(), this.f11099i)) {
                    h((int) (this.f11099i.getAlpha() * 10000.0f), false);
                } else {
                    this.k = null;
                    f();
                }
            } else if (this.f11098h != -1 && this.f11096f < this.f11097g) {
                long currentTimeMillis = System.currentTimeMillis();
                int a2 = a(currentTimeMillis - this.f11098h);
                int i2 = this.f11096f + a2;
                this.f11096f = i2;
                if (a2 != 0) {
                    this.f11098h = currentTimeMillis;
                    h(i2, true);
                }
            }
            int i3 = -1;
            if (getPaddingLeft() > 0) {
                i3 = canvas.save();
                canvas.clipRect(this.m + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.l.draw(canvas);
            if (i3 >= 0) {
                canvas.restoreToCount(i3);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        if (!z || (drawable = this.l) == null) {
            return;
        }
        drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i4 - i2) - getPaddingRight(), (i5 - i3) - getPaddingBottom());
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        Drawable drawable = this.l;
        setMeasuredDimension(size, (drawable == null ? 0 : drawable.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
    }

    public void setProgress(int i2, boolean z) {
        if (i2 == 100 && b(this.f11095e) == 100) {
            return;
        }
        this.f11095e = g(i2);
        if (i2 == 100) {
            if (this.k == null) {
                c(z);
            }
        } else if (this.f11098h == -1) {
            i();
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        this.l = drawable;
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11097g = g(66);
        this.f11098h = -1L;
        this.f11099i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11097g = g(66);
        this.f11098h = -1L;
        this.f11099i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }
}
