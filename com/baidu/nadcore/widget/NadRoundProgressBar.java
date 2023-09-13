package com.baidu.nadcore.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.jc1;
import com.baidu.tieba.q61;
/* loaded from: classes3.dex */
public class NadRoundProgressBar extends View {
    public final Paint a;
    public int b;
    public int c;
    public final int d;
    public final float e;
    public final float f;
    public float g;
    public int h;
    public int i;
    public final boolean j;
    public final int k;
    public final RectF l;
    public a m;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public NadRoundProgressBar(Context context) {
        this(context, null);
    }

    public void setCircleColor(int i) {
        this.b = i;
        postInvalidate();
    }

    public void setCircleProgressColor(int i) {
        this.c = i;
        postInvalidate();
    }

    public synchronized void setMax(int i) {
        this.h = i;
    }

    public void setOnProgressChangeListener(a aVar) {
        this.m = aVar;
    }

    public synchronized void setProgress(int i) {
        if (i > this.h) {
            i = this.h;
        }
        this.i = i;
        if (this.m != null) {
            this.m.a(i);
        }
        postInvalidate();
    }

    public void setRoundProgressColor(int i) {
        this.c = i;
    }

    public void setRoundWidth(float f) {
        this.g = f;
    }

    public NadRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"PrivateResource"})
    public NadRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.l = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jc1.NadRoundProgressBar);
        this.b = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.nad_mini_video_round_progress_border_color));
        this.c = obtainStyledAttributes.getColor(7, getResources().getColor(R.color.nad_mini_video_round_progress_color));
        this.d = obtainStyledAttributes.getColor(8, getResources().getColor(R.color.nad_mini_video_round_progress_text_color));
        this.e = obtainStyledAttributes.getDimension(9, q61.c.a(getContext(), 11.0f));
        this.f = obtainStyledAttributes.getDimension(4, q61.c.a(getContext(), 8.0f));
        this.g = obtainStyledAttributes.getDimension(10, 5.0f);
        this.h = obtainStyledAttributes.getInteger(5, 100);
        this.j = obtainStyledAttributes.getBoolean(12, true);
        this.k = obtainStyledAttributes.getInt(1, 0);
        obtainStyledAttributes.recycle();
    }

    public synchronized int getMax() {
        return this.h;
    }

    public synchronized int getProgress() {
        return this.i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i = (int) ((f - (this.g / 2.0f)) - 5.0f);
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.g);
        this.a.setAntiAlias(true);
        canvas.drawCircle(f, f, i, this.a);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(0.0f);
        this.a.setColor(this.d);
        this.a.setTextSize(this.e);
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((this.i / this.h) * 100.0f);
        float measureText = this.a.measureText(String.valueOf(i2));
        this.a.setTextSize(this.f);
        float measureText2 = this.a.measureText("%");
        if (this.j && this.k == 0) {
            if (i2 == 0) {
                i2 = 1;
            }
            this.a.setTextSize(this.e);
            canvas.drawText(String.valueOf(i2), f - ((measureText + measureText2) / 2.0f), ((this.e / 2.0f) + f) - 5.0f, this.a);
            this.a.setTextSize(this.f);
            canvas.drawText("%", ((measureText / 2.0f) + f) - (measureText2 / 2.0f), (f + (this.e / 2.0f)) - 5.0f, this.a);
        }
        this.a.setStrokeWidth(this.g);
        this.a.setColor(this.c);
        float f2 = width - i;
        float f3 = width + i;
        this.l.set(f2, f2, f3, f3);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        int i3 = this.k;
        if (i3 != 0) {
            if (i3 == 1) {
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                int i4 = this.i;
                if (i4 != 0) {
                    canvas.drawArc(this.l, -90.0f, (i4 * 360.0f) / this.h, true, this.a);
                    return;
                }
                return;
            }
            return;
        }
        this.a.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.l, -90.0f, (this.i * 360.0f) / this.h, false, this.a);
    }
}
