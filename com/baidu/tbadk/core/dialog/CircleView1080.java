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
    public int f12825e;

    /* renamed from: f  reason: collision with root package name */
    public int f12826f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f12827g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f12828h;

    /* renamed from: i  reason: collision with root package name */
    public int f12829i;

    public CircleView1080(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12829i = 0;
        a();
    }

    public void a() {
        this.f12825e = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.f12826f = getResources().getDimensionPixelSize(R.dimen.tbds6);
        Paint paint = new Paint();
        this.f12827g = paint;
        paint.setStrokeWidth(this.f12826f);
        this.f12827g.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f12827g.setStyle(Paint.Style.STROKE);
        this.f12827g.setAntiAlias(true);
        this.f12827g.setStrokeCap(Paint.Cap.ROUND);
        int i2 = this.f12826f;
        int i3 = this.f12825e;
        this.f12828h = new RectF(i2 / 2, i2 / 2, (i2 / 2) + i3, i3 + (i2 / 2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.f12828h, 270.0f, (j * this.f12829i) / k, false, this.f12827g);
    }

    public void setProgress(int i2) {
        this.f12829i = i2;
        invalidate();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12829i = 0;
        a();
    }

    public CircleView1080(Context context) {
        super(context);
        this.f12829i = 0;
        a();
    }
}
