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
    public Paint f6170a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6171b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6172c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6173d;

    /* renamed from: e  reason: collision with root package name */
    public int f6174e;

    /* renamed from: f  reason: collision with root package name */
    public int f6175f;

    /* renamed from: g  reason: collision with root package name */
    public int f6176g;

    /* renamed from: h  reason: collision with root package name */
    public float f6177h;
    public float i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6176g / 2);
        canvas.drawCircle(width, width, f2, this.f6170a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6173d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6173d, -90.0f, this.i, false, this.f6171b);
        canvas.drawText(this.j, width - (this.f6172c.measureText(this.j) / 2.0f), width, this.f6172c);
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
        this.f6176g = h.a(context, 3.0f);
        this.f6177h = h.a(context, 24.0f);
        this.f6174e = Color.parseColor("#E1DDDD");
        this.f6175f = Color.parseColor("#3C76FF");
        this.f6170a = new Paint();
        this.f6171b = new Paint();
        this.f6172c = new Paint();
        this.f6173d = new RectF();
        this.f6170a.setColor(this.f6174e);
        this.f6170a.setStyle(Paint.Style.STROKE);
        this.f6170a.setStrokeWidth(this.f6176g);
        this.f6170a.setAntiAlias(true);
        this.f6170a.setStrokeCap(Paint.Cap.ROUND);
        this.f6171b.setColor(this.f6175f);
        this.f6171b.setStyle(Paint.Style.STROKE);
        this.f6171b.setStrokeWidth(this.f6176g);
        this.f6171b.setAntiAlias(true);
        this.f6171b.setStrokeCap(Paint.Cap.ROUND);
        this.f6172c.setStrokeWidth(0.0f);
        this.f6172c.setColor(this.f6175f);
        this.f6172c.setTextSize(this.f6177h);
        this.f6172c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
