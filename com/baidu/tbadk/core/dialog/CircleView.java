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
    public int f13232e;

    /* renamed from: f  reason: collision with root package name */
    public int f13233f;

    /* renamed from: g  reason: collision with root package name */
    public int f13234g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13235h;
    public Paint i;
    public RectF j;
    public int k;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        a();
    }

    public void a() {
        this.f13232e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f13233f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f13234g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f13235h = paint;
        paint.setStrokeWidth(this.f13233f);
        this.f13235h.setColor(getResources().getColor(R.color.CAM_X0111));
        this.f13235h.setStyle(Paint.Style.STROKE);
        this.f13235h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStrokeWidth(this.f13234g);
        this.i.setColor(getResources().getColor(R.color.common_color_10042));
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        int i = this.f13233f;
        int i2 = this.f13232e;
        this.j = new RectF(i, i, i2 + i, i2 + i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 0.0f, l, false, this.i);
        canvas.drawArc(this.j, 270.0f, (l * this.k) / m, false, this.f13235h);
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
