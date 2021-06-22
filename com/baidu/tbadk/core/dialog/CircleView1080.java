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
    public int f12206e;

    /* renamed from: f  reason: collision with root package name */
    public int f12207f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f12208g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f12209h;

    /* renamed from: i  reason: collision with root package name */
    public int f12210i;

    public CircleView1080(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12210i = 0;
        a();
    }

    public void a() {
        this.f12206e = getResources().getDimensionPixelSize(R.dimen.tbds122);
        this.f12207f = getResources().getDimensionPixelSize(R.dimen.tbds6);
        Paint paint = new Paint();
        this.f12208g = paint;
        paint.setStrokeWidth(this.f12207f);
        this.f12208g.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f12208g.setStyle(Paint.Style.STROKE);
        this.f12208g.setAntiAlias(true);
        this.f12208g.setStrokeCap(Paint.Cap.ROUND);
        int i2 = this.f12207f;
        int i3 = this.f12206e;
        this.f12209h = new RectF(i2 / 2, i2 / 2, (i2 / 2) + i3, i3 + (i2 / 2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.f12209h, 270.0f, (j * this.f12210i) / k, false, this.f12208g);
    }

    public void setProgress(int i2) {
        this.f12210i = i2;
        invalidate();
    }

    public CircleView1080(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12210i = 0;
        a();
    }

    public CircleView1080(Context context) {
        super(context);
        this.f12210i = 0;
        a();
    }
}
