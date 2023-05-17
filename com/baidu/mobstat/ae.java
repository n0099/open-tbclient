package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ae extends TextView {
    public Paint a;
    public PaintFlagsDrawFilter b;

    public ae(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new PaintFlagsDrawFilter(0, 3);
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.a);
        super.draw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.setColor(i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }
}
