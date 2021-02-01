package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes3.dex */
class ag extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f3652a;

    /* renamed from: b  reason: collision with root package name */
    private PaintFlagsDrawFilter f3653b;

    public ag(Context context) {
        super(context);
        this.f3652a = new Paint();
        this.f3653b = new PaintFlagsDrawFilter(0, 3);
        this.f3652a.setColor(-1);
        this.f3652a.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f3652a.setColor(i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.f3653b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.f3652a);
        super.draw(canvas);
    }
}
