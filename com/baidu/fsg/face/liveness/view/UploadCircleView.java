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
    public Paint f6138a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6139b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6140c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6141d;

    /* renamed from: e  reason: collision with root package name */
    public int f6142e;

    /* renamed from: f  reason: collision with root package name */
    public int f6143f;

    /* renamed from: g  reason: collision with root package name */
    public int f6144g;

    /* renamed from: h  reason: collision with root package name */
    public float f6145h;

    /* renamed from: i  reason: collision with root package name */
    public float f6146i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6144g / 2);
        canvas.drawCircle(width, width, f2, this.f6138a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6141d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6141d, -90.0f, this.f6146i, false, this.f6139b);
        canvas.drawText(this.j, width - (this.f6140c.measureText(this.j) / 2.0f), width, this.f6140c);
    }

    public void setProgress(int i2) {
        this.j = i2 + "%";
        this.f6146i = (float) ((i2 * 360) / 100);
        postInvalidate();
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.j = "";
        this.f6144g = h.a(context, 3.0f);
        this.f6145h = h.a(context, 24.0f);
        this.f6142e = Color.parseColor("#E1DDDD");
        this.f6143f = Color.parseColor("#3C76FF");
        this.f6138a = new Paint();
        this.f6139b = new Paint();
        this.f6140c = new Paint();
        this.f6141d = new RectF();
        this.f6138a.setColor(this.f6142e);
        this.f6138a.setStyle(Paint.Style.STROKE);
        this.f6138a.setStrokeWidth(this.f6144g);
        this.f6138a.setAntiAlias(true);
        this.f6138a.setStrokeCap(Paint.Cap.ROUND);
        this.f6139b.setColor(this.f6143f);
        this.f6139b.setStyle(Paint.Style.STROKE);
        this.f6139b.setStrokeWidth(this.f6144g);
        this.f6139b.setAntiAlias(true);
        this.f6139b.setStrokeCap(Paint.Cap.ROUND);
        this.f6140c.setStrokeWidth(0.0f);
        this.f6140c.setColor(this.f6143f);
        this.f6140c.setTextSize(this.f6145h);
        this.f6140c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
