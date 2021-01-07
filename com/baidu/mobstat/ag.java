package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes15.dex */
class ag extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f3687a;

    /* renamed from: b  reason: collision with root package name */
    private PaintFlagsDrawFilter f3688b;

    public ag(Context context) {
        super(context);
        this.f3687a = new Paint();
        this.f3688b = new PaintFlagsDrawFilter(0, 3);
        this.f3687a.setColor(-1);
        this.f3687a.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f3687a.setColor(i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.f3688b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.f3687a);
        super.draw(canvas);
    }
}
