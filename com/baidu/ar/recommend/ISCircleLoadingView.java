package com.baidu.ar.recommend;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
/* loaded from: classes3.dex */
public class ISCircleLoadingView extends View {
    private int a;
    private int b;
    private RectF c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private Paint j;
    private Paint k;
    private ValueAnimator l;

    public ISCircleLoadingView(Context context) {
        this(context, null);
    }

    public ISCircleLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ISCircleLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 572662306;
        this.b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(this.i);
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setColor(this.i);
    }

    private void a() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return;
        }
        if (this.a <= 0) {
            this.a = Math.min(measuredWidth, measuredHeight) / 4;
        }
        this.f = measuredWidth / 2.0f;
        this.g = measuredHeight / 2.0f;
        this.c = new RectF(this.f - this.a, this.g - this.a, this.f + this.a, this.g + this.a);
        if (this.e <= 0.0f) {
            this.e = ((float) Math.sqrt((measuredWidth * measuredWidth) + (measuredHeight * measuredHeight))) / 2.0f;
        }
        this.d = this.a + (0.5f * this.b);
    }

    private void a(Canvas canvas, float f) {
        float f2 = this.e - f;
        this.k.setStrokeWidth(f2);
        canvas.drawCircle(this.f, this.g, (0.5f * f2) + f, this.k);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.h;
        if (i == 0) {
            canvas.drawCircle(this.f, this.g, this.e, this.j);
        } else if (i < 100) {
            a(canvas, this.d);
            float f = (i * 360.0f) / 100.0f;
            canvas.drawArc(this.c, (-90.0f) + f, 360.0f - f, true, this.j);
        } else if (i == 100) {
            if (this.l == null) {
                a(canvas, this.e);
                return;
            }
            float floatValue = ((Float) this.l.getAnimatedValue()).floatValue();
            a(canvas, this.d + ((this.e - this.d) * floatValue));
            if (floatValue < 1.0f) {
                postInvalidateDelayed(25L);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        a();
    }

    public void setAnimator(ValueAnimator valueAnimator) {
        this.l = valueAnimator;
    }

    public void setCircleMaxRadius(int i) {
        this.e = i;
    }

    public void setLoadingColor(int i) {
        this.i = i;
        this.j.setColor(i);
        this.k.setColor(i);
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.h = i;
        postInvalidate();
    }

    public void setRingRadius(int i) {
        this.a = i;
    }

    public void setRingStrokeSize(int i) {
        this.b = i;
    }
}
