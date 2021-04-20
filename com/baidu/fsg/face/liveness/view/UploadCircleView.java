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
    public Paint f6205a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6206b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6207c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6208d;

    /* renamed from: e  reason: collision with root package name */
    public int f6209e;

    /* renamed from: f  reason: collision with root package name */
    public int f6210f;

    /* renamed from: g  reason: collision with root package name */
    public int f6211g;

    /* renamed from: h  reason: collision with root package name */
    public float f6212h;
    public float i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6211g / 2);
        canvas.drawCircle(width, width, f2, this.f6205a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6208d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6208d, -90.0f, this.i, false, this.f6206b);
        canvas.drawText(this.j, width - (this.f6207c.measureText(this.j) / 2.0f), width, this.f6207c);
    }

    public void setProgress(int i) {
        this.j = i + "%";
        this.i = (float) ((i * 360) / 100);
        postInvalidate();
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j = "";
        this.f6211g = h.a(context, 3.0f);
        this.f6212h = h.a(context, 24.0f);
        this.f6209e = Color.parseColor("#E1DDDD");
        this.f6210f = Color.parseColor("#3C76FF");
        this.f6205a = new Paint();
        this.f6206b = new Paint();
        this.f6207c = new Paint();
        this.f6208d = new RectF();
        this.f6205a.setColor(this.f6209e);
        this.f6205a.setStyle(Paint.Style.STROKE);
        this.f6205a.setStrokeWidth(this.f6211g);
        this.f6205a.setAntiAlias(true);
        this.f6205a.setStrokeCap(Paint.Cap.ROUND);
        this.f6206b.setColor(this.f6210f);
        this.f6206b.setStyle(Paint.Style.STROKE);
        this.f6206b.setStrokeWidth(this.f6211g);
        this.f6206b.setAntiAlias(true);
        this.f6206b.setStrokeCap(Paint.Cap.ROUND);
        this.f6207c.setStrokeWidth(0.0f);
        this.f6207c.setColor(this.f6210f);
        this.f6207c.setTextSize(this.f6212h);
        this.f6207c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
