package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class TestScaleView extends View {
    private double a;
    private double b;

    public TestScaleView(Context context) {
        super(context);
    }

    public TestScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setPassLengthAndTotalLength(int i, int i2) {
        this.a = i;
        this.b = i2;
        invalidate();
    }

    public void refresh() {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.bottom = 25;
        rect.right = (int) ((this.a / this.b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.a);
        paint.setColor(Color.rgb(61, 139, 255));
        canvas.drawRect(rect, paint);
        Rect rect2 = new Rect();
        rect2.left = (int) ((this.a / this.b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.a);
        rect2.top = 0;
        rect2.bottom = 25;
        rect2.right = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a;
        paint.setColor(Color.rgb(234, 234, 234));
        canvas.drawRect(rect2, paint);
    }
}
