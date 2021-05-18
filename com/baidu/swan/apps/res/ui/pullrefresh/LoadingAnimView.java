package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import d.a.i0.a.c;
import d.a.i0.a.v2.n0;
/* loaded from: classes3.dex */
public class LoadingAnimView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f11244e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f11245f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f11246g;

    /* renamed from: h  reason: collision with root package name */
    public Canvas f11247h;

    /* renamed from: i  reason: collision with root package name */
    public Camera f11248i;
    public Matrix j;
    public Paint k;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 0.4f) {
                LoadingAnimView.this.f11244e = (floatValue / 0.4f) * 0.25f;
            } else if (floatValue < 0.6f) {
                LoadingAnimView.this.f11244e = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
            } else {
                LoadingAnimView.this.f11244e = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
            }
            LoadingAnimView.this.postInvalidate();
        }
    }

    public LoadingAnimView(Context context) {
        super(context);
        this.f11244e = 0.0f;
        b();
    }

    public void b() {
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.f11248i = new Camera();
        this.j = new Matrix();
        d();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.f11245f;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.f11245f.removeAllUpdateListeners();
            this.f11245f.removeAllListeners();
            this.f11245f.end();
            this.f11245f.cancel();
        }
    }

    public void d() {
        if (this.f11245f != null) {
            c();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f11245f = ofFloat;
        ofFloat.setDuration(750L);
        this.f11245f.setRepeatCount(20);
        this.f11245f.setRepeatMode(1);
        this.f11245f.setInterpolator(new LinearInterpolator());
        this.f11245f.addUpdateListener(new a());
        if (this.f11245f.isRunning()) {
            return;
        }
        this.f11245f.start();
    }

    public void e() {
        c();
        clearAnimation();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11246g == null || this.f11247h == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int f2 = n0.f(getContext(), 6.0f);
        this.f11246g.eraseColor(0);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(getResources().getColor(c.aiapps_pull_load_footer_image_color));
        this.k.setAlpha((int) ((((1.0d - (Math.abs(this.f11244e - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
        float f3 = measuredWidth / 2.0f;
        float f4 = measuredHeight / 2.0f;
        this.f11247h.drawCircle(f3, f4, f2, this.k);
        this.j.reset();
        this.f11248i.save();
        this.f11248i.setLocation(0.0f, 0.0f, -100.0f);
        this.f11248i.rotateY(this.f11244e * 360.0f);
        this.f11248i.getMatrix(this.j);
        this.f11248i.restore();
        this.j.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
        this.j.postTranslate(f3, f4);
        canvas.drawBitmap(this.f11246g, this.j, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f11246g = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f11247h = new Canvas(this.f11246g);
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11244e = 0.0f;
        b();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11244e = 0.0f;
        b();
    }
}
