package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;
/* loaded from: classes15.dex */
class ag extends TextView {
    private Paint a;
    private PaintFlagsDrawFilter b;

    public ag(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new PaintFlagsDrawFilter(0, 3);
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.setColor(i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.b);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.a);
        super.draw(canvas);
    }
}
