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
    public float f9948e;

    /* renamed from: f  reason: collision with root package name */
    public int f9949f;

    /* renamed from: g  reason: collision with root package name */
    public int f9950g;

    /* renamed from: h  reason: collision with root package name */
    public int f9951h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f9952i;
    public final Rect j;

    public AdVideoProgressBar(Context context) {
        super(context);
        this.f9949f = -7829368;
        this.f9950g = -16777216;
        this.f9951h = 4;
        this.f9952i = new Paint();
        this.j = new Rect();
    }

    public float getProgress() {
        return this.f9948e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        getDrawingRect(this.j);
        Rect rect = this.j;
        this.f9952i.setStyle(Paint.Style.STROKE);
        this.f9952i.setStrokeWidth(this.f9951h);
        this.f9952i.setStrokeCap(Paint.Cap.SQUARE);
        this.f9952i.setAlpha(204);
        this.f9952i.setAntiAlias(true);
        this.f9952i.setColor(this.f9950g);
        Rect rect2 = this.j;
        float f2 = (rect.top + rect.bottom) / 2;
        canvas.drawLine(rect2.left, f2, rect2.right, f2, this.f9952i);
        this.f9952i.setColor(this.f9949f);
        canvas.drawLine(this.j.left, f2, i2 + ((int) (((rect.right - rect.left) * this.f9948e) / 100.0f)), f2, this.f9952i);
    }

    public void setProgress(float f2) {
        this.f9948e = f2 * 100.0f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.f9950g = i2;
    }

    public void setProgressColor(int i2) {
        this.f9949f = i2;
    }

    public void setProgressHeight(int i2) {
        this.f9951h = i2;
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9949f = -7829368;
        this.f9950g = -16777216;
        this.f9951h = 4;
        this.f9952i = new Paint();
        this.j = new Rect();
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9949f = -7829368;
        this.f9950g = -16777216;
        this.f9951h = 4;
        this.f9952i = new Paint();
        this.j = new Rect();
    }
}
