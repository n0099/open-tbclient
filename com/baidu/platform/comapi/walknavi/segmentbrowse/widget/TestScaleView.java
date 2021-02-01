package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class TestScaleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private double f4366a;

    /* renamed from: b  reason: collision with root package name */
    private double f4367b;

    public TestScaleView(Context context) {
        super(context);
    }

    public TestScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setPassLengthAndTotalLength(int i, int i2) {
        this.f4366a = i;
        this.f4367b = i2;
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
        rect.right = (int) ((this.f4366a / this.f4367b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.f4364a);
        paint.setColor(Color.rgb(61, 139, 255));
        canvas.drawRect(rect, paint);
        Rect rect2 = new Rect();
        rect2.left = (int) ((this.f4366a / this.f4367b) * com.baidu.platform.comapi.walknavi.segmentbrowse.c.f4364a);
        rect2.top = 0;
        rect2.bottom = 25;
        rect2.right = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f4364a;
        paint.setColor(Color.rgb(234, 234, 234));
        canvas.drawRect(rect2, paint);
    }
}
