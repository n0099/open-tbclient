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
import com.baidu.tieba.R;
import com.baidu.tieba.po3;
/* loaded from: classes4.dex */
public class LoadingAnimView extends View {
    public float a;
    public ValueAnimator b;
    public Bitmap c;
    public Canvas d;
    public Camera e;
    public Matrix f;
    public Paint g;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 0.4f) {
                LoadingAnimView.this.a = (floatValue / 0.4f) * 0.25f;
            } else if (floatValue < 0.6f) {
                LoadingAnimView.this.a = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
            } else {
                LoadingAnimView.this.a = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
            }
            LoadingAnimView.this.postInvalidate();
        }
    }

    public LoadingAnimView(Context context) {
        super(context);
        this.a = 0.0f;
        b();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        b();
    }

    public LoadingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        b();
    }

    public void b() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.e = new Camera();
        this.f = new Matrix();
        d();
    }

    public final void c() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.b.removeAllUpdateListeners();
            this.b.removeAllListeners();
            this.b.end();
            this.b.cancel();
        }
    }

    public void e() {
        c();
        clearAnimation();
    }

    public void d() {
        if (this.b != null) {
            c();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.b = ofFloat;
        ofFloat.setDuration(750L);
        this.b.setRepeatCount(20);
        this.b.setRepeatMode(1);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addUpdateListener(new a());
        if (!this.b.isRunning()) {
            this.b.start();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c != null && this.d != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int f = po3.f(getContext(), 6.0f);
            this.c.eraseColor(0);
            this.g.setStyle(Paint.Style.FILL);
            this.g.setColor(getResources().getColor(R.color.obfuscated_res_0x7f060452));
            this.g.setAlpha((int) ((((1.0d - (Math.abs(this.a - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
            float f2 = measuredWidth / 2.0f;
            float f3 = measuredHeight / 2.0f;
            this.d.drawCircle(f2, f3, f, this.g);
            this.f.reset();
            this.e.save();
            this.e.setLocation(0.0f, 0.0f, -100.0f);
            this.e.rotateY(this.a * 360.0f);
            this.e.getMatrix(this.f);
            this.e.restore();
            this.f.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
            this.f.postTranslate(f2, f3);
            canvas.drawBitmap(this.c, this.f, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.d = new Canvas(this.c);
    }
}
