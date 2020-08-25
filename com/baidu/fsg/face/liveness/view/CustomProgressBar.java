package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes11.dex */
public class CustomProgressBar extends View {
    private int a;
    private int b;
    private Paint c;
    private Paint d;
    private float e;
    private boolean f;
    private final RectF g;

    public CustomProgressBar(Context context) {
        super(context);
        this.g = new RectF();
        a(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new RectF();
        a(context, attributeSet);
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new RectF();
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomProgressBar);
                this.e = typedArray.getFloat(R.styleable.CustomProgressBar_mpb_percent, 0.0f);
                this.a = typedArray.getColor(R.styleable.CustomProgressBar_mpb_fill_color, 0);
                this.b = typedArray.getColor(R.styleable.CustomProgressBar_mpb_background_color, 0);
                this.f = typedArray.getBoolean(R.styleable.CustomProgressBar_mpb_flat, false);
                this.c = new Paint();
                this.c.setColor(this.a);
                this.c.setAntiAlias(true);
                this.d = new Paint();
                this.d.setColor(this.b);
                this.d.setAntiAlias(true);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public void setFillColor(int i) {
        if (this.a != i) {
            this.a = i;
            this.c.setColor(i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.b != i) {
            this.b = i;
            this.d.setColor(i);
            invalidate();
        }
    }

    public int getFillColor() {
        return this.a;
    }

    public int getBackgroundColor() {
        return this.b;
    }

    public float getPercent() {
        return this.e;
    }

    public void setPercent(float f) {
        float max = Math.max(0.0f, Math.min(1.0f, f));
        if (this.e != max) {
            this.e = max;
            postInvalidate();
        }
    }

    public void setFlat(boolean z) {
        if (this.f != z) {
            this.f = z;
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [234=5] */
    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.e;
        canvas.save();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        float f2 = measuredWidth * f;
        float f3 = measuredHeight / 2.0f;
        this.g.left = 0.0f;
        this.g.top = 0.0f;
        this.g.right = measuredWidth;
        this.g.bottom = measuredHeight;
        if (this.b != 0) {
            canvas.drawRoundRect(this.g, f3, f3, this.d);
        }
        try {
            if (this.a != 0 && f2 > 0.0f) {
                if (f2 == measuredWidth) {
                    this.g.right = f2;
                    canvas.drawRoundRect(this.g, f3, f3, this.c);
                } else if (this.f) {
                    canvas.save();
                    this.g.right = f2 > f3 ? f3 : f2;
                    canvas.clipRect(this.g);
                    this.g.right = f3 * 2.0f;
                    canvas.drawRoundRect(this.g, f3, f3, this.c);
                    canvas.restore();
                    if (f2 <= f3) {
                        return;
                    }
                    float f4 = measuredWidth - f3;
                    float f5 = f2 > f4 ? f4 : f2;
                    this.g.left = f3;
                    this.g.right = f5;
                    canvas.drawRect(this.g, this.c);
                    if (f2 <= f4) {
                        return;
                    }
                    this.g.left = f4 - f3;
                    this.g.right = f2;
                    canvas.clipRect(this.g);
                    this.g.right = measuredWidth;
                    canvas.drawArc(this.g, -90.0f, 180.0f, true, this.c);
                } else if (f2 <= f3 * 2.0f) {
                    this.g.right = f2;
                    canvas.clipRect(this.g);
                    this.g.right = f3 * 2.0f;
                    canvas.drawRoundRect(this.g, f3, f3, this.c);
                } else {
                    this.g.right = f2;
                    canvas.drawRoundRect(this.g, f3, f3, this.c);
                }
            }
        } finally {
            canvas.restore();
        }
    }
}
