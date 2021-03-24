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
    public Matrix f13314e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f13315f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f13316g;

    public FragmentTabRootView(Context context) {
        super(context);
        this.f13314e = new Matrix();
        this.f13315f = new Paint(6);
        this.f13316g = new Rect();
        a();
    }

    public final void a() {
        setDrawingCacheEnabled(false);
        this.f13315f.setAntiAlias(true);
        this.f13315f.setStyle(Paint.Style.FILL);
        this.f13315f.setColor(-16777216);
        this.f13315f.setAlpha(0);
        setWillNotDraw(false);
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.f13314e.reset();
        this.f13314e.postTranslate(f2, f3);
        this.f13314e.postScale(f4, f5, f6, f7);
        this.f13315f.setAlpha(i);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        canvas.concat(this.f13314e);
        canvas.drawRect(this.f13316g, this.f13315f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13316g.set(0, 0, i, i2);
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13314e = new Matrix();
        this.f13315f = new Paint(6);
        this.f13316g = new Rect();
        a();
    }
}
