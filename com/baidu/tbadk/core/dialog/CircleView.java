package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CircleView extends View {
    public static int l = 360;
    public static int m = 100;

    /* renamed from: e  reason: collision with root package name */
    public int f12156e;

    /* renamed from: f  reason: collision with root package name */
    public int f12157f;

    /* renamed from: g  reason: collision with root package name */
    public int f12158g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f12159h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f12160i;
    public RectF j;
    public int k;

    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f12156e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f12157f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f12158g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f12159h = paint;
        paint.setStrokeWidth(this.f12157f);
        this.f12159h.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f12159h.setStyle(Paint.Style.STROKE);
        this.f12159h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f12160i = paint2;
        paint2.setStrokeWidth(this.f12158g);
        this.f12160i.setColor(getResources().getColor(R.color.common_color_10042));
        this.f12160i.setStyle(Paint.Style.STROKE);
        this.f12160i.setAntiAlias(true);
        int i2 = this.f12157f;
        int i3 = this.f12156e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 0.0f, l, false, this.f12160i);
        canvas.drawArc(this.j, 270.0f, (l * this.k) / m, false, this.f12159h);
    }

    public void setProgress(int i2) {
        this.k = i2;
        invalidate();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        a();
    }

    public CircleView(Context context) {
        super(context);
        this.k = 0;
        a();
    }
}
