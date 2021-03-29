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
    public int f13233e;

    /* renamed from: f  reason: collision with root package name */
    public int f13234f;

    /* renamed from: g  reason: collision with root package name */
    public int f13235g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13236h;
    public Paint i;
    public RectF j;
    public int k;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        a();
    }

    public void a() {
        this.f13233e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f13234f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f13235g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f13236h = paint;
        paint.setStrokeWidth(this.f13234f);
        this.f13236h.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f13236h.setStyle(Paint.Style.STROKE);
        this.f13236h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStrokeWidth(this.f13235g);
        this.i.setColor(getResources().getColor(R.color.common_color_10042));
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        int i = this.f13234f;
        int i2 = this.f13233e;
        this.j = new RectF(i, i, i2 + i, i2 + i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 0.0f, l, false, this.i);
        canvas.drawArc(this.j, 270.0f, (l * this.k) / m, false, this.f13236h);
    }

    public void setProgress(int i) {
        this.k = i;
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
