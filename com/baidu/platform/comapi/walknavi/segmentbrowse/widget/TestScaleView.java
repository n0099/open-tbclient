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
    public double f10093a;

    /* renamed from: b  reason: collision with root package name */
    public double f10094b;

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
        rect.right = (int) ((this.f10093a / this.f10094b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10085a);
        paint.setColor(Color.rgb(61, 139, 255));
        canvas.drawRect(rect, paint);
        Rect rect2 = new Rect();
        double d2 = this.f10093a / this.f10094b;
        int i2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10085a;
        rect2.left = (int) (d2 * i2);
        rect2.top = 0;
        rect2.bottom = 25;
        rect2.right = i2;
        paint.setColor(Color.rgb(234, 234, 234));
        canvas.drawRect(rect2, paint);
    }

    public void refresh() {
        invalidate();
    }

    public void setPassLengthAndTotalLength(int i2, int i3) {
        this.f10093a = i2;
        this.f10094b = i3;
        invalidate();
    }

    public TestScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
