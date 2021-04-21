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
import d.b.h0.a.c;
import d.b.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class LoadingAnimView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f12195e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f12196f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f12197g;

    /* renamed from: h  reason: collision with root package name */
    public Canvas f12198h;
    public Camera i;
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
                LoadingAnimView.this.f12195e = (floatValue / 0.4f) * 0.25f;
            } else if (floatValue < 0.6f) {
                LoadingAnimView.this.f12195e = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
            } else {
                LoadingAnimView.this.f12195e = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
            }
            LoadingAnimView.this.postInvalidate();
        }
    }

    public LoadingAnimView(Context context) {
        super(context);
        this.f12195e = 0.0f;
        b();
    }

    public void b() {
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.i = new Camera();
        this.j = new Matrix();
        d();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.f12196f;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.f12196f.removeAllUpdateListeners();
            this.f12196f.removeAllListeners();
            this.f12196f.end();
            this.f12196f.cancel();
        }
    }

    public void d() {
        if (this.f12196f != null) {
            c();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f12196f = ofFloat;
        ofFloat.setDuration(750L);
        this.f12196f.setRepeatCount(20);
        this.f12196f.setRepeatMode(1);
        this.f12196f.setInterpolator(new LinearInterpolator());
        this.f12196f.addUpdateListener(new a());
        if (this.f12196f.isRunning()) {
            return;
        }
        this.f12196f.start();
    }

    public void e() {
        c();
        clearAnimation();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12197g == null || this.f12198h == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int e2 = h0.e(getContext(), 6.0f);
        this.f12197g.eraseColor(0);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(getResources().getColor(c.aiapps_pull_load_footer_image_color));
        this.k.setAlpha((int) ((((1.0d - (Math.abs(this.f12195e - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
        float f2 = measuredWidth / 2.0f;
        float f3 = measuredHeight / 2.0f;
        this.f12198h.drawCircle(f2, f3, e2, this.k);
        this.j.reset();
        this.i.save();
        this.i.setLocation(0.0f, 0.0f, -100.0f);
        this.i.rotateY(this.f12195e * 360.0f);
        this.i.getMatrix(this.j);
        this.i.restore();
        this.j.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
        this.j.postTranslate(f2, f3);
        canvas.drawBitmap(this.f12197g, this.j, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f12197g = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f12198h = new Canvas(this.f12197g);
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12195e = 0.0f;
        b();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12195e = 0.0f;
        b();
    }
}
