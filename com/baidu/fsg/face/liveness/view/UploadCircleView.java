package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.fsg.face.base.d.h;
/* loaded from: classes7.dex */
public class UploadCircleView extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private RectF d;
    private int e;
    private int f;
    private int g;
    private float h;
    private float i;
    private String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j = "";
        this.g = h.a(context, 3.0f);
        this.h = h.a(context, 24.0f);
        this.e = Color.parseColor("#E1DDDD");
        this.f = Color.parseColor("#3C76FF");
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.d = new RectF();
        this.a.setColor(this.e);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.g);
        this.a.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.b.setColor(this.f);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.g);
        this.b.setAntiAlias(true);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.c.setStrokeWidth(0.0f);
        this.c.setColor(this.f);
        this.c.setTextSize(this.h);
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f = width - (this.g / 2);
        canvas.drawCircle(width, width, f, this.a);
        this.d.set(width - f, width - f, width + f, f + width);
        canvas.drawArc(this.d, -90.0f, this.i, false, this.b);
        canvas.drawText(this.j, width - (this.c.measureText(this.j) / 2.0f), width, this.c);
    }

    public void setProgress(int i) {
        this.j = i + "%";
        this.i = (i * 360) / 100;
        postInvalidate();
    }
}
