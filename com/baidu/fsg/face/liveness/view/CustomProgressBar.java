package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class CustomProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f6061a;

    /* renamed from: b  reason: collision with root package name */
    public int f6062b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6063c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f6064d;

    /* renamed from: e  reason: collision with root package name */
    public float f6065e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6066f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f6067g;

    public CustomProgressBar(Context context) {
        super(context);
        this.f6067g = new RectF();
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomProgressBar);
            this.f6065e = typedArray.getFloat(R.styleable.CustomProgressBar_mpb_percent, 0.0f);
            this.f6061a = typedArray.getColor(R.styleable.CustomProgressBar_mpb_fill_color, 0);
            this.f6062b = typedArray.getColor(R.styleable.CustomProgressBar_mpb_background_color, 0);
            this.f6066f = typedArray.getBoolean(R.styleable.CustomProgressBar_mpb_flat, false);
            Paint paint = new Paint();
            this.f6063c = paint;
            paint.setColor(this.f6061a);
            this.f6063c.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f6064d = paint2;
            paint2.setColor(this.f6062b);
            this.f6064d.setAntiAlias(true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public int getBackgroundColor() {
        return this.f6062b;
    }

    public int getFillColor() {
        return this.f6061a;
    }

    public float getPercent() {
        return this.f6065e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f6065e;
        canvas.save();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        float measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        float f3 = f2 * measuredWidth;
        float f4 = measuredHeight;
        float f5 = f4 / 2.0f;
        RectF rectF = this.f6067g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = measuredWidth;
        rectF.bottom = f4;
        if (this.f6062b != 0) {
            canvas.drawRoundRect(rectF, f5, f5, this.f6064d);
        }
        try {
            if (this.f6061a != 0 && f3 > 0.0f) {
                if (f3 == measuredWidth) {
                    this.f6067g.right = f3;
                    canvas.drawRoundRect(this.f6067g, f5, f5, this.f6063c);
                } else if (this.f6066f) {
                    canvas.save();
                    this.f6067g.right = f3 > f5 ? f5 : f3;
                    canvas.clipRect(this.f6067g);
                    this.f6067g.right = 2.0f * f5;
                    canvas.drawRoundRect(this.f6067g, f5, f5, this.f6063c);
                    canvas.restore();
                    if (f3 <= f5) {
                        return;
                    }
                    float f6 = measuredWidth - f5;
                    float f7 = f3 > f6 ? f6 : f3;
                    this.f6067g.left = f5;
                    this.f6067g.right = f7;
                    canvas.drawRect(this.f6067g, this.f6063c);
                    if (f3 <= f6) {
                        return;
                    }
                    this.f6067g.left = f6 - f5;
                    this.f6067g.right = f3;
                    canvas.clipRect(this.f6067g);
                    this.f6067g.right = measuredWidth;
                    canvas.drawArc(this.f6067g, -90.0f, 180.0f, true, this.f6063c);
                } else {
                    float f8 = 2.0f * f5;
                    if (f3 <= f8) {
                        this.f6067g.right = f3;
                        canvas.clipRect(this.f6067g);
                        this.f6067g.right = f8;
                        canvas.drawRoundRect(this.f6067g, f5, f5, this.f6063c);
                    } else {
                        this.f6067g.right = f3;
                        canvas.drawRoundRect(this.f6067g, f5, f5, this.f6063c);
                    }
                }
            }
        } finally {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.f6062b != i) {
            this.f6062b = i;
            this.f6064d.setColor(i);
            invalidate();
        }
    }

    public void setFillColor(int i) {
        if (this.f6061a != i) {
            this.f6061a = i;
            this.f6063c.setColor(i);
            invalidate();
        }
    }

    public void setFlat(boolean z) {
        if (this.f6066f != z) {
            this.f6066f = z;
            invalidate();
        }
    }

    public void setPercent(float f2) {
        float max = Math.max(0.0f, Math.min(1.0f, f2));
        if (this.f6065e != max) {
            this.f6065e = max;
            postInvalidate();
        }
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6067g = new RectF();
        a(context, attributeSet);
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6067g = new RectF();
        a(context, attributeSet);
    }
}
