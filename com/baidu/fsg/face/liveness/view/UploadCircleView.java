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
    public Paint f6384a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6385b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6386c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6387d;

    /* renamed from: e  reason: collision with root package name */
    public int f6388e;

    /* renamed from: f  reason: collision with root package name */
    public int f6389f;

    /* renamed from: g  reason: collision with root package name */
    public int f6390g;

    /* renamed from: h  reason: collision with root package name */
    public float f6391h;

    /* renamed from: i  reason: collision with root package name */
    public float f6392i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6390g / 2);
        canvas.drawCircle(width, width, f2, this.f6384a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6387d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6387d, -90.0f, this.f6392i, false, this.f6385b);
        canvas.drawText(this.j, width - (this.f6386c.measureText(this.j) / 2.0f), width, this.f6386c);
    }

    public void setProgress(int i2) {
        this.j = i2 + "%";
        this.f6392i = (float) ((i2 * 360) / 100);
        postInvalidate();
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.j = "";
        this.f6390g = h.a(context, 3.0f);
        this.f6391h = h.a(context, 24.0f);
        this.f6388e = Color.parseColor("#E1DDDD");
        this.f6389f = Color.parseColor("#3C76FF");
        this.f6384a = new Paint();
        this.f6385b = new Paint();
        this.f6386c = new Paint();
        this.f6387d = new RectF();
        this.f6384a.setColor(this.f6388e);
        this.f6384a.setStyle(Paint.Style.STROKE);
        this.f6384a.setStrokeWidth(this.f6390g);
        this.f6384a.setAntiAlias(true);
        this.f6384a.setStrokeCap(Paint.Cap.ROUND);
        this.f6385b.setColor(this.f6389f);
        this.f6385b.setStyle(Paint.Style.STROKE);
        this.f6385b.setStrokeWidth(this.f6390g);
        this.f6385b.setAntiAlias(true);
        this.f6385b.setStrokeCap(Paint.Cap.ROUND);
        this.f6386c.setStrokeWidth(0.0f);
        this.f6386c.setColor(this.f6389f);
        this.f6386c.setTextSize(this.f6391h);
        this.f6386c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
