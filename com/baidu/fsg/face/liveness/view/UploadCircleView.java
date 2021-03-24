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
    public Paint f6169a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6170b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6171c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6172d;

    /* renamed from: e  reason: collision with root package name */
    public int f6173e;

    /* renamed from: f  reason: collision with root package name */
    public int f6174f;

    /* renamed from: g  reason: collision with root package name */
    public int f6175g;

    /* renamed from: h  reason: collision with root package name */
    public float f6176h;
    public float i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6175g / 2);
        canvas.drawCircle(width, width, f2, this.f6169a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6172d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6172d, -90.0f, this.i, false, this.f6170b);
        canvas.drawText(this.j, width - (this.f6171c.measureText(this.j) / 2.0f), width, this.f6171c);
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
        this.f6175g = h.a(context, 3.0f);
        this.f6176h = h.a(context, 24.0f);
        this.f6173e = Color.parseColor("#E1DDDD");
        this.f6174f = Color.parseColor("#3C76FF");
        this.f6169a = new Paint();
        this.f6170b = new Paint();
        this.f6171c = new Paint();
        this.f6172d = new RectF();
        this.f6169a.setColor(this.f6173e);
        this.f6169a.setStyle(Paint.Style.STROKE);
        this.f6169a.setStrokeWidth(this.f6175g);
        this.f6169a.setAntiAlias(true);
        this.f6169a.setStrokeCap(Paint.Cap.ROUND);
        this.f6170b.setColor(this.f6174f);
        this.f6170b.setStyle(Paint.Style.STROKE);
        this.f6170b.setStrokeWidth(this.f6175g);
        this.f6170b.setAntiAlias(true);
        this.f6170b.setStrokeCap(Paint.Cap.ROUND);
        this.f6171c.setStrokeWidth(0.0f);
        this.f6171c.setColor(this.f6174f);
        this.f6171c.setTextSize(this.f6176h);
        this.f6171c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
