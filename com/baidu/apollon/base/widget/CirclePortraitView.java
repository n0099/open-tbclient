package com.baidu.apollon.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class CirclePortraitView extends NetImageView {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f3597a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3598b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f3599c;

    /* renamed from: d  reason: collision with root package name */
    public float f3600d;

    /* renamed from: e  reason: collision with root package name */
    public float f3601e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3597a = new Paint();
        this.f3598b = new Paint();
        this.f3599c = new RectF();
        c();
    }

    private void c() {
        this.f3597a.setAntiAlias(true);
        this.f3597a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f3598b.setAntiAlias(true);
        this.f3598b.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f3599c, this.f3598b, 31);
        float f2 = this.f3600d;
        canvas.drawCircle(f2 / 2.0f, this.f3601e / 2.0f, f2 / 2.0f, this.f3598b);
        canvas.saveLayer(this.f3599c, this.f3597a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f3600d = getWidth();
        float height = getHeight();
        this.f3601e = height;
        this.f3599c.set(0.0f, 0.0f, this.f3600d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3597a = new Paint();
        this.f3598b = new Paint();
        this.f3599c = new RectF();
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        this.f3597a = new Paint();
        this.f3598b = new Paint();
        this.f3599c = new RectF();
        c();
    }
}
