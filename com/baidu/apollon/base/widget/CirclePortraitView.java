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
    public final Paint f3600a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3601b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f3602c;

    /* renamed from: d  reason: collision with root package name */
    public float f3603d;

    /* renamed from: e  reason: collision with root package name */
    public float f3604e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3600a = new Paint();
        this.f3601b = new Paint();
        this.f3602c = new RectF();
        c();
    }

    private void c() {
        this.f3600a.setAntiAlias(true);
        this.f3600a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f3601b.setAntiAlias(true);
        this.f3601b.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f3602c, this.f3601b, 31);
        float f2 = this.f3603d;
        canvas.drawCircle(f2 / 2.0f, this.f3604e / 2.0f, f2 / 2.0f, this.f3601b);
        canvas.saveLayer(this.f3602c, this.f3600a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f3603d = getWidth();
        float height = getHeight();
        this.f3604e = height;
        this.f3602c.set(0.0f, 0.0f, this.f3603d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3600a = new Paint();
        this.f3601b = new Paint();
        this.f3602c = new RectF();
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        this.f3600a = new Paint();
        this.f3601b = new Paint();
        this.f3602c = new RectF();
        c();
    }
}
