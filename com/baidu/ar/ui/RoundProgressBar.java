package com.baidu.ar.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ar.util.Utils;
/* loaded from: classes3.dex */
public class RoundProgressBar extends View {
    private Paint a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private Context k;
    private a l;
    private Handler m;
    private Runnable n;
    private Runnable o;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public RoundProgressBar(Context context) {
        this(context, null);
        this.k = context;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.k = context;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new Handler() { // from class: com.baidu.ar.ui.RoundProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.n = new Runnable() { // from class: com.baidu.ar.ui.RoundProgressBar.2
            @Override // java.lang.Runnable
            public void run() {
                if (RoundProgressBar.this.getProgress() >= 90) {
                    RoundProgressBar.this.m.removeCallbacks(RoundProgressBar.this.n);
                    return;
                }
                RoundProgressBar.this.setProgress(RoundProgressBar.this.getProgress() + 1);
                RoundProgressBar.this.m.postDelayed(RoundProgressBar.this.n, 30L);
            }
        };
        this.o = new Runnable() { // from class: com.baidu.ar.ui.RoundProgressBar.3
            @Override // java.lang.Runnable
            public void run() {
                if (RoundProgressBar.this.getProgress() < 100) {
                    RoundProgressBar.this.setProgress(RoundProgressBar.this.getProgress() + 1);
                    RoundProgressBar.this.m.postDelayed(RoundProgressBar.this.o, 2L);
                    return;
                }
                RoundProgressBar.this.m.removeCallbacks(RoundProgressBar.this.n);
                RoundProgressBar.this.m.removeCallbacks(RoundProgressBar.this.o);
                RoundProgressBar.this.setVisibility(8);
            }
        };
        this.k = context;
        this.a = new Paint();
        this.b = -570425345;
        this.c = -16747521;
        this.d = -1;
        this.e = Utils.dipToPx(context, 30.0f);
        this.f = Utils.dipToPx(context, 5.0f);
        this.g = 100;
        this.i = true;
        this.j = 0;
    }

    public int getCricleColor() {
        return this.b;
    }

    public int getCricleProgressColor() {
        return this.c;
    }

    public synchronized int getMax() {
        return this.g;
    }

    public synchronized int getProgress() {
        return this.h;
    }

    public float getRoundWidth() {
        return this.f;
    }

    public int getTextColor() {
        return this.d;
    }

    public float getTextSize() {
        return this.e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int i = (int) (width - (this.f / 2.0f));
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f);
        this.a.setAntiAlias(true);
        canvas.drawCircle(width, width, i, this.a);
        this.a.setStrokeWidth(0.0f);
        this.a.setColor(this.d);
        this.a.setTextSize(this.e);
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((this.h / this.g) * 100.0f);
        float measureText = this.a.measureText(i2 + "%");
        if (this.i && i2 != 0 && this.j == 0) {
            canvas.drawText(i2 + "%", width - (measureText / 2.0f), (width + (this.e / 2.0f)) - 10.0f, this.a);
        }
        this.a.setStrokeWidth(this.f);
        this.a.setColor(this.c);
        RectF rectF = new RectF(width - i, height - i, width + i, height + i);
        switch (this.j) {
            case 0:
                this.a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, 270.0f, (this.h * 360) / this.g, false, this.a);
                return;
            case 1:
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.h != 0) {
                    canvas.drawArc(rectF, 270.0f, (this.h * 360) / this.g, true, this.a);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setCricleColor(int i) {
        this.b = i;
    }

    public void setCricleProgressColor(int i) {
        this.c = i;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.g = i;
    }

    public void setOnProgressListner(a aVar) {
        this.l = aVar;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i <= this.g) {
            this.h = i;
            postInvalidate();
        }
    }

    public void setProgressSync(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i <= this.g) {
            this.h = i;
            invalidate();
        }
    }

    public void setRoundWidth(float f) {
        this.f = f;
    }

    public void setTextColor(int i) {
        this.d = i;
    }

    public void setTextSize(float f) {
        this.e = f;
    }
}
