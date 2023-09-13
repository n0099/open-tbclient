package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.lh4;
/* loaded from: classes4.dex */
public class SwanAppLaunchCircleAnimationView extends View {
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public Float e;
    public ValueAnimator f;
    public long g;
    public boolean h;
    public RectF i;
    public float j;
    public int k;
    public float l;
    public float m;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwanAppLaunchCircleAnimationView.this.e = (Float) valueAnimator.getAnimatedValue();
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = SwanAppLaunchCircleAnimationView.this;
            swanAppLaunchCircleAnimationView.l = (swanAppLaunchCircleAnimationView.getWidth() - ((SwanAppLaunchCircleAnimationView.this.k * 6.0f) / 96.0f)) / 2.0f;
            if (SwanAppLaunchCircleAnimationView.this.e.floatValue() <= 0.3f) {
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView2 = SwanAppLaunchCircleAnimationView.this;
                swanAppLaunchCircleAnimationView2.j = ((float) (((swanAppLaunchCircleAnimationView2.e.floatValue() * 0.26d) / 0.3d) + 0.04d)) * 360.0f;
            } else {
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView3 = SwanAppLaunchCircleAnimationView.this;
                swanAppLaunchCircleAnimationView3.j = ((float) (0.3d - (((swanAppLaunchCircleAnimationView3.e.floatValue() - 0.3d) * 0.26d) / 0.7d))) * 360.0f;
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView4 = SwanAppLaunchCircleAnimationView.this;
            swanAppLaunchCircleAnimationView4.m = (swanAppLaunchCircleAnimationView4.e.floatValue() * 360.0f) - 90.0f;
            SwanAppLaunchCircleAnimationView.this.postInvalidate();
        }
    }

    public SwanAppLaunchCircleAnimationView(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.k;
        canvas.drawCircle(i, i, this.l, this.a);
        canvas.drawArc(this.i, this.m, this.j, false, this.b);
    }

    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }

    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }

    public final void g() {
        this.g = System.currentTimeMillis();
        this.d = getResources().getColor(R.color.obfuscated_res_0x7f060480);
        this.c = getResources().getColor(R.color.obfuscated_res_0x7f06047e);
        this.a.setColor(this.d);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.b.setColor(this.c);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(Paint.Cap.ROUND);
    }

    public void h() {
        g();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f = ofFloat;
        ofFloat.setInterpolator(new lh4(0.4f, 0.0f, 0.6f, 1.0f));
        this.f.setRepeatCount(-1);
        this.f.setRepeatMode(1);
        this.f.setDuration(800L);
        if (!this.h) {
            this.f.setCurrentPlayTime(500L);
        } else {
            this.f.setDuration(500L);
        }
        this.f.addUpdateListener(new a());
        this.f.start();
    }

    public void i() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f.cancel();
        }
        this.h = false;
    }

    public void j(float f) {
        if (System.currentTimeMillis() - this.g < 1120) {
            return;
        }
        i();
        Float valueOf = Float.valueOf(f);
        this.e = valueOf;
        this.m = -90.0f;
        this.j = valueOf.floatValue() * 360.0f;
        postInvalidate();
        if (f == 1.0f) {
            this.h = true;
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f.cancel();
            }
            h();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float f;
        super.onSizeChanged(i, i2, i3, i4);
        int width = getWidth() / 2;
        this.k = width;
        Paint paint = this.a;
        if (width > 99.0f) {
            f = (width * 1.0f) / 99.0f;
        } else {
            f = 1.0f;
        }
        paint.setStrokeWidth(f);
        this.b.setStrokeWidth((this.k * 6) / 99.0f);
        int i5 = this.k;
        this.i = new RectF(((i5 * 3.0f) / 96.0f) + 1.0f, ((i5 * 3.0f) / 96.0f) + 1.0f, (getWidth() - ((this.k * 3.0f) / 96.0f)) - 1.0f, (getHeight() - ((this.k * 3.0f) / 96.0f)) - 1.0f);
    }
}
