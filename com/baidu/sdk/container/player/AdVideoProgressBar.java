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
    public float f11202e;

    /* renamed from: f  reason: collision with root package name */
    public int f11203f;

    /* renamed from: g  reason: collision with root package name */
    public int f11204g;

    /* renamed from: h  reason: collision with root package name */
    public int f11205h;
    public Paint i;
    public final Rect j;

    public AdVideoProgressBar(Context context) {
        super(context);
        this.f11203f = -7829368;
        this.f11204g = -16777216;
        this.f11205h = 4;
        this.i = new Paint();
        this.j = new Rect();
    }

    public float getProgress() {
        return this.f11202e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        getDrawingRect(this.j);
        Rect rect = this.j;
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(this.f11205h);
        this.i.setStrokeCap(Paint.Cap.SQUARE);
        this.i.setAlpha(204);
        this.i.setAntiAlias(true);
        this.i.setColor(this.f11204g);
        Rect rect2 = this.j;
        float f2 = (rect.top + rect.bottom) / 2;
        canvas.drawLine(rect2.left, f2, rect2.right, f2, this.i);
        this.i.setColor(this.f11203f);
        canvas.drawLine(this.j.left, f2, i + ((int) (((rect.right - rect.left) * this.f11202e) / 100.0f)), f2, this.i);
    }

    public void setProgress(float f2) {
        this.f11202e = f2 * 100.0f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.f11204g = i;
    }

    public void setProgressColor(int i) {
        this.f11203f = i;
    }

    public void setProgressHeight(int i) {
        this.f11205h = i;
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11203f = -7829368;
        this.f11204g = -16777216;
        this.f11205h = 4;
        this.i = new Paint();
        this.j = new Rect();
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11203f = -7829368;
        this.f11204g = -16777216;
        this.f11205h = 4;
        this.i = new Paint();
        this.j = new Rect();
    }
}
