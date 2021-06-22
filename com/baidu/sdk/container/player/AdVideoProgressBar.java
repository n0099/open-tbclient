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
    public float f10042e;

    /* renamed from: f  reason: collision with root package name */
    public int f10043f;

    /* renamed from: g  reason: collision with root package name */
    public int f10044g;

    /* renamed from: h  reason: collision with root package name */
    public int f10045h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f10046i;
    public final Rect j;

    public AdVideoProgressBar(Context context) {
        super(context);
        this.f10043f = -7829368;
        this.f10044g = -16777216;
        this.f10045h = 4;
        this.f10046i = new Paint();
        this.j = new Rect();
    }

    public float getProgress() {
        return this.f10042e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        getDrawingRect(this.j);
        Rect rect = this.j;
        this.f10046i.setStyle(Paint.Style.STROKE);
        this.f10046i.setStrokeWidth(this.f10045h);
        this.f10046i.setStrokeCap(Paint.Cap.SQUARE);
        this.f10046i.setAlpha(204);
        this.f10046i.setAntiAlias(true);
        this.f10046i.setColor(this.f10044g);
        Rect rect2 = this.j;
        float f2 = (rect.top + rect.bottom) / 2;
        canvas.drawLine(rect2.left, f2, rect2.right, f2, this.f10046i);
        this.f10046i.setColor(this.f10043f);
        canvas.drawLine(this.j.left, f2, i2 + ((int) (((rect.right - rect.left) * this.f10042e) / 100.0f)), f2, this.f10046i);
    }

    public void setProgress(float f2) {
        this.f10042e = f2 * 100.0f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.f10044g = i2;
    }

    public void setProgressColor(int i2) {
        this.f10043f = i2;
    }

    public void setProgressHeight(int i2) {
        this.f10045h = i2;
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10043f = -7829368;
        this.f10044g = -16777216;
        this.f10045h = 4;
        this.f10046i = new Paint();
        this.j = new Rect();
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10043f = -7829368;
        this.f10044g = -16777216;
        this.f10045h = 4;
        this.f10046i = new Paint();
        this.j = new Rect();
    }
}
