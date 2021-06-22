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
    public Matrix f12297e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12298f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f12299g;

    public FragmentTabRootView(Context context) {
        super(context);
        this.f12297e = new Matrix();
        this.f12298f = new Paint(6);
        this.f12299g = new Rect();
        a();
    }

    public final void a() {
        setDrawingCacheEnabled(false);
        this.f12298f.setAntiAlias(true);
        this.f12298f.setStyle(Paint.Style.FILL);
        this.f12298f.setColor(-16777216);
        this.f12298f.setAlpha(0);
        setWillNotDraw(false);
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        this.f12297e.reset();
        this.f12297e.postTranslate(f2, f3);
        this.f12297e.postScale(f4, f5, f6, f7);
        this.f12298f.setAlpha(i2);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        canvas.concat(this.f12297e);
        canvas.drawRect(this.f12299g, this.f12298f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f12299g.set(0, 0, i2, i3);
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12297e = new Matrix();
        this.f12298f = new Paint(6);
        this.f12299g = new Rect();
        a();
    }
}
