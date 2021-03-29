package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class ag extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f8890a;

    /* renamed from: b  reason: collision with root package name */
    public PaintFlagsDrawFilter f8891b;

    public ag(Context context) {
        super(context);
        this.f8890a = new Paint();
        this.f8891b = new PaintFlagsDrawFilter(0, 3);
        this.f8890a.setColor(-1);
        this.f8890a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.f8891b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.f8890a);
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f8890a.setColor(i);
    }
}
