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
/* loaded from: classes2.dex */
public class UploadCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f6181a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6182b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6183c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6184d;

    /* renamed from: e  reason: collision with root package name */
    public int f6185e;

    /* renamed from: f  reason: collision with root package name */
    public int f6186f;

    /* renamed from: g  reason: collision with root package name */
    public int f6187g;

    /* renamed from: h  reason: collision with root package name */
    public float f6188h;

    /* renamed from: i  reason: collision with root package name */
    public float f6189i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6187g / 2);
        canvas.drawCircle(width, width, f2, this.f6181a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6184d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6184d, -90.0f, this.f6189i, false, this.f6182b);
        canvas.drawText(this.j, width - (this.f6183c.measureText(this.j) / 2.0f), width, this.f6183c);
    }

    public void setProgress(int i2) {
        this.j = i2 + "%";
        this.f6189i = (float) ((i2 * 360) / 100);
        postInvalidate();
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.j = "";
        this.f6187g = h.a(context, 3.0f);
        this.f6188h = h.a(context, 24.0f);
        this.f6185e = Color.parseColor("#E1DDDD");
        this.f6186f = Color.parseColor("#3C76FF");
        this.f6181a = new Paint();
        this.f6182b = new Paint();
        this.f6183c = new Paint();
        this.f6184d = new RectF();
        this.f6181a.setColor(this.f6185e);
        this.f6181a.setStyle(Paint.Style.STROKE);
        this.f6181a.setStrokeWidth(this.f6187g);
        this.f6181a.setAntiAlias(true);
        this.f6181a.setStrokeCap(Paint.Cap.ROUND);
        this.f6182b.setColor(this.f6186f);
        this.f6182b.setStyle(Paint.Style.STROKE);
        this.f6182b.setStrokeWidth(this.f6187g);
        this.f6182b.setAntiAlias(true);
        this.f6182b.setStrokeCap(Paint.Cap.ROUND);
        this.f6183c.setStrokeWidth(0.0f);
        this.f6183c.setColor(this.f6186f);
        this.f6183c.setTextSize(this.f6188h);
        this.f6183c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
