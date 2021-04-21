package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CircleView1080 extends View {
    public static int j = 360;
    public static int k = 100;

    /* renamed from: e  reason: collision with root package name */
    public int f12906e;

    /* renamed from: f  reason: collision with root package name */
    public int f12907f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f12908g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f12909h;
    public int i;

    public CircleView1080(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
        a();
    }

    public void a() {
        this.f12906e = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.f12907f = getResources().getDimensionPixelSize(R.dimen.tbds6);
        Paint paint = new Paint();
        this.f12908g = paint;
        paint.setStrokeWidth(this.f12907f);
        this.f12908g.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f12908g.setStyle(Paint.Style.STROKE);
        this.f12908g.setAntiAlias(true);
        this.f12908g.setStrokeCap(Paint.Cap.ROUND);
        int i = this.f12907f;
        int i2 = this.f12906e;
        this.f12909h = new RectF(i / 2, i / 2, (i / 2) + i2, i2 + (i / 2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.f12909h, 270.0f, (j * this.i) / k, false, this.f12908g);
    }

    public void setProgress(int i) {
        this.i = i;
        invalidate();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        a();
    }

    public CircleView1080(Context context) {
        super(context);
        this.i = 0;
        a();
    }
}
