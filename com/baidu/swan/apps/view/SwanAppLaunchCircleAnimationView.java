package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import d.a.m0.a.c;
import d.a.m0.a.r1.l.b;
import d.a.m0.k.d;
/* loaded from: classes3.dex */
public class SwanAppLaunchCircleAnimationView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f11487e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f11488f;

    /* renamed from: g  reason: collision with root package name */
    public int f11489g;

    /* renamed from: h  reason: collision with root package name */
    public int f11490h;

    /* renamed from: i  reason: collision with root package name */
    public Float f11491i;
    public ValueAnimator j;
    public long k;
    public boolean l;
    public RectF m;
    public float n;
    public int o;
    public float p;
    public float q;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwanAppLaunchCircleAnimationView.this.f11491i = (Float) valueAnimator.getAnimatedValue();
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = SwanAppLaunchCircleAnimationView.this;
            swanAppLaunchCircleAnimationView.p = (swanAppLaunchCircleAnimationView.getWidth() - ((SwanAppLaunchCircleAnimationView.this.o * 6.0f) / 96.0f)) / 2.0f;
            if (SwanAppLaunchCircleAnimationView.this.f11491i.floatValue() <= 0.3f) {
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView2 = SwanAppLaunchCircleAnimationView.this;
                swanAppLaunchCircleAnimationView2.n = ((float) (((swanAppLaunchCircleAnimationView2.f11491i.floatValue() * 0.26d) / 0.3d) + 0.04d)) * 360.0f;
            } else {
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView3 = SwanAppLaunchCircleAnimationView.this;
                swanAppLaunchCircleAnimationView3.n = ((float) (0.3d - (((swanAppLaunchCircleAnimationView3.f11491i.floatValue() - 0.3d) * 0.26d) / 0.7d))) * 360.0f;
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView4 = SwanAppLaunchCircleAnimationView.this;
            swanAppLaunchCircleAnimationView4.q = (swanAppLaunchCircleAnimationView4.f11491i.floatValue() * 360.0f) - 90.0f;
            SwanAppLaunchCircleAnimationView.this.postInvalidate();
        }
    }

    public SwanAppLaunchCircleAnimationView(Context context) {
        super(context);
        this.f11487e = new Paint();
        this.f11488f = new Paint();
        this.m = null;
    }

    public final void g() {
        this.k = System.currentTimeMillis();
        this.f11490h = getResources().getColor(c.app_Launch_Gray_Arc_Color);
        this.f11489g = getResources().getColor(c.app_Launch_Blue_Arc_Color);
        this.f11487e.setColor(this.f11490h);
        this.f11487e.setAntiAlias(true);
        this.f11487e.setStyle(Paint.Style.STROKE);
        this.f11488f.setColor(this.f11489g);
        this.f11488f.setAntiAlias(true);
        this.f11488f.setStyle(Paint.Style.STROKE);
        this.f11488f.setStrokeCap(Paint.Cap.ROUND);
    }

    public void h() {
        g();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.j = ofFloat;
        ofFloat.setInterpolator(new d(0.4f, 0.0f, 0.6f, 1.0f));
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(1);
        this.j.setDuration(800L);
        if (!this.l) {
            this.j.setCurrentPlayTime(500L);
        } else if (b.d() == 3) {
            this.j.setDuration(500L);
        }
        this.j.addUpdateListener(new a());
        this.j.start();
    }

    public void i() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.j.cancel();
        }
        this.l = false;
    }

    public void j(float f2) {
        if (System.currentTimeMillis() - this.k < 1120) {
            return;
        }
        i();
        Float valueOf = Float.valueOf(f2);
        this.f11491i = valueOf;
        this.q = -90.0f;
        this.n = valueOf.floatValue() * 360.0f;
        postInvalidate();
        if (f2 == 1.0f) {
            this.l = true;
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.j.cancel();
            }
            h();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2 = this.o;
        canvas.drawCircle(i2, i2, this.p, this.f11487e);
        canvas.drawArc(this.m, this.q, this.n, false, this.f11488f);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int width = getWidth() / 2;
        this.o = width;
        this.f11487e.setStrokeWidth(((float) width) > 99.0f ? (width * 1.0f) / 99.0f : 1.0f);
        this.f11488f.setStrokeWidth((this.o * 6) / 99.0f);
        int i6 = this.o;
        this.m = new RectF(((i6 * 3.0f) / 96.0f) + 1.0f, ((i6 * 3.0f) / 96.0f) + 1.0f, (getWidth() - ((this.o * 3.0f) / 96.0f)) - 1.0f, (getHeight() - ((this.o * 3.0f) / 96.0f)) - 1.0f);
    }

    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11487e = new Paint();
        this.f11488f = new Paint();
        this.m = null;
    }

    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11487e = new Paint();
        this.f11488f = new Paint();
        this.m = null;
    }
}
