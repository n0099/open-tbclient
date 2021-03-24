package com.baidu.apollon.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class CirclePortraitView extends NetImageView {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f3520a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3521b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f3522c;

    /* renamed from: d  reason: collision with root package name */
    public float f3523d;

    /* renamed from: e  reason: collision with root package name */
    public float f3524e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3520a = new Paint();
        this.f3521b = new Paint();
        this.f3522c = new RectF();
        c();
    }

    private void c() {
        this.f3520a.setAntiAlias(true);
        this.f3520a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f3521b.setAntiAlias(true);
        this.f3521b.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f3522c, this.f3521b, 31);
        float f2 = this.f3523d;
        canvas.drawCircle(f2 / 2.0f, this.f3524e / 2.0f, f2 / 2.0f, this.f3521b);
        canvas.saveLayer(this.f3522c, this.f3520a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3523d = getWidth();
        float height = getHeight();
        this.f3524e = height;
        this.f3522c.set(0.0f, 0.0f, this.f3523d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3520a = new Paint();
        this.f3521b = new Paint();
        this.f3522c = new RectF();
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        this.f3520a = new Paint();
        this.f3521b = new Paint();
        this.f3522c = new RectF();
        c();
    }
}
