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
    public final Paint f3521a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3522b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f3523c;

    /* renamed from: d  reason: collision with root package name */
    public float f3524d;

    /* renamed from: e  reason: collision with root package name */
    public float f3525e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3521a = new Paint();
        this.f3522b = new Paint();
        this.f3523c = new RectF();
        c();
    }

    private void c() {
        this.f3521a.setAntiAlias(true);
        this.f3521a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f3522b.setAntiAlias(true);
        this.f3522b.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f3523c, this.f3522b, 31);
        float f2 = this.f3524d;
        canvas.drawCircle(f2 / 2.0f, this.f3525e / 2.0f, f2 / 2.0f, this.f3522b);
        canvas.saveLayer(this.f3523c, this.f3521a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3524d = getWidth();
        float height = getHeight();
        this.f3525e = height;
        this.f3523c.set(0.0f, 0.0f, this.f3524d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3521a = new Paint();
        this.f3522b = new Paint();
        this.f3523c = new RectF();
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        this.f3521a = new Paint();
        this.f3522b = new Paint();
        this.f3523c = new RectF();
        c();
    }
}
