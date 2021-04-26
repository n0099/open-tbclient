package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class ag extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f8766a;

    /* renamed from: b  reason: collision with root package name */
    public PaintFlagsDrawFilter f8767b;

    public ag(Context context) {
        super(context);
        this.f8766a = new Paint();
        this.f8767b = new PaintFlagsDrawFilter(0, 3);
        this.f8766a.setColor(-1);
        this.f8766a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.f8767b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.f8766a);
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.f8766a.setColor(i2);
    }
}
