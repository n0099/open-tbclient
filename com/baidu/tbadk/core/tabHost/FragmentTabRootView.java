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
    public Matrix f13315e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13316f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f13317g;

    public FragmentTabRootView(Context context) {
        super(context);
        this.f13315e = new Matrix();
        this.f13316f = new Paint(6);
        this.f13317g = new Rect();
        a();
    }

    public final void a() {
        setDrawingCacheEnabled(false);
        this.f13316f.setAntiAlias(true);
        this.f13316f.setStyle(Paint.Style.FILL);
        this.f13316f.setColor(-16777216);
        this.f13316f.setAlpha(0);
        setWillNotDraw(false);
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.f13315e.reset();
        this.f13315e.postTranslate(f2, f3);
        this.f13315e.postScale(f4, f5, f6, f7);
        this.f13316f.setAlpha(i);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        canvas.concat(this.f13315e);
        canvas.drawRect(this.f13317g, this.f13316f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13317g.set(0, 0, i, i2);
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13315e = new Matrix();
        this.f13316f = new Paint(6);
        this.f13317g = new Rect();
        a();
    }
}
