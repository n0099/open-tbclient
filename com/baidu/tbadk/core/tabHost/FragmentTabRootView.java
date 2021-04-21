package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class FragmentTabRootView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Matrix f12984e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12985f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f12986g;

    public FragmentTabRootView(Context context) {
        super(context);
        this.f12984e = new Matrix();
        this.f12985f = new Paint(6);
        this.f12986g = new Rect();
        a();
    }

    public final void a() {
        setDrawingCacheEnabled(false);
        this.f12985f.setAntiAlias(true);
        this.f12985f.setStyle(Paint.Style.FILL);
        this.f12985f.setColor(-16777216);
        this.f12985f.setAlpha(0);
        setWillNotDraw(false);
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.f12984e.reset();
        this.f12984e.postTranslate(f2, f3);
        this.f12984e.postScale(f4, f5, f6, f7);
        this.f12985f.setAlpha(i);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        canvas.concat(this.f12984e);
        canvas.drawRect(this.f12986g, this.f12985f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f12986g.set(0, 0, i, i2);
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12984e = new Matrix();
        this.f12985f = new Paint(6);
        this.f12986g = new Rect();
        a();
    }
}
