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
    public Paint f6238a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6239b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6240c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6241d;

    /* renamed from: e  reason: collision with root package name */
    public int f6242e;

    /* renamed from: f  reason: collision with root package name */
    public int f6243f;

    /* renamed from: g  reason: collision with root package name */
    public int f6244g;

    /* renamed from: h  reason: collision with root package name */
    public float f6245h;

    /* renamed from: i  reason: collision with root package name */
    public float f6246i;
    public String j;

    public UploadCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f2 = width - (this.f6244g / 2);
        canvas.drawCircle(width, width, f2, this.f6238a);
        float f3 = width - f2;
        float f4 = f2 + width;
        this.f6241d.set(f3, f3, f4, f4);
        canvas.drawArc(this.f6241d, -90.0f, this.f6246i, false, this.f6239b);
        canvas.drawText(this.j, width - (this.f6240c.measureText(this.j) / 2.0f), width, this.f6240c);
    }

    public void setProgress(int i2) {
        this.j = i2 + "%";
        this.f6246i = (float) ((i2 * 360) / 100);
        postInvalidate();
    }

    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UploadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.j = "";
        this.f6244g = h.a(context, 3.0f);
        this.f6245h = h.a(context, 24.0f);
        this.f6242e = Color.parseColor("#E1DDDD");
        this.f6243f = Color.parseColor("#3C76FF");
        this.f6238a = new Paint();
        this.f6239b = new Paint();
        this.f6240c = new Paint();
        this.f6241d = new RectF();
        this.f6238a.setColor(this.f6242e);
        this.f6238a.setStyle(Paint.Style.STROKE);
        this.f6238a.setStrokeWidth(this.f6244g);
        this.f6238a.setAntiAlias(true);
        this.f6238a.setStrokeCap(Paint.Cap.ROUND);
        this.f6239b.setColor(this.f6243f);
        this.f6239b.setStyle(Paint.Style.STROKE);
        this.f6239b.setStrokeWidth(this.f6244g);
        this.f6239b.setAntiAlias(true);
        this.f6239b.setStrokeCap(Paint.Cap.ROUND);
        this.f6240c.setStrokeWidth(0.0f);
        this.f6240c.setColor(this.f6243f);
        this.f6240c.setTextSize(this.f6245h);
        this.f6240c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
