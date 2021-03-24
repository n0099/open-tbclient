package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class TestScaleView extends View {

    /* renamed from: a  reason: collision with root package name */
    public double f10174a;

    /* renamed from: b  reason: collision with root package name */
    public double f10175b;

    public TestScaleView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.bottom = 25;
        double d2 = this.f10174a / this.f10175b;
        double d3 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10166a;
        Double.isNaN(d3);
        rect.right = (int) (d2 * d3);
        paint.setColor(Color.rgb(61, 139, 255));
        canvas.drawRect(rect, paint);
        Rect rect2 = new Rect();
        double d4 = this.f10174a / this.f10175b;
        int i = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10166a;
        double d5 = i;
        Double.isNaN(d5);
        rect2.left = (int) (d4 * d5);
        rect2.top = 0;
        rect2.bottom = 25;
        rect2.right = i;
        paint.setColor(Color.rgb(234, 234, 234));
        canvas.drawRect(rect2, paint);
    }

    public void refresh() {
        invalidate();
    }

    public void setPassLengthAndTotalLength(int i, int i2) {
        this.f10174a = i;
        this.f10175b = i2;
        invalidate();
    }

    public TestScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
