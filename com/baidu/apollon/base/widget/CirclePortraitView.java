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
    public final Paint f3619a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f3620b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f3621c;

    /* renamed from: d  reason: collision with root package name */
    public float f3622d;

    /* renamed from: e  reason: collision with root package name */
    public float f3623e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3619a = new Paint();
        this.f3620b = new Paint();
        this.f3621c = new RectF();
        c();
    }

    private void c() {
        this.f3619a.setAntiAlias(true);
        this.f3619a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f3620b.setAntiAlias(true);
        this.f3620b.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f3621c, this.f3620b, 31);
        float f2 = this.f3622d;
        canvas.drawCircle(f2 / 2.0f, this.f3623e / 2.0f, f2 / 2.0f, this.f3620b);
        canvas.saveLayer(this.f3621c, this.f3619a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f3622d = getWidth();
        float height = getHeight();
        this.f3623e = height;
        this.f3621c.set(0.0f, 0.0f, this.f3622d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3619a = new Paint();
        this.f3620b = new Paint();
        this.f3621c = new RectF();
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        this.f3619a = new Paint();
        this.f3620b = new Paint();
        this.f3621c = new RectF();
        c();
    }
}
