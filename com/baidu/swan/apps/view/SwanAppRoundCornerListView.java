package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.h0;
/* loaded from: classes3.dex */
public class SwanAppRoundCornerListView extends ListView {
    public static final float j = h0.g(11.0f);

    /* renamed from: e  reason: collision with root package name */
    public final Path f12352e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f12353f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f12354g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f12355h;
    public PorterDuffXfermode i;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.f12352e = new Path();
        this.f12353f = new Paint(1);
        this.f12354g = new RectF();
        float f2 = j;
        this.f12355h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.f12353f.setColor(-1);
        this.f12353f.setXfermode(this.i);
        canvas.drawPath(this.f12352e, this.f12353f);
        this.f12353f.setXfermode(null);
        canvas.restore();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f12354g.set(0.0f, 0.0f, i, i2 + 1);
        this.f12352e.reset();
        this.f12352e.addRoundRect(this.f12354g, this.f12355h, Path.Direction.CW);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    public void setListViewRadius(float f2, float f3, float f4, float f5) {
        setListViewRadius(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length >= 8) {
            this.f12355h = new float[8];
            for (int i = 0; i < 8; i++) {
                this.f12355h[i] = fArr[i];
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12352e = new Path();
        this.f12353f = new Paint(1);
        this.f12354g = new RectF();
        float f2 = j;
        this.f12355h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12352e = new Path();
        this.f12353f = new Paint(1);
        this.f12354g = new RectF();
        float f2 = j;
        this.f12355h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
