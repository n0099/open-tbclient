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
    public double f10175a;

    /* renamed from: b  reason: collision with root package name */
    public double f10176b;

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
        rect.right = (int) ((this.f10175a / this.f10176b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10167a);
        paint.setColor(Color.rgb(61, 139, 255));
        canvas.drawRect(rect, paint);
        Rect rect2 = new Rect();
        double d2 = this.f10175a / this.f10176b;
        int i = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10167a;
        rect2.left = (int) (d2 * i);
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
        this.f10175a = i;
        this.f10176b = i2;
        invalidate();
    }

    public TestScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
