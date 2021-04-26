package com.baidu.sdk.container.player;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class AdVideoProgressBar extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f11011e;

    /* renamed from: f  reason: collision with root package name */
    public int f11012f;

    /* renamed from: g  reason: collision with root package name */
    public int f11013g;

    /* renamed from: h  reason: collision with root package name */
    public int f11014h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f11015i;
    public final Rect j;

    public AdVideoProgressBar(Context context) {
        super(context);
        this.f11012f = -7829368;
        this.f11013g = -16777216;
        this.f11014h = 4;
        this.f11015i = new Paint();
        this.j = new Rect();
    }

    public float getProgress() {
        return this.f11011e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        getDrawingRect(this.j);
        Rect rect = this.j;
        this.f11015i.setStyle(Paint.Style.STROKE);
        this.f11015i.setStrokeWidth(this.f11014h);
        this.f11015i.setStrokeCap(Paint.Cap.SQUARE);
        this.f11015i.setAlpha(204);
        this.f11015i.setAntiAlias(true);
        this.f11015i.setColor(this.f11013g);
        Rect rect2 = this.j;
        float f2 = (rect.top + rect.bottom) / 2;
        canvas.drawLine(rect2.left, f2, rect2.right, f2, this.f11015i);
        this.f11015i.setColor(this.f11012f);
        canvas.drawLine(this.j.left, f2, i2 + ((int) (((rect.right - rect.left) * this.f11011e) / 100.0f)), f2, this.f11015i);
    }

    public void setProgress(float f2) {
        this.f11011e = f2 * 100.0f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.f11013g = i2;
    }

    public void setProgressColor(int i2) {
        this.f11012f = i2;
    }

    public void setProgressHeight(int i2) {
        this.f11014h = i2;
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11012f = -7829368;
        this.f11013g = -16777216;
        this.f11014h = 4;
        this.f11015i = new Paint();
        this.j = new Rect();
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11012f = -7829368;
        this.f11013g = -16777216;
        this.f11014h = 4;
        this.f11015i = new Paint();
        this.j = new Rect();
    }
}
